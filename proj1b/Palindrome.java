/**
 * Created by lijinliang on 2017/7/1.
 */
public class Palindrome {

    /**
     *  build a Deque where the characters in the deque appear
     *  in the same order as in the word.
     * @param word
     * @return
     */
    public static Deque<Character> wordToDeque(String word) {

        Deque<Character> res = new LinkedListDeque<>();

        for(int i = 0; i < word.length(); i++) {
            Character ch = word.charAt(i);
            res.addLast(ch);
        }

        return res;
    }


    private  static boolean isPalindrome(Deque<Character> deq) {

        if (deq.isEmpty() || deq.size() == 1)
            return true;

        Character headChar = deq.removeFirst();
        Character tailChar  = deq.removeLast();

        return headChar.equals(tailChar) && isPalindrome(deq);

    }


    private  static boolean isPalindrome(Deque<Character> deq, CharacterComparator cc) {
        if (deq.isEmpty() || deq.size() == 1)
            return true;

        Character headChar  = deq.removeFirst();
        Character tailChar  = deq.removeLast();
        return cc.equalChars(headChar, tailChar) && isPalindrome(deq, cc);
    }

    public static boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> wordDeq =  Palindrome.wordToDeque(word);

        return isPalindrome(wordDeq, cc);
    }



    public static boolean isPalindrome(String word) {

        Deque<Character> wordDeq =  Palindrome.wordToDeque(word);

        return isPalindrome(wordDeq);
    }



    public  static  void main(String[] args) {

        String word = "flake";

        Deque<Character> deq = Palindrome.wordToDeque(word);

        deq.printDeque();

        OffByOne obo = new OffByOne();

        System.out.println("flake: " + Palindrome.isPalindrome(word, obo));
    }
}
