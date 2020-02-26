/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
         ArrayList<Integer> list = new ArrayList<Integer>();
        while(!queue.isEmpty()){
            int len = queue.size();
            ArrayList<Integer> temp = new ArrayList<Integer>();
            
            for(int i =0;i<len;i++){
                TreeNode node = queue.poll();
                temp.add(node.val);
                if(node.left!=null){
                    queue.offer(node.left);
                }
                
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
           
             list = temp;
             System.out.println(list);
        }
        
        return list.get(0);
    }
}
