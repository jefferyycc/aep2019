package edu.berkeley.aep;

// Understands the probability of an outcome occurring
public class Chance implements Bestable<Chance> {
    private final double probability;

    public Chance(double probability) {
        this.probability = probability;
    }

    @Override
    public String toString() {
        return "Chance with probability " + probability;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (!(other instanceof Chance)) return false;
        return Double.compare(probability, ((Chance) other).probability) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(probability);
    }

    public Chance not() {
        return new Chance(1 - probability);
    }

    public Chance and(Chance other) {
        return new Chance(probability * other.probability);
    }

    public Chance or(Chance other) {
        // De Morgan's Law
        return this.not().and(other.not()).not();
    }

    @Override
    public boolean betterThan(Chance other) {
        return this.probability > other.probability;
    }
}
