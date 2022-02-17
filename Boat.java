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
        
        // ���� ����� ���� �¿�� ���� ������ ������ ����� ä���ִ� ����
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
 * ȿ���� �׽�Ʈ
 * �׽�Ʈ 1 ��	��� (46.51ms, 57.1MB)
 * �׽�Ʈ 2 ��	��� (41.21ms, 57.4MB)
 * �׽�Ʈ 3 ��	��� (42.43ms, 56.5MB)
 * �׽�Ʈ 4 ��	���� (�ð� �ʰ�)
 * �׽�Ʈ 5 ��	��� (39.62ms, 55.4MB)
 */
