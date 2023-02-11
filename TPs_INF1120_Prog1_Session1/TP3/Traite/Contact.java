/**
 * Cette classe modelise un contact.
 * @author (votre nom): YAYA NIARE
 * (code permanent) : NIAY84360305
 * @version Decembre 2022
 */
public class Contact {
    //--------------
    //CONSTANTES DE CLASSE
    //--------------

    //Valeurs par defaut pour les attributs
    public static String NOM_DEFAUT = "Nom";
    public static String PRENOM_DEFAUT = "Prenom";

    //--------------
    //ATTRIBUT DE CLASSE
    //--------------

    private static int nbrContactsFavoris; //Compte le nombre de contacts favoris

    //--------------
    //ATTRIBUTS D'INSTANCE
    //--------------

    private String nom; //Nom du contact
    private String prenom; //Prenom du contact
    private Telephone [] telephones = new Telephone[0]; //Tableau contenant les numéros de téléphone du contact
    private Adresse adresse; //Adresse du contact
    private String [] courriels = new String[0]; //Tableau contenant les courriels du contact
    private boolean favori; //Détermine si le contact est favori ou non

    //--------------
    //CONSTRUCTEURS
    //--------------

    /**
     * Construit un objet Contact en initialisant ses attributs avec les valeurs
     * passees en parametres.
     *
     * Si le parametre nom ou prenom donne est null ou vide, l'attribut correspondant
     * est plutot initialise avec sa valeur par defaut (voir constantes de classe).
     * Si le parametre tel ou courriel est null ou vide, il ne sera pas aujoute au
     * tableau, le tableau restera le même.
     * Le parametre adresse prend la valeur qui est donne en parametre.
     * Si le parametre favori de ce contact est true, il est ajouté aux favoris sinon
     * il reste un contact non favori.
     *
     * @param nom le nom du contact
     * @param prenom le prenom du contact
     * @param tel le telephone du contact
     * @param adresse l'adresse postale du contact
     * @param courriel le courriel du contact
     * @param favori Le contact est favori ou non
     * */
    public Contact(String nom, String prenom, Telephone tel, Adresse adresse, String courriel, boolean favori){
        if(nom == null || nom.isEmpty()){
            this.nom = NOM_DEFAUT;
        }
        else
            this.nom = nom;
        if(prenom == null || prenom.isEmpty()){
            this.prenom = PRENOM_DEFAUT;
        }
        else
            this.prenom = prenom;
        if(tel!=null && !tel.equals(new Telephone("", "", "", ""))) {
            telephones = new Telephone[1];
            this.telephones[0] = tel;
        }
        this.adresse = adresse;
        if(courriel!=null && !courriel.isEmpty()){
            courriels = new String[1];
            this.courriels[0] = courriel;
        }
        this.favori = favori;
        if(favori)
            nbrContactsFavoris++;
    }
    /**
     * Construit un objet Contact en initialisant ses attributs avec les valeurs
     * passees en parametres.
     *
     * Si le parametre nom ou prenom donne est null ou vide, l'attribut correspondant
     * est plutot initialise avec sa valeur par defaut (voir constantes de classe).
     * Le parametre adresse prend la valeur qui est donne.
     * Si le parametre favori est automatiquement initialisé à false.
     *
     * @param nom le nom du contact
     * @param prenom le prenom du contact
     * @param adresse l'adresse du contact
     * */
    public Contact(String nom, String prenom, Adresse adresse){
        if(nom == null || nom.isEmpty()){
            this.nom = NOM_DEFAUT;
        }
        else
            this.nom = nom;
        if(prenom == null || prenom.isEmpty()){
            this.prenom = PRENOM_DEFAUT;
        }
        else
            this.prenom = prenom;
        this.adresse = adresse;
        favori = false;
    }

    //---------------------
    //METHODES D'INSTANCE
    //---------------------

