package game;

import java.util.Scanner;
import java.util.ArrayList;

public class Game {

    private static Scanner scannerInputInt = new Scanner(System.in);
    private static Scanner scannerInputStr = new Scanner(System.in);
    private static ArrayList<Personnage> players = new ArrayList<Personnage>();
    private static ArrayList<Weapon> armes = new ArrayList<Weapon>();
    private static ArrayList<Sort> sorts = new ArrayList<Sort>();
    private static Boolean playGame = true;
    private static int userChoice;

    public static void main(String[] args) 
    {
        System.out.println("Start the game");
        generateArmes();
        generateSort();
        generatePerso();
        
        while (playGame) 
        {
            userChoice = (selectOption());
            if (userChoice == 0) 
            {
                System.out.println("A bientot");
                playGame = false;
            }
            else if (userChoice == 1)
            {
                creerUnPersonnage();
            } 
            else if (userChoice == 2) 
            {
                listerLesElements(players);
            } 
            else if (userChoice == 3) 
            {
                editerUnPersonnage();
            } 
            else if (userChoice == 4) 
            {
                creerUneArme();
            }
            else if (userChoice == 5) 
            {
                creerUnSort();
            }
            else if (userChoice == 6) 
            {
                listerLesElements(armes);
            }
            else if (userChoice == 7) 
            {
                listerLesElements(sorts);
            }
        }
    }

    //-- Functions --\\

    //-- Show menus --\\
    private static int selectOption() {
        System.out.println("Choisissez une options:\n0 - Quitter le jeu\n1 - Creer un personnage\n2 - Lister les personnages\n3 - Editer un personnage\n4 - Creer une arme\n5 - Creer un Sort\n6 - Lister les armes\n7 - lister les sorts");
        return scannerInputInt.nextInt();
    }

    private static int selectAttr() {
        System.out.println("\n0 - quitter\n1 - Nom\n2 - Image\n3 - Vie\n4 - Attaque\n5 - changer arme / sort");
        return scannerInputInt.nextInt();
    }

    //-- Functions --\\
    private static void creerUnPersonnage()
    {
        int life, attack, type = 0;
        String nom, img;
        System.out.println("Créer un personnage:\n1 Guerrier\n2 Magicien");
        type = scannerInputInt.nextInt();
        System.out.println("Choisissez un nom:");
        nom = scannerInputStr.nextLine();
        System.out.println("Choisissez une image:");
        img = scannerInputStr.nextLine();
        System.out.println("Choisissez vos points de vie:");
        life = scannerInputInt.nextInt();
        System.out.println("Choisissez votre force d'attaque:");
        attack = scannerInputInt.nextInt();
        if (type == 1) 
        {
            players.add(new Warrior(nom, img, life, attack));
        }
        else if (type == 2) 
        {
            players.add(new Magician(nom, img, life, attack));
        }
    }


    private static void listerLesElements(ArrayList listOfObject) 
    {
        System.out.println("//////////////////////");
        System.out.println("Nb items: " + listOfObject.size());
        for(int i = 0; i < listOfObject.size(); i++) 
        {
            System.out.println("Numero ref: " + i);
            System.out.println(listOfObject.get(i));
            System.out.println("-------------------------");
        }
        System.out.println("//////////////////////");
    }


    private static void editerUnPersonnage() 
    {
        int id, attr;
        Boolean editMode = true;
        
        System.out.println("Donnez l'index du personnage à modifier:");
        id = scannerInputInt.nextInt();
        do {
            System.out.println("Quel element voulez vou modifier");
            attr = selectAttr();
            System.out.print(" Nouvelle valeur: ");
            if (attr == 1) 
            {
                players.get(id).setName(scannerInputStr.nextLine());
            } 
            else if (attr == 2) 
            {
                players.get(id).setImg(scannerInputStr.nextLine());
            } 
            else if (attr == 3) 
            {
                players.get(id).setLife(scannerInputInt.nextInt());
            } 
            else if (attr == 4) 
            {
                players.get(id).setAttack(scannerInputInt.nextInt());
            } 
            else if (attr == 5) 
            {
                donnerArmeSort(id); 
            } 
            else 
            {
                editMode = false;
            }
        } while (editMode);
    }

    /** 
     * Permet d'affecter une arme ou sort à un personnage  
     * @param ex 
     *      Il prend en parametre l'index du personnage 
     *      En fonction de son type(Warrior/Magician)
     *      On affiche la liste des éléments disponible.
     *      On demande à l'utilisateur de donner l'index
     *      de l'arme ou sort à affecter.
     */ 
    private static void donnerArmeSort(int id) 
    {
        if (players.get(id) instanceof Warrior)
        {   
            listerLesElements(armes);
            int idArme = scannerInputInt.nextInt();
            ((Warrior)players.get(id)).setArme(armes.get(0));
        } 
        else if (players.get(id) instanceof Magician)
        {
            listerLesElements(sorts);
            int idSort = scannerInputInt.nextInt();
            ((Magician)players.get(id)).setSort(sorts.get(idSort));
        }
    }


    private static void creerUneArme() 
    {
        String name;
        int power;
        System.out.println("Quel arme voulez vous creer:");
        name = scannerInputStr.nextLine();
        System.out.println("Quel la puissance de " + name);
        power = scannerInputInt.nextInt();
        armes.add(new Weapon(name, power));
    }


    private static void creerUnSort() 
    {
        String name;
        int power;
        System.out.println("Quel sort voulez vous creer:");
        name = scannerInputStr.nextLine();
        System.out.println("Quel la puissance de " + name);
        power = scannerInputInt.nextInt();
        sorts.add(new Sort(name, power));
    }


    private static void generateArmes() 
    {
        armes.add(new Weapon("couteau", 5));
        armes.add(new Weapon("épée", 10));
        armes.add(new Weapon("pistolet", 18));
    }


    private static void generateSort() 
    {
        sorts.add(new Sort("InstantDeath", 5));
        sorts.add(new Sort("ParalizeAuto", 10));
        sorts.add(new Sort("Eclair de feu", 18));
    }

    private static void generatePerso() 
    {
        players.add(new Warrior("WarMan"));
        players.add(new Magician("MagicMan"));
    }
}