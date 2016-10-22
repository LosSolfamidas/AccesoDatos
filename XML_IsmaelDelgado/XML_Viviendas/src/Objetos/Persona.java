package Objetos;

public class Persona {

    private int ID_Persona;
    private String Nombre;
    private String Apellidos;
    private int AnyoNacimiento;
    private String NumTelefono;
    private boolean registrada;

    //Constructor
    public Persona(int ID_Persona, String Nombre, String Apellidos, int AnyoNacimiento, String NumTelefono, boolean registrada) {
        this.ID_Persona = ID_Persona;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.AnyoNacimiento = AnyoNacimiento;
        this.NumTelefono = NumTelefono;
        this.registrada = registrada;
    }
    public Persona(String Nombre, String Apellidos, int AnyoNacimiento, String NumTelefono, boolean registrada) {
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.AnyoNacimiento = AnyoNacimiento;
        this.NumTelefono = NumTelefono;
        this.registrada = registrada;
    }

    public Persona(int ID_Persona, String Nombre, String Apellidos, int AnyoNacimiento, String NumTelefono) {
        this.ID_Persona = ID_Persona;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.AnyoNacimiento = AnyoNacimiento;
        this.NumTelefono = NumTelefono;
    }
    
    

    //Getters y Setters

    public int getID_Persona() {
        return ID_Persona;
    }

    public void setID_Persona(int ID_Persona) {
        this.ID_Persona = ID_Persona;
    }

    public boolean isRegistrada() {
        return registrada;
    }

    public void setRegistrada(boolean registrada) {
        this.registrada = registrada;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public int getAnyoNacimiento() {
        return AnyoNacimiento;
    }

    public void setAnyoNacimiento(int AnyoNacimiento) {
        this.AnyoNacimiento = AnyoNacimiento;
    }

    public String getNumTelefono() {
        return NumTelefono;
    }

    public void setNumTelefono(String NumTelefono) {
        this.NumTelefono = NumTelefono;
    }
    
}
