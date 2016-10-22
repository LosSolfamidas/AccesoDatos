package Controlador;

import Objetos.Persona;
import Objetos.Vivienda;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import javax.xml.transform.OutputKeys;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XPathQueryService;

public class MetodosHabitantes {

    public static ArrayList<Persona> listadoPersonasNoReg = new ArrayList<>();

    protected static String DRIVER = "org.exist.xmldb.DatabaseImpl";
    public static String URI = "xmldb:exist://localhost:8080/exist/xmlrpc/db";
    private static Collection col;
    private static XPathQueryService servicio;
    private static Database DATABASE = null;
    private static final String USER = "admin";
    private static final String PASS = "admin";

    public XPathQueryService obtenerservicio() {
        return servicio;
    }

    public static void MiConexionHabitantes() {
        try {
            Class<?> cl = Class.forName(DRIVER);
            DATABASE = (Database) cl.newInstance();
            DatabaseManager.registerDatabase(DATABASE);

            col = DatabaseManager.getCollection(URI, USER, PASS);
            servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
            servicio.setProperty("pretty", "true");
            servicio.setProperty("encoding", "UTF-8");
            col.setProperty(OutputKeys.INDENT, "no");
            servicio.setProperty("indent", "yes");

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | XMLDBException e) {
            System.out.println("Error en inicializar eXist");
        }
    }

    public static ArrayList<Persona> personasNoRegSELECT() {

        MiConexionHabitantes();

        listadoPersonasNoReg.clear();

        try {
            ResourceSet resultPersonas = servicio.query("for $d in /personas/persona return $d/ID_Persona/text()");
            ResourceIterator iterador;

            iterador = resultPersonas.getIterator();

            while (iterador.hasMoreResources()) {
                Resource recurso = iterador.nextResource();

                int ID_Persona = Integer.parseInt((String) recurso.getContent());

                String nombrePersona = servicio.query("for $d in /personas/persona[ID_Persona = " + ID_Persona + "] return $d/Nombre/text()").getIterator().nextResource().getContent().toString();
                String apellidos = servicio.query("for $d in /personas/persona[ID_Persona = " + ID_Persona + "]  return $d/Apellidos/text()").getIterator().nextResource().getContent().toString();
                int AnyoNacimiento = Integer.parseInt(servicio.query("for $d in /personas/persona[ID_Persona = " + ID_Persona + "]  return $d/AnyoNacimiento/text()").getIterator().nextResource().getContent().toString());
                String numeroTelefono = servicio.query("for $d in /personas/persona[ID_Persona = " + ID_Persona + "]  return $d/NumTelefono/text()").getIterator().nextResource().getContent().toString();
                boolean registrada = Boolean.parseBoolean(servicio.query("for $d in /personas/persona[ID_Persona = " + ID_Persona + "]  return $d/Registrada/text()").getIterator().nextResource().getContent().toString());
                Persona persona = new Persona(ID_Persona, nombrePersona, apellidos, AnyoNacimiento, numeroTelefono, registrada);

                if (!persona.isRegistrada()) {
                    listadoPersonasNoReg.add(persona);
                }

            }
        } catch (XMLDBException | NumberFormatException e) {
            System.out.println("Error en la Consulta");
        }

        return listadoPersonasNoReg;
    }

