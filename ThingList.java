import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class ThingList implements Iterable<Thing> {

    private class Node {
        Thing data;
        Node next;
        Node(Thing t) { this.data = t; }
    }

    private Node head;
    private Node tail;
    private int size;

    public void add(Thing t) {
        Node n = new Node(t);
        if (head == null) {
            head = tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
        size++;
    }

    public void addThing(Thing t) { add(t); }

    public void printAll() {
        for (Thing t : this) {
            System.out.println(t.getRow() + " " + t.getCol() + " " + t.getLab());
        }
        System.out.println("done");
        System.out.flush();
    }

    public void moveAll(Random rand) {
        for (Thing t : this) {
            t.maybeTurn(rand);
            t.step();
        }
    }

    public int size() { return size; }

    @Override
    public Iterator<Thing> iterator() {
        return new Iterator<Thing>() {
            private Node curr = head;
            @Override public boolean hasNext() { return curr != null; }
            @Override public Thing next() {
                if (curr == null) throw new NoSuchElementException();
                Thing t = curr.data;
                curr = curr.next;
                return t;
            }
        };
    }
}
