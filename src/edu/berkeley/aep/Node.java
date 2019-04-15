package edu.berkeley.aep;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

public class Node {

    private Collection<Node> children = new ArrayList<>();

    public boolean canReach(Node destination) {
        return countTo(destination, new HashSet<>()) > -1;
    }

    public void add(Node child) {
        children.add(child);
    }

    public int countTo(Node destination) {
        return countTo(destination, new HashSet<>());
    }

    private int countTo(Node destination, Collection<Node> visited) {
        if (!visited.add(this)) return -1;
        if (destination.equals(this)) return 0;
        var minCount = -1;
        for (Node child : children) {
            var count = child.countTo(destination, new HashSet(visited));
            if (count >= 0 && (count < minCount || minCount == -1)) {
                minCount = count + 1;
            }
        }
        return minCount;
    }

}
