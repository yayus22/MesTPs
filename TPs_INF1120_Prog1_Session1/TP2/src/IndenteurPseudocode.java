/**
 * La classe IndenteurPseudocode permet d'indenter un pseudocode. Lorsqu'on rentre un fichier texte
 * de pseudocode, cette classe (IndenteurPseudocode) retourne le même pseudocode sous la forme indentée.
 *
 * @author (votre nom): YAYA NIARE
 * (code permanent) : NIAY84110301
 * @version (un numéro de version ou une date)
 */
public class IndenteurPseudocode
{
    /** Delaration des constantes */
    public static final String PRESENTATION ="Ce programme permet de corriger l'indentation d'un algorithme ecrit en pseudocode.";
    public static final String MENU ="----\nMENU\n----\n1. Indenter pseudocode\n2. Quitter";
    public static final String MSG_SOL ="Entrez votre choix : ";
    public static final String TAP_ENT ="Tapez <ENTREE> pour continuer...";
    public static final String LIM ="--------------------\n";
    public static final String MSG_ERR ="ERREUR ! Choix invalide. Recommencez...";
    public static final String MSG_FORM ="Mots reserves : en (m)inuscules ou en (M)ajuscules : \n";
    public static final String FINPROG ="F I N   N O R M A L E   D U   P R O G R A M M E. ";
    public static final String AFFICHER ="AFFICHER";
    public static final String ECRIRE = "ECRIRE";
    public static final String LIRE  = "LIRE";
    public static final String SAISIR = "SAISIR";
    public static final String SINON = "SINON";
    public static final String FIN = "FIN";
    public static final String SI = "SI";
    public static final String TANT_QUE = "TANT QUE";
    public static final String FAIRE = "FAIRE";
    public static final String ALORS = "ALORS";
    public static final String DEBUT = "DEBUT";
    public static final String ES = " ";
    /** Cette methode est une boucle de validation du choix menu,
     * elle demande à l'utilisateur d'entrer un chiffre, si ce chiffre correspond
     * a l'un des chiffres en parametre, il retourne le chiffre, sinon il redemande
     * a l'utilisateur d'entrer un chiffre valide.
     *
     * @param (a,b,menu) la chaine entree par l'utilisateur doit correspondre
     * a a ou b et menu est le menu qui affiche les choix possibles.
     * @return une chaine correspondant aux chaines a ou b en parametre.
     * */
    public static String ValiderChoix(String a, String b, String menu){
        String x; // Variable qui va contenir la chaine valide et qui sera retournée
        System.out.print(menu);
        System.out.print(MSG_SOL);
        x = Clavier.lireString();
        // Debut de la boucle de validation.
        while(!x.equals(a) && !x.equals(b)){
            System.out.println(MSG_ERR + "\n" + menu);
            x = Clavier.lireString();
        }
        return x;
    }
    /** Cette methode est une boucle de validation du chemin fichier,
     * elle retourne le contenu de la variable en parametre si elle est valide,
     * si elle est invalide elle demande à l'utilisateur d'entrer un
     * chemin valide.
     *
     * @param chem le chemin à traiter
     * @return un chemin différent de null
     * */
    public static String validChemin(String chem) {
        // Debut de la boucle de validation.
        while (chem == null) {
            System.out.println(MSG_ERR);
            System.out.println("Entrez le chemin du fichier du pseudo-code : ");
            chem = Clavier.lireString();
            chem = TP2Utils.lireFichierTexte(chem);
        }
        return chem;
    }
    /**
     * Cette methode retourne une nouvelle chaine de caracteres qui represente
     * le pseudocode donne en parametre, auquel on a enleve tous les caracteres
     * blancs au debut de chaque ligne et tous les caracteres blancs superflus
     * a la fin de chaque ligne (en conservant cependant le caractere '\n' qui
     * marque la fin d'une ligne).
     *
     * @param pseudocode le pseudocode à traiter.
     * @return une nouvelle chaine representant le pseudocode donne en parametre,
     * auquel on a enleve tous les caracteres blancs au debut et a la fin
     * de chaque ligne (en conservant le caractere '\n' à la fin de chaque
     * ligne).
     */
    public static String trimer (String pseudocode) {
        String sTrim = ""; //pseudocode a retourner
        String sTmp;
        int debut = 0; ; //indice du debut de la ligne courante
        int fin; //indice de la fin de la ligne courante
        //parcourir les lignes, et enlever les caracteres blancs avant et après
        //chaque ligne sauf le \n a la fin de la ligne.
        pseudocode = pseudocode.trim() + "\n";
        fin = pseudocode.indexOf("\n", debut);
        while (fin != -1) {
            //extraire la ligne courante et enlever tous les caracteres blancs
            //en debut et fin de ligne
            sTmp = pseudocode.substring(debut, fin).trim();
            //concatener la ligne courante a la chaine a retourner, en ajoutant
            //le saut de ligne a la fin.
            sTrim = sTrim + sTmp + "\n";
            //ajuster le debut de la ligne courante suivante
            debut = fin + 1;
            //trouver la fin de la ligne courante suivante
            fin = pseudocode.indexOf("\n", debut);
        }
        return sTrim;
    }
    /**Cette methode transforme les mots reserves de la
     * chaine qui lui ait fourni en majuscule et retourne
     * cette meme en ayant transforme ses mots réserves en
     * majuscule si elle en contient.
     * */
    public static String MotMaj (String sTmp) {
        int x=0; // Cette variable va permettre de stocker les positions des chaines à utiliser.
        int y=0;
        if(sTmp.equalsIgnoreCase(DEBUT.toLowerCase())) {
            sTmp = sTmp.toUpperCase();
        }
        else if(sTmp.equalsIgnoreCase(FIN.toLowerCase())) {
                sTmp = sTmp.toUpperCase();
        }
        else if((sTmp.toUpperCase().startsWith(AFFICHER + ES))) {
            x = sTmp.toUpperCase().indexOf(AFFICHER + ES);
            sTmp = sTmp.toUpperCase().substring(x,9) + sTmp.substring(9);
        }
        else if((sTmp.toUpperCase().startsWith(ECRIRE + ES))) {
            x = sTmp.toUpperCase().indexOf(ECRIRE + ES);
            sTmp = sTmp.toUpperCase().substring(x, 7) + sTmp.substring(7);
        }
        else if((sTmp.toUpperCase().startsWith(LIRE + ES))) {
            x = sTmp.toUpperCase().indexOf(LIRE + ES);
            sTmp = sTmp.toUpperCase().substring(x, 5) + sTmp.substring(5);
        }
        else if((sTmp.toUpperCase().startsWith(SAISIR + ES))) {
            x = sTmp.toUpperCase().indexOf(SAISIR + ES);
            sTmp = sTmp.toUpperCase().substring(x, 7) + sTmp.substring(7);
        }
        else if((sTmp.toUpperCase().startsWith(SINON))) {
            x = sTmp.toUpperCase().indexOf(SINON);
            sTmp = sTmp.toUpperCase().substring(x, 5) + sTmp.substring(5);
        }
        else if((sTmp.toUpperCase().startsWith(FIN + ES) && (sTmp.toUpperCase().endsWith(SI)))) {
            x = sTmp.toUpperCase().indexOf(FIN + ES);
            y = sTmp.toUpperCase().indexOf(SI);
            sTmp = sTmp.toUpperCase().substring(x);
        }
        else if((sTmp.toUpperCase().startsWith(TANT_QUE + ES) && sTmp.toUpperCase().endsWith(FAIRE))) {
            x = sTmp.toUpperCase().indexOf(TANT_QUE + ES);
            y = sTmp.toUpperCase().indexOf(FAIRE);
            sTmp = sTmp.toUpperCase().substring(x,9) + sTmp.substring(9,y) + sTmp.toUpperCase().substring(y);
        }
        else if((sTmp.toUpperCase().startsWith(FIN) && (sTmp.toUpperCase().endsWith(TANT_QUE)))) {
            x = sTmp.toUpperCase().indexOf(FIN);
            y = sTmp.toUpperCase().indexOf(TANT_QUE + ES);
            sTmp = sTmp.toUpperCase().substring(x);
        }
        else if((sTmp.toUpperCase().startsWith(FAIRE))) {
            x = sTmp.toUpperCase().indexOf(FAIRE);
            sTmp = sTmp.toUpperCase().substring(x);
        }
        else if((sTmp.toUpperCase().startsWith(TANT_QUE + ES))) {
            x = sTmp.toUpperCase().indexOf(TANT_QUE + ES);
            sTmp = sTmp.toUpperCase().substring(x,9) + sTmp.substring(9);
        }
        else if((sTmp.toUpperCase().startsWith(SI) && (sTmp.toUpperCase().endsWith(ALORS)))) {
            x = sTmp.toUpperCase().indexOf(SI );
            y = sTmp.toUpperCase().indexOf(ALORS);
            sTmp = sTmp.toUpperCase().substring(x,2) + sTmp.substring(2,y) + sTmp.toUpperCase().substring(y);
        }
        return sTmp;
    }

