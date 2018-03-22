package game;

public class Weapon 
{
    private String name = "none";
    private int power = 0;

    public Weapon(){}

    public Weapon(String name, int power) 
    {
        this.name = name;
        this.power = power;
    }

    public String getName() 
    {
        return this.name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public int getPower() 
    {
        return this.power;
    }

    public void setPower(int power)
    {
        this.power = power;
    }

    public String toString()
    {
        return "\nARME: " + name + "\nPower : " + power;
    }
}