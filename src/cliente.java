public class cliente extends Thread {
    private concecionario buffer;
    private int unidadcompracoche;

    public cliente(concecionario buffer, int unidadcompracoche) {
        this.buffer = buffer;
        this.unidadcompracoche = unidadcompracoche;
    }

    @Override
    public void run() {
        try {
            // Tengo un bucle el cual sirve retirar x coches indicados
            for (int i = 0; i < unidadcompracoche; i++) {
                // Escojo los coches del array
                String texto = buffer.retirarCoche();
                // Espero un tiempo random
                sleep((int) (Math.random() * 3000) + 1000);
                // Muestro por pantalla.
                System.out.println("Se retiro el coche " + texto + " del concecionario");
                System.out.println("**********************************************************");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
