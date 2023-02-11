/**
 * Décrivez votre classe ParisHippiques ici.
 *
 * @author (votre nom): YAYA NIARE
 * (code permanent) : NIAY84110301
 * @version (un numéro de version ou une date)
 */
public class ParisHippiques
{
    //Declaration des constantes
    public static final String PRESENTATION = "Ce programme permet de placer des paris sur des courses hippiques virtuelles.\n\n"
                                                +"Votre compte est vide, Pour continuer deposez de l'argent (ou 0 pour quitter) : ";
    public static final String MENU = "----\nMENU\n ----\n1. Placer un paris\n2. Gerer la banque\n"
                                        +"3. Quitter\n\nEntrez votre choix(1, 2 ou 3) : ";
    public static final String MESSAGE_DERREUR_1 = "Erreur, entrez un choix entre 1 et 3! Recommencez...\n";
    public static final String MESSAGE_DERREUR_2 = "Erreur, entrez un choix entre 1 et 5! Recommencez...\n";
    public static final String MESSAGE_DERREUR_3 = "Erreur, entrez un choix entre 1 et 6! Recommencez...\n";
    public static final String MENU_PARIS = "--------------\nPLACER UN PARI\n--------------\nType de pari\n1. Pari simple gagnant\n2. Pari simple place\n3. Pari couple gagnant ordonne\n"
                                        +"4. Pari couple gagnant non ordonne\n5. Revenir au menu principal\n\nEntrez le type de pari :";
    public static final String LISTE_CHEVEAUX = "Chevaux\n\n1. Gaspard\n2. Bubulle\n3. Babette\n4. Socrate\n5. Romarin\n6. Canelle\n\n"
                                                +"Choisissez votre cheval";
    public static final String MONTANT_EN_BANQUE = "** montant en banque :";
    public static final String MONTANT_MISE = "Entrez le montant de la mise (0 pour annuler) : ";
    public static void main(String [] args){
        //Declaration des variables
        double montantDepose, banque, banque1, montantMise, gain, gainCumule;
        char choix, choixParis, choixMenuBanque;
        int  cheval1, cheval2, classement;
        boolean x, y, z;
        System.out.print(PRESENTATION);
        montantDepose = Clavier.lireDouble();
        x=true;
        // Boucle de validation 1 (permet de revenir au menu principal)
        banque = montantDepose;
        gainCumule = 0;
        while (x == true){ 
            if(montantDepose > 0){
                System.out.print(MENU);
                choix = Clavier.lireCharLn();
                while(choix != '1' && choix != '2' && choix != '3'){
                    System.out.println(MESSAGE_DERREUR_1 + MENU);
                    choix = Clavier.lireCharLn();
                }
                z=true;
                // Boucle de validation 2 ( permet de revenir au menu paris)
                while(z == true){
                    switch (choix){
                        case '1':{
                            System.out.println(MENU_PARIS);
                            choixParis = Clavier.lireCharLn();
                            while(choixParis != '1' && choixParis != '2' && choixParis != '3' && choixParis != '4' && choixParis != '5'){
                                System.out.println(MESSAGE_DERREUR_2 + MENU_PARIS);
                                choixParis = Clavier.lireCharLn();
                            }
                            // Instructions donnés en fonction du choix de paris de l'utilisateur
                            switch(choixParis){
                                //Instructions si l'utilisateur entre 1 au menu paris
                                case '1':{
                                    System.out.println(LISTE_CHEVEAUX);
                                    cheval1 = Clavier.lireInt();
                                    // Boucle de validation du choix de cheval
                                    while(cheval1 != 1 && cheval1 != 2 && cheval1 != 3 && cheval1 != 4 && cheval1 != 5 && cheval1 != 6){                                        
                                        System.out.println(MESSAGE_DERREUR_3 + LISTE_CHEVEAUX);
                                        cheval1 = Clavier.lireInt();
                                    }
                                    System.out.print(MONTANT_MISE);
                                    montantMise = Clavier.lireDouble();
                                    // Boucle de validation du monatnt de la mise
                                    while(montantMise<0 || montantMise>banque){
                                        System.out.printf("Erreur, la mise doit etre entre 0.00$ et %.2f$ ! Recommencez...\n", banque);
                                        System.out.print(MONTANT_MISE);
                                        montantMise = Clavier.lireDouble();
                                    }
                                    if(montantMise == 0){
                                        System.out.println("----> OPERATION ANNULEE <----\n\n");
                                        System.out.println("Appuyez sur <ENTREE> pour revennir au menu principal");
                                        Clavier.lireFinLigne();
                                        z=false; // le changement de valeur de la variable z permet de sortir de la boucle de validation 1
                                        x=true; // le changement de valeur de la variable x permet de retourner au menu principal
                                    }
                                    else{
                                        banque = banque - montantMise;
                                        classement = TP1Utils.executerCourse();
                                        if(classement / 100000 == cheval1){
                                            gain = montantMise*3;
                                            gainCumule = gainCumule +(gain -  montantMise);
                                            banque = banque + gain;
                                            System.out.printf("BRAVO ! Vous avez gagné %.2f$\n\n",gain);
                                            if(gainCumule<0){
                                                gainCumule = gainCumule - 2*gainCumule;
                                                System.out.printf("PERTE CUMULEE     : %.2f$\nBANQUE          : %.2f$",gainCumule,banque);
                                                gainCumule = (-1)*gainCumule;
                                            }
                                            else
                                                System.out.printf("GAIN CUMULE     : %.2f$\nBANQUE          : %.2f$",gainCumule,banque);
                                            System.out.println("\n\nAppuyez sur <ENTREE> pour revennir au menu principal");
                                            Clavier.lireFinLigne();
                                            z=false;
                                            x=true;
                                        }
                                        else{
                                            gainCumule = gainCumule - montantMise;
                                            System.out.println("DESOLE ! Vous avez perdu votre pari.\n\n");
                                            if(gainCumule<0){
                                                gainCumule = gainCumule - 2*gainCumule;
                                                System.out.printf("PERTE CUMULEE     : %.2f$\nBANQUE          : %.2f$",gainCumule,banque);
                                                gainCumule = (-1)*gainCumule;
                                            }
                                            else
                                                System.out.printf("GAIN CUMULE     : %.2f$\nBANQUE          : %.2f$",gainCumule,banque);
                                            System.out.println("\n\nAppuyez sur <ENTREE> pour revennir au menu principal");
                                            Clavier.lireFinLigne();
                                            z=false;
                                            x=true;
                                        }
                                    }
                                    break;
                                }
                                //Instructions si l'utilisateur entre 2 au menu paris
                                case '2':{
                                    System.out.println(LISTE_CHEVEAUX);
                                    cheval1 = Clavier.lireInt();
                                    // Boucle de validation du choix de cheval
                                    while(cheval1 != 1 && cheval1 != 2 && cheval1 != 3 && cheval1 != 4 && cheval1 != 5 && cheval1 != 6){
                                        System.out.println(MESSAGE_DERREUR_3 + LISTE_CHEVEAUX);
                                        cheval1 = Clavier.lireInt();                                    
                                    }
                                    System.out.print(MONTANT_MISE);
                                    montantMise = Clavier.lireDouble();
                                    // Boucle de validation du monatnt de la mise
                                    while(montantMise<0 || montantMise>banque){
                                        System.out.printf("Erreur, la mise doit etre entre 0.00$ et %.2f$ ! Recommencez...\n", banque);
                                        System.out.print(MONTANT_MISE);
                                        montantMise = Clavier.lireDouble();
                                    }
                                    if(montantMise == 0){
                                        System.out.println("----> OPERATION ANNULEE <----\n\n");
                                        System.out.println("Appuyez sur <ENTREE> pour revennir au menu principal");
                                        Clavier.lireFinLigne();
                                        z=false;
                                        x=true;
                                    }
                                    else{
                                        banque = banque - montantMise;
                                        classement = TP1Utils.executerCourse();
                                        if(classement / 100000 == cheval1 || classement / 10000 % 10 == cheval1){
                                            gain = montantMise*3;
                                            gainCumule = gainCumule +(gain -  montantMise);
                                            banque = banque + gain;
                                            System.out.printf("BRAVO ! Vous avez gagné %.2f$\n\n",gain);
                                            if(gainCumule<0){
                                                gainCumule = gainCumule - 2*gainCumule;
                                                System.out.printf("PERTE CUMULEE     : %.2f$\nBANQUE          : %.2f$",gainCumule,banque);
                                                gainCumule = (-1)*gainCumule;
                                            }
                                            else
                                                System.out.printf("GAIN CUMULE     : %.2f$\nBANQUE          : %.2f$",gainCumule,banque);
                                            System.out.println("\n\nAppuyez sur <ENTREE> pour revennir au menu principal");
                                            Clavier.lireFinLigne();
                                            z=false;
                                            x=true;
                                        }
                                        else{
                                            gainCumule = gainCumule - montantMise;
                                            System.out.println("DESOLE ! Vous avez perdu votre pari.\n\n");
                                            if(gainCumule<0){
                                                gainCumule = gainCumule - 2*gainCumule;
                                                System.out.printf("PERTE CUMULEE     : %.2f$\nBANQUE          : %.2f$",gainCumule,banque);
                                                gainCumule = (-1)*gainCumule;
                                            }
                                            else
                                                System.out.printf("GAIN CUMULE     : %.2f$\nBANQUE          : %.2f$",gainCumule,banque);
                                            System.out.println("\n\nAppuyez sur <ENTREE> pour revennir au menu principal");
                                            Clavier.lireFinLigne();
                                            z=false;
                                            x=true;
                                        }
                                    }
                                    break;
                                }
                                //Instructions si l'utilisateur entre 3 au menu paris
                                case '3':{
                                    System.out.println(LISTE_CHEVEAUX + " 1 : ");
                                    cheval1 = Clavier.lireInt();
                                    // Boucle de validation du choix de cheval
                                    while(cheval1 != 1 && cheval1 != 2 && cheval1 != 3 && cheval1 != 4 && cheval1 != 5 && cheval1 != 6){
                                        System.out.println(MESSAGE_DERREUR_3 + LISTE_CHEVEAUX +" 1 : ");
                                        cheval1 = Clavier.lireInt();
                                    }
                                    System.out.println(LISTE_CHEVEAUX + " 2 : ");
                                    cheval2 = Clavier.lireInt();
                                    while(cheval2 != 1 && cheval2 != 2 && cheval2 != 3 && cheval2 != 4 && cheval2 != 5 && cheval2 != 6){
                                        System.out.println(MESSAGE_DERREUR_3 + LISTE_CHEVEAUX + " 2 : ");
                                        cheval2 = Clavier.lireInt();
                                    }
                                    System.out.print(MONTANT_MISE);
                                    montantMise = Clavier.lireDouble();
                                    // Boucle de validation du monatnt de la mise
                                    while(montantMise<0 || montantMise>banque){
                                        System.out.printf("Erreur, la mise doit etre entre 0.00$ et %.2f$ ! Recommencez...\n", banque);
                                        System.out.print(MONTANT_MISE);
                                        montantMise = Clavier.lireDouble();
                                    }
                                    if(montantMise == 0){
                                        System.out.println("----> OPERATION ANNULEE <----\n\n");
                                        System.out.println("Appuyez sur <ENTREE> pour revennir au menu principal");
                                        Clavier.lireFinLigne();
                                        z=false;
                                        x=true;
                                    }
                                    else{
                                        banque = banque - montantMise;
                                        classement = TP1Utils.executerCourse();
                                        if(cheval1 == classement / 100000 && cheval2 == classement / 10000 % 10){
                                            gain = montantMise*3.5;
                                            gainCumule = gainCumule + (gain -  montantMise);
                                            banque = banque + gain;
                                            System.out.printf("BRAVO ! Vous avez gagné %.2f$\n\n",gain);
                                            if(gainCumule<0){
                                                gainCumule = gainCumule - 2*gainCumule;
                                                System.out.printf("PERTE CUMULEE     : %.2f$\nBANQUE          : %.2f$",gainCumule,banque);
                                                gainCumule = (-1)*gainCumule;
                                            }
                                            else
                                                System.out.printf("GAIN CUMULE     : %.2f$\nBANQUE          : %.2f$",gainCumule,banque);
                                            System.out.println("\n\nAppuyez sur <ENTREE> pour revennir au menu principal");
                                            Clavier.lireFinLigne();
                                            z=false;
                                            x=true;
                                        }
                                        else{
                                            gainCumule = gainCumule - montantMise;
                                            System.out.println("DESOLE ! Vous avez perdu votre pari.\n\n");
                                            if(gainCumule<0){
                                                gainCumule = gainCumule - 2*gainCumule;
                                                System.out.printf("PERTE CUMULEE     : %.2f$\nBANQUE          : %.2f$",gainCumule,banque);
                                                gainCumule = (-1)*gainCumule;
                                            }
                                            else
                                                System.out.printf("GAIN CUMULE     : %.2f$\nBANQUE          : %.2f$",gainCumule,banque);
                                            System.out.println("\n\nAppuyez sur <ENTREE> pour revennir au menu principal");
                                            Clavier.lireFinLigne();
                                            z=false;
                                            x=true;
                                        }
                                    }
                                    break;
                                }
                                // Instructions si l'utilisateur entre 4 au menu paris
                                case '4':{
                                    System.out.println(LISTE_CHEVEAUX + " 1 : ");
                                    cheval1 = Clavier.lireInt();
                                    // Boucle de validation du choix de cheval
                                    while(cheval1 != 1 && cheval1 != 2 && cheval1 != 3 && cheval1 != 4 && cheval1 != 5 && cheval1 != 6){
                                        System.out.println(MESSAGE_DERREUR_3 + LISTE_CHEVEAUX + " 1 : ");
                                        cheval1 = Clavier.lireInt();
                                    }
                                    System.out.println(LISTE_CHEVEAUX + " 2 : ");
                                    cheval2 = Clavier.lireInt();
                                    while(cheval2 != 1 && cheval2 != 2 && cheval2 != 3 && cheval2 != 4 && cheval2 != 5 && cheval2 != 6){
                                        System.out.println(MESSAGE_DERREUR_3 + LISTE_CHEVEAUX + " 2 : ");
                                        cheval2 = Clavier.lireInt();
                                    }
                                    System.out.print(MONTANT_MISE);
                                    montantMise = Clavier.lireDouble();
                                    // Boucle de validation du monatnt de la mise
                                    while(montantMise<0 || montantMise>banque){
                                        System.out.printf("Erreur, la mise doit etre entre 0.00$ et %.2f$ ! Recommencez...\n", banque);
                                        System.out.print(MONTANT_MISE);
                                        montantMise = Clavier.lireDouble();
                                    }
                                    if(montantMise == 0){
                                        System.out.println("----> OPERATION ANNULEE <----\n\n");
                                        System.out.println("Appuyez sur <ENTREE> pour revennir au menu principal");
                                        Clavier.lireFinLigne();
                                        z=false;
                                        x=true;
                                    }
                                    else{
                                        banque = banque - montantMise;
                                        classement = TP1Utils.executerCourse();
                                        if(cheval1 == classement / 100000 && cheval2 == classement / 10000 % 10){
                                            gain = montantMise*2.5;
                                            gainCumule = gainCumule + (gain -  montantMise);
                                            banque = banque + gain;
                                            System.out.printf("BRAVO ! Vous avez gagné %.2f$\n\n",gain);
                                            if(gainCumule<0){
                                                gainCumule = gainCumule - 2*gainCumule;
                                                System.out.printf("PERTE CUMULEE     : %.2f$\nBANQUE          : %.2f$",gainCumule,banque);
                                                gainCumule = (-1)*gainCumule;
                                            }
                                            else
                                                System.out.printf("GAIN CUMULE     : %.2f$\nBANQUE          : %.2f$",gainCumule,banque);
                                            System.out.println("\n\nAppuyez sur <ENTREE> pour revennir au menu principal");
                                            Clavier.lireFinLigne();                         
                                            z=false;
                                            x=true;
                                        }
                                        else{
                                            gainCumule = gainCumule - montantMise;
                                            System.out.println("DESOLE ! Vous avez perdu votre pari.\n\n");
                                            if(gainCumule<0){
                                                gainCumule = gainCumule - 2*gainCumule;
                                                System.out.printf("PERTE CUMULEE     : %.2f$\nBANQUE          : %.2f$",gainCumule,banque);
                                                gainCumule = (-1)*gainCumule;
                                            }
                                            else
                                                System.out.printf("GAIN CUMULE     : %.2f$\nBANQUE          : %.2f$",gainCumule,banque);
                                            System.out.println("\n\nAppuyez sur <ENTREE> pour revennir au menu principal");
                                            Clavier.lireFinLigne();
                                            z=false;
                                            x=true;
                                        }
                                    }
                                    break;
                                }
                                // instructions, si l'utilisateur rentre 5 au menu paris
                                case '5':{
                                    z=false;
                                    x=true;
                                    break;
                                }
                            }
                            // Instructions quand le solde en banque est egal à 0
                            if(banque == 0){
                                System.out.print("\n\nVotre banque est vide.\n" + "Pour continuer, entrez un montant a mettre en banque (0 pour quitter) :");
                                banque = Clavier.lireDouble();
                                while(banque<0){
                                    System.out.print("Erreur, le montant doit etre plus grand ou egal a 0! Recommencez...\n" + "entrez un montant a mettre en banque (0 pour quitter) :");
                                    banque = Clavier.lireDouble();
                                }
                                if(banque>0)
                                    x=true;
                                else if(banque==0){
                                        System.out.println("Aurevoir\n");
                                        x=false;
                                }
                            }
                            break;
                        // Instructions si l'utilisateur entre 2 au menu principal  (Pour gérer sa banque)
                        }
                        case '2':{
                            System.out.print(MONTANT_EN_BANQUE);
                            System.out.printf("%.2f$ **\n",banque);
                            y=true;
                            // Boucle de validation 3
                            while(y == true){
                                System.out.print("(A)jouter, (V)ider, ou (R)evenir au menu principal : ");
                                choixMenuBanque = Clavier.lireCharLn();
                                // Boucle de valisation de la valeur entrée.
                                while(choixMenuBanque != 'A' && choixMenuBanque != 'a' && choixMenuBanque != 'V' && choixMenuBanque !='v' && choixMenuBanque != 'R' && choixMenuBanque != 'r'){
                                    System.out.print("Erreur! Recommencez...\n");
                                    System.out.print("(A)jouter, (V)ider, ou (R)evenir au menu principal : ");
                                    choixMenuBanque = Clavier.lireCharLn();
                                }
                                // Instructions pour ajouter de l'argent
                                if(choixMenuBanque == 'A' || choixMenuBanque == 'a'){
                                    System.out.print ("Entrez le montant a ajouter (0 pour annuler) : ");
                                    banque1 = Clavier.lireDouble();
                                    while(banque1<0){
                                        System.out.print("Erreur, le montant doit etre plus grand ou egal a 0! Recommencez...\n" + "entrez un montant a mettre en banque (0 pour quitter) :");
                                        banque1 = Clavier.lireDouble();
                                    }
                                    banque = banque + banque1;
                                    System.out.printf("** Montant en banque : %.2f$  **\n",banque);
                                    y=true;
                                }
                                // instructions pour vider la banque
                                else if(choixMenuBanque == 'V' || choixMenuBanque == 'v'){
                                        System.out.println("Aurevoir\n");
                                        y=false;
                                        z=false;
                                        x=false;
                                    }
                                    // instructions pour retourner au menu principal
                                    else if(choixMenuBanque == 'R' || choixMenuBanque == 'r'){
                                            y=false;
                                            z=false;
                                            x=true;
                                    }
                            }
                            break;
                        // Instruction pour quitter 2
                        }   
                        case '3':{
                            System.out.println("Aurevoir\n");
                            z=false;
                            x=false;
                            break;
                        }
                    }
                }
            }
            // Instructions pour quitter 1
            else{
                System.out.println ("Aurevoir\n");
                x=false;
            }
        }
    }
}