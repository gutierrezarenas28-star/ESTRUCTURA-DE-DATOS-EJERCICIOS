import java.util.Scanner;

public class Ejercicio004 {
    /*
    4. Control de Acceso (Gimnasio)
Un gimnasio tiene una lista de códigos de acceso de los socios que pagaron la mensualidad. La lista está **ordenada de menor a mayor**.
- **El Problema:** Cuando un socio digita su código, el sistema debe validar si el código está en la lista de "pagos al día". Si no está, se le niega la entrada.
- **Algoritmo a usar:** **Búsqueda Binaria**. Es eficiente para buscar códigos numéricos en una lista que ya está organizada. */

    public static void main(String[] args) {

        int[] codigos = {1001, 1050, 1100, 1200, 1300, 1400, 1500};

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese su código de acceso: ");
        int codigoBuscado = sc.nextInt();

        int inicio = 0;
        int fin = codigos.length - 1;
        boolean autorizado = false;

        while (inicio <= fin) {

            int medio = (inicio + fin) / 2;

            if (codigos[medio] == codigoBuscado) {
                autorizado = true;
                break;
            }

            if (codigoBuscado < codigos[medio]) {
                fin = medio - 1;
            } else {
                inicio = medio + 1;
            }
        }

        if (autorizado) {
            System.out.println("Acceso permitido. Bienvenido ");
        } else {
            System.out.println("Acceso denegado. Mensualidad pendiente.");
        }

        sc.close();
    }
}
