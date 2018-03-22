package game;
import java.util.ArrayList;

public class Warrior extends Personnage {
    private Weapon arme = new Weapon();
    private ArrayList<Weapon> armeList = new ArrayList<Weapon>();

    public Warrior() {
    
    }

    public Warrior(String name) {
        this.setName(name);
    }

    public Warrior(String name, String url, int life, int attack, Weapon arme) {
        this.setName(name);
        this.setImg(url);
        this.setLife(life);
        this.setAttack(attack);
        this.setArmes(arme);
        armeList.add(this.arme);
    }

    public void setArmes(Weapon newWeapon) {
        this.arme = newWeapon;
    }

    public String getArmes() {
        return this.arme.getName();
    }

    public ArrayList<Weapon> getArmeList(){
        return armeList;
    }

    public void addWeapon(Weapon newWeapon) {
        armeList.add(newWeapon);
    }

    public String toString() {
        return "WARRIOR: \n" + super.toString() + "Arme selectionné: \n" + this.arme.toString() + "Liste des armes:\n" + this.armeList.toString();
    }
}