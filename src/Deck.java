import java.util.*;
public class Deck {

    /**
     * The "deck" takes the form of an array of cards. Where the first index is the top card
     */
    private Card[] myCards;
    /**
     * The number of cards left in the deck.
     * A deck starts with 52 cards and can contain other decks
     * A typical blackjack game is played with 6-8 decks
     */
    private int numOfCards;

    /**
     * Default constructor 1 un-shuffled deck
     */

    public Deck(){
        this(1,false);
    }

    /**
     * Deck constructor.
     * @param numDecks - Number of decks in this deck
     * @param shuffled - Whether or not the deck is shuffled
     */

    public Deck(int numDecks, boolean shuffled){
        //init card index
        int c = 0;
        this.numOfCards = numDecks * 52;
        this.myCards = new Card[this.numOfCards];

        // For each created deck
        for(int i = 0; i < numDecks; i++){
            //For each suit
            for (int j = 0; j < 4; j++){
                //for each card
                for(int k = 1; k <= 13; k++){
                    //Add a new card to the deck
                    this.myCards[c++] = new Card(Suit.values()[j], k);

                }
            }
        }

        if (shuffled) {

            this.shuffle();
        }

    }

    /**
     * Deck is shuffled by swapping random pairs of cards
     */
    public void shuffle(){

        int j;
        //random number generator
        Random rng = new Random();
        //temporary card
        Card tmp;

        for(int i = 0; i < this.numOfCards; i++){
            //generates value between 0 and numOfCards - 1
            j = rng.nextInt(this.numOfCards);

            //swap two indexes

            tmp = this.myCards[i];
            this.myCards[i] = this.myCards[j];
            this.myCards[j] = tmp;


        }


    }

    /**
     * Deal the next card in the deck
     * @return The next card in the deck
     */

    public Card dealTopCard(){
        //getting the top card off the deck
        Card top = this.myCards[0];

        //Shift each subsequent card to the previous slot in the deck
        for(int i = 1; i <this.numOfCards; i++){
            this.myCards[i - 1] = this.myCards[i];
        }
        this.myCards[this.numOfCards - 1] = null;

        //Decrement the total number of cards left in the deck
        this.numOfCards--;


        return top;
    }

    /**
     * Print the top cards in the deck
     * @param numOfCardsToPrint the number of cards to print from the deck
     */
    public void printDeck(int numOfCardsToPrint){
        for(int i = 0; i < numOfCardsToPrint; i++){
            System.out.printf("% 3d/%d %s\n", i + 1, this.numOfCards, this.myCards[i].toString());
        }
        System.out.printf("\t\t [%d other]\n", this.numOfCards - numOfCardsToPrint);
    }



}
