public class Reverse extends Card {
    /**
     * Create a new reverse card
     * @param color reverse card color
     */
    public Reverse(String color) {
        super(color, "reverse",20);
    }

    /**
     * override toSting method
     * @return string
     */
    @Override
    public String toString() {
        return "|$$$$$$$$$$|" + "\n" + "|          |" + "\n" + "| " + getValue() + "  |" + "\n"
                + "|          |" + "\n" + "|$$$$$$$$$$|";
    }
}
