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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> hm = new HashMap<>();
        Set<TreeNode> set = new HashSet<>();
        inorder(root, hm, null);
        List<Integer> res = new ArrayList<>();
        findAns(target, hm, set, k, res);
      /*  for(Map.Entry map: hm.entrySet()){
            TreeNode child = (TreeNode)map.getKey();
            TreeNode parent = (TreeNode)map.getValue();
            System.out.println(child.val+" "+((parent!=null) ? parent.val : "null"));
        }*/
        return res;
    }
    
    void inorder(TreeNode root, HashMap<TreeNode, TreeNode> hm, TreeNode parent){
        if(root == null) return;
        inorder(root.left, hm, root);
        hm.put(root, parent);
        inorder(root.right, hm ,root);
    }
    
    void findAns(TreeNode target, HashMap<TreeNode, TreeNode> hm, Set<TreeNode> set, int k, List<Integer> res){
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(target);
        set.add(target);
        set.add(null);
        int current_level = 0;
        while(!qu.isEmpty()){
            if(current_level == k){
                int size = qu.size();
                while(size-- > 0){
                    TreeNode temp = qu.poll();
                    res.add(temp.val);
                }
                break;
            }
            int size = qu.size();
            while(size-- > 0){
                TreeNode temp = qu.poll();
                if(!set.contains(temp.left) && temp.left != null) { qu.add(temp.left); set.add(temp.left); }
                if(!set.contains(temp.right) && temp.right != null) { qu.add(temp.right); set.add(temp.right); }
                TreeNode parent = hm.get(temp);
               // if(parent!=null) System.out.println(parent.val);
                if(!set.contains(parent) && parent!=null) { System.out.println(parent.val);qu.add(parent); set.add(parent); }
            }
        current_level++;
        }
    }
}