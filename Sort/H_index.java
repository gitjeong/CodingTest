package Sort;
import java.util.*;

public class H_index {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        // 뒤에서부터 하나씩 논문들을 카운트한다.
        int num_citations = citations.length;
        int idx = 0;
        for(; idx<num_citations; idx++){
            if(citations[num_citations-1-idx] <= idx){
                break;
            }
        }

        return idx;
    }

    public static void main(String[] args){
        int[] citations = new int[]{3, 0, 6, 1, 5};
        H_index h = new H_index();
        int answer = h.solution(citations);
        System.out.println(answer);

    }
}
