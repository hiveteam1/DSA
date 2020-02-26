class Solution {
    public boolean equationsPossible(String[] equations) {
        int parent[] = new int[26];
        UnionFind uf = new UnionFind(parent);
        
        for(String s : equations){
            char ch[] = s.toCharArray();
            if(ch[1]=='='){
                uf.union(ch[0]-'a',ch[3]-'a');
            }
        }
        
        for(String s : equations){
            char ch[] = s.toCharArray();
            //if both of equal and equation is ! then false;
            if(ch[1]=='!' && uf.find(ch[0]-'a') ==uf.find(ch[3]-'a')){
                return false;
            }
        }
        
        return true;
    }
}


class UnionFind{
    
    int parent[];
    
    UnionFind(int parent[]){
        this.parent= parent;
        int len = parent.length;
        for(int i=0;i<len;i++){
            this.parent[i]=i;
        }
    }
    
    
     void union(int x, int y){
        
        if(find(x)==find(y))return;
        
        parent[find(x)] =find(y);
    }
     int find(int x){
        while(x!=parent[x]){
            x =parent[x];
        }
        return x;
    }
}
