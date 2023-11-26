//Creado por Sebastian Manrique e Ignacio Delgado
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RuletaDeLaSuerte {
	 static StringBuilder resultado = new StringBuilder();
	 static StringBuilder FRASE = new StringBuilder();
	public static String reemplazarLetras(String texto) {
	    FRASE.setLength(0);
        
        for (int i = 0; i < texto.length(); i++) {//modifica la frase a "*"
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
        return FRASE.toString(); //Lo comvierte a String
    }

    static final List<Integer> RESULTADOS = Arrays.asList(0, 25, 50, 75, 100, 150);//Probabilidades de la ruleta
    static final int DINERO_INICIAL = 100; //Dinero principal de los jugadores
    static int[] dineroJugadores = new int[3]; //3 variables de dinero para 3 jugadores 
    static int turnoActual = 0; //Establece el turno de los jugadores, se va sumando, empieza en 0.
    static String panel = "";
    static String pista= "";
    static int panelNum=0;
    public static void main(String[] args) { //main
        inicializarJuego(); //Mecanica de turnos
        FRASE = resultado; //Pase la frase a asteriscos
		Scanner scanner = new Scanner(System.in);
        panelActual();
         //el panel

        // Llamada a la función para reemplazar letras por asteriscos
       
        while (!hayGanador()) { // El juego en sí
            if (turnoActual == 4) {
                turnoActual = 0;
            }
            panelActual();
            
            // Mover la línea dentro del bucle while
            String resultadoTexto = reemplazarLetras(panel); // Cambio de nombre de la variable local
            
            System.out.println("Turno del jugador " + (turnoActual + 1)); // Imprime a qué jugador le toca
            System.out.println("Frase: " + resultadoTexto + " pista: " + pista); // Imprime la frase

            int resultadoRuleta = girarRuleta(); // Inicia mecánica de "ruleta"
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(""
            		+ "                                                ..:-=+====--::.                                                   \r\n"//Dibujo de la ruleta
            		+ "                                          .-=++++=-:::**@+#---=++++-:                                             \r\n"
            		+ "                                      .-++=-.          :@-         :=+*=:                                         \r\n"
            		+ "                                   .=*+:                @              .=++-                                      \r\n"
            		+ "                                 -*+.                   @                  -*+.                                   \r\n"
            		+ "                               =%*                      @                    .+*:                                 \r\n"
            		+ "                             -#- =*:                    @                    :*=+*.                               \r\n"
            		+ "                           .*=    .+*:                  @                  .*+.  :*=                              \r\n"
            		+ "                          =#.       .+*.                @                .+*.      =*.                            \r\n"
            		+ "                         ++           .*+.              @              .+#:         :#.                           \r\n"
            		+ "                        *=              :*=             @             =*:            .#.                          \r\n"
            		+ "                       ++                 -#-           @           -#-               :#.                         \r\n"
            		+ "                      =*                    -#-         @         :*=                  :#                         \r\n"
            		+ "                     .%.                      =*:       @       .*+.                    +=                        \r\n"
            		+ "                     +=                        .+*.     @     .+*.                      .%                        \r\n"
            		+ "                     %.                          .*+.   @   .+*:                         +=                       \r\n"
            		+ "                    -*                             :*+. @  =*-                           -*                       \r\n"
            		+ "                    =+                               :*=@-#-                             .%                       \r\n"
            		+ "                   :##+++++++++++++++++++++++++++++++++%@@++++++++++++++++++++++++++++++++@=                      \r\n"
            		+ "                    +=                               .*+@=*:                              @                       \r\n"
            		+ "                    =+                             .+*. @ .+*:                           :#                       \r\n"
            		+ "                    :#                            =*:   @   .+*.                         -*                       \r\n"
            		+ "                     %.                         =#-     @     .*+.                       #:                       \r\n"
            		+ "                     =+                       -#-       @       :*=                     :#                        \r\n"
            		+ "                      %:                    :*=         @         -#-                   #:                        \r\n"
            		+ "                      :%.                 .*+.          @           -#-                ++                         \r\n"
            		+ "                       -#               .+*.            @             =*:             =#                          \r\n"
            		+ "                        -#.            =*:              @              .+*.          =*                           \r\n"
            		+ "                         :#.         =#-                @                .*+.       +*                            \r\n"
            		+ "                          .#=      -#=                  @                  :*+.   .*-                             \r\n"
            		+ "                            =*:  :*=                    @                    :*= +*.                              \r\n"
            		+ "                             .*+*+.                     @                      ##-                                \r\n"
            		+ "                               .+*:                     @                   .=*-                                  \r\n"
            		+ "                                 .=*=.                  @                 -*+:                                    \r\n"
            		+ "                                    .=*+-               @             :=*+-                                       \r\n"
            		+ "                                       .-+++=:.         @        :-++*=.                                          \r\n"
            		+ "                                            .-=++++++===@==++++++=:                                               \r\n"
            		+ "                                                     .                                                            \r\n"
            		+ "\nLa ruleta ha caido en: " + resultadoRuleta);

            if (resultadoRuleta == 0) { // Si cae un quiebra
                System.out.println("¡Quiebra! El jugador pierde todo el dinero ganado.");
                dineroJugadores[turnoActual] = 0; // cambia turno
                siguienteTurno();
            } else {
                boolean adivinoCorrectamente = false; // inicia turno 
                do {
                    System.out.println("Que quieres hacer: 'resolver frase' o 'decir letra' (escriba la opción)."); // Imprime las opciones
                    String decision = scanner.nextLine();
                    if (decision.equals("resolver frase") || decision.equals("resolver") || decision.equals("frase")) {// Resolver frase
                        System.out.println("El panel es:" + resultadoTexto + " y la pista es: " + pista);
                        String respuesta = scanner.nextLine();
                        if (respuesta.equals(panel)) { // verifica la frase
                            System.out.println("Enhorabuena, ¡has acertado el panel! " + panel);
                            hayGanador();
                            panelNum++;
                            panelActual();
                        } else {
                            System.out.println("No has acertado.");
                            siguienteTurno();
                        }
                    } else if (decision.equals("decir letra") || decision.equals("decir") || decision.equals("letra")) {// Decir letra
                        System.out.println("Dime la letra a poner.");
                        char letra = scanner.nextLine().charAt(0);
                        if (panel.toUpperCase().indexOf(Character.toUpperCase(letra)) != -1) { // verifica la letra
                            int index = -1;
                            do {
                                index = panel.toUpperCase().indexOf(Character.toUpperCase(letra), index + 1);// revela la o las letras
                                if (index != -1) {
                                    FRASE.setCharAt(index, letra);
                                    dineroJugadores[turnoActual] += resultadoRuleta;
                                }
                            } while (index != -1);

                            adivinoCorrectamente = true; // sigue en el turno
                            System.out.println("¡Letra correcta! El jugador gana " + resultadoRuleta + " monedas.");
                            System.out.println("¡Felicidades! Has adivinado la letra: " + FRASE);
                        } else {
                            System.out.println("Letra incorrecta. El jugador pierde su turno.");
                            adivinoCorrectamente = false; // salta turno 
                        }
                    } else {
                        System.out.println("Error.");
                    }

                } while (adivinoCorrectamente && FRASE.indexOf("*") != -1); // Continuar mientras adivine correctamente y la frase no esté completamente revelada

                if (FRASE.indexOf("*") == -1) {
                    System.out.println("¡Felicidades! Has adivinado la frase: " + panel);
                    hayGanador();
                    panelNum++;
                    panelActual();
                }

                siguienteTurno();
            }
        }

    }

    static void inicializarJuego() {    //Ejecuta el juego
        for (int i = 0; i < dineroJugadores.length; i++) {
            dineroJugadores[i] = DINERO_INICIAL;
        }
    }

    static int girarRuleta() {			//Sistema aleatorio para ganancia o quiebra
        Random random = new Random();
        return RESULTADOS.get(random.nextInt(RESULTADOS.size()));
    }

    static void siguienteTurno() {	//Coge la variable turno y la va sumando
        turnoActual = (turnoActual + 1) % dineroJugadores.length;
    }
    static void panelActual() {
    	
        switch (panelNum) {
            case 0:
                panel = "yo era un aventurero";
                pista = "Algunos soldados les da nostalgia verte.";
                break;
            case 1:
                panel = "nunca llueve a gusto de todos";
                pista = "Lo que resulta placentero para unos puede desagradar a otros";
                break;
            case 2:
                panel = "victoria o muerte";
                pista = "Dalo todo hasta morir";
                break;
            default:
                System.out.println("Fin del juego");
                System.exit(0); //Apaga el juego.
                
                if (panelNum >= 3) {
                    panelNum=0; // Reinicia panelNum cuando llega al último panel
            }
          }
        }
        
        

    static void mostrarDineroJugadores() {			//Como su nombre indica, imprime el dinero de los juegadores
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
