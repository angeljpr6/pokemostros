import java.util.Scanner;

public class ControlarTexto {

    public static void mostrarTextoLento( String texto){
        for (int i = 0; i < texto.length(); i++) {
            System.out.print(texto.charAt(i));
            if (texto.charAt(i)==','){
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                continue;
            }
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void mostrarTextoLento2(Scanner sn, String texto){

        for (int i = 0; i < texto.length(); i++) {
            if (sn.nextLine()==null){
                System.out.println(texto);
                break;
            }
            System.out.print(texto.charAt(i));
            if (texto.charAt(i)==','){
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                continue;
            }
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void limpiarConsola() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

}
