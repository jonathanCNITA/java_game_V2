package game;

public class Magician extends Personnage {
    private Sort sort = new Sort();

    public Magician() {
        
    }
    
    public Magician(String name) {
        this.setName(name);
    }
    
    public Magician(String name, String url, int life, int attack, Sort sort) {
        this.setName(name);
        this.setImg(url);
        this.setLife(life);
        this.setAttack(attack);
        this.setSort(sort);
    }

    public void setSort(Sort newSort) {
        this.sort = newSort;
    }

    public String getSort() {
        return this.sort.getName();
    }

    public String toString() {
        return "MAGICIAN: \n" + super.toString() + this.sort.toString();
    }
}