/**
 * The Game class simulates the roulette game.
 *
 * @author (your name)
 * @version (a version number or a date)
 */



public class Game
{
    // instance variables
    private Spinner gameWheel;
    private Purse perrysPrettyPinkPurse;


    /**
     * Constructor for objects of class Game. Creates the roulette wheel by constructing the
     * appropriate Spinner. Creates an empty purse.
     */
    public Game()
    {
        gameWheel = new Spinner(4);
        perrysPrettyPinkPurse = new Purse();
    }


    /**
     * method spinTheWheel simulates a spin returning a 0, 2, or 3 as defined by the roulette wheel pictured
     * in the problem. Since half of the circle is 0, spins of both 0 and 1 will return a 0.
     * There's a 50% chance of spinning a 0, 25% chance of spinning a 2, and a 25% chance
     * of spinning a 3.
     * @return  int     result of spinning wheel spin
     */
    public int spinTheWheel()
    {
        int bruh = (int)Math.floor(Math.random() * 4);
        if(bruh == 0 || bruh == 1)
        {
            bruh = 0; 
        }
        return bruh;
    }

    /**
     * method playRoulette simulates the game of roulette as follows:
     * First, setUpStartingPurse() is called in order to put some number of coins in the purse.
     * HINT: Next, you may need to declare or declare and initialize some variables.
     * The game loops until the
     * player doubles the starting value of the money in the purse OR the player has no coins left in his or her purse.
     * 1) bet (remove a coin from the purse)
     * 2) spin the roulette wheel
     * 3) based on the result of the spin
     *         a) spin results in 0 -- don't add any coins to the purse
     *         b) spin results in 2 -- add two new of the same coin that was bet to the purse
     *         c) spin results in 3 -- add three new of the same coin that was bet to the purse
     * The method returns the total value in the purse once the purse is empty OR the purse value has doubled.
     *
     * @return int   the total value in Purse
     */
    public int playRoulette()
    {
       // Stuff a purse with x coins to start the game with. The number of coins is controlled by the game
       // player and the type of coins (penny, nickel, dime, quarter) is random.
       perrysPrettyPinkPurse.setUpStartingPurse();
       // Display a description of the purse contents to the player
       perrysPrettyPinkPurse.toString();
       // use a variable to store starting money
       int startingMoney = perrysPrettyPinkPurse.getTotal();

       // The game goes on as long as there are coins left in the purse and the game player has not doubled
       // his or her money
       // YOUR CODE HERE   --- GOOD LUCK AND PERSEVERE :)
       int num = 0;
       int winnings = startingMoney;
       int goalMoney = startingMoney * 2;
       System.out.println(perrysPrettyPinkPurse.toString());
       while(winnings != 0 || winnings < goalMoney)
       {
           if(winnings == 0 || winnings >= goalMoney)
           {
               break;
           }
           Coin wagerCoin = perrysPrettyPinkPurse.getFirstCoin();
           num = spinTheWheel();
           if(num == 0)
           {
               perrysPrettyPinkPurse.removeCoin();
               System.out.println("Spin was a 0. Unfortunate. You lost that bet");
               System.out.println(perrysPrettyPinkPurse.toString());
           }
           if(num == 2)
           {
               perrysPrettyPinkPurse.addCoin(wagerCoin);
               System.out.println("Spin was a 2. Woohoo!");
               System.out.println(perrysPrettyPinkPurse.toString());
           }
           if(num == 3)
           {
               perrysPrettyPinkPurse.addCoin(wagerCoin);
               perrysPrettyPinkPurse.addCoin(wagerCoin);
               System.out.println("Spin was a 3. Epic gambling moment!"); 
               System.out.println(perrysPrettyPinkPurse.toString());
           }
           winnings = perrysPrettyPinkPurse.getTotal();
       }
       return winnings; 
    }
    
} // end class