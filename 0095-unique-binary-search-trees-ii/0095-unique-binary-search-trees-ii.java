/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return build(1, n);
    }

    private List<TreeNode> build(int lo, int hi) {
        List<TreeNode> result = new ArrayList<>();

        if (lo > hi) {
            // empty subtree - represented by a single null placeholder
            result.add(null);
            return result;
        }

        for (int rootVal = lo; rootVal <= hi; rootVal++) {
            List<TreeNode> leftSubtrees = build(lo, rootVal - 1);
            List<TreeNode> rightSubtrees = build(rootVal + 1, hi);

            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(rootVal);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }

        return result;
    }
}