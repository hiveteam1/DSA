import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShortestUniquePrefix {

	ShortestUniquePrefix() {

	}

	public ArrayList<String> prefix(ArrayList<String> a) {

		 ArrayList<String> list = new ArrayList<String>();
		 TrieNode node = new TrieNode();
		 
		 for(String s : a){
			 insert(node,s);
		 }
		 
		 for(String s : a){
			 list.add(lookup(node,s));
		 }
		 System.out.println("ShortestUniquePrefix.prefix()"+list);
		 
		 return list;
	}
	
	
	private void insert(TrieNode node, String word){
		TrieNode current  = node;
		
		for(int i = 0;i<word.length();i++){
			 char ch = word.charAt(i);
			 current= current.children.computeIfAbsent(ch, fn->new TrieNode());
			 
			 current.count++;
		}
	}
	
	private String lookup(TrieNode node, String word){
       TrieNode current= node;
		StringBuffer buffer = new StringBuffer();
		int i =0;
		char chArr[] = word.toCharArray();
		while(true){
			char ch =chArr[i++];
		 
			
			buffer.append(ch);
			  current = current.children.get(ch);
			if(current!=null && current.count==1){
				return buffer.toString();
			}
		}
			
	}

 

	public static void main(String args[]) {
		// String arr[] = { "zebra", "dog", "duck", "dove" };

		ArrayList<String> arr = new ArrayList<String>();
		arr.add("zebra");
		arr.add("dog");
		arr.add("duck");
		arr.add("dove");

		new ShortestUniquePrefix().prefix(arr);
	}
}

class TrieNode {
	int count = 0;
	Map<Character, TrieNode> children = new HashMap<>();
}
