package edu.berkeley.aep;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

// Understands how to traverse a graph
public class Node {

    private Collection<Edge> children = new ArrayList<>();

    public boolean canReach(Node destination) {
        return countTo(destination) > -1;
    }

    public void add(Edge child) {
        children.add(child);
    }

    public int countTo(Node destination) {
        Path path = pathTo(destination, new HashSet<>(), Edge.HOP_STRATEGY);
        if (path == Path.UNREACHABLE) {
            return -1;
        }
        return path.distance();
    }

    public Path pathTo(Node destination, HopStrategy strategy) {
        return pathTo(destination, new HashSet<>(), strategy);
    }

    Path pathTo(Node destination, Collection<Node> visited, HopStrategy strategy) {
        if (destination.equals(this)) return new Path();
        if (visited.contains(this)) return Path.UNREACHABLE;
        visited.add(this);
        Path champion = Path.UNREACHABLE;
        for (Edge child : children) {
            Path challenger = child.pathTo(destination, new HashSet<>(visited), strategy);
            if (challenger.compareTo(champion) < 0) {
                champion = challenger;
            }
        }
        return champion;
    }

}
