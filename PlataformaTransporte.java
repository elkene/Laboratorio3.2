public class PlataformaTransporte {
    public static void main(String[] args) {
        // Crear una instancia de CarroServicio
        CarroServicio carro = new CarroServicio("ABC123", "Toyota Corolla", 4);

        // Usar métodos de la clase Carro
        System.out.println("Matrícula: " + carro.getMatricula());
        System.out.println("Modelo: " + carro.getModelo());
        System.out.println("Capacidad: " + carro.getCapacidad());
        carro.conducir();
        carro.estacionar();

        // Usar métodos de la interfaz Servicio
        carro.iniciarViaje("Centro Comercial");
        carro.calcularTarifa(10.5); // Ejemplo de distancia
        carro.finalizarViaje();
    }
}

abstract class Vehiculo {
    protected String matricula;
    protected String modelo;
    protected int capacidad;

    public Vehiculo(String matricula, String modelo, int capacidad) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.capacidad = capacidad;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public abstract void conducir();
    public abstract void estacionar();
}

class Carro extends Vehiculo {
    public Carro(String matricula, String modelo, int capacidad) {
        super(matricula, modelo, capacidad);
    }

    @Override
    public void conducir() {
        System.out.println("Conduciendo el carro " + modelo);
    }

    @Override
    public void estacionar() {
        System.out.println("Estacionando el carro " + modelo);
    }
}
interface Servicio {
    void iniciarViaje(String destino);
    void finalizarViaje();
    double calcularTarifa(double distancia);
}

class CarroServicio extends Carro implements Servicio {
    public CarroServicio(String matricula, String modelo, int capacidad) {
        super(matricula, modelo, capacidad);
    }

    @Override
    public void iniciarViaje(String destino) {
        System.out.println("Iniciando viaje hacia " + destino);
    }

    @Override
    public void finalizarViaje() {
        System.out.println("Finalizando viaje.");
    }

    @Override
    public double calcularTarifa(double distancia) {
        double tarifa = distancia * 1.5; // Ejemplo de cálculo de tarifa
        System.out.println("La tarifa es: $" + tarifa);
        return tarifa;
    }
}
