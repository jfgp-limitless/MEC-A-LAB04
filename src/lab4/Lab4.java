
package lab4;

import java.util.ArrayList;
import java.util.Random;

public class Lab4 {
    public static void main(String[] args) {
        ArrayList<Persona> listaPersonas = Persona.generarListaPersonas(10);
        System.out.println("Lista de Personas:");
        for (int i = 0; i < listaPersonas.size(); i++) {
            System.out.println(listaPersonas.get(i));
        }
        
        AfiliadosEPS afiliados = new AfiliadosEPS(listaPersonas);
        ArrayList<Persona> menores60mayores12 = afiliados.getMenores60yMayores12();
        
        System.out.println("\nAfiliados menores de 12 y mayores de 60:");
        for (int i = 0; i < menores60mayores12.size(); i++) {
            System.out.println(menores60mayores12.get(i));
        }
        
    }
}

class Persona {
    private String nombre;
    private int edad;
    private String sexo;

    public Persona(String nombre, int edad, String sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getSexo() {
        return sexo;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Edad: " + edad + ", Sexo: " + sexo;
    }

    public static ArrayList<Persona> generarListaPersonas(int cantidad) {
        ArrayList<Persona> listaPersonas = new ArrayList<>();
        Random random = new Random();

        String[] nombres = {"Juan", "Ana", "Luis", "María", "Pedro", "Sofía", "Diego", "Lucía", "Carlos", "Marta"};
        String[] sexos = {"M", "F"};

        for (int i = 0; i < cantidad; i++) {
            String nombreAleatorio = nombres[random.nextInt(nombres.length)];
            int edadAleatoria = random.nextInt(90) + 1;
            String sexoAleatorio = sexos[random.nextInt(sexos.length)];
            Persona persona = new Persona(nombreAleatorio, edadAleatoria, sexoAleatorio);
            listaPersonas.add(persona);
        }

        return listaPersonas;
    }
}

class AfiliadosEPS {
    private ArrayList<Persona> afiliados;
    private ArrayList<Persona> menores60mayores12;
    
    public AfiliadosEPS(ArrayList<Persona> afiliados) {
        this.afiliados = afiliados;
        this.menores60mayores12 = new ArrayList<Persona>();
        separarAfiliados();
    }
    
    private void separarAfiliados() {
        for (int i = 0; i < afiliados.size(); i++) {
            Persona persona = afiliados.get(i);
            if (persona.getEdad() < 12 || persona.getEdad() > 60) {
                menores60mayores12.add(persona);
            }
        }
    }
    
    public ArrayList<Persona> getMenores60yMayores12() {
        return menores60mayores12;
    }
}