    /**Cette methode transforme les mots reserves de la
     * chaine qui lui ait fourni en minuscule et retourne
     * cette meme en ayant transforme ses mots reserves en
     * minuscule si elle en contient.
     * */
    public static String MotMin (String sTmp) {
        int x=0;
        int y=0;
        if(sTmp.equalsIgnoreCase(DEBUT.toLowerCase())) {
            sTmp = sTmp.toLowerCase();
        }
        else if(sTmp.equalsIgnoreCase(FIN.toLowerCase())) {
                sTmp = sTmp.toLowerCase();
        }
        else if((sTmp.toUpperCase().startsWith(AFFICHER))) {
            x = sTmp.toUpperCase().indexOf(AFFICHER );
            sTmp = sTmp.toLowerCase().substring(x,9) + sTmp.substring(9);
        }
        else if((sTmp.toUpperCase().startsWith(ECRIRE + ES))) {
            x = sTmp.toUpperCase().indexOf(ECRIRE + ES);
            sTmp = sTmp.toLowerCase().substring(x, 7) + sTmp.substring(7);
        }
        else if((sTmp.toUpperCase().startsWith(LIRE+ ES))) {
            x = sTmp.toUpperCase().indexOf(LIRE + ES);
            sTmp = sTmp.toLowerCase().substring(x, 5) + sTmp.substring(5);
        }
        else if((sTmp.toUpperCase().startsWith(SAISIR + ES))) {
            x = sTmp.toUpperCase().indexOf(SAISIR + ES);
            sTmp = sTmp.toLowerCase().substring(x, 7) + sTmp.substring(7);
        }
        else if((sTmp.toUpperCase().startsWith(SINON))) {
            x = sTmp.toUpperCase().indexOf(SINON);
            sTmp = sTmp.toLowerCase().substring(x, 5) + sTmp.substring(5);
        }
        else if((sTmp.toUpperCase().startsWith(FIN + ES) && (sTmp.toUpperCase().endsWith(SI)))) {
            x = sTmp.toUpperCase().indexOf(FIN + ES);
            y = sTmp.toUpperCase().indexOf(SI);
            sTmp = sTmp.toLowerCase().substring(x);
        }
        else if((sTmp.toUpperCase().startsWith(TANT_QUE) && (sTmp.toUpperCase().endsWith(FAIRE)))) {
            x = sTmp.toUpperCase().indexOf(TANT_QUE);
            y = sTmp.toUpperCase().indexOf(FAIRE);
            sTmp = sTmp.toLowerCase().substring(x,9) + sTmp.substring(9,y) + sTmp.toLowerCase().substring(y);
        }
        else if((sTmp.toUpperCase().startsWith(FIN + ES) && (sTmp.toUpperCase().endsWith(TANT_QUE)))) {
            x = sTmp.toUpperCase().indexOf(FIN + ES);
            y = sTmp.toUpperCase().indexOf(TANT_QUE);
            sTmp = sTmp.toLowerCase().substring(x);
        }
        else if((sTmp.toUpperCase().startsWith(FAIRE))) {
            x = sTmp.toUpperCase().indexOf(FAIRE);
            sTmp = sTmp.toLowerCase().substring(x);
        }
        else if((sTmp.toUpperCase().startsWith(TANT_QUE ))) {
            x = sTmp.toUpperCase().indexOf(TANT_QUE );
            sTmp = sTmp.toLowerCase().substring(x,9) + sTmp.substring(9);
        }
        else if((sTmp.toUpperCase().startsWith(SI) && (sTmp.toUpperCase().endsWith(ALORS)))) {
            x = sTmp.toUpperCase().indexOf(SI);
            y = sTmp.toUpperCase().indexOf(ALORS);
            sTmp = sTmp.toLowerCase().substring(x,2) + sTmp.substring(2,y) + sTmp.toLowerCase().substring(y);
        }
        return sTmp;
    }

