public class Ejercicio004 {
    /* ### Ejercicio 4 — Placa de un vehículo
El RUNT almacena datos básicos de vehículos. Modela la información de un carro con:

- Placa (`String`)
- Año de fabricación (`int`)
- Cilindraje en cc (`int`)
- Precio de compra (`double`)
- Inicial del color (`char`)
- Si tiene SOAT vigente (`boolean`)

Muestra todos los datos en consola. */

    public static void main(String[] args) {
        
        //placa de un vehiculo

        String placa="BX4-76I";
        int añoFabricacion=2024;
        int cilindraje=1200;
        double precioCompra=94000000;
        char color= 'A';
        boolean soat=true;

        System.out.println("Placa: "+ placa+
            "Año Fabricacion: "+ añoFabricacion+
            "Cilindraje: "+ cilindraje+
            "Precio Compra: "+ precioCompra+
            "Color: "+ color+
            "Soat: "+ soat
        );
    }
}
