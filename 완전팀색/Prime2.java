import java.util.*;

public class Prime2 {
	
	static Set<Integer> ret = new HashSet<Integer>();
	public static void permutation(String numbers, int n, int r, int depth, boolean[] visited, String output) {
		if(depth == r) ret.add(Integer.parseInt(output));
		else {
			for(int i=0; i<numbers.length(); i++) {
				if(!visited[i]) {
					visited[i] = true;
					permutation(numbers, n, r, depth+1, visited, output + Character.toString(numbers.charAt(i)));
					visited[i] = false;
				}
			}
		}
	}
	
	
	public static boolean isPrime(int number) {
		boolean ret = true;
		if(number < 2) return false;
		else {
			for(int denom=2; denom<number; denom++) {
				if(number % denom == 0) return false;
			}
		}
		return ret;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int answer=0;
		String numbers = "011";
		
		// ¼ø¿­ ¸¸µé±â
		int n = numbers.length();
		boolean[] visited = new boolean[numbers.length()];
		Arrays.fill(visited, false);
		for(int r=1; r<=n; r++) {
			permutation(numbers, n, r, 0, visited, "");
		}
		
		for(int e : ret) {
			if(isPrime(e)) {
				answer += 1;
			}
		}
		
		
		System.out.println(answer);
		
		
	}

}
