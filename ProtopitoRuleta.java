import java.util.Random;
public class ProtopitoRuleta {
	static int j1=0;
	static int j2=0;
	static int j3=0;
	static Random rnd = new Random();

	public static void main(String[] args) {
		int Turno=1;
		jugarTurno(Turno);
	}
	        
	 private static void jugarTurno(int Turno){
			System.out.println("Turno del jugador 1");
	        // Lógica del turno, acciones del jugador, etc. Cambiar al siguiente turno
			for(int i=1;i<=3;i++){
				System.out.println(i);
				switch (i) {
				case 1: {
				j1 = ruleta(j1);
				System.out.println("Jugador 1 en el for "+j1);
				break;
				}
				case 2: {
				System.out.println("Prueba2");
				j2 = ruleta(j2);
				System.out.println("Jugador 2 en el for "+j2);
				break;
				}
				case 3: {
				System.out.println("Prueba3");	
				j3 =ruleta(j3);
				System.out.println("Jugador 3 en el for "+j3);
				break;
				}
				default:
				System.out.println("Error jugarTurno.");
				}
			}
	       }
	 private static int ruleta(int jugadores){
		 int coin =  rnd.nextInt(6);// Retorna un número aleatorio entre 0 y 6
	        switch(coin) {
	        case 0:
	        	jugadores +=0;
	        	System.out.println("Valor de coin dentro de switch"+jugadores);
	        	return jugadores;
	        case 1:
	        	jugadores +=25;
	        	System.out.println("Valor de coin dentro de switch "+jugadores);
	        	return jugadores;
	        case 2:
	        	jugadores +=50;
	        	System.out.println("Valor de coin dentro de switch "+jugadores);
	        	return jugadores;
	        case 3:
	        	jugadores +=75;
	        	System.out.println("Valor de coin dentro de switch "+jugadores);
	        	return jugadores;
	        case 4:
	        	jugadores +=100;
	        	System.out.println("Valor de coin dentro de switch "+jugadores);
	        	return jugadores;
	        case 5:
	        	jugadores +=125;
	        	System.out.println("Valor de coin dentro de switchasdasd "+jugadores);
	        	return jugadores;
	        default:
				System.out.println("Error Ruleta.");
				}
			return jugadores;
	 }
	 
}