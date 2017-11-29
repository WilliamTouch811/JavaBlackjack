/**
 * A card found within the deck
 */
public class Card {

    /**
     * Can be Spades, Hearts, Diamonds, Clubs
     */
    private Suit cardSuit;
    /**
     * 2-10 Aces = 1 Jack-King = 11-13
     */
    private int cardNumber;

    /**
     * Card constructor
     * @param aSuit
     * @param aNumber
     */

    public Card(Suit aSuit, int aNumber){
            this.cardSuit = aSuit;
            if(aNumber >= 1 && aNumber <= 13){
                this.cardNumber = aNumber;
            }
            else{
                System.err.println("Q&A Testing fuck off pls");
                System.exit(1);
            }

    }


    /**
     * Getter method for the card's number
     * @return cardNumber
     */
    public int getNumber(){
        return cardNumber;
    }

    /**
     * Getter method for the card's suit
     * @return cardSuit
     */

    public Suit getSuit(){
        return cardSuit;
    }

    public String toString(){
        String numStr = "_BLANK_";
        switch(this.cardNumber){
            case 1:
                numStr = "Ace";
                break;

            case 2:
                numStr = "Two";
                break;

            case 3:
                numStr = "Three";
                break;

            case 4:
                numStr = "Four";
                break;

            case 5:
                numStr = "Five";
                break;

            case 6:
                numStr = "Six";
                break;

            case 7:
                numStr = "Seven";
                break;

            case 8:
                numStr = "Eight";
                break;

            case 9:
                numStr = "Nine";
                break;

            case 10:
                numStr = "Ten";
                break;

            case 11:
                numStr = "Jack";
                break;

            case 12:
                numStr = "Queen";
                break;

            case 13:
                numStr = "King";
                break;
        }
        return numStr + " of " + cardSuit.toString();

    }


}
