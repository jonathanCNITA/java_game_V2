package game;

public class Sort 
{
    private String name = "sort";
    private int power = 5;

    public Sort(){}

    public Sort(String name, int power) 
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
        return "\nSORT: " + name + "\nPower : " + power;
    }
}