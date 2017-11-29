import java.util.*;
public class NewGame {
    public static void main(String[] args){

        Scanner scanIt = new Scanner(System.in);
        Deck aDeck = new Deck(1, true);

        //initialize players
        Player you = new Player("Player");
        Player dealer = new Player("Dealer");

        //Deal cards
        you.dealACard(aDeck.dealTopCard());
        dealer.dealACard(aDeck.dealTopCard());
        you.dealACard(aDeck.dealTopCard());
        dealer.dealACard(aDeck.dealTopCard());

        //print starting hands
        System.out.println("Cards are dealt");
        you.printHand(true);
        dealer.printHand(false);
        System.out.print("\n");

        //flags used to confirm if player has hit/stayed

        boolean playerTurnOver = false;
        boolean dealerTurnOver = false;
        String reply;

        while(!playerTurnOver || !dealerTurnOver){
            //player's turn
            if(!playerTurnOver){
                System.out.print("Do you Hit? or Stay?");
                reply = scanIt.nextLine();
                System.out.println();

                if(reply.compareToIgnoreCase("Hit") == 0){
                    //add next card int he deck and find if the player has busted
                    playerTurnOver = !you.dealACard(aDeck.dealTopCard());
                    //dealer.printHand(false);
                    you.printHand(true);

                } else if(reply.compareToIgnoreCase("Stay") == 0){
                    playerTurnOver = true;
                } else {
                    System.out.println("I said, HIT or STAY, wiseguy.");
                    dealerTurnOver = true;
                }
            }

            if(!dealerTurnOver){
                if(dealer.getHandSum() < 17){
                    System.out.println("The dealer hits.");
                    dealerTurnOver = !dealer.dealACard(aDeck.dealTopCard());
                    dealer.printHand(false);
                } else{
                    System.out.println("The dealer stays.");
                    dealerTurnOver = true;
                }
            }
            System.out.println();

        }

        //close scanner
        scanIt.close();

        //print final hands
        you.printHand(true);
        dealer.printHand(true);

        int playerSum = you.getHandSum();
        int dealerSum = dealer.getHandSum();

        if(playerSum > dealerSum && playerSum <= 21 || dealerSum > 21){
            System.out.println("You win. Now get outta here before I gotta call the pit boss");
        } else {
            System.out.println("Heh. The house always wins, baby");
        }

    }
}
