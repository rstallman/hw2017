/**
 * Created by lijinliang on 2017/7/1.
 */
/**
 * Created by lijinliang on 2017/6/25.
 */
public class LinkedListDeque<Item> implements Deque<Item> {

    private Node sentinel;  // sentinel node

    private int size;       // Deque size


    private class Node {
        Item item;
        Node prev;
        Node next;

        public Node(Item item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }


    public LinkedListDeque() {
        size = 0;
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;  // circular sentinel
    }

    /**
     * Adds an item to the front of the Deque.
     */
    public void addFirst(Item item) {
        Node newNode = new Node(item, null, null);
        Node tmp = sentinel.next;
        sentinel.next = newNode;
        newNode.prev = sentinel;
        tmp.prev = newNode;
        newNode.next = tmp;

        size += 1;

    }

    public void addLast(Item item) {
        Node newNode = new Node(item, null, null);
        Node tmp = sentinel.prev;
        sentinel.prev = newNode;
        newNode.next = sentinel;
        newNode.prev = tmp;
        tmp.next = newNode;
        size += 1;
    }

    public boolean isEmpty() {

        return size == 0;
    }

    public int size() {
        return size;
    }

    public Item removeFirst() {
        assert !isEmpty() : " Empty deque, cannot removeFirst!";

        Node firstNode = sentinel.next;

        sentinel.next = firstNode.next;
        firstNode.next.prev = sentinel;
        firstNode.prev = null;
        firstNode.next = null;
        size -= 1;

        return firstNode.item;
    }


    public Item removeLast() {
        assert !isEmpty() : " Empty deque, cannot removeLast!";

        Node lastNode = sentinel.prev;

        sentinel.prev = lastNode.prev;
        lastNode.prev.next = sentinel;
        lastNode.prev = null;
        lastNode.next = null;
        size -= 1;

        return lastNode.item;

    }

    /**
     * get the ith element in deque
     * @param index
     * @return
     */
    public Item get(int index) {

        Node first = sentinel.next;

        for(int i = 0; i < size &&  i < index; i++) {

            first = first.next;

        }

        if (first != null)
            return first.item;
        else
            return null;
    }


    private Node getNode(Node start, int index) {

        if (start == sentinel)
            return null;

        if (index == 0)
            return start;

        return getNode(start.next, index - 1);
    }


    public Item getRecursive(int index) {

        Node res = getNode(sentinel.next, index);

        if (res == null)
            return null;
        else
            return res.item;

    }


    public void printDeque() {

        Node first = sentinel.next;

        while (first != sentinel) {

            System.out.print(first.item + " ");
            first = first.next;
        }

        System.out.println();

    }


    public static void main(String[] args) {

        LinkedListDeque<Integer> deq = new LinkedListDeque<>();

        deq.addFirst(3);
        deq.addFirst(2);
        deq.addFirst(1);
        deq.addLast(4);
        deq.addLast(5);

        deq.printDeque();


        while (!deq.isEmpty()) {
            System.out.println(deq.removeFirst() + " ");
        }

        for (int i = 0; i < 10; i++) {
            deq.addLast(i * 10);
        }

        deq.printDeque();


        for(int i = 2; i < 8; i++) {
            System.out.println(deq.getRecursive(i));
        }

    }

}
