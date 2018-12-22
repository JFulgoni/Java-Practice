import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class PathSum{
	public static boolean hasPathSum(TreeNode root, int sum){
		if(root == null){
			return false;
		}
		if(root.left == null && root.right == null){
			return sum == root.val;
		}
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}
	
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        findPathSum(root, sum, result, path);
        return result;
    }
    
    public void findPathSum(TreeNode root, int sum, List<List<Integer>> result, List<Integer> path){
    	if(root == null){
    		return;
    	}
    	path.add(root.val);
    	//root.val == sum && 
    	if(root.left == null && root.right == null){
    		List<Integer> temp = new ArrayList<Integer>(path);
    		//temp.add(root.val);
    		result.add(temp);  		
    	}
    	/*
    	 * this part is similar to the find path function from before
    	 * once we 
    	 */
    	findPathSum(root.left, sum - root.val, result, path);
    	findPathSum(root.right, sum - root.val, result, path);
    	path.remove(path.size() - 1);
    }
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(10);
		root.add(8);
		root.add(4);
		root.add(9);
		root.add(20);
		root.add(30);
		root.add(11);
		
		System.out.println(root.byLevel());
		if(hasPathSum(root, 10)){
			System.out.println("Yes");
		}
		else{
			System.out.println("No");
		}
		
		PathSum ps = new PathSum();
		System.out.println(ps.pathSum(root, 11));
	}
}
