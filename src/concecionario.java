public class concecionario {

    private String cochesAlmacenados[];
    private int puntero =0;
    private boolean lleno = false;
    private boolean vacio = true;

    // Asigna la distancia que tienes de los coches almacenados
    public concecionario (int capacidad) {this.cochesAlmacenados = new String[capacidad];}

    public synchronized void introducirCoche(String coche) throws InterruptedException {

        // si el array esta llego espera hasta que tenga un hueco
        while (lleno) {
            wait();
        }

        // Añado un coche al array
        cochesAlmacenados[puntero] = coche;
        //muevo el puntero una posición
        puntero = puntero + 1;
        //indico que no esta vacio
        vacio = false;
        // si el puntero  se pasa o tiene la misma cantidad que la capacidad del array indico que esta lleno
        lleno = puntero >= cochesAlmacenados.length;
        // Notifico a todos los procesos que este acabó con la ejecución
        notifyAll();
    }

    public synchronized String retirarCoche() throws InterruptedException {

        // si el array esta llego espera hasta que tenga un vehiculo dentro
        while (vacio) {
            wait();
        }
        // Quito un vehiculo del array
        String cocheEscogido = cochesAlmacenados[--puntero];
        // indico que no esta llego el array
        lleno = false;
        // si es cero o nemor indico que el array esta vacio
        vacio = puntero <= 0;
        // Notifico a todos los procesos que este acabó con la ejecución
        notifyAll();
        // retorno el coche
        return cocheEscogido;
    }




}

