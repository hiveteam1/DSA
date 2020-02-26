/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    ArrayList<Integer> list = null;
	public ArrayList<Integer> postorderTraversal(TreeNode a) {
	  list = new ArrayList<Integer>();
	
	  
	    postOrder(a);
	    return list;
	    
	}
	
	
	private void postOrder(TreeNode tree){
	    
	    TreeNode current = tree;
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    stack.push(current);
        
        while(!stack.isEmpty() ){
            TreeNode node = stack.peek();
            
            if(node.right==null && node.left ==null){
                
                TreeNode temp = stack.pop();
                list.add(temp.val); 
            }else{
                if(node.right!=null){
                    stack.push(node.right);
                    node.right =null;
                }
                
                if(node.left!=null){
                    stack.push(node.left);
                    node.left = null;
                }
                
            }
            
             
	    }
	    
	    
	}
	
}
