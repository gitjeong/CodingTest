import java.util.*;

class PermRes{
	private String perm_str;
	private boolean[] visited;
	public PermRes(String perm_str, int len) {
		this.perm_str = perm_str;
		this.visited = new boolean[len];
		//Arrays.fill(this.visited, false);;
	}
	// getter
	public String getString() {
		return this.perm_str;
	}
	public boolean[] getVisit() {
		return this.visited;
	}
	// setter
	public void setString(String perm_str) {
		this.perm_str = perm_str;
	}
	public void setVisited(boolean bool, int idx) {
		this.visited[idx] = bool;
	}
	@Override
	public String toString() {
		return this.perm_str;
	}
}

public class Prime {

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
	
	public static int factorial(int number) {
		if(number <2) return 1;
		else {
			return number*factorial(number-1);
		}
	}
	
	public static PermRes[] permutation(String num_string, int r) {
		int size = factorial(num_string.length()) / factorial(num_string.length() - r);
		PermRes[] ret = new PermRes[size];
		for(int i=0; i<size; i++) {
			ret[i] = new PermRes("", num_string.length());
		}
		if(r == 1) {
			for(int i=0; i<num_string.length(); i++) {
				ret[i].setString(Character.toString(num_string.charAt(i)));
				ret[i].setVisited(true, i);
			}
			return ret;
		}
		else {
			int idx = 0;
			PermRes[] perm_before = permutation(num_string, r-1);
			for(PermRes pb : perm_before) {
				boolean[] visited = pb.getVisit();
				for(int i=0; i<num_string.length(); i++) {
					if(!visited[i]) {
						String temp = pb.getString() + num_string.charAt(i);
						ret[idx].setString(temp);
						ret[idx].setVisited(true, i);
						//
						for(boolean e : ret[idx].getVisit()) System.out.println(e);
						System.out.println(idx);
						System.out.println("==========");
						//
						idx++;
					}
				}
			}
			
			return ret;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int answer=0;
		String num_str = "abcd";
		PermRes[] res = permutation(num_str, 3);
		for(PermRes e : res) {
			System.out.println(e);
		}
		
		
	}

}
