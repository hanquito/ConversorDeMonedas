import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        ConsultaConversion consulta = new ConsultaConversion();
        int opcion = 0;
        Scanner scanner = new Scanner(System.in);
        String menu = """
                    **************************************************
                    Sea Bienvenido/a al Conversor de Moneda =]\n
                    1) Dólar =>> Peso argentino
                    2) Peso argentino =>> Dólar
                    3) Dólar =>> Real brasileño
                    4) Real brasileño =>> Dólar
                    5) Dólar =>> Peso colombiano
                    6) Peso colombiano =>> Dólar
                    7) Salir
                    Elija una opción válida: 
                    ***************************************************
                    """;
        double cantidad = 0;

        while (opcion != 7) {
            try {
                boolean continuar = true;
                System.out.println(menu);
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1 : handleConversion("USD", "ARS", scanner, consulta);
                        break;
                    case 2 : handleConversion("ARS", "USD", scanner, consulta);
                        break;
                    case 3 : handleConversion("USD", "BRL", scanner, consulta);
                        break;
                    case 4 : handleConversion("BRL", "USD", scanner, consulta);
                        break;
                    case 5 : handleConversion("USD", "COP", scanner, consulta);
                        break;
                    case 6 : handleConversion("COP", "USD", scanner, consulta);
                        continue;
                    case 7 : System.out.println("Saliendo del programa...");
                        System.exit(0);
                        break;
                    default : System.out.println("¡Opcion Invalida!\n");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Debe ingresar obligatoriamente al Conversor de Moneda.");
                System.out.println("Elija una de las opciones en el Conversor de Moneda");
                System.out.println("//////////////////////////////////////////////////////");
                scanner.nextLine();
            }
            opcion++;
        }
    }
    private static void handleConversion(String moneda_base, String moneda_destino, Scanner scanner, ConsultaConversion consulta) {
        System.out.println("Ingrese el valor que deseas convertir: ");
        double cantidad = scanner.nextDouble();
        Moneda moneda = consulta.realizaConversion(moneda_base, moneda_destino, cantidad);
        System.out.println("El valor: "+ cantidad +" ["+moneda_base+"]"+
                " corresponde al valor final de =>>> " +moneda.conversion_result()+ " ["+moneda_destino+"]");
    }
}
