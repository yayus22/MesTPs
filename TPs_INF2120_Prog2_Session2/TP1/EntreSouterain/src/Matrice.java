public class Matrice {
    public static int axeDesX;
    public static int axeDesY;
    public static String matrice[][] = new String[100][100];

    public static void Matrice(int maxX, int maxY){
        for(int i=0; i<maxX; i++){
            for(int j=0; j<maxY; j++){
                if((i==8 || i==9 || i==10 || i==11 || i==12 || i==13) && (j==6 || j==7 || j==8))
                    matrice[i][j] = ".";
                else
                    matrice[i][j] = "O";
            }
        }
        for(int i=0; i<maxX; i++) {
            for (int j = 0; j<maxY; j++) {
                System.out.print(matrice[i][j]);
            }
            System.out.println();
        }
    }
    public static boolean PeutOnPlacerLaPieceDeDepart(int parcoursI, int parcoursJ, int maxX, int maxY, int xPiece1, int yPiece1){
        int xMilieu = maxX/2;
        int yMilieu = maxY/2;
        if(x)
    }
    /*public static void PremierePiece(int maxX, int maxY){
        for(int i=0; i<maxX; i++){
            for(int j=0; j<maxY; j++){
                matrice[i][j] = ".";
            }
        }
        for(int i=0; i<maxX; i++) {
            for (int j = 0; j<maxY; j++) {
                System.out.print(matrice[i][j]);
            }
            System.out.println();
        }
    }*/
}
