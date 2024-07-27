import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private List<Alumno> alumnos;
    private List<Catedratico> catedraticos;
    private List<Curso> cursos;

    public Menu() {
        alumnos = new ArrayList<>();
        catedraticos = new ArrayList<>();
        cursos = new ArrayList<>();
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("----- Menú Principal -----");
            System.out.println("1. Registrar Alumno");
            System.out.println("2. Registrar Catedrático");
            System.out.println("3. Inscribir Alumno en Curso");
            System.out.println("4. Asignar Curso a Catedrático");
            System.out.println("5. Mostrar Alumnos");
            System.out.println("6. Mostrar Catedráticos");
            System.out.println("7. Eliminar Alumno");
            System.out.println("8. Eliminar Catedrático");
            System.out.println("9. Modificar Alumno");
            System.out.println("10. Modificar Catedrático");
            System.out.println("11. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    registrarAlumno(scanner);
                    break;
                case 2:
                    registrarCatedratico(scanner);
                    break;
                case 3:
                    inscribirAlumnoEnCurso(scanner);
                    break;
                case 4:
                    asignarCursoACatedratico(scanner);
                    break;
                case 5:
                    mostrarAlumnos();
                    break;
                case 6:
                    mostrarCatedraticos();
                    break;
                case 7:
                    eliminarAlumno(scanner);
                    break;
                case 8:
                    eliminarCatedratico(scanner);
                    break;
                case 9:
                    modificarAlumno(scanner);
                    break;
                case 10:
                    modificarCatedratico(scanner);
                    break;
                case 11:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
    }
//----------------------------ELIMINAR ALUMNO, CATEDRATICO Y/O MODIFICARLOS----------------------------------//

    private void eliminarAlumno(Scanner scanner) {
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.\n");
            return;
        }
        System.out.println("Lista de Alumnos:");
        for (int i = 0; i < alumnos.size(); i++) {
            System.out.println(i + 1 + ". " + alumnos.get(i).getNombre());
        }
        System.out.print("Elige el número del Alumno a eliminar: ");
        int numAlumno = scanner.nextInt() - 1;
        scanner.nextLine();
        if (numAlumno >= 0 && numAlumno < alumnos.size()) {
            alumnos.remove(numAlumno);
            System.out.println("Alumno eliminado exitosamente.\n");
        } else {
            System.out.println("Número de alumno inválido.\n");
        }
    }
    private void eliminarCatedratico(Scanner scanner) {
        if (catedraticos.isEmpty()) {
            System.out.println("No hay catedráticos registrados.\n");
            return;
        }
        System.out.println("Lista de Catedráticos:");
        for (int i = 0; i < catedraticos.size(); i++) {
            System.out.println(i + 1 + ". " + catedraticos.get(i).getNombre());
        }
        System.out.print("Elige el número del Catedrático a eliminar: ");
        int numCatedratico = scanner.nextInt() - 1;
        scanner.nextLine();
        if (numCatedratico >= 0 && numCatedratico < catedraticos.size()) {
            catedraticos.remove(numCatedratico);
            System.out.println("Catedrático eliminado exitosamente.\n");
        } else {
            System.out.println("Número de catedrático inválido.\n");
        }
    }
    private void modificarAlumno(Scanner scanner) {
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.\n");
            return;
        }
        System.out.println("Lista de Alumnos:");
        for (int i = 0; i < alumnos.size(); i++) {
            System.out.println(i + 1 + ". " + alumnos.get(i).getNombre());
        }
        System.out.print("Elige el número del Alumno a modificar: ");
        int numAlumno = scanner.nextInt() - 1;
        scanner.nextLine();
        if (numAlumno >= 0 && numAlumno < alumnos.size()) {
            Alumno alumno = alumnos.get(numAlumno);
            System.out.print("Nuevo nombre del Alumno (deja en blanco para no cambiar): ");
            String nuevoNombre = scanner.nextLine();
            System.out.print("Nueva carrera del Alumno (deja en blanco para no cambiar): ");
            String nuevaCarrera = scanner.nextLine();
            if (!nuevoNombre.isEmpty()) {
                alumno.setNombre(nuevoNombre);
            }
            if (!nuevaCarrera.isEmpty()) {
                alumno.setCarrera(nuevaCarrera);
            }
            System.out.println("Alumno modificado exitosamente.\n");
        } else {
            System.out.println("Número de alumno inválido.\n");
        }
    }
    private void modificarCatedratico(Scanner scanner) {
        if (catedraticos.isEmpty()) {
            System.out.println("No hay catedráticos registrados.\n");
            return;
        }
        System.out.println("Lista de Catedráticos:");
        for (int i = 0; i < catedraticos.size(); i++) {
            System.out.println(i + 1 + ". " + catedraticos.get(i).getNombre());
        }
        System.out.print("Elige el número del Catedrático a modificar: ");
        int numCatedratico = scanner.nextInt() - 1;
        scanner.nextLine();
        if (numCatedratico >= 0 && numCatedratico < catedraticos.size()) {
            Catedratico catedratico = catedraticos.get(numCatedratico);
            System.out.print("Nuevo nombre del Catedrático (deja en blanco para no cambiar): ");
            String nuevoNombre = scanner.nextLine();
            System.out.print("Nueva profesión del Catedrático (deja en blanco para no cambiar): ");
            String nuevaProfesion = scanner.nextLine();
            if (!nuevoNombre.isEmpty()) {
                catedratico.setNombre(nuevoNombre);
            }
            if (!nuevaProfesion.isEmpty()) {
                catedratico.setProfesion(nuevaProfesion);
            }
            System.out.println("Catedrático modificado exitosamente.\n");
        } else {
            System.out.println("Número de catedrático inválido.\n");
        }
    }


    private void registrarAlumno(Scanner scanner) {
        System.out.print("Nombre del Alumno: ");
        String nombre = scanner.nextLine();
        System.out.print("ID del Alumno: ");
        String id = scanner.nextLine();
        System.out.print("Carrera del Alumno: ");
        String carrera = scanner.nextLine();

        Alumno alumno = new Alumno(nombre, id, carrera);
        alumnos.add(alumno);
        System.out.println("Alumno registrado exitosamente.\n");

        // Enviar notificación por correo electrónico
        EmailSender emailSender = new EmailSender();
        emailSender.enviarCorreo("copi4l4nd@gmail.com", "Nuevo Alumno Registrado",
                "Se ha registrado un nuevo alumno:\nNombre: " + nombre + "\nID: " + id + "\nCarrera: " + carrera);
    }

    private void registrarCatedratico(Scanner scanner) {
        System.out.print("Nombre del Catedrático: ");
        String nombre = scanner.nextLine();
        System.out.print("ID del Catedrático: ");
        String id = scanner.nextLine();
        System.out.print("Profesión del Catedrático: ");
        String profesion = scanner.nextLine();

        Catedratico catedratico = new Catedratico(nombre, id, profesion);
        catedraticos.add(catedratico);
        System.out.println("Catedrático registrado exitosamente.\n");

        // Enviar notificación por correo electrónico
        EmailSender emailSender = new EmailSender();
        emailSender.enviarCorreo("copi4l4nd@gmail.com", "Nuevo Catedrático Registrado",
                "Se ha registrado un nuevo catedrático:\nNombre: " + nombre + "\nID: " + id + "\nProfesión: " + profesion);
    }

    private void inscribirAlumnoEnCurso(Scanner scanner) {
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.\n");
            return;
        }
        System.out.println("Lista de Alumnos:");
        for (int i = 0; i < alumnos.size(); i++) {
            System.out.println(i + 1 + ". " + alumnos.get(i).getNombre());
        }
        System.out.print("Elige el número del Alumno: ");
        int numAlumno = scanner.nextInt() - 1;
        scanner.nextLine();

        System.out.print("Nombre del Curso: ");
        String nombreCurso = scanner.nextLine();
        System.out.print("Código del Curso: ");
        String codigoCurso = scanner.nextLine();

        Curso curso = new Curso(nombreCurso, codigoCurso);
        alumnos.get(numAlumno).inscribirCurso(curso);
        cursos.add(curso);
    }

    private void asignarCursoACatedratico(Scanner scanner) {
        if (catedraticos.isEmpty()) {
            System.out.println("No hay catedráticos registrados.\n");
            return;
        }
        System.out.println("Lista de Catedráticos:");
        for (int i = 0; i < catedraticos.size(); i++) {
            System.out.println(i + 1 + ". " + catedraticos.get(i).getNombre());
        }
        System.out.print("Elige el número del Catedrático: ");
        int numCatedratico = scanner.nextInt() - 1;
        scanner.nextLine();

        System.out.print("Nombre del Curso: ");
        String nombreCurso = scanner.nextLine();
        System.out.print("Código del Curso: ");
        String codigoCurso = scanner.nextLine();

        Curso curso = new Curso(nombreCurso, codigoCurso);
        catedraticos.get(numCatedratico).asignarCurso(curso);
        cursos.add(curso);
    }

    private void mostrarAlumnos() {
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.\n");
        } else {
            System.out.println("----- Lista de Alumnos -----");
            for (Alumno alumno : alumnos) {
                alumno.mostrarDetalles();
            }
            System.out.println();
        }
    }

    private void mostrarCatedraticos() {
        if (catedraticos.isEmpty()) {
            System.out.println("No hay catedráticos registrados.\n");
        } else {
            System.out.println("----- Lista de Catedráticos -----");
            for (Catedratico catedratico : catedraticos) {
                catedratico.mostrarDetalles();
            }
            System.out.println();
        }
    }

}