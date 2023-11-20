public class TurnoRuleta {
	static int j1=0;
	static int j2=0;
	static int j3=0;

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
				System.out.println("Prueba1");
				sumar(j1);
				break;
				}
				case 2: {
				System.out.println("Prueba2");
				sumar(j2);
				break;
				}
				case 3: {
				System.out.println("Prueba3");	
				sumar(j3);
				break;
				}
				default:
				System.out.println("Error.");
				}
			}
	       }
	 private static void sumar(int jugadores){
		 jugadores=+2;
		 System.out.println("Valor del turno "+jugadores);
	 }
	 
}
