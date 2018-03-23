/**
 * Personnage est une classe 'abstract' elle defifinit les attributs commun 
 * des personnages du jeu :
 * <ul>
 * <li>name: nom du personnage</li>
 * <li>img: lien vers l'image du personnage</li>
 * <li>life: nombre de points de vie du personnage</li>
 * <li>attack: Puissance d'attaque du personnage</li>
 * </ul>
 * 
 * </p>
 * 
 * </p>
 * @author jonathanCNITA
 * @version 1
 */

package game;

public abstract class Personnage 
{
    protected String name = "Unamed";
    protected String img = "No image ref";
    protected int life = 100;
    protected int attack = 10;
    
    /** 
     * method 'setter' qui modifie le nom du personnage 
     * @param userName prend en parametre un nom pour le personnage.
     */
    public void setName(String userName) 
    {
        this.name = userName;
    }

    /** 
     * method 'getter' qui retourne le nom du personnage 
     * @return retourne le nom du personnage
     */
    public String getName() {
        return this.name;
    }

    /** 
     * method 'setter' qui modifie le fichier image 
     * @param imageLink prend en parametre une URL 
     * pour l'image qui illustre le personnage.
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

    /** 
     * method 'toString' qui retourne les valeurs des attributs. 
     */
    public String toString() 
    {
        return "Name : " + this.name + "\n" +
        "Image : " + this.img + "\n" +
        "Life : " + this.life + "\n" +
        "Attack : " + this.attack + "\n";
    }
}