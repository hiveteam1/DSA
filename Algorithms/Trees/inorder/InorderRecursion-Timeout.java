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
    ArrayList<Integer> list = new ArrayList<Integer>();
	public ArrayList<Integer> inorderTraversal(TreeNode a) {
	    
	    inorder(a);
	    
	    return list;
	}
	
	private void inorder(TreeNode node){
	   if(node==null){
	       return ; 
	   }
	    
	    inorder(node.left);
	    
	    
	    int val = node.val;
	    if(!list.contains(val)){
	      list.add(node.val);
	    }
	    
	    
	    inorder(node.right);
	    val = node.val;
	    
	    if(!list.contains(val)){
	      list.add(node.val);
	    }
	     
	    
	}
}
