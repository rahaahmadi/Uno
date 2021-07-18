import java.util.Scanner;

public class HumanPlayer extends Player {
    /**
     * Create a new human player
     */
    public HumanPlayer() {
        super();
    }

    /**
     * play draw+2 card method for human player
     * @return draw+2 card
     */
    @Override
    public Card playDraw2Card() {
        Scanner input = new Scanner(System.in);
        int index;
        outer:
        while (true) {
            String color = input.next();
            String value = input.next();
            if (value.equals("+2")) {
                for (Card c : getValidCards()) {
                    if (c.getValue().equals(value) && c.getColor().equals(color.toUpperCase())) {
                        index = getValidCards().indexOf(c);
                        break outer;
                    }
                }
            }
            System.out.println("Wrong card");
            System.out.println("try again");
        }
        return getValidCards().get(index);
    }

    /**
     * override play wild+4 method
     * @return wild+4 card
     */
    @Override
    public Card playWildDraw() {
        Scanner input = new Scanner(System.in);
        int index;
        outer:
        while (true) {
            String value = input.next();
            if (value.equals("wild+4")) {
                for (Card c : getValidCards()) {
                    if (c.getValue().equals(value)) {
                        index = getValidCards().indexOf(c);
                        break outer;
                    }
                }
            }
            System.out.println("Wrong card");
            System.out.println("try again");

        }
        return getValidCards().get(index);
    }

    /**
     * override wildColor method
     * @return string of color
     */
    @Override
    public String wildColor() {
        Scanner input = new Scanner(System.in);
        String color;
        outer:
        while (true) {
            System.out.println("color:");
            color = input.next();
            for (Color c : Color.values()) {
                if (c.name().equals(color.toUpperCase()))
                    break outer;
            }
            System.out.println("Wrong color");
            System.out.println("try again");
        }
        return color.toUpperCase();
    }

    /**
     * put a card by human player
     * @param game UNO game
     * @return card to put
     */
    @Override
    public Card cardToPut(Game game) {
        Scanner input = new Scanner(System.in);
        int index;
        String card;
        outer:
        while (true) {
            System.out.println("enter card");
            card = input.nextLine();
            String[] parts = card.split(" ");
            if (parts.length == 1) {
                String value = parts[0];
                for (Card c : getValidCards()) {
                    if (c.getValue().equals(value)) {
                        index = getValidCards().indexOf(c);
                        break outer;
                    }
                }
            } else {
                String color;
                String value;
                color = parts[0];
                value = parts[1];
                for (Card c : getValidCards()) {
                    if (c.getColor().equals(color.toUpperCase()) && c.getValue().equals(value)) {
                        index = getValidCards().indexOf(c);
                        break outer;
                    }
                }
            }
            System.out.println("wrong cart");
        }
        return getValidCards().get(index);
    }
}
