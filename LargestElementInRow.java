/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int[] findValueMostElement(TreeNode root) {
        return find(root,new Stack(), new Stack());
        
    }
    
    public static int[] find(TreeNode root, Stack<TreeNode> st,Stack<TreeNode> st1){
        List<Integer> a = new ArrayList();
        int i = 0;
        if(root == null)
            return new int[0];
        st.push(root);
        a.add(root.val);
        while(!st.isEmpty()){
            while(!st.isEmpty()){
                TreeNode node = st.pop();
                if(node.left!= null)
                 st1.push(node.left);
                if(node.right!=null)
                st1.push(node.right);
                
            }
            //System.out.println(st1.peek().val);
            st = (Stack<TreeNode>)st1.clone();
            
             int max = -2147483648;
            while(!st1.isEmpty()){
                max = Math.max(max,st1.pop().val);
                
            }
            
           if(!st.isEmpty())
            a.add(max);
            i++;
           
        }
        
        int[] arr = new int[a.size()];
            for (int j = 0; j < arr.length; j++) {
            arr[j] = a.get(j);
        }
       
        return arr;
          
    }
}
