package Controlador;

import org.xmldb.api.base.*;
import org.xmldb.api.modules.XPathQueryService;
import javax.xml.transform.OutputKeys;
import java.util.ArrayList;
import java.util.Iterator;
import Objetos.Vivienda;
import Objetos.Persona;
import org.xmldb.api.DatabaseManager;

public class MetodosViviendas {

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

    public static void MiConexionViviendas() {
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

    public static ArrayList<Vivienda> viviendasSELECT() {
        MiConexionViviendas();

        ArrayList<Vivienda> listaViviendas = new ArrayList<>();

        try {
            ResourceSet result = servicio.query("for $d in /viviendas/vivienda return $d/ID_Vivienda/text()");

            ResourceIterator iterador;
            iterador = result.getIterator();

            while (iterador.hasMoreResources()) {
                ArrayList<Persona> listaPersonas = new ArrayList<>();
                Resource recurso = iterador.nextResource();
                int ID_Vivienda = Integer.parseInt((String) recurso.getContent());

                //Almacenamos los valores de las viviendas
                String calle = servicio.query("for $d in /viviendas/vivienda[ID_Vivienda = " + ID_Vivienda + "] return $d/Calle/text()").getIterator().nextResource().getContent().toString();
                String numero = servicio.query("for $d in /viviendas/vivienda[ID_Vivienda = " + ID_Vivienda + "] return $d/Numero/text()").getIterator().nextResource().getContent().toString();
                String tipo = servicio.query("for $d in /viviendas/vivienda[ID_Vivienda = " + ID_Vivienda + "] return $d/Tipo/text()").getIterator().nextResource().getContent().toString();

                //Sentencia para almacenar las viviendas
                ResourceSet resAct = servicio.query("for $d in /viviendas/vivienda[ID_Vivienda = " + ID_Vivienda + "]/habitantes/persona return $d/ID_Persona/text()");
                ResourceIterator iteradorRes = resAct.getIterator();
                while (iteradorRes.hasMoreResources()) {
                    Resource rAct = iteradorRes.nextResource();
                    int ID_Persona = Integer.parseInt(rAct.getContent().toString());
                    String nombrePersona = servicio.query("for $d in /viviendas/vivienda[ID_Vivienda = " + ID_Vivienda + "]/habitantes/persona[ID_Persona = " + ID_Persona + "]  return $d/Nombre/text()").getIterator().nextResource().getContent().toString();
                    String apellidos = servicio.query("for $d in /viviendas/vivienda[ID_Vivienda = " + ID_Vivienda + "]/habitantes/persona[ID_Persona = " + ID_Persona + "]  return $d/Apellidos/text()").getIterator().nextResource().getContent().toString();
                    int AnyoNacimiento = Integer.parseInt(servicio.query("for $d in /viviendas/vivienda[ID_Vivienda = " + ID_Vivienda + "]/habitantes/persona[ID_Persona = " + ID_Persona + "]  return $d/AnyoNacimiento/text()").getIterator().nextResource().getContent().toString());
                    String numeroTelefono = servicio.query("for $d in /viviendas/vivienda[ID_Vivienda = " + ID_Vivienda + "]/habitantes/persona[ID_Persona = " + ID_Persona + "]  return $d/NumTelefono/text()").getIterator().nextResource().getContent().toString();
                    Persona persona = new Persona(ID_Persona, nombrePersona, apellidos, AnyoNacimiento, numeroTelefono);
                    listaPersonas.add(persona);
                }
                Vivienda vivienda = new Vivienda(ID_Vivienda, calle, numero, tipo, listaPersonas);
                listaViviendas.add(vivienda);
            }
        } catch (XMLDBException | NumberFormatException e) {
            System.out.println("Error en la Consulta");
        }

        return listaViviendas;
    }

    public static boolean viviendaINSERT(Vivienda vivienda) {
        MiConexionViviendas();
        String nuevaVivienda = "<vivienda>";

        nuevaVivienda += "<ID_Vivienda>" + vivienda.getID_Vivienda() + "</ID_Vivienda>";
        nuevaVivienda += "<Calle>" + vivienda.getCalle() + "</Calle>";
        nuevaVivienda += "<Numero>" + vivienda.getNumero() + "</Numero>";
        nuevaVivienda += "<Tipo>" + vivienda.getTipo() + "</Tipo>";
        nuevaVivienda += "<habitantes>";

        Iterator<Persona> iterador = vivienda.getHabitantes().iterator();
        while (iterador.hasNext()) {
            Persona persona = iterador.next();

            nuevaVivienda += "<persona>";
            nuevaVivienda += "<ID_Persona>" + persona.getID_Persona() + "</ID_Persona>";
            nuevaVivienda += "<Nombre>" + persona.getNombre() + "</Nombre>";
            nuevaVivienda += "<Apellidos>" + persona.getApellidos() + "</Apellidos>";
            nuevaVivienda += "<AnyoNacimiento>" + persona.getAnyoNacimiento() + "</AnyoNacimiento>";
            nuevaVivienda += "<NumTelefono>" + persona.getNumTelefono() + "</NumTelefono>";
            nuevaVivienda += "</persona>";
        }
        nuevaVivienda += "</habitantes></vivienda>";

        try {
            ResourceSet result = servicio.query("update insert " + nuevaVivienda + " into /viviendas");
            return true;
        } catch (Exception e) {
            System.out.println("Error al insertar.");
            return false;
        }
    }

    public static boolean viviendaUPDATE(Vivienda vivienda) throws XMLDBException {
        MiConexionViviendas();

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
        viviendaUPDATE += "</habitantes></vivienda>";

        ResourceSet result = servicio.query("update replace /viviendas/vivienda[ID_Vivienda = " + vivienda.getID_Vivienda() + "] with " + viviendaUPDATE);
        return true;

    }

    public static boolean viviendaDELETE(Vivienda vivienda) {
        MiConexionViviendas();
        int ID_Vivienda = vivienda.getID_Vivienda();

        try {
            ResourceSet result = servicio.query("update delete /viviendas/vivienda[ID_Vivienda = " + ID_Vivienda + "]");
            return true;
        } catch (XMLDBException e) {
            System.out.println("Error al borrar.");
            return false;
        }
    }

    public static ArrayList<Vivienda> viviendaBUSCAR(String nombreCalle) {
        MiConexionViviendas();

        ArrayList<Vivienda> listadoViviendas = new ArrayList<>();

        try {
            ResourceSet result = servicio.query("for $d in /viviendas/vivienda[contains(Calle, '" + nombreCalle + "')] return $d/ID_Vivienda/text()");
            ResourceIterator iterador;
            iterador = result.getIterator();

            while (iterador.hasMoreResources()) {
                ArrayList<Persona> listaPersonas = new ArrayList<>();
                Resource recurso = iterador.nextResource();
                int ID_Vivienda = Integer.parseInt((String) recurso.getContent());

                //Almacenamos los valores de las Viviendas
                String calle = servicio.query("for $d in /viviendas/vivienda[ID_Vivienda = " + ID_Vivienda + "] return $d/Calle/text()").getIterator().nextResource().getContent().toString();
                String numero = servicio.query("for $d in /viviendas/vivienda[ID_Vivienda = " + ID_Vivienda + "] return $d/Numero/text()").getIterator().nextResource().getContent().toString();
                String tipo = servicio.query("for $d in /viviendas/vivienda[ID_Vivienda = " + ID_Vivienda + "] return $d/Tipo/text()").getIterator().nextResource().getContent().toString();

                //Sentencia para registrar las personas
                ResourceSet resAct = servicio.query("for $d in /viviendas/vivienda[ID_Vivienda = " + ID_Vivienda + "]/habitantes/persona return $d/ID_Persona/text()");
                ResourceIterator iAct = resAct.getIterator();
                while (iAct.hasMoreResources()) {
                    Resource rAct = iAct.nextResource();
                    int ID_Persona = Integer.parseInt(rAct.getContent().toString());
                    String nombrePersona = servicio.query("for $d in /viviendas/vivienda[ID_Vivienda = " + ID_Vivienda + "]/habitantes/persona[ID_Persona = " + ID_Persona + "]  return $d/Nombre/text()").getIterator().nextResource().getContent().toString();
                    String apellidos = servicio.query("for $d in /viviendas/vivienda[ID_Vivienda = " + ID_Vivienda + "]/habitantes/persona[ID_Persona = " + ID_Persona + "]  return $d/Apellidos/text()").getIterator().nextResource().getContent().toString();
                    Integer anyoNacimiento = Integer.parseInt(servicio.query("for $d in /viviendas/vivienda[ID_Vivienda = " + ID_Vivienda + "]/habitantes/persona[ID_Persona = " + ID_Persona + "]  return $d/AnyoNacimiento/text()").getIterator().nextResource().getContent().toString());
                    String numTelefono = servicio.query("for $d in /viviendas/vivienda[ID_Vivienda = " + ID_Vivienda + "]/habitantes/persona[ID_Persona = " + ID_Persona + "]  return $d/NumTelefono/text()").getIterator().nextResource().getContent().toString();
                    Persona persona = new Persona(ID_Persona, nombrePersona, apellidos, anyoNacimiento, numTelefono);
                    listaPersonas.add(persona);
                }
                Vivienda vivienda = new Vivienda(ID_Vivienda, calle, numero, tipo, listaPersonas);
                listadoViviendas.add(vivienda);
            }
        } catch (XMLDBException | NumberFormatException e) {
            System.out.println("Error en la Busqueda");
        }

        return listadoViviendas;
    }

    public static int nuevaID_Vivienda() {
        MiConexionViviendas();

        int id_vivienda = 0;

        try {
            ResourceSet result = servicio.query("for $d in /viviendas/vivienda[ID_Vivienda = max(ID_Vivienda)]/ID_Vivienda/text() return $d");
            ResourceIterator iterador;
            iterador = result.getIterator();

            while (iterador.hasMoreResources()) {
                Resource recurso = iterador.nextResource();
                id_vivienda = Integer.parseInt((String) recurso.getContent());
                System.err.println(id_vivienda);
            }
        } catch (XMLDBException | NumberFormatException e) {
            System.out.println("Error al asignar una nueva ID");
        }

        return id_vivienda + 1;
    }

}
