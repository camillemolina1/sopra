
import java.util.ArrayList;

public class Solucion {


// Escriba un algoritmo que lea un número entero y determine si es par 
// o impar. Si es par, que escriba todos los pares de manera descendiente
// desde sí mismo y hasta el cero. Si es impar, que escriba todos los 
// impares de manera descendiente desde si sí mismo hasta el uno. 
// Utilice la instrucción LEER NUMERO al inicio del programa para 
// cargar un número en la variable NUMERO.
    public static void leerNumero(int numero) {
        ArrayList<Integer> listaNumeros = new ArrayList<Integer>();

        int k = numero;

            for (int i = 0; k > 1; i++) {
                k = k - 2;
                listaNumeros.add(k); 
            }

        System.out.println(listaNumeros);
        return;
    }
//     Escriba un algoritmo que visualice una clasificación de 50 personas según edad y sexo. Deberá mostrar los siguientes resultados:
// Cantidad de personas mayores de edad (18 años o más).
// Cantidad de personas menores de edad.
// Cantidad de personas masculinas mayores de edad.
// Cantidad de personas femeninas menores de edad.
// Porcentaje que representan las personas mayores de edad respecto al total de personas.
// Porcentaje que representan las mujeres respecto al total de personas.
// Utilice la instrucción LEER PERSONAS al inicio del programa para cargar los datos de las 50 personas en un variable, PERSONAS, que actúa 
// como un vector de 50 posiciones.
// Cada elemento de PERSONAS es de un tipo estructurado que dispone dos campos: SEXO y EDAD.

    public static void leerPersonas(String[][] personas) {
        int SEXO = 0;
        int EDAD = 1;

        int total = personas.length;
        int mujeres = 0;
        int menorDeEdad = 0;
        int mujeresmenorDeEdad = 0;
        int hombresmajorDeEdad = 0;

        for (int i = 0 ; i < total; i++) {
            int edad = Integer.parseInt(personas[i][EDAD]);

            if (personas[i][SEXO] == "F") {
                mujeres++;
                if (edad < 18) {
                    mujeresmenorDeEdad++;
                }
            } else {
                if(edad >= 18) hombresmajorDeEdad++;
            }
            if (edad < 18) {
                menorDeEdad++;
            } 
        }
        System.out.println("La cantidad de majores de edad es : " + (total - menorDeEdad));
        System.out.println("La cantidad de menores de edad es : " + (menorDeEdad));
        System.out.println("La cantidad de hombres majores edad es : " + (hombresmajorDeEdad));
        System.out.println("La cantidad de mujeres menor de edad es : " + (mujeresmenorDeEdad));
        System.out.println("El porcentaje que representan las personas mayores de edad respecto al total de personas es de : " + (((total - menorDeEdad) / total) * 100) + "%");
        System.out.println("El porcentaje que representan las personas mayores de edad respecto al total de personas es de : " + ((mujeres / total) * 100) + "%");
    }

    // Desarrolle un algoritmo para el cálculo del salario de un trabajador. El importe liquidado (sueldo) depende de una tarifa o precio 
    // por hora establecida y de un condicionante sobre las horas trabajadas: si la cantidad de horas trabajadas es mayor a 40 horas, 
    // la tarifa se incrementa en un 50% para las horas extras. Calcular el sueldo recibido por el trabajador en base las horas trabajadas 
    // y la tarifa. Utilice las instrucciones LEER HORASTRABAJADAS y LEER TARIFA al inicio del programa para cargar los valores en las 
    // variables HORASTRABAJADAS y TARIFA.
    public static int leerHorasTrabajadas(String[][] listaDeHorasYTarifas, String persona) {
        for (int i = 0 ; i < listaDeHorasYTarifas.length; i++) {
            if (listaDeHorasYTarifas[i][0].equals(persona)) {
                int horas = Integer.parseInt(listaDeHorasYTarifas[i][1]);
                return horas;
            }
            else {
                return 0;
            }
        }
        return 0;
    }

    public static int leerTarifa(String[][] listaDeHorasYTarifas, String persona) {
        for (int i = 0 ; i < listaDeHorasYTarifas.length; i++) {
            if (listaDeHorasYTarifas[i][0].equals(persona)) {
                return (Integer.parseInt(listaDeHorasYTarifas[i][2]));
            }
            else return 0;
        }
        return 0;

    }

    public static void calcularSalario(String[][] lista, String persona) {
        int horasTrabajadas = leerHorasTrabajadas(lista, persona);
        int tarifa = leerTarifa(lista, persona);
        int horasExtra = 0;

        if (horasTrabajadas > 40) {
            horasExtra = horasTrabajadas - 40;
        }

        if (horasTrabajadas == 0 && tarifa == 0) {System.out.println("Persona no esta en el systema"); return;}

        double salario = (horasTrabajadas * tarifa) + (horasExtra * (tarifa * 1.5));
        System.out.println("El salario de " + persona + " es de " + salario + " euros.");
        return;
    }


	public static void main(String[] args) {
        int numero = 86;
        leerNumero(numero);

        String[][] lista = {{"F", "18"}, {"M", "88"}, {"F", "28"}, {"M", "58"}, {"M", "38"}, {"M", "90"}, {"F", "22"}, {"M", "25"}};
        leerPersonas(lista);

        String[][] lista2 = {{"Pepe", "18", "10"}, {"Manuel", "42", "40"}, {"Jose", "28", "10"}};
        String persona = "Pepe";
        calcularSalario(lista2, persona);
	}
}