/** This class outputs all palindromes in the words file in the current directory. */

import edu.princeton.cs.algs4.*;

public class PalindromeFinder {


    public static void main(String[] args) {
        int minLength = 4;
        In in = new In("words");
        OffByN offBy5 = new OffByN(8);

        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && Palindrome.isPalindrome(word, offBy5)) {
                System.out.println(word);
            }
        }
    }


} 
