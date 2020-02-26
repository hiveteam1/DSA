/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        //L,Right,Root
        Stack<TreeNode> st= new Stack<TreeNode>();
        while(!st.isEmpty()|| A!=null){
           while(A!=null){
                st.push(A);
                A = A.left;
           }
           A = st.pop();
           result.add(A.val);
           if(A!=null){
                A = A.right;
           }
           
        }
        
        return result;
    }
}
