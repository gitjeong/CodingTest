import java.util.*;

public class Boat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] people = {24,30,35,41,59,65,70,76};
		int limit = 100;
		
		LinkedList<Integer> people_lst = new LinkedList<>();
		Deque<Integer> people_deq = people_lst;
        int weight_count = 0;
        int boat_count = 0;
        
        int num_people = people.length;
        for(int idx=0; idx<num_people; idx++) {
        	people_lst.add(people[idx]);
        }
        Collections.sort(people_lst);
        
        // 살찐 사람을 먼저 태우고 남는 공간에 가벼운 사람을 채워넣는 전략
        /*
        while(!people_deq.isEmpty()) {
        	if(weight_count == 0) {
        		boat_count += 1;
        		weight_count = people_deq.pollLast();
        	}
        	else if(weight_count + people_deq.peekFirst() <= limit){
        		weight_count += people_deq.pollFirst();
        	}
        	else {
        		weight_count = 0;
        	}
        }
        */
        
        while(num_people > 0) {
        	if(weight_count == 0) {
        		boat_count += 1;
        		weight_count = people_deq.pollLast();
            	num_people--;
        	}
        	else if(weight_count + people_deq.peekFirst() <= limit){
        		weight_count += people_deq.pollFirst();
            	num_people--;
        	}
        	else {
        		weight_count = 0;
        	}
        }
        
        System.out.println(boat_count);
	}

}


/*
 * 효율성 테스트
 * 테스트 1 〉	통과 (46.51ms, 57.1MB)
 * 테스트 2 〉	통과 (41.21ms, 57.4MB)
 * 테스트 3 〉	통과 (42.43ms, 56.5MB)
 * 테스트 4 〉	실패 (시간 초과)
 * 테스트 5 〉	통과 (39.62ms, 55.4MB)
 */
