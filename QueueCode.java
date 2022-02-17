import java.util.LinkedList; //import

class Printer{
	int priority;
	int index;
	public Printer(int p, int i) {
		this.priority = p;
		this.index = i;
	}
	
	@Override
	public String toString() {
		String ret = this.priority + ", " + this.index;
		return ret;
	}
	
}

public class QueueCode {
    public int solution(int[] priorities, int location) {
        LinkedList<Printer> q_before = new LinkedList<>();
        LinkedList<Printer> q_after = new LinkedList<>();
        int answer = 0;
        // Queue 삽입
        for(int i=0; i<priorities.length; i++)
            q_before.add(new Printer(priorities[i], i));
        // Queue 정렬
        while(q_before.isEmpty() == false){
            Printer first_element = q_before.poll();
            int i;
            for(i=0; i<q_before.size(); i++){
                if(first_element.priority < q_before.get(i).priority){
                    q_before.add(first_element);
                    break;
                }   
            }
            if(i == q_before.size())
                q_after.add(first_element);
        }
        // location에 있는 값 찾기
        for(int j=0; j<q_after.size(); j++){
            if(q_after.get(j).index == location)
                answer = j+1;
        }
        
        return answer;
    }
	public static void main(String[] args) {
		int[] priorities = new int[] {2, 1, 3, 2};
		int location = 2;
		QueueCode qc = new QueueCode();
		int a = qc.solution(priorities, location);
		System.out.println(a);
	}
}
