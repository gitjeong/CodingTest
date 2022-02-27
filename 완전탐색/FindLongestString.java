package 완전탐색;

import java.util.HashSet;

public class FindLongestString {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> current_set = new HashSet<Character>();
        int length = s.length();
        if(length == 0){
            return 0;
        }
        int current_longest = 1;
        int count;
        for(int idx=0; idx<length; idx++){
            count=0;
            current_set.removeAll(current_set);
            for(int j=idx; j<length; j++) {
                if (current_set.contains(s.charAt(j))) {
                    break;
                } else {
                    current_set.add(s.charAt(j));
                    count++;
                    if (count >= current_longest) {
                        current_longest = count;
                    }
                }
            }
        }
        return current_longest;
    }

    public static void main(String[] args){
        String s = "ab";
        FindLongestString f = new FindLongestString();
        int answer = f.lengthOfLongestSubstring(s);
        System.out.println(answer);
    }
}
