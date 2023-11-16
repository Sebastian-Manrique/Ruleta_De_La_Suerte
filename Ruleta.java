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
    private static void turno() { // El turno sera un do while
        
    }
    private static void panel() { //Panel de palabras
        
    }
    
}
