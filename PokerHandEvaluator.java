import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Scanner;

public class PokerHandEvaluator {
    private static Set<Card> cardsInHand;
    private static List<Card> deckOfCards;

    public static void main (String... args) {
        System.out.println("Choose 5 unique cards for your hand. Press enter after every choice!"); // Prompt the user to input cards of choice from a deck list
        deckOfCards = loadDeckOfCards(); // Load all the cards
        for (int x=0; x<deckOfCards.size(); x++) {
            System.out.println("Select " + x + ". " + deckOfCards.get(x).getSuit() + " of " + deckOfCards.get(x).getKind()); // Display the cards to the user
        }
        System.out.println();

        // Scan input from the user
        int selectedIndexes[] = new int[5];
        Scanner scanner = new Scanner(System.in);
        for (int y=0; y<selectedIndexes.length; y++) {
            selectedIndexes[y] = Integer.parseInt(scanner.nextLine());
        }

        evaluateHandRank(selectedIndexes, deckOfCards); //Analyze the choosen hand cards
        cardsInHand = new HashSet<>(deckOfCards);
    }

    static void evaluateHandRank(int selectedIndexes[], List<Card> deckOfCards){
        /* Evaluate the 10 hand-ranking categories
        checkIfHighCards();
        checkIfOnePair(selectedIndexes, deckOfCards);
        checkIfTwoPairs();
        checkIfThreeOfAKind();
        checkIfStraight();
        checkIfFlush();
        checkIfFullHouse();
        checkIfFourOfAKind();
        checkIfStraightFlush();
        checkIfRoyalFlush();
        */
    }

    static boolean checkIfOnePair(int selectedIndexes[], List<Card> deckOfCards){
        int duplicatesCount = countDuplicateCards(selectedIndexes, deckOfCards);
        return duplicatesCount == 1 ? true : false; //Return true if there is one instance of a duplicate
    }

    static int countDuplicateCards(int selectedIndexes[], List<Card> deckOfCards) {
        return 0; //Dummy return value
    }

    // Loading cards to the deck. In this case, with all kinds and suits
    static List<Card> loadDeckOfCards(){
        List<Card> deckOfCards = new ArrayList<>();
        String kinds[] = {"A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3", "2"};
        String suits[] = {"Spades", "Hearts", "Diamonds", "Clubs"};
        for (int i=0; i<kinds.length; i++) {
            for (int j=0; j<suits.length; j++) {
                deckOfCards.add(new Card(kinds[i], suits[j]));
            }
        }
        return deckOfCards;
    }
}

class Card {
    // Encapsulating instance variables
    private String suit;
    private String kind;

    //Constructor to enable building of Card instances
    Card (String suit, String kind) {
        this.suit = suit;
        this.kind = kind;
    }

    // Public getter methods to access hidden variables
    public String getSuit(){
        return suit;
    }

    public String getKind(){
        return kind;
    }
}