class Solution {
    public String longestPalindrome(String s) {
        
        StringBuffer buffer = new StringBuffer();
        
        int len = s.length();
        if(len<=1)return s;
        String res = "";
        int maxlen =0;
        
        
        for(int i =0;i<len-1;i++){
          res =extendFromCenter(s,i,i,res);
          res = extendFromCenter(s,i,i+1,res);
        }
        
        return res;
    }
    
    
   
    
    private String extendFromCenter(String s,int i, int j,String res){
        int len = s.length();
        
        //abc
        while(i>=0 && j<len  && s.charAt(i) ==  s.charAt(j)){
            i--;
            j++;
        }
        String temp = s.substring(i+1,j);//since we reduced 1 in top
       if(temp.length()>res.length())return temp;
        
        return res;
    }
    
    
}
