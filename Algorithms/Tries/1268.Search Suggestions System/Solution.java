class Solution {
    
    //Runtime: 55 ms, faster than 25.12% of Java online submissions for Search Suggestions System.
//Memory Usage: 48.1 MB, less than 100.00% of Java online submissions for Search Suggestions System.
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
            int  index = word.charAt(i)-'a';
            if(node.next[index]==null){
                node.next[index] = new TrieNode();
            }
                node.next[index].searchHistory.add(word);
            
            node =  node.next[index];
        }
         
        //add word at this search for e.g mou search word add mouse
    }
    
    public void getSearchList(String word,List<String> resultList,int max){
        TrieNode node = root;
        int n = word.length();
        
        
        for(int i =0;i<n;i++){
            int index = word.charAt(i)-'a';
            TrieNode temp = node.next[index];
            //if it is null break not continue
            if(temp==null)break;
            if(i==n-1 ){
                resultList.addAll(temp.searchHistory);
            } 
            node = node.next[index];
        }
    }
    
}


class TrieNode{
    
    TrieNode next[] = new TrieNode[26];
    TreeSet<String> searchHistory = new TreeSet<String>();
    
    TrieNode(){
        
    }
    
}
