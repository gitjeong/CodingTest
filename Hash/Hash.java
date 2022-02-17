import java.util.HashMap;

class HashFuck {
	private String[] participant;
	private String[] completion;
	
	public HashFuck(String[] participant, String[] completion) {
		this.participant = participant;
		this.completion = completion;
	}
	public String findLoser() {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		for(String p : participant) {
			if(hm.containsKey(p) == false)
				hm.put(p, 1);
			else
				hm.put(p, hm.get(p) + 1);
		}
		for(String c : completion) {
			if(hm.get(c) > 1) 
				hm.put(c, hm.get(c) -1);
			else
				hm.remove(c);
		}
		String loser = (String)hm.keySet().toArray()[0];
		return loser;
	}
	
}

class Hash{
	public static void main(String[] args) {
		String[] participant = new String[]{"aa", "aa", "bb", "bb", "cc"};
		String[] completion = new String[] {"aa", "aa", "bb", "cc"};
		HashFuck hash = new HashFuck(participant, completion);
		String answer = hash.findLoser();
		System.out.println(answer);
	}
}
