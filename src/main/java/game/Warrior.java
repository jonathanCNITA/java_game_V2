package game;
import java.util.ArrayList;

public class Warrior extends Personnage {
    private Weapon arme = new Weapon();

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

    public void setArme(Weapon newWeapon) {
        this.arme = newWeapon;
    }

    public String getArme() {
        return this.arme.getName();
    }

    public String toString() {
        return "WARRIOR: \n" + super.toString() + "Arme selectionné: \n" + this.arme.toString();
    }
}