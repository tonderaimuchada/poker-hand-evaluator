import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PokerHandEvaluator {
    private static Set<Card> cardsInHand;
    private static List<Card> deckOfCards;

    public static void main (String... args) {
        System.out.println("Choose 5 unique cards for your hand");
        deckOfCards = loadDeckOfCards();
        for (int x=0; x<deckOfCards.size(); x++) {
            System.out.println("Select " + x + ". " + deckOfCards.get(x).getSuit() + " of " + deckOfCards.get(x).getKind());
        }
        cardsInHand = new HashSet<>(deckOfCards);
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