    /**Cette methode parcours ligne par ligne le pseudocode et utilise les deux methodes
     * precedantes en fonction de la valeur du parametre formFic et retourne le pseudocode
     * avec tous les mots reserves en minuscule ou en majuscule.
     *
     * @param (formFic,pseudocode) formFic est un variable qui lorsqu'elle prend "m"
     * cette methode utilise la methode MotMin, si elle prend "M" cette methode utilise la methode
     * MotMaj et pseudocode contient le pseudocode a indenter.
     * @return le pseudocode avec tous les mots reserves avec la meme taille (minuscule ou majuscule).
     * */
    public static String Majmin (String formFic,String pseudocode) {
        String sTrim = ""; //pseudocode a retourner
        String sTmp;
        int debut = 0; //indice du debut de la ligne courante
        int fin; //indice de la fin de la ligne courante
        //parcourir les lignes
        //chaque ligne sauf le \n a la fin de la ligne.
        fin = pseudocode.indexOf("\n", debut);
        while (fin != -1) {
            //extraire la ligne courante
            //en debut et fin de ligne
            sTmp = pseudocode.substring(debut, fin);
            // choisi la methode a utiliser en fonction du contenu de formFic
            switch (formFic) {
                case "m": {
                    sTmp = MotMin(sTmp);
                    break;
                }
                case "M": {
                    sTmp = MotMaj(sTmp);
                    break;
                }
            }
            //concatener la ligne courante a la chaine a retourner, en ajoutant
            //le saut de ligne a la fin.
            sTrim = sTrim + sTmp + "\n";
            //ajuster le debut de la ligne courante suivante
            debut = fin + 1;
            //trouver la fin de la ligne courante suivante
            fin = pseudocode.indexOf("\n", debut);
        }
        return sTrim;
    }

