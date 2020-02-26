Use stringTokenizer over Split
==============================


public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int lengthOfLastWord(final String A) {
        
        char ch[] = A.toCharArray();
        String word ="";
        StringTokenizer st = new StringTokenizer(A," ");
        while(st.hasMoreTokens()){
            
           String token = st.nextToken();
           word = token;
         }
 
        return  word.length();
    }
}


for input "Hello World  " it will return 1 only if below is used.

       String arr[] = A.split(" ");

it return 1 it consider last "" which follows after World. stringTokenizer takes care of identifying whether word is there
or not using st.hasMoreTokens().
