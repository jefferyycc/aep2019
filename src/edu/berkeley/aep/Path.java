package edu.berkeley.aep;

// Understands a path through a graph
public class Path implements Comparable<Path> {
    private final int distance;

    public static final Path UNREACHABLE = new Path() {
        @Override
        public int compareTo(Path other) {
            return 1; // always bigger!
        }
    };

    public Path() {
        this.distance = 0;
    }

    public Path(int distance) {
        this.distance = distance;
    }

    public int distance() {
        return distance;
    }

    public Path add(int cost) {
        return new Path(distance + cost);
    }

    @Override
    public int compareTo(Path other) {
        if (other.equals(Path.UNREACHABLE)) {
            return -1;
        }
        return Integer.compare(distance, other.distance);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Path)) return false;
        return ((Path) obj).distance == distance;
    }

    @Override
    public int hashCode() {
        return distance;
    }
}
