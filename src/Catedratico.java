import java.util.ArrayList;
import java.util.List;

public class Catedratico extends Persona {
    private String profesion;
    private List<Curso> cursos;

    public Catedratico(String nombre, String id, String profesion) {
        super(nombre, id);
        this.profesion = profesion;
        this.cursos = new ArrayList<>();
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public void asignarCurso(Curso curso) {
        cursos.add(curso);
        System.out.println("Asignado al curso: " + curso.getNombre());
    }
//COLOCO CON OVERRIDE PARA SOBREESCRIBIR UN METODO CON EL MISMO NOMBRE Y LA MISMA FIRMA EN SU SUPERCLASE//
    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Catedratico: " + getNombre() + ", ID: " + getId() + ", Profesion: " + profesion);
        System.out.println("Cursos Asignados:");
        for (Curso curso : cursos) {
            System.out.println(" - " + curso.getNombre());
        }
    }
}
