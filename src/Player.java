/**
 * The human playing Blackjack
 */

public class Player {

    /**
     * Player name
     */
    private String name;
    /**
     * The player's hand
     */
    private Card[] hand = new Card[10];

    /**
     * The number of cards in the player's current hand
     */
    private int numCards;

    /**
     * Player constructor
     */

    public Player(String aName){
        this.name = aName;
        this.emptyHand();
    }

    /**
     * Empty the player's hand of cards
     */

    public void emptyHand(){
        for(int i = 0; i < 10; i++){
            this.hand[i] = null;
        }
        this.numCards = 0;
    }

    /**
     * Add a card to the player's hand
     * @param aCard: The card to be added
     * @return whether or not the sum of the current hand <= 21
     */
    public boolean dealACard(Card aCard){
        //print error if hand > 10
        if(this.numCards == 10){
            System.err.printf("%s's hand has 10 cards;" + "cannot add another card\n", this.name);
            System.exit(1);
        }

        //add new card in next slot and increment the card counter
        this.hand[this.numCards] = aCard;
        this.numCards++;

        return this.getHandSum() <= 21;
    }

    public int getHandSum(){
        int handSum = 0;
        int cardNum;
        int numAces = 0;

        //Calculate the sum of the hand by card
        for(int i = 0; i < this.numCards; i++){
            cardNum = this.hand[i].getNumber();
            //If the hand includes an Ace
            if(cardNum == 1){
                numAces++;
                handSum += 11;
                //If the hand includes a face card
            } else if(cardNum > 10){
                handSum += 10;
                //If the hand includes any standard card
            } else{
                handSum += cardNum;
            }

            // If we have aces and sum > 21, set as many aces as necessary to 1

            while(handSum > 21 && numAces > 0){
                handSum -= 10;
                numAces--;
            }
        }

        return handSum;
    }

    /**
     * Print the cards in the player's hand
     * @param printNextCard whether the first card is hidden or not
     */
    public void printHand(boolean printNextCard){
        System.out.printf("%s's cards:\n", this.name);
        for(int i = 0; i < this.numCards; i++){
            if(i == 0 && !printNextCard) {
                System.out.print("  [HIDDEN]\n");
            }
            else{
                System.out.printf("  %s\n", this.hand[i].toString());
                }

        }
    }


}
