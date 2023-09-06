class Card {
    // Encapsulating instance variables
    private String kind;
    private String suit;

    //Constructor to enable building of Card instances
    Card (String kind, String suit) {
        this.kind = kind;
        this.suit = suit;
    }

    // Public getter methods to access hidden variables
    public String getSuit(){
        return suit;
    }

    public String getKind(){
        return kind;
    }
}