public class NumberCard extends Card {
    /**
     * Create a new Number card
     * @param color number card color
     * @param value number card value
     */
    public NumberCard(String color, Integer value) {
        super(color,value.toString(),value);
    }

    /**
     * override toSting method
     * @return string
     */
    @Override
    public String toString() {
        return "|$$$$$$$$$$|" + "\n" + "|          |" + "\n" + "|    " + getValue() + "     |" + "\n"
                + "|          |" + "\n" + "|$$$$$$$$$$|";
    }
}
