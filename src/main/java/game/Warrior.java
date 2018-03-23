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
import java.util.ArrayList;

public class Warrior extends Personnage {
    private Weapon arme = new Weapon();

    /**
     * CONSTRUCTEURS
     */
    public Warrior() {
    
    }

    public Warrior(String name) {
        this.setName(name);
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
        this.setArme(arme);
    }

    /**
     * setter pour arme.
     * @param newWeapon
     *  prend en parametre un objet de type Weapon.
     *  Puis l'assigne au warrior en question.
     */
    public void setArme(Weapon newWeapon) {
        this.arme = newWeapon;
    }

    /**
     * getter pour arme.
     * 
     * @return 
     * retourne le nom de l'arme du Warrior
     */
    public String getArme() {
        return this.arme.getName();
    }

    /**
     * Methode toString qui appel la methode toString de personnage 
     * et ajoute l'arme utilisé par ce dernier.
     */
    public String toString() {
        return "WARRIOR: \n" + super.toString() + "Arme selectionné: \n" + this.arme.toString();
    }
}