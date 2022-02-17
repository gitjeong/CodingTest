import java.util.*;

public class BigNum {
	public static int[] findBiggest(List<Integer> lst, int ans_size_current) {
		//System.out.print(lst);
		int[] ret = {0,0};
		int lst_size = lst.size();
		for(int idx=0; idx<lst_size-ans_size_current+1; idx++) {
			if(ret[0] < lst.get(idx)) {
				ret[0] = lst.get(idx);
				ret[1] = idx;
			}
		}
		return ret;
	}
	public static void main(String[] args) {
		String number = "1231234";
		int k = 3;
		
		// 변수 선언
		// ArrayList is 2-5 times faster
		List<Integer> number_lst = new ArrayList<>();
		int ans_size = number.length()-k;
		int[] ans_arr = new int[ans_size];
		
		// number_lst 초기화
		int number_len = number.length();
		for(int i=0; i<number_len; i++) {
			int temp_int = Character.getNumericValue(number.charAt(i));
			number_lst.add(temp_int);
		}
		
		while(ans_size > 0) {
			int[] big_num = new int[2];
			big_num = findBiggest(number_lst, ans_size);
			ans_arr[number.length() - k - ans_size] = big_num[0];
			ans_size -= 1;
			number_lst = number_lst.subList(big_num[1] + 1, number_lst.size());
			// System.out.println(number_lst);
		}
		
		for(int i : ans_arr) {
			System.out.print(i);
		}
		
		
		String answer="";
	}
}
