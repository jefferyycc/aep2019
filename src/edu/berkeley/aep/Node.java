package edu.berkeley.aep;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

public class Node {

    private Collection<Edge> children = new ArrayList<>();

    public boolean canReach(Node destination) {
        return costTo(destination, new HashSet<>(), Edge.HOP_STRATEGY) > -1;
    }

    public void add(Edge child) {
        children.add(child);
    }

    public int countTo(Node destination) {
        return costTo(destination, new HashSet<>(), Edge.HOP_STRATEGY);
    }

    public int costTo(Node destination) {
        return costTo(destination, new HashSet<>(), Edge.COST_STRATEGY);
    }

    int costTo(Node destination, Collection<Node> visited, HopStrategy strategy) {
        if (!visited.add(this)) return -1;
        if (destination.equals(this)) return 0;
        var minCost = -1;
        for (Edge child : children) {
            var cost = child.costTo(destination, new HashSet(visited), strategy);
            if (cost >= 0 && (cost < minCost || minCost == -1)) {
                minCost = cost;
            }
        }
        return minCost;
    }
}
