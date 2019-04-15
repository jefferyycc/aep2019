package edu.berkeley.aep;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class NodeTest {

    private static Node a = new Node();
    private static Node b = new Node();
    private static Node c = new Node();
    private static Node d = new Node();
    private static Node e = new Node();
    private static Node f = new Node();
    private static Node g = new Node();
    private static Node h = new Node();

    static {
        h.add(new Edge(b, 20));
        b.add(new Edge(a, 12));
        a.add(new Edge(f, 8));
        b.add(new Edge(c, 10));
        c.add(new Edge(d, 6));
        d.add(new Edge(e, 8));
        c.add(new Edge(e, 16));
        c.add(new Edge(e, 22));
        e.add(new Edge(b, 9));
    }

    @Test
    public void nodeShouldReachItself() {
        Node node = new Node();
        assertTrue(node.canReach(node));
    }

    @Test
    public void nodeShouldReachChild() {
        Node parent = new Node();
        Node child = new Node();
        parent.add(new Edge(child, 0));
        assertTrue(parent.canReach(child));
    }

    @Test
    public void nodeShouldNotReachDisconnectedNode() {
        Node parent = new Node();
        Node random = new Node();
        assertFalse(parent.canReach(random));
    }

    @Test
    public void shouldNotBlowStackIfCyclesExist() {
        assertFalse(h.canReach(g));
    }

    @Test
    public void hopCountFromOneNodeToItselfIsZero() {
        assertEquals(0, h.countTo(h));
    }

    @Test
    public void hopCountFromHtoDIsThree() {
        assertEquals(2, h.countTo(c));
    }

    @Test
    public void hopCountFromBtoEIsTwo() {
        assertEquals(2, b.countTo(e));
    }

    @Test
    public void costFromBtoEIs24() {
        assertEquals(24, b.costTo(e));
    }
}
