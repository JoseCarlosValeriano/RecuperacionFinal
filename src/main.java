public class main {

    public static void main(String[] args) {
        int unidadcoche = 10;
        // Instancio el concesionario donde se guardan los coches que el productor produce y el cliente compra
        concecionario Puntodeventa = new concecionario(10);
        //Tambien Instancio al productor de los coches y el cliente
        productor Jaime = new productor(Puntodeventa, unidadcoche, 3000);
        cliente Juan = new cliente(Puntodeventa, unidadcoche);

        //El productor y el consumidor empiezan con la ejecución
        Jaime.start();
        Juan.start();
    }
}