package LabNum4;

public class Trio implements MenuItem, Comparable<Trio> {
    private Sandwich sandwich;
    private Salad salad;
    private Drink drink;

    private String name;
    private double price;

    public Trio(Sandwich sandwich, Salad salad, Drink drink) throws IllegalTrioException {
        double p1 = sandwich.getPrice();
        double p2 = salad.getPrice();
        double p3 = drink.getPrice();

        if (p1 == p2 && p2 == p3) {
            throw new IllegalTrioException("All Trio items have the same price.");
        }
        this.sandwich = sandwich;
        this.salad = salad;
        this.drink = drink;
        this.name = sandwich.getName() + "/" + salad.getName() + "/" + drink.getName() + " Trio";
        this.price = calculatePrice(p1, p2, p3);
    }

    private double calculatePrice(double p1, double p2, double p3) {
        // price is sum of two highest
        if (p1 <= p2 && p1 <= p3) {
            return p2 + p3;
        } else if (p2 <= p1 && p2 <= p3) {
            return p1 + p3;
        } else {
            return p1 + p2;
        }
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public static class IllegalTrioException extends Exception {
        public IllegalTrioException(String message) {
            super(message);
        }
    }

    public int compareTo(Trio other) {
        // higher price is "larger", return positive if this > other, negative if this < other
        return Double.compare(this.price, other.price);
    }
}

