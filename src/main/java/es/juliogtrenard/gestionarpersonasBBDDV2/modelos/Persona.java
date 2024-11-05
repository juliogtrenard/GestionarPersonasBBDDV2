package es.juliogtrenard.gestionarpersonasBBDDV2.modelos;

/**
 * Clase que representa a una persona con nombre, apellidos y edad.
 */
public class Persona {
    /**
     * Id de la persona.
     */
    private int id;

    /**
     * Nombre de la persona.
     */
    private String nombre;

    /**
     * Apellidos de la persona.
     */
    private String apellidos;

    /**
     * Edad de la persona.
     */
    private int edad;

    /**
     * Constructor que inicializa los atributos de la persona.
     *
     * @param nombre    El nombre de la persona.
     * @param apellidos Los apellidos de la persona.
     * @param edad      La edad de la persona.
     */
    public Persona(int id, String nombre, String apellidos, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    /**
     * Constructor vacío
     */
    public Persona() {

    }

    /**
     * Obtiene el nombre de la persona.
     *
     * @return El nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene los apellidos de la persona.
     *
     * @return Los apellidos de la persona.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Obtiene la edad de la persona.
     *
     * @return La edad de la persona.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Establece el nombre de la persona.
     *
     * @param nombre El nuevo nombre de la persona.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece los apellidos de la persona.
     *
     * @param apellidos Los nuevos apellidos de la persona.
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Establece la edad de la persona.
     *
     * @param edad La nueva edad de la persona.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Obtiene el id de la persona.
     *
     * @return El identificador único de la persona.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el id de la persona.
     *
     * @param id El nuevo id de la persona.
     */
    public void setId(int id) {
        this.id = id;
    }
}
