import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TurnoY_Quiebra {
	static StringBuilder resultado = new StringBuilder();
	public static String reemplazarLetras(String texto) {
        resultado = new StringBuilder();
        
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == ' ') {
                resultado.append(" ");
            } else {
                resultado.append("*");
            }
            /*En Java, el método append() pertenece a la clase StringBuilder,
            que se utiliza para construir cadenas de caracteres de manera eficiente
            al permitir la modificación de la cadena sin crear nuevos objetos de cadena
            en cada operación.
            La función append() se utiliza para agregar contenido al final de un StringBuilder.
            Puede aceptar diferentes tipos de datos como parámetro y los convierte automáticamente
            a cadenas de caracteres para su concatenación.*/
        }
        
        return resultado.toString();
    }

    static final List<Integer> RESULTADOS = Arrays.asList(0, 25, 50, 75, 100, 150);
    static final StringBuilder FRASE = resultado;
    static final int DINERO_INICIAL = 100;

    static int[] dineroJugadores = new int[3];
    static int turnoActual = 0;

    
	public static void main(String[] args) {
        inicializarJuego();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Introduce una frase:");
        String input = scanner.nextLine();

        // Llamada a la función para reemplazar letras por asteriscos
        String resultadoTexto = reemplazarLetras(input); // Cambio de nombre de la variable local
        FRASE.replace(0, FRASE.length(), resultadoTexto); // Reemplaza el contenido de FRASE con resultadoTexto
        
        System.out.println("Texto original: " + input);
        System.out.println("Texto con letras reemplazadas por asteriscos: " + resultadoTexto);

        while (!hayGanador()) {
        	if (turnoActual == 4) {
        		turnoActual = 0;
        	}
            System.out.println("Turno del jugador " + (turnoActual + 1));
            System.out.println("Frase: " + FRASE);

            int resultadoRuleta = girarRuleta();
            System.out.println("La ruleta ha caído en: " + resultadoRuleta);

            if (resultadoRuleta == 0) {
                System.out.println("¡Quiebra! El jugador pierde todo el dinero ganado.");
                dineroJugadores[turnoActual] = 0;
            } else {
                boolean adivinoCorrectamente = false;
                do {
                    System.out.println("Que quieres hacer: 'resolver frase' o 'decir letra' (escriba la opción).");
                    String decision =scanner.nextLine();
                    if(decision.equals("resolver frase") || decision.equals("resolver") || decision.equals("frase")){
                    	System.out.println("El panel es:" +FRASE+" y la pista es ");
                    	String respuesta =scanner.nextLine();
                    	  if (respuesta.equals(FRASE.toString())) {
                    		System.out.println("Enhorabuena, ¡has acertado!");
                    		//Siguiente panel
                    	}
                    	else{
                    		System.out.println("No has acertado.");
                    		siguienteTurno();
                    	}
                    }
                    else if(decision.equals("decir letra") || decision.equals("decir")) {
                    	System.out.println("Dime la letra a poner.");
                    	char letra = scanner.nextLine().charAt(0);//
                    	if (input.toUpperCase().indexOf(Character.toUpperCase(letra)) != -1) {
                    	    int index = -1;
                    	    do {
                    	        index = input.toUpperCase().indexOf(Character.toUpperCase(letra), index + 1);
                    	        if (index != -1) {
                    	            FRASE.setCharAt(index, letra);
                    	            dineroJugadores[turnoActual] += resultadoRuleta;
                    	        }
                    	    } while (index != -1);

                    	    adivinoCorrectamente = true;
                    	    System.out.println("¡Letra correcta! El jugador gana " + resultadoRuleta + " monedas.");
                    	    System.out.println("¡Felicidades! Has adivinado la letra: " + FRASE);
                    	}
                    	else {
                    	    System.out.println("Letra incorrecta. El jugador pierde su turno.");
                    	    adivinoCorrectamente = false;
                    	}
                    }else{
                    	System.out.println("Error.");
                    }

                } while (adivinoCorrectamente && FRASE.indexOf("*") != -1); // Continuar mientras adivine correctamente y la frase no esté completamente revelada
            }

            if (FRASE.indexOf("*") == -1) {
                System.out.println("¡Felicidades! Has adivinado la frase: " + input);
                break;
            }

            siguienteTurno();
        }
    }

    static void inicializarJuego() {
        for (int i = 0; i < dineroJugadores.length; i++) {
            dineroJugadores[i] = DINERO_INICIAL;
        }
    }

    static int girarRuleta() {
        Random random = new Random();
        return RESULTADOS.get(random.nextInt(RESULTADOS.size()));
    }

    static void siguienteTurno() {
        turnoActual = (turnoActual + 1) % dineroJugadores.length;
    }

    static void mostrarDineroJugadores() {
        for (int i = 0; i < dineroJugadores.length; i++) {
            System.out.println("Jugador " + (i + 1) + ": " + dineroJugadores[i] + " monedas");
        }
    }

    static boolean hayGanador() {
        for (int dinero : dineroJugadores) {
            if (dinero >= 500) { // Cambia el valor aquí para ajustar la cantidad necesaria para ganar
                return true;
            }
        }
        return false;
    }

    static int obtenerGanador() {
        for (int i = 0; i < dineroJugadores.length; i++) {
            if (dineroJugadores[i] >= 500) { // Cambia el valor aquí para ajustar la cantidad necesaria para ganar
                return i;
            }
        }
        return -1;
    }
}