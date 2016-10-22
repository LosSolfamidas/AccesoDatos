package Controlador;

import org.xmldb.api.base.*;
import org.xmldb.api.modules.XPathQueryService;
import javax.xml.transform.OutputKeys;
import java.util.ArrayList;
import Objetos.Persona;
import org.xmldb.api.DatabaseManager;

public class MetodosPersonas {

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

    public static void MiConexionPersonas() {
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

    public static ArrayList<Persona> personasSELECT() {
        MiConexionPersonas();
        
        ArrayList<Persona> listaPersonas = new ArrayList<>();

        try {
            ResourceSet result = servicio.query("for $d in /personas/persona return $d/ID_Persona/text()");
            ResourceIterator iterador;
            iterador = result.getIterator();

            while (iterador.hasMoreResources()) {
                Resource recurso = iterador.nextResource();
                int ID_Persona = Integer.parseInt((String) recurso.getContent());

                String nombrePersona = servicio.query("for $d in /personas/persona[ID_Persona = " + ID_Persona + "] return $d/Nombre/text()").getIterator().nextResource().getContent().toString();
                String apellidos = servicio.query("for $d in /personas/persona[ID_Persona = " + ID_Persona + "]  return $d/Apellidos/text()").getIterator().nextResource().getContent().toString();
                int AnyoNacimiento = Integer.parseInt(servicio.query("for $d in /personas/persona[ID_Persona = " + ID_Persona + "]  return $d/AnyoNacimiento/text()").getIterator().nextResource().getContent().toString());
                String numeroTelefono = servicio.query("for $d in /personas/persona[ID_Persona = " + ID_Persona + "]  return $d/NumTelefono/text()").getIterator().nextResource().getContent().toString();
                boolean registrada = Boolean.parseBoolean(servicio.query("for $d in /personas/persona[ID_Persona = " + ID_Persona + "]  return $d/Registrada/text()").getIterator().nextResource().getContent().toString());
                Persona persona = new Persona(ID_Persona, nombrePersona, apellidos, AnyoNacimiento, numeroTelefono,registrada);
                listaPersonas.add(persona);
            }
        } catch (XMLDBException | NumberFormatException e) {
            System.out.println("Error en la Consulta");
        }

        return listaPersonas;
    }

    public static int nuevaID_Persona() {
        MiConexionPersonas();

        int id_persona = 0;

        try {
            ResourceSet result = servicio.query("for $d in /personas/persona[ID_Persona = max(ID_Persona)]/ID_Persona/text() return $d");
            ResourceIterator iterador;
            iterador = result.getIterator();

            while (iterador.hasMoreResources()) {
                Resource recurso = iterador.nextResource();
                id_persona = Integer.parseInt((String) recurso.getContent());
                System.err.println(id_persona);
            }
        } catch (XMLDBException | NumberFormatException e) {
            System.out.println("Error al asignar una nueva ID");
        }

        return id_persona + 1;
    }

    public static boolean personaINSERT(Persona persona) {
        MiConexionPersonas();
        String nuevaPersona = "<persona>";

        nuevaPersona += "<ID_Persona>" + persona.getID_Persona() + "</ID_Persona>";
        nuevaPersona += "<Nombre>" + persona.getNombre() + "</Nombre>";
        nuevaPersona += "<Apellidos>" + persona.getApellidos() + "</Apellidos>";
        nuevaPersona += "<AnyoNacimiento>" + persona.getAnyoNacimiento() + "</AnyoNacimiento>";
        nuevaPersona += "<NumTelefono>" + persona.getNumTelefono() + "</NumTelefono>";
        nuevaPersona += "<Registrada>" + persona.isRegistrada() + "</Registrada>";
        nuevaPersona += "</persona>";

       // nuevaPersona += "</habitantes>";

        try {
            ResourceSet result = servicio.query("update insert " + nuevaPersona + " into /personas");
            return true;
        } catch (Exception e) {
            System.out.println("Error al insertar.");
            return false;
        }
    }

    public static boolean personaDELETE(Persona persona) {
        MiConexionPersonas();
        int ID_Persona = persona.getID_Persona();

        try {
            ResourceSet result = servicio.query("update delete /personas/persona[ID_Persona = " + ID_Persona + "]");
            
        } catch (XMLDBException e) {
            System.out.println("Error al borrar persona.");
            return false;
        }
        
        try {
            ResourceSet result2 = servicio.query("update delete /viviendas/vivienda/habitantes/persona[ID_Persona = " + ID_Persona + "]");
            return true;
        } catch (XMLDBException e) {
            System.out.println("Error al borrar habitante.");
            return false;
        }
       
    }
    

    public static boolean personaUPDATE(Persona persona) throws XMLDBException {
        MiConexionPersonas();

        String personaUPDATE = "<persona>";

        personaUPDATE += "<ID_Persona>" + persona.getID_Persona() + "</ID_Persona>";
        personaUPDATE += "<Nombre>" + persona.getNombre() + "</Nombre>";
        personaUPDATE += "<Apellidos>" + persona.getApellidos() + "</Apellidos>";
        personaUPDATE += "<AnyoNacimiento>" + persona.getAnyoNacimiento() + "</AnyoNacimiento>";
        personaUPDATE += "<NumTelefono>" + persona.getNumTelefono() + "</NumTelefono>";
        personaUPDATE += "<Registrada>" + persona.isRegistrada() + "</Registrada>";
        personaUPDATE += "</persona>";

        ResourceSet result = servicio.query("update replace /personas/persona[ID_Persona = " + persona.getID_Persona() + "] with " + personaUPDATE);

        return true;

    }

    public static ArrayList<Persona> personaBUSCAR(String nombrePersona) {
        MiConexionPersonas();

        ArrayList<Persona> listadoPersonas = new ArrayList<>();

        try {
            ResourceSet result = servicio.query("for $d in /personas/persona[contains(Nombre, '" + nombrePersona + "')] return $d/ID_Persona/text()");
            ResourceIterator iterador;
            iterador = result.getIterator();

            while (iterador.hasMoreResources()) {
                Resource recurso = iterador.nextResource();
                int ID_Persona = Integer.parseInt((String) recurso.getContent());
                String nomPersona = servicio.query("for $d in /personas/persona[ID_Persona = " + ID_Persona + "]  return $d/Nombre/text()").getIterator().nextResource().getContent().toString();
                String apellidos = servicio.query("for $d in /personas/persona[ID_Persona = " + ID_Persona + "]  return $d/Apellidos/text()").getIterator().nextResource().getContent().toString();
                Integer anyoNacimiento = Integer.parseInt(servicio.query("for $d in /personas/persona[ID_Persona = " + ID_Persona + "]  return $d/AnyoNacimiento/text()").getIterator().nextResource().getContent().toString());
                String numTelefono = servicio.query("for $d in /personas/persona[ID_Persona = " + ID_Persona + "]  return $d/NumTelefono/text()").getIterator().nextResource().getContent().toString();
                Persona persona = new Persona(ID_Persona, nomPersona, apellidos, anyoNacimiento, numTelefono);
                listadoPersonas.add(persona);
            }

        } catch (XMLDBException | NumberFormatException e) {
            System.out.println("Error en la Busqueda");
        }

        return listadoPersonas;
    }
}
