import java.time.*;
import java.util.Scanner;

public class Cajero {
    public static void main(String[] args) {
        Scanner data = new Scanner(System.in);
        int cont = 1, contArray = 0;
        String typeMovement[]= new String[10], dateMovement[]= new String[10], timeMovement[] = new String[10];
        double moneyMovement[] = new double[10];
        double saldo = 1000;
        boolean menu = true;
        while (cont <= 3){
            if(pin()) {
                while (menu){
                    System.out.println("BIENVENIDO A NUESTRO SISTEMA");
                    System.out.println("INGRESA EL NUMERO DE LA OPCION ELEGIDA:\n1.CONSULTAR SALDO\n2.RETIRAR SALDO\n3.MOVIMIENTOS\n4.SALIR");
                    int menuOption = data.nextInt();
                    if (menuOption == 1){
                        typeMovement[contArray] = "CONSULTA";
                        dateMovement[contArray] = String.valueOf(LocalDate.now());
                        timeMovement[contArray] =  String.valueOf(LocalTime.of(LocalTime.now().getHour(),LocalTime.now().getMinute(),LocalTime.now().getSecond()));
                        moneyMovement[contArray] = consulta(saldo);
                        contArray++;
                    } else if (menuOption == 2) {
                        double retiro = retiro(saldo);
                        typeMovement[contArray] = "RETIRO";
                        dateMovement[contArray] = String.valueOf(LocalDate.now());
                        timeMovement[contArray] =  String.valueOf(LocalTime.of(LocalTime.now().getHour(),LocalTime.now().getMinute(),LocalTime.now().getSecond()));
                        moneyMovement[contArray] = retiro;
                        saldo -= retiro;
                        contArray++;
                    } else if (menuOption == 3) {
                        System.out.println("HISTORIAL DE MOVIMIENTOS");
                        System.out.println("TIPO\t\tFECHA\t\tHORA\t\tCANTIDAD");
                        for (int a = 0;a < contArray;a++){
                            System.out.println(typeMovement[a]+"\t"+dateMovement[a]+"\t"+timeMovement[a]+"\t"+"$"+moneyMovement[a]);
                        }
                    }
                    else if (menuOption == 4) {
                        break;
                    }else {
                        System.out.println("OPCION INVALIDA");
                    }
                    System.out.println("¿REGRESAR AL MENU?\n1.SI\n2.NO");
                    int exit = data.nextInt();
                    if (exit == 2){
                        menu = false;
                        break;
                    }
                }
                break;
            }
            cont++;
        }
        if(cont == 4){
            System.out.println("HAS EXCEDIDO EL NUMERO MAXIMO DE INTENTOS");
        }
        System.out.println("GRACIAS POR UTILIZAR NUESTRO SERVICIO");
    }

    public static boolean pin(){
        Scanner data = new Scanner(System.in);
        boolean auth = false;
        System.out.println("PARA CONTINUAR INGRESA TU PIN DE 4 DIGITOS NUMERICOS:");
        int pin = data.nextInt();
        if(pin == 1234){
            return auth = true;
        }
        System.out.println("EL PIN ES INCORRECTO");
        return auth;
    }

    public static double consulta(double saldo){
        System.out.println("SU SALDO DISPONIBLE");
        System.out.println("$" + saldo);
        return saldo;
    }

    public static double retiro(double saldo){
        Scanner data = new Scanner(System.in);
        double retiro = 0;
        while (true){
            System.out.println("MONTO A RETIRAR");
            retiro = data.nextDouble();
            if (retiro < saldo){
                System.out.println("RETIRO EXITOSO");
                return retiro;
            }
            System.out.println("EL MONTO DE RETIRO EXCEDE EL SALDO ACTIUAL : $" + saldo);
        }
    }
}