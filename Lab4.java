import java.util.Arrays;

public class Lab4 {
    public static void main(String[] args) {
        // Create sandwiches
        Sandwich burger = new Sandwich("Cheeseburger", 2.75);
        Sandwich club = new Sandwich("Club Sandwich", 2.75);
        Sandwich tuna = new Sandwich("Tuna Sandwich", 3.00);
        Sandwich veggie = new Sandwich("Veggie Sandwich", 2.50);

        // Create salads
        Salad spinachSalad = new Salad("Spinach Salad", 1.25);
        Salad coleslaw = new Salad("Coleslaw", 1.25);
        Salad caesar = new Salad("Caesar Salad", 2.00);
        Salad greek = new Salad("Greek Salad", 2.50);

        // Create drinks
        Drink orange = new Drink("Orange Soda", 1.25);
        Drink cap = new Drink("Cappuccino", 3.50);
        Drink lemonade = new Drink("Lemonade", 1.50);
        Drink tea = new Drink("Green Tea", 2.00);

        // Create an array of Trios
        Trio[] trios = new Trio[6];

        try {
            trios[0] = new Trio(burger, spinachSalad, orange);
            trios[1] = new Trio(club, coleslaw, cap);
            trios[2] = new Trio(tuna, caesar, lemonade);
            trios[3] = new Trio(veggie, greek, tea);
            trios[4] = new Trio(burger, greek, lemonade);
            trios[5] = new Trio(tuna, coleslaw, cap);
        } catch (Trio.IllegalTrioException e) {
            System.out.println("Error creating trio: " + e.getMessage());
        }

        System.out.println("Before sorting:");
        for (Trio t : trios) {
            if (t != null) {
                System.out.println(t.getName() + ": $" + t.getPrice());
            }
        }

        // Sort the trios by price (using Comparable)
        Arrays.sort(trios);

        System.out.println("\nAfter sorting (from cheapest to most expensive):");
        for (Trio t : trios) {
            if (t != null) {
                System.out.println(t.getName() + ": $" + t.getPrice());
            }
        }
    }
}

