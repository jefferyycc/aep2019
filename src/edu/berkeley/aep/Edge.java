package edu.berkeley.aep;

import java.util.HashSet;

public class Edge {
    private final Node child;
    private final int cost;
    public final static HopStrategy HOP_STRATEGY = edge -> 1;
    public final static HopStrategy COST_STRATEGY = edge -> edge.cost;

    public Edge(Node child, int cost) {
        this.child = child;
        this.cost = cost;
    }

    public int costTo(Node destination, HashSet<Node> visited, HopStrategy strategy) {
        int cost = child.costTo(destination, visited, strategy);
        if (cost == -1) return -1;
        return cost + strategy.cost(this);
    }
}
