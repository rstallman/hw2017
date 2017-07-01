/**
 * Created by lijinliang on 2017/7/1.
 */
public class OffByOne implements CharacterComparator {

    /**
     * implement CharacterComparator such that equalChars
     * returns true for letters that are different by exactly one letter.
     * @param x , char
     * @param y , char
     * @return if x and y differ by one character
     */
    @Override
    public boolean equalChars(char x, char y) {

        if(y - x == 1 || y - x == -1 )
            return true;
        else
            return false;
    }


    public static void main(String[] args) {


        OffByOne obo = new OffByOne();


        System.out.println("l, k: " + obo.equalChars('k', 'l'));
    }



}