    /**
     * Permet d'obtenir le nom du contact a cette adresse.
     * @return le nom du contact de cette adresse.
     */
    public String getNom(){return nom;
    }
    /**
     * Permet d'obtenir le prenom du contact de cette adresse.
     * @return le prenom du contact de cette adresse.
     */
    public String getPrenom(){
        return prenom;
    }
    /**
     * Permet d'obtenir l'adresse postale du contact de cette adresse.
     * @return l'adresse (attribut d'instance) du contact de cette adresse.
     */
    public Adresse getAdresse(){
        return adresse;
    }
    /**
     * Permet d'obtenir le status (favori ou non) du contact de cette adresse.
     * @return le status (favori ou non) du contact de cette adresse.
     */
    public boolean isFavori(){
        return favori;
    }
    /**
     * Modifie le nom du contact de cette adresse par le nom donne en parametre.
     * Si le nom donne est null ou vide, l'attribut nom de cet objet sera
     * modifie avec la chaine NOM_DEFAUT.
     *
     * @param nom le nouveau nom du contact assigner a cette adresse
     */
    public void setNom(String nom){
        if((nom != null) && !(nom.isEmpty())) {
            this.nom = nom;
        }
    }
    /**
     * Modifie le prenom du contact de cette adresse par le prenom donne en parametre.
     * Si le prenom donne est null ou vide, l'attribut prenom de cet objet sera
     * modifie avec la chaine PRENOM_DEFAUT.
     *
     * @param prenom le nouveau prenom du contact assigner a cette adresse
     */
    public void setPrenom(String prenom){
        if(prenom != null && !(prenom.isEmpty())){
            this.prenom = prenom;
        }
    }
    /**
     * Modifie l'adresse postale du contact de cette adresse par l'adresse donne en parametre.
     *
     * @param adresse la nouvelle adresse du contact assigner a cette adresse
     */
    public void setAdresse(Adresse adresse){
        this.adresse = adresse;
    }
    /**
     * Modifie le status du contact de cette adresse par le status donne en parametre.
     *
     * @param favori le nouveau status du contact assigner a cette adresse
     */
    public void setFavori(boolean favori){
        this.favori = favori;
    }

    //------------------------------------
    //AUTRES METHODES D'INSTANCE PUBLIQUES
    //------------------------------------

    /**
     * Permet d'ajouter le numero de telephone donne en parametre
     * a la liste de numero de telephone du contact de cette adresse
     *
     * @param tel le nouveau telephone a ajouter.
     * Si le telephone donne est null, rien n'est aujouté.
     */
    public void ajouterTelephone(Telephone tel){
        if(tel == null){
            // Rien faire
        }
        else{
            Telephone[] telephones1 = new Telephone[telephones.length + 1];
            for(int i=0; i<telephones.length; i++) {
                telephones1[i] = telephones[i];
            }
            telephones = telephones1;
            telephones[telephones1.length-1] = tel;
        }
    }
    /**
     * Permet d'ajouter le courriel donne en parametre
     * a la liste de courriel du contact de cette adresse
     *
     * @param courriel le nouveau courriel a ajouter.
     * Si le courriel donne est null, rien n'est aujouté.
     */
    public void ajouterCourriel(String courriel){
        if(courriel == null || courriel.equals("")){
            //Rien faire
        }
        else{
            String[] courriels1 = new String[courriels.length + 1];
            for(int i=0; i<courriels.length; i++) {
                courriels1[i] = courriels[i];
            }
            courriels = courriels1;
            courriels[courriels1.length-1] = courriel;
        }
    }
    /**
     * Permet d'obtenir le telephone a la position donne
     * en parametre du contact a cette adresse
     *
     * Si la position donne n'existe pas on retourne null.
     *
     * @param position l'indice de l'element recherche dans le tableau
     * @return le telephone a la position donne en parametre
     * du contact a cette adresse
     */
    public Telephone obtenirTelephone(int position){
        Telephone tel;
        if(position<0 || position>telephones.length-1){
            tel = null;
        }
        else{
            tel = telephones[position];
        }
        return tel;
    }
    /**
     * Permet d'obtenir le courriel a la position donne
     * en parametre du contact a cette adresse
     *
     * Si la position donne n'existe pas, null est retourne.
     *
     * @param position l'indice de l'element recherche dans le tableau
     * @return le courriel a la position donne en parametre
     * du contact a cette adresse
     */
    public String obtenirCourriel(int position){
        String courriel;
        if(position<0 || position>courriels.length-1){
            courriel = null;
        }
        else{
            courriel = courriels[position];
        }
        return courriel;
    }
    /**
     * Permet de supprimer le telephone a la position donne
     * en parametre du contact a cette adresse
     *
     * Si la position donne n'existe pas, null est retourne.
     *
     * @param position l'indice de l'element recherche dans le tableau
     * @return le telephone a la position (telephone supprime) donne en parametre
     * du contact a cette adresse
     */
    public Telephone supprimerTelephone(int position){
        Telephone [] telephones1 = new Telephone[telephones.length-1];
        Telephone tel;
        if(position<0 || position>telephones.length-1){
            tel = null;
        }
        else{
            for(int i=0; i<position;i++){
                telephones1[i] = telephones[i];
            }
            for(int i=position+1; i< telephones.length;i++){
                telephones1[i-1] = telephones[i];
            }
            telephones = telephones1;
            tel = obtenirTelephone(position);
        }
        return tel;
    }
    /**
     * Permet de supprimer le courriel a la position donne
     * en parametre du contact a cette adresse
     *
     * Si la position donne n'existe pas, null est retourne.
     *
     * @param position l'indice de l'element recherche dans le tableau
     * @return le courriel a la position (courriel supprime) donne en parametre
     * du contact a cette adresse
     */
    public String supprimerCourriel(int position){
        String [] courriels1 = new String[courriels.length-1];
        String courriel;
        if(position<0 || position>courriels.length-1){
            return null;
        }
        else{
            for(int i=0; i<position;i++){
                courriels1[i] = courriels[i];
            }
            for(int i=position+1; i< courriels1.length;i++){
                courriels1[i-1] = courriels[i];
            }
            courriel = obtenirCourriel(position);
            courriels = courriels1;
        }
        return courriel;
    }
    /**
     * Permet de modifier le telephone a la position donne
     * en parametre du contact a cette adresse
     *
     * Si la position donne ne contient pas de telephone,
     * aucune modification n'est faite
     * Si le indReg est null ou de longueur different de 3, aucune
     * modification n'est fait a ce niveau
     * Si le numero est null ou de longueur different de 7, aucune
     * modification n'est fait a ce niveau
     * Si le poste est null, aucune modification n'est fait a ce niveau
     * Si le type est null ou vide, aucune modification n'est fait a ce niveau
     *
     */
    public void modifierTelephone(int position, String indReg, String numero, String poste, String type){
        Telephone tel = obtenirTelephone(position);
        if(tel == null){
            //Rien faire
        }
        else{
            if(indReg == null || (indReg.length()!=3)){
                //Rien faire
            }
            else {
                tel.setIndReg(indReg);
            }
            if(numero == null || (numero.length()!=7)){
                //Rien faire
            }
            else {
                tel.setNumero(numero);
            }
            if(poste == null){
                //Rien faire
            }
            else {
                tel.setPoste(poste);
            }
            if(type == null || (type.isEmpty())){
                //Rien faire
            }
            else {
                tel.setType(type);
            }
        }
    }
    /**
     * Permet de modifier le courriel a la position donne en parametre par
     * le courriel donne en parametre du contact a cette adresse
     *
     * Si la position donne ne contient pas de courriel,
     * aucune modification n'est faite,
     * Si le courriel donne est null ou vide aucune modification n'est faite.
     *
     * @param position indice de l'element du tableau a modifier
     * @param courriel le nouveau courriel
     * */

