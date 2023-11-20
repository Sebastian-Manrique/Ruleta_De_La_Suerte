//Creado por Sebastian Manrique e Ignacio Delgado
import java.util.Scanner;
public class Ruleta {
	static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int j1=0;  //Valores de jugadores y solicitud de turno
        int j2=0;  //La variable jugador es el dinero
        int j3=0;  //Su suma de dinero será el producto de multiplicar el número aleatorio en el que haya caído multiplicado
        //Turno jugador 1, gira ruleta, pide letra (bucle), panel, termina turno.

	//Se puede hacer un bucle infinito con
	Boolean turno_j1=true;        //Luego mover turno_j1 a su clase privada y hacer en su alli despues un cambio de valores.
        do{
        	System.out.println("Tira de la ruleta el primer jugador.");
        	System.out.println("Que quieres hacer.\n1.Decir letra\n2.Elegir resolver");
        }while(turno_j1=true);
    }
    //paneles tambien
    private static void ruleta() { /*numero aleatorio, los valores en los
	    que puede caer la ruleta son 0, 25, 50, 75, 100, 150 o la quiebra.*/
	     int coin =  rnd.nextInt(11);// Retorna un número aleatorio entre 0 y 10
        switch(coin) {
        case 1:
            j1 +=0;
        case 2:
            pj += 25;
        case 3:
            pj += 50;
        case 4:
            pj += 75;
        case 5:
            pj += 100;
        case 6:
            pj +=125;
        defalut
        
        }
	
	System.out.println("              @@@@@@@@@@@@@             \r\n" //Dibujo de la ruleta hecho.
			+ "         @@     @@@@@@@@@    ,@@        \r\n"
			+ "      /@   @@  @@   @   @@ ,@@   @      \r\n"
			+ "     @  %@ @@   @*  @  @@   @@ @*  @    \r\n"
			+ "   @@  @@    @@  @@@@@@@  @@    @@  @@  \r\n"
			+ "  @@  @   ,@@ @@         @@ @@    @  @% \r\n"
			+ "  @  @@@@@   @  @ @@ @# @  @   @@@@@  @ \r\n"
			+ "  @  @      @@      @      @@      @  @ \r\n"
			+ "  @  @@@@@   @  @ @@ @# @  @   @@@@@  @ \r\n"
			+ "  &@  @    @@ @@         @@ @@    @  @/ \r\n"
			+ "   @@  @@    @@  @@@@@@@  @@    @@  @@  \r\n"
			+ "    .@  (@ @@   @/  @  @@   @@ @.  @    \r\n"
			+ "      @@   @@  @@   @   @@ .@@   @@     \r\n"
			+ "         @@.    @@@@@@@@@    #@@        \r\n"
			+ "              @@@@@@@@@@@@@             "
			+ "\n              Gira la ruleta 🎰");
    
    }
    private static void jugarTurno() {
        System.out.println("Turno del Jugador " + turnoActual);
        // Lógica del turno, acciones del jugador, etc.

        // Cambiar al siguiente turno
        cambiarTurno();
    }

    private static void cambiarTurno() {
        turnoActual = (turnoActual % 3) + 1;  // Alternar entre los jugadores 
    }

    private static boolean juegoTerminado() {
        // Lógica para determinar si el juego ha terminado
        // Puedes usar condiciones específicas según tu juego
        return false;  // Cambiar esto con la lógica real
    }
    private static void panel() { //Panel de palabras
        
    }
    
}
