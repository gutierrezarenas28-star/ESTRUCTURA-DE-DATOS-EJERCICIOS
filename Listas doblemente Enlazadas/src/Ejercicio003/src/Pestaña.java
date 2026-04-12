public class Pestaña {
    
    String tituloPagina;
    String url;
    String horaApertura;

    Pestaña siguiente;
    Pestaña anterior;

    public Pestaña(String tituloPagina, String url, String horaApertura) {
        this.tituloPagina = tituloPagina;
        this.url = url;
        this.horaApertura = horaApertura;
        this.siguiente = null;
        this.anterior = null;
    }

    

}
