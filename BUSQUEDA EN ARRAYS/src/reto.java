import java.util.Scanner;

public class reto {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] listaNegra = {50, 120, 450, 800, 999};

        int[] intentos = new int[8];

        for (int i = 0; i < 8; i++) {
            System.out.print("Ingrese 8 IDs de intentos de acceso "+(i+1)+": ");
            intentos[i] = sc.nextInt();
        }

        int max = intentos[0];

        for (int i = 1; i < intentos.length; i++) {
            if (intentos[i] > max) {
                max = intentos[i];
            }
        }

        System.out.println("ID sospechoso principal: " + max);

        int inicio = 0;
        int fin = listaNegra.length - 1;
        boolean encontrado = false;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;

            if (listaNegra[medio] == max) {
                encontrado = true;
                break;
            } else if (max < listaNegra[medio]) {
                fin = medio - 1;
            } else {
                inicio = medio + 1;
            }
        }

        if (encontrado) {
            System.out.println("El atacante ya está en la lista negra.");
        } else {
            System.out.println("Nuevo atacante detectado, procediendo a bloquear.");
        }

        sc.close();
    }
}
