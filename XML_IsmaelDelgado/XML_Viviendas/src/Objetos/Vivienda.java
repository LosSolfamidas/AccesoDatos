package Objetos;

import java.util.*;

public class Vivienda implements java.io.Serializable {

    private int ID_Vivienda;
    private String Calle;
    private String Numero;
    private String Tipo;
    private ArrayList<Persona> Habitantes;

    
    //Constructores
    public Vivienda() {
    }

    public Vivienda(int ID_Vivienda, String Calle, String Numero, String Tipo) {
        this.ID_Vivienda = ID_Vivienda;
        this.Calle = Calle;
        this.Numero = Numero;
        this.Tipo = Tipo;
    }

    public Vivienda(int ID_Vivienda, String Calle, String Numero, String Tipo, ArrayList<Persona> Habitantes) {
        this.ID_Vivienda = ID_Vivienda;
        this.Calle = Calle;
        this.Numero = Numero;
        this.Tipo = Tipo;
        this.Habitantes = Habitantes;
    }

    public Vivienda(ArrayList<Persona> Habitantes) {
        this.Habitantes = Habitantes;
    }
    
    
    
    //Getters y Setters 

    public int getID_Vivienda() {
        return ID_Vivienda;
    }

    public void setID_Vivienda(int ID_Vivienda) {
        this.ID_Vivienda = ID_Vivienda;
    }

    public String getCalle() {
        return Calle;
    }

    public void setCalle(String Calle) {
        this.Calle = Calle;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String Numero) {
        this.Numero = Numero;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public ArrayList<Persona> getHabitantes() {
        return Habitantes;
    }

    public void setHabitantes(ArrayList<Persona> Habitantes) {
        this.Habitantes = Habitantes;
    }

    public void getHabitantes(Persona personaSeleccionada) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
