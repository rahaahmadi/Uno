public class Wild extends Card {
    /**
     * Create a new wild card
     */
    public Wild() {
        super("BLACK", "wild",50);
    }

    /**
     * override toSting method
     * @return string
     */
    @Override
    public String toString() {
        return "|$$$$$$$$$$|" + "\n" + "|          |" + "\n" + "|   " + getValue() + "   |" + "\n"
                + "|          |" + "\n" + "|$$$$$$$$$$|";
    }

}