    /** Cette methode parcours le pseudocode ligne par ligne et
     * retourne le pseudocode indenté avec tous les mots reserves en
     * minuscule. Elle change la valeur du compteur en fonction des debut et fin+1 de ligne
     * et en fonction de la valeur du compteur il accede une des boucles for
     * pour donner une nouvelle valeur a IND qui est le nombre d'espaces ajoute avant une ligne.
     *
     *@param pseudocode contient le fichier pseudocode a indenter
     * @return retourne le pseudocode indente avec les mots reserves en minuscule
     * */
    public static String IndenteurMin(String pseudocode){
        String sTrim = ""; //pseudocode a retourner
        String sTmp;
        int debut = 0; //indice du debut de la ligne courante
        int fin; //indice de la fin de la ligne courante
        int ind = 1; // compteur pour le niveau d'indentation
        String IND =""; // nombre d'espace avant une ligne
        fin = pseudocode.indexOf("\n", debut);
        while (fin != -1) {
            //extraire la ligne courante
            //en debut et fin de ligne (+1 pour que le \n soit prise en compte)
            sTmp = pseudocode.substring(debut, fin+1);
            if(sTmp.startsWith(SINON.toLowerCase())){
                ind--;
            }
            else if(sTmp.equalsIgnoreCase(DEBUT.toLowerCase()+"\n") || (sTmp.startsWith(SI.toLowerCase()) && sTmp.endsWith(ALORS.toLowerCase()+"\n") || sTmp.endsWith(FAIRE.toLowerCase()+"\n"))){
                ind++;
            }
            else if((sTmp.startsWith("tant ") || sTmp.endsWith(SI.toLowerCase()+"\n") || sTmp.endsWith("que\n"))){
                ind--;
            }
            else if(sTmp.equalsIgnoreCase(FIN.toLowerCase()+"\n"))
                IND = "";
            for(int i=1; i>ind; i--){
                int x = IND.length();
                x = x-3;
                IND = IND.substring(0,x);
                ind++;
                if(sTmp.startsWith(SINON.toLowerCase())){
                    ind++;
                }
            }
            sTrim = sTrim + IND + sTmp;
            for(int i=1; i<ind; i++){
                IND = "   " + IND;
                ind--;
            }
            debut = fin + 1;
            fin = pseudocode.indexOf("\n", debut);
        }
        return sTrim;
    }
    /** Cette methode parcours le pseudocode ligne par ligne et
     * retourne le pseudocode indenté avec tous les mots reserves en
     * majuscule. Elle change la valeur du compteur en fonction des debut et fin+1 de ligne
     * et en fonction de la valeur du compteur il accede une des boucles for
     * pour donner une nouvelle valeur a IND qui est le nombre d'espaces ajoute avant une ligne.
     *
     *@param pseudocode contient le fichier pseudocode a indenter
     * @return retourne le pseudocode indente avec les mots reserves en majuscule
     * */
    public static String IndenteurMaj(String pseudocode){
        String sTrim = "";
        String sTmp;
        int debut = 0;
        int fin;
        int ind = 1;
        String IND ="";
        String k;
        fin = pseudocode.indexOf("\n", debut);
        while (fin != -1) {
            sTmp = pseudocode.substring(debut, fin+1);
            if(sTmp.startsWith(SINON)){
                ind--;
            }
            else if(sTmp.equalsIgnoreCase(DEBUT+"\n") || (sTmp.startsWith(SI) && sTmp.endsWith(ALORS+"\n") || sTmp.endsWith(FAIRE+"\n"))){
                ind++;
            }
            else if((sTmp.startsWith("TANT ") || sTmp.endsWith(SI+"\n") || sTmp.endsWith(" QUE\n"))){
                ind--;
            }
            else if(sTmp.equalsIgnoreCase(FIN+"\n"))
                IND = "";
            for(int i=1; i>ind; i--){
                int x = IND.length();
                x = x-3;
                IND = IND.substring(0,x);
                ind++;
                if(sTmp.startsWith(SINON)){
                    ind++;
                }
            }
            sTrim = sTrim + IND + sTmp;
            for(int i=1; i<ind; i++){
                IND = "   " + IND;
                ind--;
            }
            debut = fin + 1;
            fin = pseudocode.indexOf("\n", debut);
        }
        return sTrim;
    }
    /** Methode main */
    public static void main(String [] args) {
        String choix; // Variable pour le choix de menu
        String cheminFic; // Variable qui lit le chemin du fichier pseudocode
        String nomFic; // Variable qui va contenir le pseudocode contenu dans le fichier
        String formFic; // Variable pour choisir la taille des mots reserves
        boolean m; // Variable pour la boucle de retour au menu principal
        m = true;
        System.out.println(PRESENTATION);
        // Debut de la boucle de retour au menu
        while (m) {
            choix = ValiderChoix("1", "2", MENU);
            switch (choix) {
                case "1": {
                    System.out.print("Entrez le chemin du fichier du pseudo-code : ");
                    cheminFic = Clavier.lireString();
                    nomFic = TP2Utils.lireFichierTexte(cheminFic);
                    nomFic = validChemin(nomFic); // Cette ligne valide le chemin du fichier
                    nomFic = trimer(nomFic); //Cette ligne trime le pseudocode
                    formFic = ValiderChoix("m", "M", MSG_FORM); // Cette ligne demande se saisir la taille des mots reserves
                    nomFic = Majmin(formFic,nomFic); // Cette ligne va transformer les mots reserves en majuscule ou minuscule
                    if(formFic.equals("m"))
                        nomFic = IndenteurMin(nomFic); // Cette ligne indente le pseudocode, avec tous les mots reserves en minuscule
                    else
                        nomFic = IndenteurMaj(nomFic); // Cette ligne indente le pseudocode, avec tous les mots reserves en majuscule
                    System.out.println(LIM);
                    System.out.println((nomFic)); // Cette ligne affiche le pseudocode après toutes les modifications
                    System.out.println(LIM);
                    System.out.println(TAP_ENT);
                    Clavier.lireFinLigne();
                    m = true;
                    break;
                }
                case "2": {
                     System.out.println(FINPROG);
                    m = false;
                }
            }
        }
    }
}