TreeTraversal:
===============

Option 1:
==========

have 2 reference i holding to main and other to traversal and after all traversal return root.
so any changes made will updated to main (root)


        https://github.com/arunsadhasivam/datastructure/blob/master/code/linkedlist/RemoveNthNode/RemoveNth.java



        public ListNode removeNthFromEnd(ListNode a, int b) {
		ListNode result = new ListNode(-1);
		ListNode cur= result;
		int totcount =getCount(a);
		int count =0 ;
		while(a!=null){
			if(count == 0){
				 count ++;
				 a = a.next;
				 continue;
			}
			else if(b == totcount-count){
				 count ++;
				 a = a.next;
				 continue;
			 }
			 
			cur.next = new ListNode(a.val);
			a = a.next;
			cur = cur.next;
			count ++;
		}
		
		return result.next;
	}
	
	private int getCount(ListNode a){
		int count =0 ;
		while(a!=null){
			count ++;
			a = a.next;
		}
		return count;
	}


option 2:
=========

deep cloning

        private void traverse(TreeNode node)
            TreeNode root = new TreeNode(-1);
           int count ;
            while(node!=null){
               root.left = new Treenode(node.val);
               node = node.next;
            }


          return root;
        }



option 3:
=========
        
Recursion.
        
    https://github.com/arunsadhasivam/datastructure/blob/master/leetcode/Medium/PopulateNextRightPointer/Solution.java

        public void connect(TreeLinkNode root) {
                TreeLinkNode cur = root;

                if(cur==null){
                    return;
                }

               if(cur.left!=null){
                   cur.left.next = cur.right;
               }
                if(cur.right!=null){
                    cur.right.next = (cur.next)!=null ? cur.next.left : null;
                }
                connect(root.left);
                connect(root.right);
            }

