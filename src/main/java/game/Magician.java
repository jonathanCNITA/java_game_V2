/**
 * Magician est une classe qui hérite de Personnage elle defifinit les attributs 
 * spécifique du magician ici son sorts (Sort)
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


public class Magician extends Personnage {
    private Sort[] sort = new Sort[3];
    private int sortSelectedIndex = 0;

    /**
     * CONSTRUCTEURS
     */
    public Magician() {
        
    }
    
    public Magician(String name, Sort sort) {
        this.setName(name);
        this.setSort(sort, 0);
    }

    public Magician(String name, String url, int life, int attack) {
        this.setName(name);
        this.setImg(url);
        this.setLife(life);
        this.setAttack(attack);
    }
    
    public Magician(String name, String url, int life, int attack, Sort sort) {
        this.setName(name);
        this.setImg(url);
        this.setLife(life);
        this.setAttack(attack);
        this.setSort(sort, 0);
    }

    /**
     * setter pour sort.
     * @param newWeapon
     *  prend en parametre un objet de type Weapon.
     *  Puis l'assigne au warrior en question.
     */
    public void setSort(Sort newSort, int index) 
    {
        if(index > this.sort.length - 1 || index < 0) 
        {
            System.out.println("Index is not available!");
        } 
        else 
        {
            this.sort[index] = newSort;
        }
    }


    public Sort[] getSort() {
        return this.sort;
    }


    public int getSortSelectedIndex() {
        return sortSelectedIndex;
    }


    public void setSortSelectedIndex(int index) {
        if(index > this.sort.length - 1 || index < 0) 
        {
            System.out.println("Index is not available!");
        }
        else
        {
            this.sortSelectedIndex = index;
        }
    }

    public Sort getSelectedSort()
    {
        return sort[sortSelectedIndex];
    }

    public void setSortIndex(int index)
    {
        this.sortSelectedIndex = index;
    }

    public String toString() 
    {
        return "MAGICIAN: \n" + super.toString() + "\nSort selectionee:\n" + this.sort[sortSelectedIndex] + "\nSort Liste: \n" + Arrays.toString(sort);
    }
}