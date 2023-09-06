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