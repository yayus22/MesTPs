import java.util.Scanner;

public class Main {
    public static final String MSG_SOL = "Entrez un nombre positif svp: ";
    public static final String MSG_ERR = "Entrée invalide";
    public static final String MSG_SOL_CONV = "Entrez une base de conversion (un nombre de 2 à 36): ";

    public static void main(String[] args) {
        int nombre;
        int baseDeConverssion;
        int nombreConcerti;
        String nombreConvertiEnString = "";
        System.out.println(MSG_SOL);
        Scanner Lire = new Scanner(System.in);
        nombre = Lire.nextInt();
        while (nombre < 0) {
            System.out.println(MSG_ERR + "\n");
            System.out.println(MSG_SOL);
            nombre = Lire.nextInt();
        }
        System.out.println(MSG_SOL_CONV);
        baseDeConverssion = Lire.nextInt();
        while (baseDeConverssion < 2 || baseDeConverssion > 36) {
            System.out.println(MSG_ERR + "\n");
            System.out.println(MSG_SOL_CONV);
            baseDeConverssion = Lire.nextInt();
        }
        while (nombre != 0) {
            nombreConcerti = nombre % baseDeConverssion;
            if (baseDeConverssion > 10) {
                switch (nombreConcerti) {
                    case 10: {
                        nombreConvertiEnString = "A" + nombreConvertiEnString;
                        break;
                    }
                    case 11: {
                        nombreConvertiEnString = "B" + nombreConvertiEnString;
                        break;
                    }
                    case 12: {
                        nombreConvertiEnString = "C" + nombreConvertiEnString;
                        break;
                    }
                    case 13: {
                        nombreConvertiEnString = "D" + nombreConvertiEnString;
                        break;
                    }
                    case 14: {
                        nombreConvertiEnString = "E" + nombreConvertiEnString;
                        break;
                    }
                    case 15: {
                        nombreConvertiEnString = "F" + nombreConvertiEnString;
                        break;
                    }
                    case 16: {
                        nombreConvertiEnString = "G" + nombreConvertiEnString;
                        break;
                    }
                    case 17: {
                        nombreConvertiEnString = "H" + nombreConvertiEnString;
                        break;
                    }
                    case 18: {
                        nombreConvertiEnString = "I" + nombreConvertiEnString;
                        break;
                    }
                    case 19: {
                        nombreConvertiEnString = "J" + nombreConvertiEnString;
                        break;
                    }
                    case 20: {
                        nombreConvertiEnString = "K" + nombreConvertiEnString;
                        break;
                    }
                    case 21: {
                        nombreConvertiEnString = "L" + nombreConvertiEnString;
                        break;
                    }
                    case 22: {
                        nombreConvertiEnString = "M" + nombreConvertiEnString;
                        break;
                    }
                    case 23: {
                        nombreConvertiEnString = "N" + nombreConvertiEnString;
                        break;
                    }
                    case 24: {
                        nombreConvertiEnString = "O" + nombreConvertiEnString;
                        break;
                    }
                    case 25: {
                        nombreConvertiEnString = "P" + nombreConvertiEnString;
                        break;
                    }
                    case 26: {
                        nombreConvertiEnString = "Q" + nombreConvertiEnString;
                        break;
                    }
                    case 27: {
                        nombreConvertiEnString = "R" + nombreConvertiEnString;
                        break;
                    }
                    case 28: {
                        nombreConvertiEnString = "S" + nombreConvertiEnString;
                        break;
                    }
                    case 29: {
                        nombreConvertiEnString = "T" + nombreConvertiEnString;
                        break;
                    }
                    case 30: {
                        nombreConvertiEnString = "U" + nombreConvertiEnString;
                        break;
                    }
                    case 31: {
                        nombreConvertiEnString = "V" + nombreConvertiEnString;
                        break;
                    }
                    case 32: {
                        nombreConvertiEnString = "W" + nombreConvertiEnString;
                        break;
                    }
                    case 33: {
                        nombreConvertiEnString = "X" + nombreConvertiEnString;
                        break;
                    }
                    case 34: {
                        nombreConvertiEnString = "Y" + nombreConvertiEnString;
                        break;
                    }
                    case 35: {
                        nombreConvertiEnString = "Z" + nombreConvertiEnString;
                        break;
                    }
                    default:
                        nombreConvertiEnString = nombreConcerti + nombreConvertiEnString;
                }
            } else {
                nombreConvertiEnString = nombreConcerti + nombreConvertiEnString;
            }
            nombre = nombre / baseDeConverssion;
        }
        System.out.println(nombre + " en base " + baseDeConverssion + " est " + nombreConvertiEnString);
    }
}