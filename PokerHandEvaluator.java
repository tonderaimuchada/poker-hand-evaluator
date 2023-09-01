import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PokerHandEvaluator {
    private static Set<Card> cardsInHand;
    private static List<Card> deckOfCards;

    public static void main (String... args) {
        System.out.println("Choose 5 cards for your hand");
        deckOfCards = loadDeckOfCards();
        System.out.println(deckOfCards.size());
        cardsInHand = new HashSet<>(deckOfCards);
    }

    static List<Card> loadDeckOfCards(){
        List<Card> deckOfCards = new ArrayList<>();
        String kinds[] = {"A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3", "2"};
        String suits[] = {"Spades", "Hearts", "Diamonds", "Clubs"};
        for (int i=0; i<kinds.length; i++) {
            for (int j=0; j<suits.length; j++) {
                deckOfCards.add(new Card(kinds[i], suits[i]));
            }
        }
        deckOfCards.add(new Card("A", "Spades"));
        deckOfCards.add(new Card("A", "Hearts"));
        deckOfCards.add(new Card("A", "Diamonds"));
        deckOfCards.add(new Card("A", "Clubs"));
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