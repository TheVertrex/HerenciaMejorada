abstract class Persona {
    private String nombre;
    private String id;

    public Persona(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }
    //MODIFICACION PARA HACER PUBLICO EL ATRIBUTO NOMBRE PARA NO IMPEDIR ACCESO DIRECTO DESDE SUBCLASES//
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setId(String id) {
        this.id = id;
    }
    public abstract void mostrarDetalles();
}