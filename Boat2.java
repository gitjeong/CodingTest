import java.util.*;

public class Boat2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] people = {24,30,35,41,59,65,70,76};
		int limit = 100;
		
		LinkedList<Integer> people_lst = new LinkedList<>();
		Deque<Integer> people_deq = people_lst;
        int weight_count = 0;
        int boat_count = 0;
        
        int num_people = people.length;
        Arrays.sort(people);
        for(int idx=0; idx<num_people; idx++) {
        	people_lst.add(people[idx]);
        }
        //Collections.sort(people_lst);
        
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
