package 완전탐색;
import java.util.*;

public class Rectangle {
    public static int[] findHeightWidth(int brown, int yellow){
        int[] result = new int[]{1,1};
        int limit = (int)Math.sqrt(yellow);
        for(int denom=1; denom<=limit; denom++){
            if(yellow % denom == 0 && 2*(denom + yellow/denom + 2) == brown){
                result = new int[] {yellow/denom + 2, denom + 2};
            }
        }

        return result;
    }

    public static void main(String[] args){
        int brown = 24;
        int yellow = 24;

        int[] result = findHeightWidth(brown, yellow);
        System.out.println(result[0]);
    }
}
