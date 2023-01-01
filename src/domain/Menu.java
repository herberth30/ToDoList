package domain;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<String> opciones;

    public Menu() {
        opciones = new ArrayList<>();
        opciones.add("Ver todo");
        opciones.add("Ver completos");
        opciones.add("Ver incompletos");
        opciones.add("Insertar tarea");
        opciones.add("Marcar completo");
        opciones.add("Marcar incompleto");
        opciones.add("Eliminar tarea");
        opciones.add("Salir");

    }

    public void mostrarMenu() {
        System.out.println();
        System.out.println("----------------------------------------------------------------");
        System.out.println("TO-DO-LIST");
        for (int i = 0; i < opciones.size(); i++) {
            System.out.println((i + 1) + "-" + opciones.get(i));
        }
        System.out.println("----------------------------------------------------------------");
    }
}
