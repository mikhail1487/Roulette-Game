/**
 * class Purse holds the coins. When a purse is constructed, it is empty.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

// comment this line (what's this import for)
import java.util.Scanner;
// comment this line (what's this import for?)
import java.util.ArrayList;

public class Purse
{
    // private instance variables (other classes cannot see these)
        private int numOfCoins;
        private int totalValue;
        // Here's something new!
        // Remember lists in Snap? Java ArrayLists work similarly. The next
        // line declares an ArrayList of Coins called coinsInPurse.
        // For now it is just a declaration. There are not yet any coins in the arrayList.
        private ArrayList<Coin> coinsInPurse;

    /**
     * Constructor for objects of class Purse. Constructs an empty purse.
     */
    public Purse()
    {
        numOfCoins = 0;  // there are no coins, thus
        totalValue = 0;  // there's no value in this purse.
        coinsInPurse = new ArrayList<Coin>();   // the ArrayList is empty
    }


    /**
     * method setUpStartingPurse sets up a beginning purse based on the number of coins that the user
     * decides to start with. The user only decides the number of coins. The coins are randomly
     * generated (penny, nickel, dime, or quarter).
     */
    public void setUpStartingPurse()
    {
       // declare variable of type Coin
       Coin coinToPutInPurse;
       // declare and initialize coinValue to 0
       int coinValue = 0;

       // Here also is something new. An array is like an arrayList, but arrays can't grow and shrink
       // Declare and initialize an array of Strings called coinNames
       String []coinNames = {"penny", "nickel", "dime", "quarter"};

       // Instantiate a Scanner object (instance) called sc
       Scanner sc = new Scanner(System.in);

       // Get user input regarding number of coins that the purse should start with
       System.out.print("Enter number of coins to start with (pick a number less than 6)");
       int startingNumOfCoinsInPurse = sc.nextInt();

       for (int i = 1; i <= startingNumOfCoinsInPurse; i++)
       {
           // randomly choose one coin name from the array called coinNames
           String coinName = coinNames[(int)(Math.floor(Math.random() * 4))];

           // We had an introduction to switch once before. Here is "switch" in action. It's a
           // cool tool, but you don't need to know how to use it for the AP Exam
           switch (coinName)
            {
                case "penny": coinValue = 1;  break;
                case "nickel": coinValue = 5;  break;
                case "dime": coinValue = 10;  break;
                case "quarter": coinValue = 25; break;
            }

           // Here we are creating a new random coin each time we go through the loop
           coinToPutInPurse = new Coin(coinValue, coinName);
           // Here we call the method addCoin() in order to add this newly created
           // coin to the ArrayList called coinsInPurse (see method addCoin below!)
           addCoin(coinToPutInPurse);

       }


    }

    /**
     * method addCoin() adds a coin to the purse. Each coin has two states: its name and its value.
     * When a coin is added to the purse, we need to update instance variables
     * including the number of coins, and the total value of the coins contained in the
     * purse.
     *
     * @param  aCoin   coin to add to purse
     */
    public void addCoin (Coin someSortOfCoin)
    {
       coinsInPurse.add(someSortOfCoin);
       numOfCoins += 1;
       totalValue += someSortOfCoin.getCoinValue();


    }

    /**
     * method removeCoin() removes a coin from the purse. This removal happens each time a
     * bet is placed. The player has no control over which coin gets removed (bet).
     * The coin is randomly pulled (removed) from the purse.
     *
     * @return Coin  the coin that was removed
     */
    public Coin removeCoin()
    {
       // Our purse coins are stored in an ArrayList called coinsInPurse.
       // The ArrayList method called remove() removes the element at the specified
       // index
       Coin removedCoin = coinsInPurse.remove((int)Math.random() * coinsInPurse.size());
       // decrement the number of coins in the purse by 1
       numOfCoins--;
       // decrease the totalValue of the coins in the purse by the value of the coin
       totalValue -= removedCoin.getCoinValue();
       // Let the user know what's going on in the game
       System.out.println("Placing a bet!");

       return removedCoin;
    }

    /**
     * method getTotal() returns the total value of coins in the purse.
     *
     * @return int    total value in purse (in cents)
     */
    public int getTotal()
    {
       return totalValue;
    }

    /**
     * method coinCount returns the number of coins in the purse
     *
     * @return int   the number of coins in the purse
     */
    public int getCoinCount()
    {
      return numOfCoins;
    }
    
    /**
     * method coinCount returns the number of coins in the purse
     *
     * @return int   the number of coins in the purse
     */
    public String getNumOfCoins()
    {
      String returnString = "";
      for(Coin a : coinsInPurse)
      {
          returnString = returnString + a.getCoinName() + " "; 
      }
      return returnString;
    }
    
    /**
     * method getFirstCoin returns the first coin in the purse
     *
     * @return Coin   the first coin in the purse
     */
    public Coin getFirstCoin()
    {
      return coinsInPurse.get(0);
    }
    
    /**
     * Returns a nicely formatted description of the coins in the purse
     *
     * @return String   list of the coins in the purse
     */
    public String toString()
    {
        return "Your purse currently has " + getCoinCount() + " coins" + "\n" + "Its contents: "
        + getNumOfCoins() + "\n" + "Its current value: " + getTotal();
    }

} //end class