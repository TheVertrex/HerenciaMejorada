
//TODO ESTO FUE HECHO CON AYUDA DE CHATGPT, NO LO TOME COMO UNA MODIFICACIÓN VALIDA, SOLO QUERÍA EXPERIMENTAR CON DESARROLLO DE LA APLICACIÓN//

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GuiApp {
    private JFrame frame;
    private JTextArea textArea;
    private JTextField nameField, idField, carreraField, profesionField, cursoNombreField, cursoCodigoField;
    private List<Alumno> alumnos;
    private List<Catedratico> catedraticos;
    private List<Curso> cursos;

    public GuiApp() {
        alumnos = new ArrayList<>();
        catedraticos = new ArrayList<>();
        cursos = new ArrayList<>();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Sistema de Gestión Académica");
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.NORTH);
        panel.setLayout(new GridLayout(6, 2, 5, 5));

        panel.add(new JLabel("Nombre:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("ID:"));
        idField = new JTextField();
        panel.add(idField);

        panel.add(new JLabel("Carrera:"));
        carreraField = new JTextField();
        panel.add(carreraField);

        panel.add(new JLabel("Profesión:"));
        profesionField = new JTextField();
        panel.add(profesionField);

        panel.add(new JLabel("Nombre del Curso:"));
        cursoNombreField = new JTextField();
        panel.add(cursoNombreField);

        panel.add(new JLabel("Código del Curso:"));
        cursoCodigoField = new JTextField();
        panel.add(cursoCodigoField);

        JPanel buttonPanel = new JPanel();
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        buttonPanel.setLayout(new GridLayout(1, 5, 5, 5));

        JButton btnRegistrarAlumno = new JButton("Registrar Alumno");
        btnRegistrarAlumno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registrarAlumno();
            }
        });
        buttonPanel.add(btnRegistrarAlumno);

        JButton btnRegistrarCatedratico = new JButton("Registrar Catedrático");
        btnRegistrarCatedratico.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registrarCatedratico();
            }
        });
        buttonPanel.add(btnRegistrarCatedratico);

        JButton btnModificarAlumno = new JButton("Modificar Alumno");
        btnModificarAlumno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modificarAlumno();
            }
        });
        buttonPanel.add(btnModificarAlumno);

        JButton btnEliminarAlumno = new JButton("Eliminar Alumno");
        btnEliminarAlumno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarAlumno();
            }
        });
        buttonPanel.add(btnEliminarAlumno);

        JButton btnMostrar = new JButton("Mostrar Datos");
        btnMostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarDatos();
            }
        });
        buttonPanel.add(btnMostrar);

        frame.setVisible(true);
    }

    private void registrarAlumno() {
        String nombre = nameField.getText();
        String id = idField.getText();
        String carrera = carreraField.getText();
        if (!nombre.isEmpty() && !id.isEmpty() && !carrera.isEmpty()) {
            Alumno alumno = new Alumno(nombre, id, carrera);
            alumnos.add(alumno);
            textArea.append("Alumno registrado: " + nombre + "\n");
        } else {
            textArea.append("Datos incompletos para registrar el alumno.\n");
        }
    }

    private void registrarCatedratico() {
        String nombre = nameField.getText();
        String id = idField.getText();
        String profesion = profesionField.getText();
        if (!nombre.isEmpty() && !id.isEmpty() && !profesion.isEmpty()) {
            Catedratico catedratico = new Catedratico(nombre, id, profesion);
            catedraticos.add(catedratico);
            textArea.append("Catedrático registrado: " + nombre + "\n");
        } else {
            textArea.append("Datos incompletos para registrar el catedrático.\n");
        }
    }

    private void modificarAlumno() {
        String id = idField.getText();
        String nuevoNombre = nameField.getText();
        String nuevaCarrera = carreraField.getText();

        Alumno alumno = buscarAlumnoPorId(id);
        if (alumno != null) {
            if (!nuevoNombre.isEmpty()) {
                alumno.setNombre(nuevoNombre);
            }
            if (!nuevaCarrera.isEmpty()) {
                alumno.setCarrera(nuevaCarrera);
            }
            textArea.append("Alumno modificado: " + alumno.getNombre() + "\n");
        } else {
            textArea.append("Alumno con ID " + id + " no encontrado.\n");
        }
    }

    private void eliminarAlumno() {
        String id = idField.getText();
        Alumno alumno = buscarAlumnoPorId(id);
        if (alumno != null) {
            alumnos.remove(alumno);
            textArea.append("Alumno eliminado: " + alumno.getNombre() + "\n");
        } else {
            textArea.append("Alumno con ID " + id + " no encontrado.\n");
        }
    }

    private Alumno buscarAlumnoPorId(String id) {
        for (Alumno alumno : alumnos) {
            if (alumno.getId().equals(id)) {
                return alumno;
            }
        }
        return null;
    }

    private void mostrarDatos() {
        textArea.append("----- Lista de Alumnos -----\n");
        for (Alumno alumno : alumnos) {
            textArea.append("Alumno: " + alumno.getNombre() + ", ID: " + alumno.getId() + ", Carrera: " + alumno.getCarrera() + "\n");
        }
        textArea.append("----- Lista de Catedráticos -----\n");
        for (Catedratico catedratico : catedraticos) {
            textArea.append("Catedrático: " + catedratico.getNombre() + ", ID: " + catedratico.getId() + ", Profesión: " + catedratico.getProfesion() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GuiApp();
            }
        });
    }
}
