/**
 * Created by lijinliang on 2017/7/1.
 */
public class MyArrayDeque<Item> {


    private static final int INIT_LENGTH = 8;

    private Item[] items;
    private int size;
    private int nextFirst;
    private int nextLast;


    public MyArrayDeque() {

        items = (Item[]) new Object[INIT_LENGTH];
        size  = 0;
        nextFirst = INIT_LENGTH / 2 - 1;
        nextLast = nextFirst + 1;

    }


    private Item[] resize(int newLength) {
        assert nextFirst == nextLast: "Should not resize!";
        Item[] res = (Item[])new Object[newLength];

        int collisionPosition = nextFirst;


        if(nextFirst > items.length / 2 - 1) {

            nextLast  =  newLength / 4 + nextLast;
            nextFirst =  newLength / 4 - (items.length - collisionPosition);

            System.arraycopy(items, 0, res, newLength / 4, items.length / 2);
            System.arraycopy(items, items.length / 2, res, newLength / 2, collisionPosition - items.length / 2);
            System.arraycopy(items, collisionPosition + 1, res, nextFirst + 1, items.length - collisionPosition - 1);

        }
        else {

            nextFirst = newLength / 4 + nextFirst;
            nextLast  = newLength * 3 / 4 + nextLast;

            System.arraycopy(items, items.length / 2, res, newLength / 2, items.length / 2);
            System.arraycopy(items, 0, res, newLength * 3 / 4, collisionPosition);
            System.arraycopy(items,  collisionPosition + 1, res,  nextFirst + 1, items.length / 2 - collisionPosition - 1);

        }

        return res;
    }

    public void addFirst(Item item) {

        items[nextFirst] = item;

        nextFirst = nextFirst - 1;

        if (nextFirst < 0) {
            nextFirst += items.length;
        }


        if(nextFirst == nextLast) {
            items = resize(2 * items.length);
        }

        size += 1;
    }


    public void addLast(Item item) {

        items[nextLast] = item;

        nextLast = nextLast + 1;

        if(nextLast >= items.length) {
            nextLast = nextLast % items.length;
        }


        if(nextFirst == nextLast) {
            items = resize(2 * items.length);
        }

        size += 1;

    }



    public boolean isEmpty() {
        return size == 0;
    }


    public int size() {
        return size;
    }

    public void printDeque() {

        int front = nextFirst + 1;

        if(nextFirst > items.length / 2 - 1 || nextLast < items.length / 2)  {
            while (front < items.length) {
                System.out.print(items[front] + " ");
                front += 1;
            }
            front = 0;
            while (front < nextLast) {
                System.out.print(items[front] + " ");
                front += 1;
            }
        }
        else {
            while (front < nextLast) {
                System.out.print(items[front] + " ");
                front += 1;
            }
        }
        System.out.println();
    }


    private Item[] shrink(int newLength) {
        Item[] res = (Item[]) new Object[newLength];

        if (nextLast < nextFirst) {
            System.arraycopy(items, 0, res, newLength / 2, nextLast + 1);

            int newFirst = newLength / 2 - (items.length - nextFirst);
            int newLast  = newLength / 2 + nextLast;

            // System.out.println("newFirst: " + newFirst + "newLast: " + newLast);
            System.arraycopy(items, nextFirst, res, newFirst, items.length - nextFirst);
            nextFirst = newFirst;
            nextLast  = newLast;
        }
        else {

            if (nextFirst >= items.length / 2 || nextLast < items.length / 2) {
                System.arraycopy(items, nextFirst, res, newLength / 2 - 1, nextLast - nextFirst);
                int tmp = nextLast - nextFirst;
                nextFirst = newLength / 2 - 1;
                nextLast  = nextFirst + tmp;
            }
            else  {

                System.arraycopy(items, items.length / 2, res, newLength / 2, nextLast - items.length / 2);

                System.arraycopy(items, nextFirst + 1, res, newLength / 2 - (items.length / 2 - nextFirst - 1), items.length / 2 - nextFirst - 1);

                nextFirst = nextFirst - items.length / 4;

                nextLast = nextLast - items.length / 4;
            }

        }

        return res;
    }


    public Item removeFirst() {

        int index = nextFirst + 1;

        if (index >= items.length) {
            index = index % items.length;
        }

        Item res = items[index];
        items[index] = null;

        nextFirst = index;

        size -= 1;

        if(items.length > 16 && size <= items.length / 4) {
            items = shrink(items.length / 2);
        }

        return res;

    }

    public Item removeLast() {

        int index = nextLast - 1;

        if (index < 0) {
            index += items.length;
        }

        Item res = items[index];
        items[index] = null;
        nextLast = index;
        size -= 1;

        if(items.length > 16 && size <= items.length / 4) {
            items = shrink(items.length / 2);
        }

        return  res;
    }



    public Item get(int index) {
        if(size == 0)
            return null;

        int pos = nextFirst + 1 + index;
        pos = pos % items.length;
        return items[pos];
    }
}
