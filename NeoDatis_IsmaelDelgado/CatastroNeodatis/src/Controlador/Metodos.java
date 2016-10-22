package Controlador;

import Objetos.Persona;
import Objetos.Vivienda;
import java.util.ArrayList;
import org.neodatis.odb.*;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

public class Metodos {

    public static ArrayList<Persona> listadoPersonasNoReg = new ArrayList<>();

    //**************************************************************************
    //************************ MÉTODOS DE VIVIENDAS ****************************
    //**************************************************************************
    public static ArrayList<Vivienda> viviendasSELECT() {
        ODB BaseDatos = ODBFactory.open("Catastro.DB");// Este es el nombre que se otorga a la DB
        ArrayList<Vivienda> listaViviendas = new ArrayList<>();

        try {
            IQuery SELECT = new CriteriaQuery(Vivienda.class);
            Objects<Vivienda> iterador = BaseDatos.getObjects(SELECT);

            while (iterador.hasNext()) {
                Vivienda vivienda = iterador.next();
                listaViviendas.add(vivienda);
            }
        } catch (Exception e) {
            System.out.println("Error al realizar el SELECT");
        } finally {
            BaseDatos.close();
        }
        return listaViviendas;
    }

    //Método para asignar una nueva ID a una vivienda de forma autoincremental
    public static int nuevaIDVivienda() {
        int newID = 0;

        ODB BaseDatos = ODBFactory.open("Catastro.DB");
        try {
            Values valores = BaseDatos.getValues(new ValuesCriteriaQuery(Objetos.Vivienda.class).field("ID_Vivienda"));
            while (valores.hasNext()) {
                ObjectValues objectValues = (ObjectValues) valores.next();
                newID = (int) objectValues.getByAlias("ID_Vivienda");
            }
        } catch (Exception e) {
            System.out.println("Error al crear la nueva ID");
        } finally {
            BaseDatos.close();
        }
        newID = newID + 1;
        return newID;
    }

    public static boolean viviendaINSERT(Object vivienda) {
        ODB BaseDatos = ODBFactory.open("Catastro.DB");
        try {
            BaseDatos.store(vivienda);
            return true;
        } catch (Exception e) {
            System.out.println("Error al Insertar");
            return false;
        } finally {
            BaseDatos.close();
        }
    }

    public static boolean viviendaUPDATE(Vivienda updateVivienda) {
        ODB BaseDatos = ODBFactory.open("Catastro.DB");
        try {
            IQuery query = new CriteriaQuery(Vivienda.class, Where.equal("ID_Vivienda", updateVivienda.getID_Vivienda()));
            Objects<Vivienda> objecto = BaseDatos.getObjects(query);

            Vivienda Vivienda = objecto.getFirst();

            Vivienda.setCalle(updateVivienda.getCalle());
            Vivienda.setNumero(updateVivienda.getNumero());
            Vivienda.setTipo(updateVivienda.getTipo());
            Vivienda.setHabitantes(updateVivienda.getHabitantes());

            BaseDatos.store(Vivienda);

            return true;
        } catch (Exception e) {
            System.out.println("Error al Actualizar");
            return false;
        } finally {
            BaseDatos.close();
        }
    }

    public static boolean viviendaDELETE(Vivienda vivienda) {
        ODB BaseDatos = ODBFactory.open("Catastro.DB");

        try {
            IQuery DELETE = new CriteriaQuery(Vivienda.class, Where.equal("ID_Vivienda", vivienda.getID_Vivienda()));
            Objects<Vivienda> objeto = BaseDatos.getObjects(DELETE);

            BaseDatos.deleteCascade(objeto.getFirst());

            BaseDatos.commit();
            return true;
        } catch (Exception e) {
            System.out.println("Error al Borrar");
            return false;
        } finally {
            BaseDatos.close();
        }
    }

    public static ArrayList<Vivienda> viviendaBUSQUEDA(String Calle) {
        ODB BaseDatos = ODBFactory.open("Catastro.DB");
        ArrayList<Vivienda> listaViviendas = new ArrayList<>();

        try {
            IQuery query = new CriteriaQuery(Vivienda.class, Where.like("Calle", Calle));
            Objects<Vivienda> objeto = BaseDatos.getObjects(query);

            while (objeto.hasNext()) {
                Vivienda vivienda = objeto.next();
                listaViviendas.add(vivienda);
            }
        } catch (Exception e) {
            System.out.println("Error en la Busqueda");
        } finally {
            BaseDatos.close();
        }

        return listaViviendas;
    }

