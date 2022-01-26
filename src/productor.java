public class productor extends Thread {

    // instancio las constantes necesarias para utilizarlas más adelante
    private final concecionario buffer;
    private final int unidadesDeCochesProducidos;
    private final int tiempoDeProduccion;

    private String[] coches = { "Seat León",
            "Audi Accidentado",
            "Nissan Qashqai",
            "Citröen Berlingo",
            "Volkswagen Polo",
            "Opel Meriva",
            "Fiat Punto",
            "Tesla Roadster",
            "Hyundai Ioniq"
    };

    // creo el constructor
    public productor(concecionario buffer, int unidadesDeCochesProducidos, int tiempoDeProduccion) {
        this.buffer = buffer;
        this.unidadesDeCochesProducidos = unidadesDeCochesProducidos;
        this.tiempoDeProduccion = tiempoDeProduccion;
    }

    @Override
    public void run() {

        int Marcacoche;
        String cocheproducido;
        int Tproduccion;

        try {
            // hago un bucle con la cantida de cohes que quiero producir
            for (int i = 0; i < unidadesDeCochesProducidos; i++) {

                // genero un numero randome el cual lo utilizo para que espere la aplicación
                Tproduccion = (int) (Math.random() * this.tiempoDeProduccion);
                sleep(Tproduccion);
                // saco un numero randome de la lista para poder sacar un coche
                Marcacoche = (int) (Math.random() * this.coches.length);
                cocheproducido = coches[Marcacoche];
                // llamo al buffer el cual es el concesionario y meto el coche
                buffer.introducirCoche(cocheproducido);
                // muestro por pantalla los datos
                System.out.println("Se produjo el vehiculo => " + cocheproducido + " tardo en producirse " + Tproduccion + " segundos");
                System.out.println("*****************************************************************");
            }
        } catch (Exception e) {

        }
    }

}