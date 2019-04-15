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
        h.add(b);
        b.add(a);
        a.add(f);
        b.add(c);
        c.add(d);
        d.add(e);
        c.add(e);
        c.add(e);
        e.add(b);
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
        parent.add(child);
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
}
