/**
 * The Coin class.  Each coin (object) has a name and a value.
 * Example object values: penny, 1; nickel, 5; dime, 10; quarter, 25
 * Possible object behaviors: getCoinValue(), getCoinName()
 * Notice that the instance variables are private, but that the instance methods
 * (getCoinValue() and getCoinName()) are public.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Coin
{
    // instance variables - replace the example below with your own
    private int value;  // monetary value of the coin un cents
    private String name;   // name of the coin
    

    /**
     * Constructor for objects of class Coin
     * @param aValue   the monetary value of the coin
     * @param aName   the name of the coin
     */
    public Coin(int aValue, String aName)
    {
        value = aValue;
        name = aName;
    }

    /**
     * Returns the coin value
     * @return int    coin value
     */
    public int getCoinValue()
    {
        return value; 
    }

    /**
     * Returns the coin name
     * @return String    coin name
     */
    public String getCoinName()
    {
        return name; 
    }
    
} // end class