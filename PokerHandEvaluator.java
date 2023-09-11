import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.stream.Stream;
import java.util.Comparator;
import java.util.Arrays;

public class PokerHandEvaluator {
    private static Set<Card> cardsInHand; // The combination includes community cards
    private static List<Card> deckOfCards;
    private static List<String> globalKinds = Arrays.asList(new String[]{"A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3", "2"});
    private static List<String> globalSuits = Arrays.asList(new String[]{"Spades", "Hearts", "Diamonds", "Clubs"});

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

        System.out.println(evaluateHandRank(cardsInHand)); //Analyze the choosen hand cards
    }

    static HandRank evaluateHandRank(Set<Card> cardsInHand){
        int distinctKindsCount = countDistinctKinds(cardsInHand);
        int duplicateKindsCount = countDuplicateKinds(cardsInHand);
        int distinctSuitsCount = countDistinctSuits(cardsInHand);
        boolean isHandStraight = checkIfHandIsStraight(cardsInHand);
        boolean isATheFirstElement = checkIfAIsTheFirstElement(cardsInHand);

        // Evaluate the 10 hand-ranking categories
        if (duplicateKindsCount == 1) {
            return HandRank.ONEPAIR;
        } else if (duplicateKindsCount == 2 && distinctKindsCount == 3) {
            return HandRank.TWOPAIR;
        } else if (duplicateKindsCount == 1 && distinctKindsCount == 3) {
            return HandRank.THREEOFAKIND;
        } else if (duplicateKindsCount == 2 && distinctKindsCount == 2) {
            return HandRank.FULLHOUSE;
        } else if (duplicateKindsCount == 1 && distinctKindsCount == 2){
            return HandRank.FOUROFAKIND;
        } else if (isHandStraight) {
            if (distinctSuitsCount == 1){
                if (isATheFirstElement)
                    return HandRank.FIVEOFAKIND;
                return HandRank.STRAIGHTFLUSH;
            }
            return HandRank.STRAIGHT;
        } else if (distinctSuitsCount == 1) {
            return HandRank.FLUSH;
        }
        return HandRank.HIGHCARD;
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

    static int countDistinctKinds(Set<Card> cardsInHand) {
        List<String> kinds = new ArrayList<>();
        for (Card card : cardsInHand) {
            kinds.add(card.getKind());
        }
        return (int) kinds.stream().distinct().count();
    }

    static int countDuplicateKinds(Set<Card> cardsInHand) {
        List<String> kinds = new ArrayList<>();
        for (Card card : cardsInHand) {
            kinds.add(card.getKind());
        }
        return kinds.stream().filter(i -> Collections.frequency(kinds, i) > 1).collect(Collectors.toSet()).size();
    }

    static int countDistinctSuits(Set<Card> cardsInHand) {
        List<String> suits = new ArrayList<>();
        for (Card card : cardsInHand) {
            suits.add(card.getSuit());
        }
        return (int) suits.stream().distinct().count();
    }

    static boolean checkIfHandIsStraight(Set<Card> cardsInHand) {
        List<String> kinds = new ArrayList<>();
        for (Card card : cardsInHand) {
            kinds.add(card.getKind());
        }
        Collections.sort(kinds, new Comparator<String>() {
                public int compare(String kind1, String kind2) {
                    return kinds.indexOf(kind2) - kinds.indexOf(kind1);
                }});
        System.out.println("sortedlist is" + kinds.toString());
        for (int i=0; i<kinds.size() - 1; i++) { // -1 to avoid IndexOutOfBoundsException from comparing the last element with non-existing element
            if (globalKinds.indexOf(kinds.get(i)) != globalKinds.indexOf(kinds.get(i+1)) + 1) //Check if the next index is 1 value above the current index
                return false;
        }
        return true;
    }

    static boolean checkIfAIsTheFirstElement(Set<Card> cardsInHand) {
        List<String> kinds = new ArrayList<>();
        for (Card card : cardsInHand) {
            kinds.add(card.getKind());
        }
        Collections.sort(kinds, new Comparator<String>() {
                public int compare(String kind1, String kind2) {
                    return kinds.indexOf(kind1) - kinds.indexOf(kind2);
                }});
        return kinds.get(0).equals("A") ? true : false;
    }

    // Loading cards to the deck. In this case, with all kinds and suits
    static List<Card> loadDeckOfCards(){
        List<Card> deckOfCards = new ArrayList<>();
        for (int i=0; i<globalKinds.size(); i++) {
            for (int j=0; j<globalSuits.size(); j++) {
                deckOfCards.add(new Card(globalKinds.get(i), globalSuits.get(j)));
            }
        }
        return deckOfCards;
    }
}