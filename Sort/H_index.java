package Sort;
import java.util.*;

public class H_index {
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);
        int num_citations = citations.length;
        for(int idx=0; idx<num_citations; idx++){
            if(citations[num_citations-1-idx] <= idx){
                answer = idx;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        int[] citations = new int[]{3, 0, 6, 1, 5};
        H_index h = new H_index();
        int answer = h.solution(citations);
        System.out.println(answer);

    }
}
