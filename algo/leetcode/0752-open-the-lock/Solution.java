
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

	public int openLock(String[] deadends, String target) {
		HashSet<Integer> visisted = new HashSet<>();
		for (int i = 0; i < deadends.length; i++) {
			visisted.add(toInt(deadends[i]));
		}

		Queue<Integer> q = new LinkedList<>();
		int key = toInt("0000");
		q.offer(key);
		visisted.add(key);
		while (!q.isEmpty()) {
			int length = q.size();
			for (int i = 0; i < length; i++) {
				int val = 
			}
		}
	}

	private static int toInt(String s) {
		int v = 0;
		for (int i = s.length()-1; i >= 0; i--) {
			v = v*10 + (s.charAt(i)-'0');
		}
		return v;
	}

	public static void main(String[] args) {
				
	}
}
