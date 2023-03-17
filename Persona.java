import java.util.Random;

public class Persona {
    String nombre;
    int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public static void main(String[] args) {
        String[] nombres = {"Juan", "Ana", "Pedro", "Luis", "Marta", "Carla", "Jorge", "Lucía", "María", "Pablo"};
        Random random = new Random();
        Persona[] personas = new Persona[10];
        
        for (int i = 0; i < personas.length; i++) {
            String nombreAleatorio = nombres[random.nextInt(nombres.length)];
            int edadAleatoria = random.nextInt(50) + 18; // edad entre 18 y 67
            personas[i] = new Persona(nombreAleatorio, edadAleatoria);
        }

        // Imprimir los datos de las personas creadas
        for (int i = 0; i < personas.length; i++) {
            System.out.println("Persona " + (i+1) + ": nombre=" + personas[i].nombre + ", edad=" + personas[i].edad);
        }
    }
}
