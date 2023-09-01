import java.util.*;

public class PokerHandEvaluator {
    private List<Card> cardsList;
    private List<Card> deckOfCards;

    public static void main (String... args) {
        System.out.println("Choose 5 cards for your hand");
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