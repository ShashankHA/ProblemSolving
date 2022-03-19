import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/path-sum-ii/
 * Given the root of a binary tree and an integer targetSum, 
 return all root-to-leaf paths where the sum of the node values in the path equals targetSum. 
 Each path should be returned as a list of the node values, not node references.
  A root-to-leaf path is a path starting from the root and ending at any leaf node.
  A leaf is a node with no children.*/

public class PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		findPathSum(res, root, targetSum, new ArrayList<Integer>());
		return res;
	}

	public void findPathSum(List<List<Integer>> res, TreeNode root, int sum, List<Integer> current) {
		if (root == null)
			return;
		current.add(root.val);
		if (root.left == null && root.right == null) {
			if (sum - root.val == 0) {
				res.add(current);
			}
			return;
		}

		findPathSum(res, root.left, sum - root.val, new ArrayList<>(current));
		findPathSum(res, root.right, sum - root.val, new ArrayList<>(current));

	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
