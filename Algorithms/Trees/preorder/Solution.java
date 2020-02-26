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
	public ArrayList<Integer> preorderTraversal(TreeNode a) {
	    
	    
	    list = new ArrayList<Integer>();
	    
	    preorder(a);
	    
	    return list;
	}
	
	
	private void preorder(TreeNode tree){
	    
 	     
	    Stack <TreeNode> stack=new Stack<>();
	    stack.push(tree);
	  
	    while(!stack.empty()){
	        TreeNode node=stack.pop();
	        list.add( node.val);
	        if(node.right!=null){
	            stack.push(node.right);
	        }
	        if(node.left!=null){
	            stack.push(node.left);
	        }
	    
	   }
	}
}
