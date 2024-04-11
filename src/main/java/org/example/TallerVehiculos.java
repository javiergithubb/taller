package org.example;
import java.util.ArrayList;
import java.util.Scanner;

// Clase base para representar un vehículo
class Vehiculo {
    private String matricula;
    private String color;
    private String marca;

    public Vehiculo(String matricula, String color, String marca) {
        this.matricula = matricula;
        this.color = color;
        this.marca = marca;
    }

    public String obtenerMatricula() {
        return matricula;
    }

    public String obtenerColor() {
        return color;
    }

    public String obtenerMarca() {
        return marca;
    }

    public String obtenerTipo() {
        return "Vehículo";
    }

    public String toString() {
        return obtenerTipo() + " - Matrícula: " + matricula + ", Color: " + color + ", Marca: " + marca;
    }
}

// Clases derivadas que heredan de Vehiculo
class Coche extends Vehiculo {
    public Coche(String matricula, String color, String marca) {
        super(matricula, color, marca);
    }

    @Override
    public String obtenerTipo() {
        return "Coche";
    }
}

class Moto extends Vehiculo {
    public Moto(String matricula, String color, String marca) {
        super(matricula, color, marca);
    }

    @Override
    public String obtenerTipo() {
        return "Moto";
    }
}

class Camion extends Vehiculo {
    public Camion(String matricula, String color, String marca) {
        super(matricula, color, marca);
    }

    @Override
    public String obtenerTipo() {
        return "Camión";
    }
}

class Tractor extends Vehiculo {
    public Tractor(String matricula, String color, String marca) {
        super(matricula, color, marca);
    }

    @Override
    public String obtenerTipo() {
        return "Tractor";
    }
}

class Grua extends Vehiculo {
    public Grua(String matricula, String color, String marca) {
        super(matricula, color, marca);
    }

    @Override
    public String obtenerTipo() {
        return "Grua";
    }
}

// Clase principal que maneja el taller
public class TallerVehiculos {
    private ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
        System.out.println("Vehículo agregado al taller: " + vehiculo);
    }

    public void repararVehiculo() {
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehículos para reparar.");
            return;
        }

        System.out.println("Vehículos en el taller:");
        for (int i = 0; i < vehiculos.size(); i++) {
            System.out.println((i + 1) + ". " + vehiculos.get(i));
        }

        System.out.print("Seleccione el vehículo a reparar (1-" + vehiculos.size() + "): ");
        int opcion = scanner.nextInt();
        if (opcion < 1 || opcion > vehiculos.size()) {
            System.out.println("Opción inválida.");
            return;
        }

        Vehiculo vehiculo = vehiculos.get(opcion - 1);
        System.out.println("Reparando vehículo: " + vehiculo);

        scanner.nextLine(); // Limpiar el buffer del scanner

        System.out.print("¿Qué hay que reparar? ");
        String reparacion = scanner.nextLine();
        System.out.println("Reparación a realizar en " + vehiculo.obtenerTipo() + ": " + reparacion);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\nMenú:");
            System.out.println("1. ¿Qué vehículo entra?");
            System.out.println("2. ¿Qué hay que reparar?");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    agregarVehiculo(ingresoVehiculo());
                    break;
                case 2:
                    repararVehiculo();
                    break;
                case 3:
                    System.out.println("Saliendo del taller...");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        } while (opcion != 3);
    }

    private Vehiculo ingresoVehiculo() {
        System.out.println("\nSeleccione el tipo de vehículo:");
        System.out.println("1. Coche");
        System.out.println("2. Moto");
        System.out.println("3. Camión");
        System.out.println("4. Tractor");
        System.out.println("5. Grua");
        System.out.print("Ingrese el tipo de vehículo (1-5): ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner

        System.out.print("Ingrese la matrícula del vehículo: ");
        String matricula = scanner.nextLine();
        System.out.print("Ingrese el color del vehículo: ");
        String color = scanner.nextLine();
        System.out.print("Ingrese la marca del vehículo: ");
        String marca = scanner.nextLine();

        switch (opcion) {
            case 1:
                return new Coche(matricula, color, marca);
            case 2:
                return new Moto(matricula, color, marca);
            case 3:
                return new Camion(matricula, color, marca);
            case 4:
                return new Tractor(matricula, color, marca);
            case 5:
                return new Grua(matricula, color, marca);
            default:
                System.out.println("Opción inválida, se creará un vehículo genérico.");
                return new Vehiculo(matricula, color, marca);
        }
    }

    public static void main(String[] args) {
        TallerVehiculos taller = new TallerVehiculos();
        taller.mostrarMenu();
    }
}