    //**************************************************************************
    //*********************** MÉTODOS PARA LAS PERSONAS **********************
    //**************************************************************************
    public static ArrayList<Persona> totalPersonasSELECT() {
        ODB BaseDatos = ODBFactory.open("Catastro.DB");
        ArrayList<Persona> listadoPersonas = new ArrayList<>();
        ArrayList<Integer> arrayIDes = new ArrayList<>();

        try {
            IQuery SELECT = new CriteriaQuery(Persona.class);
            Objects<Persona> personas = BaseDatos.getObjects(SELECT);

            while (personas.hasNext()) {
                Persona persona = personas.next();
                if (!arrayIDes.contains(persona.getID_Persona())) {
                    arrayIDes.add(persona.getID_Persona());
                    listadoPersonas.add(persona);
                }
            }
        } catch (Exception e) {
            System.out.println("Error al realizar el SELECT");
        } finally {
            BaseDatos.close();
        }

        return listadoPersonas;
    }

    //Método para asignar una nueva ID a una persona de forma autoincremental
    public static int nuevoIDPersona() {
        int nuevaID = 0;
        ODB BaseDatos = ODBFactory.open("Catastro.DB");

        try {
            Values valores = BaseDatos.getValues(new ValuesCriteriaQuery(Objetos.Persona.class).field("ID_Persona"));
            while (valores.hasNext()) {
                ObjectValues objectValues = (ObjectValues) valores.next();
                nuevaID = (int) objectValues.getByAlias("ID_Persona");
            }
        } catch (Exception e) {
            System.out.println("Error al crear la nueva ID");
        } finally {
            BaseDatos.close();
        }
        nuevaID = nuevaID + 1;
        return nuevaID;
    }

    public static void personasNoRegSELECT() {

        ODB BaseDatos = ODBFactory.open("Catastro.DB");
        listadoPersonasNoReg.clear();

        try {
            IQuery SELECT = new CriteriaQuery(Persona.class);
            Objects<Persona> objetoPersonas = BaseDatos.getObjects(SELECT);

            while (objetoPersonas.hasNext()) {
                Persona persona = objetoPersonas.next();

                if (!persona.isRegistrada()) {
                    listadoPersonasNoReg.add(persona);
                }
            }
        } catch (Exception e) {
            System.out.println("Error al realizar el SELECT");
        } finally {
            BaseDatos.close();
        }
    }

    public static ArrayList<Persona> habitantesSELECT(Vivienda vivienda) {

        ODB BaseDatos = ODBFactory.open("Catastro.DB");
        ArrayList<Persona> listadoHabitantes = new ArrayList<>();
        try {
            IQuery query = new CriteriaQuery(Vivienda.class, Where.equal("ID_Vivienda", vivienda.getID_Vivienda()));

            Objects<Vivienda> objetoVivienda = BaseDatos.getObjects(query);

            Vivienda aux = objetoVivienda.getFirst();
            
            
            for (int i = 0; i < aux.getHabitantes().size(); i++) {
                listadoHabitantes.add(aux.getHabitantes().get(i));
            }

        } catch (Exception e) {
            System.out.println("Error al realizar el SELECT");
        } finally {
            BaseDatos.close();
        }

        return listadoHabitantes;
    }

    //Método para insertar una nueva Persona
    public static boolean personaINSERT(Object objeto) {
        ODB BaseDatos = ODBFactory.open("Catastro.DB");
        try {
            BaseDatos.store(objeto);
            return true;
        } catch (Exception e) {
            System.out.println("Error al Insertar");
            return false;
        } finally {
            BaseDatos.close();
        }
    }

    public static boolean personaUPDATE(Persona personaUpdate) {
        ODB BaseDatos = ODBFactory.open("Catastro.DB");
        try {
            IQuery query = new CriteriaQuery(Persona.class, Where.equal("ID_Persona", personaUpdate.getID_Persona()));
            Objects<Persona> objetoPersona = BaseDatos.getObjects(query);

            Persona persona = objetoPersona.getFirst();

            persona.setNombre(personaUpdate.getNombre());
            persona.setApellidos(personaUpdate.getApellidos());
            persona.setAnyoNacimiento(personaUpdate.getAnyoNacimiento());
            persona.setNumTelefono(personaUpdate.getNumTelefono());

            BaseDatos.store(persona);
            BaseDatos.commit();

            return true;
        } catch (Exception e) {
            System.out.println("Error al Actualizar");
            return false;
        } finally {
            BaseDatos.close();
        }
    }

