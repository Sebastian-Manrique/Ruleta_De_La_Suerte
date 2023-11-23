//Creado por Sebastian Manrique e Ignacio Delgado
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TurnoY_Quiebra {
	static StringBuilder resultado = new StringBuilder();
	public static String reemplazarLetras(String texto) {
        resultado = new StringBuilder();
        
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
        
        return resultado.toString(); //Lo comvierte a String
    }

    static final List<Integer> RESULTADOS = Arrays.asList(0, 25, 50, 75, 100, 150);//Probabilidades de la ruleta
    static final StringBuilder FRASE = resultado; //Pase la frase a asteriscos
    static final int DINERO_INICIAL = 100; //Dinero principal de los jugadores
    static int[] dineroJugadores = new int[3]; //3 variables de dinero para 3 jugadores 
    static int turnoActual = 0; //Establece el turno de los jugadores, se va sumando, empieza en 0.

    public static void main(String[] args) { //main
        inicializarJuego(); //Mecanica de turnos
        Scanner scanner = new Scanner(System.in);
        
        String input = "Nunca llueve a gusto de todos"; //el panel 
        System.out.println("El panel se mostrara aqui");

        // Llamada a la función para reemplazar letras por asteriscos
        String resultadoTexto = reemplazarLetras(input); // Cambio de nombre de la variable local
        FRASE.replace(0, FRASE.length(), resultadoTexto); // Reemplaza el contenido de FRASE con resultadoTexto
        System.out.println("Texto del panel  " + resultadoTexto +"\npista: un refran (La primera mayuscula)."); //Imprime el panel en * y su pista
        while (!hayGanador()) { //El juego en si
        	if (turnoActual == 4) {
        		turnoActual = 0;
        	}
            System.out.println("Turno del jugador " + (turnoActual + 1)); //Imprime a que jugador le toca
            System.out.println("Frase: " + FRASE); //Imprime la frase

            int resultadoRuleta = girarRuleta();// inicia mecanica de "ruleta"
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
            		+ "\nLa ruleta ha caído en: " + resultadoRuleta);

            if (resultadoRuleta == 0) { //Si cae un quiebra
                System.out.println("¡Quiebra! El jugador pierde todo el dinero ganado.");
                dineroJugadores[turnoActual] = 0; //camvia turno
            } else {
                boolean adivinoCorrectamente = false; //inicia turno 
                do {
                    System.out.println("Que quieres hacer: 'resolver frase' o 'decir letra' (escriba la opción)."); //Imprime las opciones
                    String decision =scanner.nextLine();
                    if(decision.equals("resolver frase") || decision.equals("resolver") || decision.equals("frase")){//Resolver frase
                    	System.out.println("El panel es:" +FRASE+" y la pista es un refran");
                    	String respuesta =scanner.nextLine();
                    	  if (respuesta.equals(input)) { //verifica la frase
                    		System.out.println("Enhorabuena, ¡has acertado!");
                    		hayGanador();
                    		System.exit(0);
                    		//termina el juego
                    	}
                    	else{
                    		System.out.println("No has acertado.");
                    		siguienteTurno();
                    	}
                    }
                    else if(decision.equals("decir letra") || decision.equals("decir") || decision.equals("letra")) {//Decir letra
                    	System.out.println("Dime la letra a poner.");
                    	char letra = scanner.nextLine().charAt(0);
                    	if (input.toUpperCase().indexOf(Character.toUpperCase(letra)) != -1) { //verifica la letra
                    	    int index = -1;
                    	    do {
                    	        index = input.toUpperCase().indexOf(Character.toUpperCase(letra), index + 1);//revela la o las letras
                    	        if (index != -1) {
                    	            FRASE.setCharAt(index, letra);
                    	            dineroJugadores[turnoActual] += resultadoRuleta;
                    	        }
                    	    } while (index != -1);

                    	    adivinoCorrectamente = true; //sigue en el turno
                    	    System.out.println("¡Letra correcta! El jugador gana " + resultadoRuleta + " monedas.");
                    	    System.out.println("¡Felicidades! Has adivinado la letra: " + FRASE);
                    	}
                    	else {
                    	    System.out.println("Letra incorrecta. El jugador pierde su turno.");
                    	    adivinoCorrectamente = false; // salta turno 
                    	}
                    }else{
                    	System.out.println("Error.");
                    }

                } while (adivinoCorrectamente && FRASE.indexOf("*") != -1); // Continuar mientras adivine correctamente y la frase no esté completamente revelada
            }

            if (FRASE.indexOf("*") == -1) {
                System.out.println("¡Felicidades! Has adivinado la frase: " + input);
                break;
                //Termina el juego
            }

            siguienteTurno();
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
