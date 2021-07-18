public class Skip extends Card {
    /**
     * Create a new skip card
     * @param color color of skip card
     */
    public Skip(String  color) {
        super(color,"skip",20);
    }

    /**
     * override toSting method
     * @return sting
     */
    @Override
    public String toString() {
        return "|$$$$$$$$$$|" + "\n" + "|          |" + "\n" + "|   " + getValue() + "   |" + "\n"
                + "|          |" + "\n" + "|$$$$$$$$$$|";
    }

}
