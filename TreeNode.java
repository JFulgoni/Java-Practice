package john_test;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
	public int val;
	public TreeNode left = null;
	public TreeNode right = null;
	public TreeNode(int x){
		this.val = x;
	}

	public void setLeft(TreeNode next){
		this.left = next;
	}

	public void setRight(TreeNode next){
		this.right = next;
	}

	/*
	 * got this from online somewhere
	 */
	public boolean add(int value) {
		if (value == this.val)
			return false;
		else if (value <this.val) {
			if (left == null) {
				left = new TreeNode(value);
				return true;
			} else
				return left.add(value);
		} else if (value > this.val) {
			if (right == null) {
				right = new TreeNode(value);
				return true;
			} else
				return right.add(value);
		}
		return false;
	}

	// this is all pure crap
	//	public String toString(){
	//		return treeString(this);
	//	}
	//	public String treeString(TreeNode root){
	//		if(root == null){
	//			return "";
	//		}
	//		return Integer.toString(root.val) + '\n' + treeString(root.left) + ',' + treeString(root.right);
	//	}

	/*
	 * got this from stack overflow as well
	 */
	public String byLevel(){
		Queue<TreeNode> level  = new LinkedList<TreeNode>();
		level.add(this);
		StringBuilder sb = new StringBuilder();
		while(!level.isEmpty()){
			TreeNode node = level.poll();
			sb.append(node.val + " ");
			//System.out.print(node.val + " ");
			if(node.left != null){
				level.add(node.left);
			}
			if(node.right!= null){
				level.add(node.right);
			}
		}
		return sb.toString();
	}
}
