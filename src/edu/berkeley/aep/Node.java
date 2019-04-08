package edu.berkeley.aep;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class Node {

    private Collection<Node> children = new ArrayList<>();

    public boolean canReach(Node node) {
        return canReach(node, new HashSet<>());
    }

    private boolean canReach(Node node, Collection<Node> visited) {
        if (!visited.add(this)) return false;
        if (node.equals(this)) return true;
        for (Node child : children) {
            if (child.canReach(node, visited)) {
                return true;
            }
        }
        return false;
    }

    public void add(Node child) {
        children.add(child);
    }
}
