public class WildDrawFour extends Card {
    /**
     * Create a new Wild draw four card
     */
    public WildDrawFour() {
        super("BLACK", "wild+4",50);
    }

    /**
     * override toSting method
     * @return string
     */
    @Override
    public String toString() {
        return "|$$$$$$$$$$|" + "\n" + "|          |" + "\n" + "|  " + getValue() + "  |" + "\n"
                + "|          |" + "\n" + "|$$$$$$$$$$|";
    }

}
