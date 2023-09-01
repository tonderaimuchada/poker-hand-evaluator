import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Scanner;

public class PokerHandEvaluator {
    private static Set<Card> cardsInHand;
    private static List<Card> deckOfCards;

    public static void main (String... args) {
        System.out.println("Choose 5 unique cards for your hand. Press enter after every choice!");
        deckOfCards = loadDeckOfCards();
        for (int x=0; x<deckOfCards.size(); x++) {
            System.out.println("Select " + x + ". " + deckOfCards.get(x).getSuit() + " of " + deckOfCards.get(x).getKind());
        }

        int selectedIndexes[] = new int[5];
        Scanner scanner = new Scanner(System.in);
        for (int y=0; y<selectedIndexes.length; y++) {
            selectedIndexes[y] = Integer.parseInt(scanner.nextLine());
        }
        for (int y=0; y<selectedIndexes.length; y++) {
            System.out.println(selectedIndexes[y]);
        }

        evaluateHandRank();
        cardsInHand = new HashSet<>(deckOfCards);
    }

    static void evaluateHandRank(){
        /* Evaluate the 10 hand-ranking categories
        checkIfHighCards();
        checkIfOnePair();
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
    private String suit;
    private String kind;

    Card (String suit, String kind) {
        this.suit = suit;
        this.kind = kind;
    }

    public String getSuit(){
        return suit;
    }

    public String getKind(){
        return kind;
    }
}