    public static boolean personaDELETE(Persona persona) {
        ODB BaseDatos = ODBFactory.open("Catastro.DB");

        try {
            IQuery query = new CriteriaQuery(Persona.class, Where.equal("ID_Persona", persona.getID_Persona()));
            Objects<Persona> objetoPersona = BaseDatos.getObjects(query);

            BaseDatos.deleteCascade(objetoPersona.getFirst());

            Objects<Persona> objetoPersona2 = BaseDatos.getObjects(query);
            try {
                BaseDatos.deleteCascade(objetoPersona2.getFirst());
            } catch (Exception e) {

            }

            BaseDatos.commit();
            return true;
        } catch (Exception e) {
            System.out.println("Error al Borrar");
            return false;
        } finally {
            BaseDatos.close();
        }
    }

    public static ArrayList<Persona> personaBUSQUEDA(String nombrePersona) {
        ODB BaseDatos = ODBFactory.open("Catastro.DB");
        ArrayList<Persona> listaPersonas = new ArrayList<>();

        try {
            IQuery query = new CriteriaQuery(Persona.class, Where.like("Nombre", nombrePersona));
            Objects<Objetos.Persona> o = BaseDatos.getObjects(query);

            while (o.hasNext()) {
                Persona n = o.next();
                listaPersonas.add(n);
            }
        } catch (Exception e) {
            System.out.println("Error en la Busqueda");
        } finally {
            BaseDatos.close();
        }

        return listaPersonas;
    }

    //**************************************************************************
    //*********************** MÉTODOS MIXTOS **********************
    //**************************************************************************
    public static boolean registrarPersonaUPDATE(Persona personaUpdate, boolean registrada) {
        ODB BaseDatos = ODBFactory.open("Catastro.DB");
        try {
            IQuery query = new CriteriaQuery(Persona.class, Where.equal("ID_Persona", personaUpdate.getID_Persona()));
            Objects<Persona> objetoPersona = BaseDatos.getObjects(query);
            Persona persona = objetoPersona.getFirst();

            persona.setRegistrada(registrada);
            BaseDatos.store(persona);
            BaseDatos.commit();
            BaseDatos.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error al Actualizar Persona");
            return false;
        }
    }

    public static boolean personaEnViviendaUPDATE(Persona persona, Vivienda vivienda) {

        ODB BaseDatos = ODBFactory.open("Catastro.DB");
        try {

            IQuery queryVivienda = new CriteriaQuery(Vivienda.class, Where.equal("ID_Vivienda", vivienda.getID_Vivienda()));
            Objects<Vivienda> objetoVivienda = BaseDatos.getObjects(queryVivienda);

            Vivienda vivSeleccionada = objetoVivienda.getFirst();

            IQuery query = new CriteriaQuery(Persona.class, Where.equal("ID_Persona", persona.getID_Persona()));
            Objects<Persona> objetoPersona = BaseDatos.getObjects(query);
            
            Persona personaSeleccionada = objetoPersona.getFirst();
            
            vivSeleccionada.getHabitantes().add(personaSeleccionada);
            
            BaseDatos.store(vivSeleccionada);

            BaseDatos.commit();
            BaseDatos.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error al Actualizar Vivienda");
            return false;
        } 
    }

    public static boolean personaEnViviendaDELETE(Persona persona, Vivienda vivienda) {

        ODB BaseDatos = ODBFactory.open("Catastro.DB");
        try {

            IQuery queryVivienda = new CriteriaQuery(Vivienda.class, Where.equal("ID_Vivienda", vivienda.getID_Vivienda()));
            Objects<Vivienda> objetoVivienda = BaseDatos.getObjects(queryVivienda);

            Vivienda viv = objetoVivienda.getFirst();
            

            IQuery queryPersona = new CriteriaQuery(Persona.class, Where.equal("ID_Persona", persona.getID_Persona()));
            Objects<Persona> objetoPersona = BaseDatos.getObjects(queryPersona);

            Persona per = objetoPersona.getFirst();

            for (int i = 0; i < viv.getHabitantes().size(); i++) {
                Persona aux = viv.getHabitantes().get(i);

                if (aux.equals(per)) {
                    viv.getHabitantes().remove(aux);
                    BaseDatos.store(viv);
                    BaseDatos.commit();
                }
            }
            //BaseDatos.store(viv);

            //BaseDatos.commit();
            BaseDatos.close();

            return true;
        } catch (Exception e) {
            BaseDatos.close();
            System.out.println("Error al Actualizar Vivienda");
            return false;
        }
    }
    

}
