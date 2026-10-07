package leetcode.binarytree.easy

import leetcode.binarytree.TreeNode
import kotlin.math.max

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/ (DFS / Recursion)
 *
 * We want to find the maximum depth, meaning:
 *   The number of nodes from the root to the deepest leaf.
 */
fun main() {
    val binaryTree = TreeNode(3).apply {
        left = TreeNode(9)
        right = TreeNode(20).apply {
            left = TreeNode(15)
            right = TreeNode(7)
        }
    }

    val output = maxDepth(binaryTree)

    println("Max Depth of Binary Tree: $output")
}

private fun maxDepth(root: TreeNode?): Int {
    // If the current node is null, return 0.
    if (root == null) return 0

    // Add 1 for the current node and take the deeper subtree.
    return 1 + max(maxDepth(root.left), maxDepth(root.right))

    /*
        Time complexity is O(n)
            because we visit every node once.

        Space complexity is O(h)
            because the recursion stack can hold up to h nodes,
            where h is the height of the tree.
     */
}
