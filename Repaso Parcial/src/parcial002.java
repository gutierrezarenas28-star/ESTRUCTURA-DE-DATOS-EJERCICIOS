import java.util.Scanner;

public class parcial002 {
    
    public static class Estudiante {
        int codigo;
        String nombre;
        double nota;

        public Estudiante(int codigo, String nombre, double nota) {
            this.codigo = codigo;
            this.nombre = nombre;
            this.nota = nota;
        }

        @Override
        public String toString() {
            return "Codigo: " + codigo + " | Nombre: " + nombre + " | Nota: " + nota;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Estudiante[] estudiantes = new Estudiante[6];

        System.out.println("*** REGISTRO DE ESTUDIANTES ***");

        for (int i = 0; i < estudiantes.length; i++) {
            System.out.println("\nEstudiante " + (i + 1) + ":");

            System.out.print("Ingrese el codigo: ");
            int codigo = sc.nextInt();
            sc.nextLine();

            System.out.print("Ingrese el nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Ingrese la nota: ");
            double nota = sc.nextDouble();
            sc.nextLine();

            estudiantes[i] = new Estudiante(codigo, nombre, nota);
        }

        
        int aprobados = 0;
        for (int i = 0; i < estudiantes.length; i++) {
            if (estudiantes[i].nota >= 3.0) {
                aprobados++;
            }
        }

        System.out.println("\nTotal de estudiantes que Aprobaron: " + aprobados);

        
        insertionSort(estudiantes);

        System.out.println("\n*** LISTA ORDENADA POR CODIGO ASCENDENTE ***");
        mostrarEstudiantes(estudiantes);

        // Buscar por código
        System.out.print("\nIngrese el codigo del estudiante a buscar: ");
        int codigoBuscar = sc.nextInt();

        int posicion = busquedaBinaria(estudiantes, codigoBuscar);

        if (posicion != -1) {
            System.out.println("\n*** ESTUDIANTE ENCONTRADO ***");
            System.out.println("Nombre: " + estudiantes[posicion].nombre);
            System.out.println("Nota: " + estudiantes[posicion].nota);

            if (estudiantes[posicion].nota >= 3.0) {
                System.out.println("Estado: APROBADO");
            } else {
                System.out.println("Estado: NO APRUEBA");
            }
        } else {
            System.out.println("\nEl estudiante no fue encontrado.");
        }

        System.out.println("\nTotal de estudiantes que Aprobaron: " + aprobados);

        sc.close();
    }

    // Insertion Sort
    public static void insertionSort(Estudiante[] x) {
        for (int i = 1; i < x.length; i++) {
            Estudiante actual = x[i];
            int j = i - 1;

            while (j >= 0 && x[j].codigo > actual.codigo) {
                x[j + 1] = x[j];
                j--;
            }

            x[j + 1] = actual;
        }
    }

    // Búsqueda binaria
    public static int busquedaBinaria(Estudiante[] x, int codigoBuscado) {
        int inicio = 0;
        int fin = x.length - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;

            if (x[medio].codigo == codigoBuscado) {
                return medio;
            } else if (codigoBuscado < x[medio].codigo) {
                fin = medio - 1;
            } else {
                inicio = medio + 1;
            }
        }

        return -1;
    }

    public static void mostrarEstudiantes(Estudiante[] x) {
        for (int i = 0; i < x.length; i++) {
            System.out.println(x[i]);
        }
    }


}
