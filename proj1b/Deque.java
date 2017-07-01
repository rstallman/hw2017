/**
 * Created by lijinliang on 2017/7/1.
 */
/**
 * Created by lijinliang on 2017/7/1.
 */
public interface Deque<Item> {

    /**
     * add  item to the front of Deque
     * @param item, item to add, a generic type Item
     */
    public void addFirst(Item item);

    /**
     * add item to the tail of Deque
     * @param item, item to add, a generic type Item
     */
    public void addLast(Item item);

    /**
     * whether the Deque is empty?
     * @return boolean, true if Deque is empty
     */
    public boolean isEmpty();

    /**
     * return Deque size, an int
     * @return size of Deque
     */
    public int size();

    /**
     * remove item from head of deque
     * @return item of generic type Item
     */
    public Item removeFirst();

    /**
     * remove item from tail of deque
     * @return item of generic type Item
     */
    public Item removeLast();

    /**
     * get item at index
     * @param index, index of deque, start from 0
     * @return item of generic type Item
     */
    public Item get(int index);


    public void printDeque();

}
