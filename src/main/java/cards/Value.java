package cards;

public enum Value {
    
    ACE ('A'),
    TWO ('2'),
    THREE ('3'),
    FOUR ('4'),
    FIVE ('5'),
    SIX ('6'),
    SEVEN ('7'),
    EIGHT ('8'),
    NINE ('9'),
    TEN ('0'),
    JOKER ('J'),
    QUEEN ('Q'),
    KING ('K');
    
    private char value;
    
    private Value(char value) {
        this.value = value;
    }
    
    public char getValue() {
        return this.value;
    }
    
}
