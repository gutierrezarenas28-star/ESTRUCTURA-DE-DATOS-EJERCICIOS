package Reto.src;

import java.util.Scanner;

public class programReto {
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        int opcion;

        ColaTren tren = new ColaTren();

        do {
            System.out.println("\n==============================================");
            System.out.println("   TREN DE CARGA - Menú Principal");
            System.out.println("==============================================");
            System.out.println("1. Nuevo vagon (Agregar al final del tren)");
            System.out.println("2. Calcular peso total de la carga");
            System.out.println("3. Contar Nodos");
            System.out.println();
            System.out.println("0. Salir");
            System.out.println("==============================================");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();

            System.out.println();

            switch (opcion) {

                case 1:
                    System.out.print("Ingrese el contenido del vagon: ");
                    sc.nextLine();
                    String contenido = sc.nextLine();
                    System.out.print("Ingrese el peso del vagon (en toneladas): ");
                    double pesoToneladas = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Ingrese el origen del vagon: ");
                    String origen = sc.nextLine();
                    System.out.print("Ingrese el destino del vagon: ");
                    String destino = sc.nextLine();

                    Vagon nuevoVagon = new Vagon(contenido, pesoToneladas, origen, destino);
                    tren.agregarVagon(nuevoVagon);
                    break;
                case 2:
                    double pesoTotal = tren.calcularPesoTotal();
                    System.out.println("El peso total de la carga es: " + pesoTotal + " toneladas.");
                    break;

                case 3:
                    int numNodos= tren.contarNodos();
                    System.out.println("el numero de nodos es: "+numNodos);
                    break;

                case 0:

                
                    System.out.println("¡Saliendo del módulo de Tren de Carga!");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }

        } while (opcion != 0);

        sc.close();
    
    }
}
