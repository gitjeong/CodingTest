import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.Math;


public class Progresses {

	public static int[] solution(int[] progresses, int[] speeds) {
		List<Integer> answer0 = new ArrayList<>();
		int[] remain_days = new int[progresses.length];
        
		for(int i=0; i<progresses.length; i++){
			double remain_prog = 100 - progresses[i];
			remain_days[i] = (int)Math.ceil(remain_prog / speeds[i]);
			}
        
        // Third Try
        ArrayList<Integer> indexes = new ArrayList<>();
        int big_num = remain_days[0];
        
        System.out.println(remain_days[0]);
        System.out.println(remain_days[1]);
        boolean a = remain_days[1] > big_num;
        System.out.println(a);
        
        indexes.add(0);
        for(int i=1; i<remain_days.length; i++){
            if(remain_days[i] > big_num){
            	System.out.println(remain_days[i] + ", " + big_num);
                big_num = remain_days[i];
                indexes.add(i);
            }
        }
        indexes.add(remain_days.length);
        for(int i=0; i<indexes.size()-1; i++){
            answer0.add(indexes.get(i+1) - indexes.get(i));
        }
        
		Integer[] answer = answer0.stream().toArray(Integer[]::new);
		return Arrays.stream(answer).mapToInt(i->i).toArray();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] progresses = new int[] {95, 90, 99, 99, 80, 99};
		int[] speeds = new int[] {1, 1, 1, 1, 1, 1};
		int[] answer = solution(progresses, speeds);
		System.out.println(answer[0]);
	}

}
