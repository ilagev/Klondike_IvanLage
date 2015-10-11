
public enum Suit {
    
    CLUB ('C'),
    DIAMOND ('D'),
    HEART ('H'),
    SPADE ('S');
    
    private char value;
    
    private Suit(char value) {
        this.value = value;
    }
    
    public char getValue() {
        return this.value;
    }
    
    public Color getColor(Suit suit) {
        return suit == Suit.DIAMOND || suit == Suit.HEART ? Color.RED : Color.BLACK;
    }
}
