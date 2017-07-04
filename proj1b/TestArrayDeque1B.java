/**
 * Created by lijinliang on 2017/7/1.
 */


import static org.junit.Assert.*;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

public class TestArrayDeque1B {

    @Test
    public void testDeque() {

        MyArrayDeque<Integer> sdeq = new MyArrayDeque<>();

        ArrayDequeSolution<Integer> deq = new ArrayDequeSolution<>();

        OperationSequence fs = new OperationSequence();


        // int i = 0;
        for(int i = 0; i < 2000; i++){
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.25) {
                sdeq.addLast(i);
                deq.addLast(i);
                DequeOperation dequeOp1 = new DequeOperation("addLast", i);
                fs.addOperation(dequeOp1);
                i++;
            }
            else if (numberBetweenZeroAndOne < 0.5){
                sdeq.addFirst(i);
                deq.addFirst(i);
                DequeOperation dequeOp2 = new DequeOperation("addFirst", i);
                fs.addOperation(dequeOp2);
                i++;
            }
            else if (numberBetweenZeroAndOne < 0.75  && !sdeq.isEmpty() && !deq.isEmpty()) {
                Integer x1 = sdeq.removeFirst();
                Integer x2 = deq.removeFirst();
                DequeOperation dequeOp3 = new DequeOperation("removeFirst");
                fs.addOperation(dequeOp3);
                String message = fs.toString();
                assertEquals(message, x2, x1);

            }
            else if(!sdeq.isEmpty() && !deq.isEmpty()) {
                Integer x1 = sdeq.removeLast();
                Integer x2 = deq.removeLast();
                DequeOperation dequeOp4 = new DequeOperation("removeLast");
                fs.addOperation(dequeOp4);
                String message = fs.toString();
                assertEquals(message, x2, x1);

            }

        }


    }

}
