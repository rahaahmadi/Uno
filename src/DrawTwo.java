public class DrawTwo extends Card {
    /**
     * create a Draw2 card
     * @param color color of draw2 card
     */
    public DrawTwo(String color) {
        super(color, "+2",20);
    }

    /**
     * override toSting method
     * @return string of card
     */
    @Override
    public String toString() {
        return "|$$$$$$$$$$|" + "\n" + "|          |" + "\n" + "|    " + getValue() + "    |" + "\n"
                + "|          |" + "\n" + "|$$$$$$$$$$|";
    }

}
