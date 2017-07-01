/**
 * Created by lijinliang on 2017/7/1.
 */
public class OffByN implements CharacterComparator {

    private  int N;


    public OffByN(int N) {

        this.N = N;
    }

    /**
     * implement CharacterComparator such that equalChars
     * returns true for letters that are different by exactly N letter.
     * @param x , char
     * @param y , char
     * @return if x and y differ by one character
     */
    @Override
    public boolean equalChars(char x, char y) {

        if(y - x == N || y - x == -N )
            return true;
        else
            return false;
    }



    public static void main(String[] args) {


        OffByN obn = new OffByN(5);


        System.out.println("f, h: " + obn.equalChars('f', 'h'));
    }

}
