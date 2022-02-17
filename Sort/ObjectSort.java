import java.lang.Comparable;
import java.util.Arrays;

class NumString implements Comparable<NumString> {
	String str;
	public NumString(int n1){
		str = Integer.toString(n1);
    }
    
    // 두 객체 비교 방법 -> 누굴 앞에 놓았을 때 큰 숫자가 되는지 비교
	public int compareTo(NumString nst2){
		int concat_number1 = Integer.parseInt(this.str.concat(nst2.str));
		int concat_number2 = Integer.parseInt(nst2.str.concat(this.str));
		return concat_number1 - concat_number2;
		
	}
}

class Solution {
    public String solution(int[] numbers) {
        //answer를 StringBuilder 변수로 초기화 -> 빠름!
        StringBuilder answer = new StringBuilder("");
        
        //NumString 배열 인스턴스 선언
        NumString[] numbers_str = new NumString[numbers.length];
        
        //NumString 배열 초기화
        for(int i=0; i<numbers_str.length; i++){
            numbers_str[i] = new NumString(numbers[i]);
        }
        
        //정렬(오름차순)
        Arrays.sort(numbers_str);
        
        //Merge
        for(int i=numbers_str.length-1; i>=0; i--){
            answer.append(numbers_str[i].str);
        }
        
        // StringBuilder to String
        String ret = answer.toString();
        
        // 모두 0인 경우 예외처리
        if(numbers_str[numbers_str.length-1].str.equals("0"))
            return "0";
        else
            return ret;
        
    }
}

public class ObjectSort {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int[] numbers = {0, 0, 0, 0};
		System.out.println(sol.solution(numbers));
	}

}
