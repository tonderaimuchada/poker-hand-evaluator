import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Scanner;

public class PokerHandEvaluator {
    private static Set<Card> cardsInHand; // The combination includes community cards
    private static List<Card> deckOfCards;

    public static void main (String... args) {
        System.out.println("Choose 5 unique cards for your hand. Press enter after every choice!"); // Prompt the user to input cards of choice from a deck list
        deckOfCards = loadDeckOfCards(); // Load all the cards
        cardsInHand = new LinkedHashSet<>();
        for (int x=0; x<deckOfCards.size(); x++) {
            System.out.println("Select " + x + ". " + deckOfCards.get(x).getKind() + " of " + deckOfCards.get(x).getSuit()); // Display the cards to the user
        }
        System.out.println();

        // Scan input from the user
        int selectedIndexes[] = new int[5];
        Scanner scanner = new Scanner(System.in);
        try {
            for (int y=0; y<selectedIndexes.length; y++) {
                selectedIndexes[y] = Integer.parseInt(scanner.nextLine());
                cardsInHand.add(deckOfCards.get(selectedIndexes[y]));
            }
        } catch (NumberFormatException exception) {
            exception.printStackTrace();
        }

        evaluateHandRank(cardsInHand); //Analyze the choosen hand cards
    }

    static void evaluateHandRank(Set<Card> cardsInHand){
        System.out.println(checkIfOnePair(cardsInHand));
        System.out.println(checkIfTwoPairs(cardsInHand));
        /* Evaluate the 10 hand-ranking categories
        checkIfHighCards();
        checkIfOnePair(cardsInHand);
        checkIfTwoPairs(cardsInHand);
        checkIfThreeOfAKind();
        checkIfStraight();
        checkIfFlush();
        checkIfFullHouse();
        checkIfFourOfAKind();
        checkIfStraightFlush();
        checkIfRoyalFlush();
        */
    }

    static boolean checkIfOnePair(Set<Card> cardsInHand){
        int duplicateKindsCount = countDuplicateKinds(cardsInHand);
        return duplicateKindsCount == 1 ? true : false; //Return true if there is one instance of a duplicate
    }

    static boolean checkIfTwoPairs(Set<Card> cardsInHand){
        int duplicateKindsCount = countDuplicateKinds(cardsInHand);
        return duplicateKindsCount == 2 ? true : false; //Return true if there are two instances of a duplicate
    }

    static int countDuplicateKinds(Set<Card> cardsInHand) {
        int count = 0;
        List<String> kinds = new ArrayList<>();
        for (Card card : cardsInHand) {
            kinds.add(card.getKind());
            System.out.println(card.getKind());
        }
        return cardsInHand.size() - (int) kinds.stream().distinct().count();
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