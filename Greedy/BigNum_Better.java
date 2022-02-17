import java.util.*;

public class BigNum_Better {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String number = "1924";
		int k = 2;
		
		int number_len = number.length();
		int ans_len = number_len - k;
		
		Stack<Character> stack = new Stack<>();
		
		
		for(int idx=0; idx<number_len; idx++) {
			while(!stack.isEmpty() && stack.peek() < number.charAt(idx) && k-- > 0) {
				stack.pop();
			}
			if(stack.size() < ans_len) {
				stack.push(number.charAt(idx));
			}
		}
		Iterator<Character> itr = stack.iterator();
		StringBuilder ans_bld = new StringBuilder();
		while(itr.hasNext()) {
			ans_bld.append(itr.next());
		}
		
		System.out.println(ans_bld.toString());
	}

}
