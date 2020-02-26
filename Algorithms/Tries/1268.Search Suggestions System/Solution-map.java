class Solution {
    
   //Runtime: 73 ms, faster than 18.90% of Java online submissions for Search Suggestions System.
   //Memory Usage: 47.9 MB, less than 100.00% of Java online submissions for Search Suggestions System.
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        
        Trie trie = new Trie();
        
        for(String product : products){
            trie.addToTrie(product);
        }
        int n = searchWord.length();
        for(int i =1;i<=n;i++){
            String word = searchWord.substring(0,i);
            List<String> list = new ArrayList<String>();
        
            trie.getSearchList(word,list,3);
            
            if(list.size()>3){
               List<String> temp =  list.subList(0,3);
                 result.add( temp);
            }else{
                result.add( list);
            }
            
        }
        
        return result;
    }
}




class Trie{
    TrieNode root = new TrieNode();
    Trie(){
    }
    public void addToTrie(String word){
        TrieNode node = root;
        int n = word.length();
        for(int i=0;i<n;i++){
            char  ch = word.charAt(i);
            if(node.next.get(ch)==null){
                node.next.put(ch,new TrieNode());
            }
                node.next.get(ch).searchHistory.add(word);
            
            node =  node.next.get(ch);
        }
         
        //add word at this search for e.g mou search word add mouse
    }
    
    public void getSearchList(String word,List<String> resultList,int max){
        TrieNode node = root;
        int n = word.length();
        
        
        for(int i =0;i<n;i++){
            char ch = word.charAt(i);
            TrieNode temp = node.next.get(ch);
            //if it is null break not continue
            if(temp==null)break;
            if(i==n-1 ){
                resultList.addAll(temp.searchHistory);
            } 
            node = node.next.get(ch);
        }
    }
    
}


class TrieNode{
    
    HashMap<Character,TrieNode> next = new HashMap<>();
    TreeSet<String> searchHistory = new TreeSet<String>();
    
    TrieNode(){
        
    }
    
}
