package game;

public abstract class Personnage 
{
    protected String name = "Unamed";
    protected String img = "No image ref";
    protected int life = 100;
    protected int attack = 10;
    
    /** 
     * method 'setter' qui modifie le nom du personnage 
     */
    public void setName(String userName) 
    {
        this.name = userName;
    }

    /** 
     * method 'getter' qui retourne le nom du personnage 
     */
    public String getName() {
        return this.name;
    }

    /** 
     * method 'setter' qui modifie le fichier image 
     */
    public void setImg(String imageLink) 
    {
        this.img = imageLink;
    }

    public String getImage() 
    {
        return this.img;
    }
    
    public void setLife(int newLife) 
    {
        this.life = newLife;
    }

    public int getLife() {
        return this.life;
    }

    public void setAttack(int newAttack) 
    {
        this.attack = newAttack;
    }

    public int getAttack() 
    {
        return this.attack;
    }

    public String toString() 
    {
        return "Name : " + this.name + "\n" +
        "Image : " + this.img + "\n" +
        "Life : " + this.life + "\n" +
        "Attack : " + this.attack + "\n";
    }
}