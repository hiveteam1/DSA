/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 //Recursion causes timeout since it piles lot of stack causing timeout
 //without recursion below works!!!
public class Solution {
    ArrayList<Integer> list = new ArrayList<Integer>();
	public ArrayList<Integer> inorderTraversal(TreeNode a) {
	    
	    inorder(a);
	    
	    return list;
	}
	
	private void inorder(TreeNode tree){
	   Stack<TreeNode> stack = new Stack<TreeNode>();
	  
	  
	   while(!stack.isEmpty() || tree !=null){
	     
	       
	       if(tree!=null){
	         stack.push(tree);
	          tree = tree.left;
	        
	       }else{
	          TreeNode node =stack.pop();
	          int val = node.val;
	          list.add(val);
	           tree= node.right;
	       }
	       
	       
	   } 
	    
	  // list.add(mainNode);
	     
	    
	}
}
