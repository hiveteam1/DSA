class Trie {

    /** Initialize your data structure here. */
    TrieNode root = new TrieNode();
    
    public Trie() {
        
       
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode temp = root;
        
         
        char ch[] = word.toCharArray();
             
        for(int i =0;i<word.length();i++){
            int index = word.charAt(i)-'a';
            if(temp.node[index]==null)
            temp.node[ index] = new TrieNode();
            
            temp = temp.node[index];
        }
        temp.word = word;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
         
        
        TrieNode temp = root;
        char ch[] = word.toCharArray();
        int count = 0;
        for(int i =0;i<word.length();i++){
            
            int index = word.charAt(i)-'a';
            if(temp.node[index]==null) return false;
            temp = temp.node[index];
            
        }
         
        return  temp.word.equals(word) ? true: false;
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        
        
        TrieNode temp = root;
        char ch[] = prefix.toCharArray();
        int count = 0;
        for(int i =0;i<prefix.length();i++){
            
            int index = prefix.charAt(i)-'a';
             if(temp.node[index]==null) return false;
            
              temp = temp.node[index];
        }
         
        return true;
        
    }
    
    
    
       
     static class TrieNode{
        
        TrieNode[] node = new TrieNode[26];
        String word ="";
         
        TrieNode(){
            
        }
    }  
          
    
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
