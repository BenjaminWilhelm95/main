import java.util.ArrayList;
import java.util.List;

class Animal {
    private String nombre;
    private double peso;
    private String sexo;

    public Animal(String nombre, double peso, String sexo) {
        this.nombre = nombre;
        this.peso = peso;
        this.sexo = sexo;
    }

    public void hacerSonido() {
        // Por defecto, no se especifica un sonido para el animal genérico
        System.out.println("El animal hace un sonido.");
    }

    // Getters y setters para los atributos

    @Override
    public String toString() {
        return "Animal: " + nombre + " - Peso: " + peso + " - Sexo: " + sexo;
    }
}

class Perro extends Animal {
    public Perro(String nombre, double peso, String sexo) {
        super(nombre, peso, sexo);
    }

    @Override
    public void hacerSonido() {
        System.out.println("El perro hace guau guau.");
    }
}

class Gato extends Animal {
    public Gato(String nombre, double peso, String sexo) {
        super(nombre, peso, sexo);
    }

    @Override
    public void hacerSonido() {
        System.out.println("El gato hace miau miau.");
    }
}

class Cliente {
    private String nombre;

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Cliente: " + nombre;
    }
}

class Vendedor {
    private String nombre;

    public Vendedor(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Vendedor: " + nombre;
    }
}

class AgenciaDeViajes {
    private List<Cliente> clientes;
    private List<Vendedor> vendedores;
    private List<Animal> animales;

    public AgenciaDeViajes() {
        clientes = new ArrayList<>();
        vendedores = new ArrayList<>();
        animales = new ArrayList<>();
    }

    public void añadirCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void añadirVendedor(Vendedor vendedor) {
        vendedores.add(vendedor);
    }

    public void añadirAnimal(Animal animal) {
        animales.add(animal);
    }

    public Cliente buscarCliente(String nombreCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equalsIgnoreCase(nombreCliente)) {
                return cliente;
            }
        }
        return null; // Si no se encuentra el cliente
    }

    public Vendedor buscarVendedor(String nombreVendedor) {
        for (Vendedor vendedor : vendedores) {
            if (vendedor.getNombre().equalsIgnoreCase(nombreVendedor)) {
                return vendedor;
            }
        }
        return null; // Si no se encuentra el vendedor
    }

    public void eliminarVendedor(Vendedor vendedor) {
        vendedores.remove(vendedor);
    }

    public void generarVenta(Cliente cliente, Vendedor vendedor) {
        // Implementa la lógica para generar una venta
        System.out.println("Se generó una venta para el cliente " + cliente.getNombre() + " con el vendedor " + vendedor.getNombre());
    }

    public void hacerSonidoAnimal(Animal animal) {
        animal.hacerSonido();
    }
}

public class main  {
    public static void main(String[] args) {
        AgenciaDeViajes agencia = new AgenciaDeViajes();

        Cliente cliente1 = new Cliente("Juan");
        Cliente cliente2 = new Cliente("María");
        agencia.añadirCliente(cliente1);
        agencia.añadirCliente(cliente2);

        Vendedor vendedor1 = new Vendedor("Pedro");
        Vendedor vendedor2 = new Vendedor("Laura");
        agencia.añadirVendedor(vendedor1);
        agencia.añadirVendedor(vendedor2);

        Perro perro = new Perro("Max", 15.5, "Macho");
        Gato gato = new Gato("Luna", 7.2, "Hembra");
        agencia.añadirAnimal(perro);
        agencia.añadirAnimal(gato);

        Cliente clienteEncontrado = agencia.buscarCliente("Juan");
        Vendedor vendedorEncontrado = agencia.buscarVendedor("Laura");

        System.out.println(clienteEncontrado);
        System.out.println(vendedorEncontrado);

        agencia.eliminarVendedor(vendedor1);

        agencia.generarVenta(cliente2, vendedorEncontrado);

        agencia.hacerSonidoAnimal(perro);
        agencia.hacerSonidoAnimal(gato);
    }
}
