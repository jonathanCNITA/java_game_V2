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
            else if (userChoice == 8) 
            {
                supprimerUnElement(players);
            }
        }
    }

    //-- Functions --\\

    /**
     * Menu principal qui présentes les options de bases
     */
    private static int selectOption() {
        System.out.println("Choisissez une options:\n0 - Quitter le jeu\n1 - Creer un personnage\n2 - Lister les personnages\n3 - Editer un personnage\n4 - Creer une arme\n5 - Creer un Sort\n6 - Lister les armes\n7 - lister les sorts\n8 - Supprimer un personnage");
        return scannerInputInt.nextInt();
    }

    /**
     * Menu secondaire de la section éditer un personnage
     * il liste les différents attribut modifiables
     * @return puis retourne le choix utilisateur sous forme d'un entier.
     */
    private static int selectAttr() {
        System.out.println("\n0 - quitter\n1 - Nom\n2 - Image\n3 - Vie\n4 - Attaque\n5 - changer arme / sort\n6 - ajouter arme / sort");
        return scannerInputInt.nextInt();
    }

    /**
     * Fonction qui permet de créer un personnage (!sans arme)
     * Les informations demandé sont: type, nom, img, life, attack
     * En fonction du type choisi le personnage est crée et ajouté 
     * à la liste de players.
     */
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
            players.add(new Warrior(nom, img, life, attack, armes.get(0)));
        }
        else if (type == 2)
        {
            players.add(new Magician(nom, img, life, attack, sorts.get(0)));
        }
    }

    /**
     * Fonction qui affiche les éléments d'une liste.(players, armes sorts...)
     * @param listOfObject 
     *  la fonction prend en parametre une liste de type ArrayList.
     *  Elle affiche le la taille de la liste.
     *  Puis affiche la fonction toString precedé de l'index.
     *  
     */
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
                changerArmeSort(id);
            } 
            else if (attr == 6) 
            {
                ajouterArmeSort(id);
            } 
            else 
            {
                editMode = false;
            }
        } while (editMode);
    }

    private static void supprimerUnElement(ArrayList list) 
    {
        int id;

        System.out.println("Donnez l'index à supprimer:");
        id = scannerInputInt.nextInt();
        list.remove(id);
    }


    private static void ajouterArmeSort(int id) 
    {
        if (players.get(id) instanceof Warrior)
        {   
            listerLesElements(armes);
            System.out.println("choisissez une id d'arme");
            int idArme = scannerInputInt.nextInt();
            System.out.println("choisissez ou stocker l'arme (0 1 2)");
            int indexCollection = scannerInputInt.nextInt();
            ((Warrior)players.get(id)).setArme(armes.get(idArme), indexCollection);
        } 
        else if (players.get(id) instanceof Magician)
        {
            listerLesElements(sorts);
            System.out.println("choisissez une id d'arme");
            int idSort = scannerInputInt.nextInt();
            System.out.println("choisissez ou stocker l'arme (0 1 2)");
            int indexCollection = scannerInputInt.nextInt();
            ((Magician)players.get(id)).setSort(sorts.get(idSort), indexCollection);
        }
    }

    private static void changerArmeSort(int id) 
    {
        if (players.get(id) instanceof Warrior)
        {   
            System.out.println(((Warrior)players.get(id)));
            System.out.println("choisissez nouvelle arme (0 1 2)");
            int indexCollection = scannerInputInt.nextInt();
            ((Warrior)players.get(id)).setWeaponIndex(indexCollection);
        }
        else if (players.get(id) instanceof Magician)
        {
            System.out.println(((Magician)players.get(id)));
            System.out.println("choisissez nouveau sort (0 1 2)");
            int indexCollection = scannerInputInt.nextInt();
            ((Magician)players.get(id)).setSortIndex(indexCollection);
        }
    }


    /** 
     * Permet d'affecter une arme ou sort à un personnage
     * @param id 
     *      Il prend en parametre l'index du personnage
     *      En fonction de son type(Warrior/Magician)
     *      On affiche la liste des éléments disponible.
     *      On demande à l'utilisateur de donner l'index
     *      de l'arme ou sort à affecter.
     */ 

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
        players.add(new Warrior("WarMan", armes.get(0)));
        players.add(new Magician("MagicMan", sorts.get(0)));
    }
}