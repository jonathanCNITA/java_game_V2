/**
 * Warrior est une classe qui hérite de Personnage elle defifinit les attributs 
 * spécifique du Guerrier ici son arme (Weapon)
 * <ul>
 * <li>arme: Arme du personnage de type Weapon</li>
 * </ul>
 * 
 * </p>
 * ??????
 * </p>
 * @author jonathanCNITA
 * @version 1
 */

package game;

import java.util.Arrays;


public class Warrior extends Personnage {
    private Weapon[] arme = new Weapon[3];
    private int weaponSelectedIndex = 0;

    /**
     * CONSTRUCTEURS
     */
    public Warrior() {
    
    }

    public Warrior(String name, Weapon arme) {
        this.setName(name);
        this.setArme(arme, 0);
    }

    public Warrior(String name, String url, int life, int attack) {
        this.setName(name);
        this.setImg(url);
        this.setLife(life);
        this.setAttack(attack);
    }

    public Warrior(String name, String url, int life, int attack, Weapon arme) {
        this.setName(name);
        this.setImg(url);
        this.setLife(life);
        this.setAttack(attack);
        this.setArme(arme, 0);
    }

    /**
     * setter pour arme.
     * @param newWeapon
     *  prend en parametre un objet de type Weapon.
     *  Puis l'assigne au warrior en question.
     */
    public void setArme(Weapon newWeapon, int index) {
        if(index > this.arme.length - 1) 
        {
            System.out.println("Index is not available!");
        } 
        else 
        {
            this.arme[index] = newWeapon;
        }
        
    }

    /**
     * getter pour arme.
     * 
     * @return 
     * retourne le nom de l'arme du Warrior
     */
    public Weapon[] getArme() {
        return this.arme;
    }

    public int getWeaponSelectedIndex() {
        return weaponSelectedIndex;
    }

    public void setWeaponSelectedIndex(int index) {
        if(index > this.arme.length - 1 || index < 0) 
        {
            System.out.println("Index is not available!");
        }
        else
        {
            this.weaponSelectedIndex = index;
        }
    }

    public Weapon getSelectedWeapon()
    {
        return arme[weaponSelectedIndex];
    }

    public void setWeaponIndex(int index)
    {
        this.weaponSelectedIndex = index;
    }

    /**
     * Methode toString qui appel la methode toString de personnage 
     * et ajoute l'arme utilisé par ce dernier.
     */
    public String toString() {
        return "WARRIOR: \n" + super.toString() + "Arme selectionee:\n" + this.arme[weaponSelectedIndex] + "\nArme Liste: \n" + Arrays.toString(arme);
    }
}