    public static boolean personaEnViviendaUPDATE(Persona persona, Vivienda vivienda) throws XMLDBException {

        MiConexionHabitantes();
        boolean registrada = true;
        registrarPersonaUPDATE(persona, registrada);

        String viviendaUPDATE = "<vivienda>";
        viviendaUPDATE += "<ID_Vivienda>" + vivienda.getID_Vivienda() + "</ID_Vivienda>";
        viviendaUPDATE += "<Calle>" + vivienda.getCalle() + "</Calle>";
        viviendaUPDATE += "<Numero>" + vivienda.getNumero() + "</Numero>";
        viviendaUPDATE += "<Tipo>" + vivienda.getTipo() + "</Tipo>";
        viviendaUPDATE += "<habitantes>";

        Iterator<Persona> iterador = vivienda.getHabitantes().iterator();
        while (iterador.hasNext()) {
            Persona a = iterador.next();
            viviendaUPDATE += "<persona>";
            viviendaUPDATE += "<ID_Persona>" + a.getID_Persona() + "</ID_Persona>";
            viviendaUPDATE += "<Nombre>" + a.getNombre() + "</Nombre>";
            viviendaUPDATE += "<Apellidos>" + a.getApellidos() + "</Apellidos>";
            viviendaUPDATE += "<AnyoNacimiento>" + a.getAnyoNacimiento() + "</AnyoNacimiento>";
            viviendaUPDATE += "<NumTelefono>" + a.getNumTelefono() + "</NumTelefono>";
            viviendaUPDATE += "</persona>";
        }
        viviendaUPDATE += "<persona>";
        viviendaUPDATE += "<ID_Persona>" + persona.getID_Persona() + "</ID_Persona>";
        viviendaUPDATE += "<Nombre>" + persona.getNombre() + "</Nombre>";
        viviendaUPDATE += "<Apellidos>" + persona.getApellidos() + "</Apellidos>";
        viviendaUPDATE += "<AnyoNacimiento>" + persona.getAnyoNacimiento() + "</AnyoNacimiento>";
        viviendaUPDATE += "<NumTelefono>" + persona.getNumTelefono() + "</NumTelefono>";
        viviendaUPDATE += "</persona>";
        viviendaUPDATE += "</habitantes></vivienda>";

        ResourceSet result = servicio.query("update replace /viviendas/vivienda[ID_Vivienda = " + vivienda.getID_Vivienda() + "] with " + viviendaUPDATE);
        return true;
    }

    public static boolean personaEnViviendaDELETE(Persona persona, Vivienda vivienda) throws XMLDBException {

        MiConexionHabitantes();

        int ID_Persona = persona.getID_Persona();
        try {
            ResourceSet result = servicio.query("update delete /viviendas/vivienda/habitantes/persona[ID_Persona = " + ID_Persona + "]");
            return true;
        } catch (XMLDBException e) {
            System.out.println("Error al borrar.");
            return false;
        }
    }

    public static boolean registrarPersonaUPDATE(Persona persona, boolean registrada) throws XMLDBException {

        MiConexionHabitantes();

        String personaUPDATE = "<persona>";

        personaUPDATE += "<ID_Persona>" + persona.getID_Persona() + "</ID_Persona>";
        personaUPDATE += "<Nombre>" + persona.getNombre() + "</Nombre>";
        personaUPDATE += "<Apellidos>" + persona.getApellidos() + "</Apellidos>";
        personaUPDATE += "<AnyoNacimiento>" + persona.getAnyoNacimiento() + "</AnyoNacimiento>";
        personaUPDATE += "<NumTelefono>" + persona.getNumTelefono() + "</NumTelefono>";
        personaUPDATE += "<Registrada>" + registrada + "</Registrada>";
        personaUPDATE += "</persona>";

        ResourceSet result = servicio.query("update replace /personas/persona[ID_Persona = " + persona.getID_Persona() + "] with " + personaUPDATE);

        return true;
    }

    public static boolean registrarTodasPersonasUPDATE(ArrayList<Persona> personas, boolean registrada) throws XMLDBException {

        MiConexionHabitantes();
        
        
        
        for (int i = 0; i < personas.size(); i++) {
             String personaUPDATE = "<persona>";

        personaUPDATE += "<ID_Persona>" + personas.get(i).getID_Persona() + "</ID_Persona>";
        personaUPDATE += "<Nombre>" + personas.get(i).getNombre() + "</Nombre>";
        personaUPDATE += "<Apellidos>" + personas.get(i).getApellidos() + "</Apellidos>";
        personaUPDATE += "<AnyoNacimiento>" + personas.get(i).getAnyoNacimiento() + "</AnyoNacimiento>";
        personaUPDATE += "<NumTelefono>" + personas.get(i).getNumTelefono() + "</NumTelefono>";
        personaUPDATE += "<Registrada>" + registrada + "</Registrada>";
        personaUPDATE += "</persona>";

        ResourceSet result = servicio.query("update replace /personas/persona[ID_Persona = " + personas.get(i).getID_Persona() + "] with " + personaUPDATE);
        }

        return true;
    }

}
