import java.util.Scanner;

public class PanelRuleta {

    // Función para reemplazar letras por asteriscos respetando los espacios
    public static String reemplazarLetras(String texto) {
        StringBuilder resultado = new StringBuilder();
        
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Introduce una frase:");
        String input = scanner.nextLine();

        // Llamada a la función para reemplazar letras por asteriscos
        String resultado = reemplazarLetras(input);
        
        System.out.println("Texto original: " + input);
        System.out.println("Texto con letras reemplazadas por asteriscos: " + resultado);
        
        scanner.close();
    }
}