    public void modifierCourriel(int position, String courriel){
        String courriel2 = obtenirCourriel(position);
        if(courriel2 == null || courriel == null || courriel.isEmpty()){
            //rien faire
        }
        else{
            courriels[position] = courriel;
        }
    }
    /**
     * Permet de compter le nombre de telephones du contact a cette adresse.
     *
     * Si sa liste de telephone est null, on retourne 0
     *
     * @return le nombre de telephones du contact a cette adresse
     * */
    public int nbrTelephones(){
        if(telephones == null){
            return 0;
        }
        else
            return telephones.length;
    }
    /**
     * Permet de compter le nombre de courriels du contact a cette adresse.
     *
     * Si sa liste de courriel est null, on retourne 0
     *
     * @return le nombre de courriels du contact a cette adresse
     * */
    public int nbrCourriels(){
        if(courriels == null){
            return 0;
        }
        else
            return courriels.length;
    }
    /**
     * Construit une representation de ce contact sous forme de chaine de
     * caracteres.
     *
     * @return une representation de ce conatact sous forme de chaine de
     * caracteres.
     */
    public String toString(){
        String x = "";
        int i=0;
        if(favori) {
            x = x + nom.toUpperCase() + ", " + prenom + " [FAVORI]" + "\n\n" + "TELEPHONE(S) :" + "\n";
            if (telephones == null) {
                //Rien faire
            } else {
                for (Telephone j : telephones) {
                    x = x + j + "\n";
                }
            }
            x = x + "\n" + "ADRESSE :" + "\n";
            if(adresse == null){
                x = x + "" + "\n\n";
            }
            else{
                x = x + "\n";
            }
            x = x + "COURRIEL(S)" + "\n";
            if (courriels == null) {
                //Rien faire
            }
            else {
                for (String g : courriels) {
                    x = x + g + "\n";
                }
            }
        }
        else{
            x = x + nom.toUpperCase() + ", " + prenom + "\n\n" + "TELEPHONE(S) :" + "\n";
            if (telephones == null) {
                //Rien faire
            }
            else {
                for (Telephone j : telephones) {
                    x = x + j + "\n";
                }
            }
            x = x + "\n" + "ADRESSE :" + "\n";
            if(adresse == null){
                x = x + "\n";
            }
            else{
                x = x + adresse + "\n\n";
            }
            x = x + "COURRIEL(S)" + "\n";
            if (courriels == null) {
                //Rien faire
            }
            else {
                for (String g : courriels) {
                    x = x + g + "\n";
                }
            }
        }
        return x;
    }

    //------------------------------------
    //METHODE DE CLASSES PUBLIQUES
    //------------------------------------

    /**
     * Compte le nombre de contacts favori
     *
     * @return le nombre de contacts favori*/
    public static int obtenirNbrContactsFavoris(){
        return nbrContactsFavoris;
    }
}
