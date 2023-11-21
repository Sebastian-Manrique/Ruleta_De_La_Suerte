import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TurnoY_Quiebra {

    static final List<Integer> RESULTADOS = Arrays.asList(0, 25, 50, 75, 100, 150);
    static final String FRASE = "El perro está en el parque";
    static final int DINERO_INICIAL = 100;

    static int[] dineroJugadores = new int[3];
    static int turnoActual = 0;

    public static void main(String[] args) {
        inicializarJuego();

        while (true) {
            System.out.println("Turno del jugador " + (turnoActual + 1));
            System.out.println("Frase: " + FRASE);

            int resultadoRuleta = girarRuleta();
            System.out.println("La ruleta ha caído en: " + resultadoRuleta);

            if (resultadoRuleta == 0) {
                System.out.println("¡Quiebra! El jugador pierde todo el dinero ganado.");
                dineroJugadores[turnoActual] = 0;
            } else {
                System.out.println("Ingresa una letra para adivinar la frase:");
                Scanner scanner = new Scanner(System.in);
                char letra = scanner.next().charAt(0);

                if (FRASE.indexOf(letra) == -1) {
                    System.out.println("Letra incorrecta. El jugador pierde su turno.");
                    siguienteTurno();
                } else {
                    dineroJugadores[turnoActual] += resultadoRuleta;
                    System.out.println("¡Letra correcta! El jugador gana " + resultadoRuleta + " monedas.");
                }
            }

            mostrarDineroJugadores();

            if (hayGanador()) {
                int ganador = obtenerGanador();
                System.out.println("¡El jugador " + (ganador + 1) + " ha ganado el juego!");
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
