import java.io.*;
import java.util.*;

class Fibonacci {
	static long[][] count = new long[2][41];
	public static void fibo(int number) {
		if(number == 0) {
			count[0][number] = 1;
			return ;
		}
		else if(number == 1) {
			count[1][number] = 1;
			return ;
		}
		else if(count[0][number] == 0 || count[1][number] == 0) {
			fibo(number-1);
			fibo(number-2);
		}
		count[0][number] = count[0][number-1] + count[0][number-2];
		count[1][number] = count[1][number-1] + count[1][number-2];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			Arrays.fill(count[0], 0);
			Arrays.fill(count[1], 0);
			fibo(N);
			System.out.println(Long.toString(count[0][N]) + " " + Long.toString(count[1][N]));
		}
		 
	}
}
