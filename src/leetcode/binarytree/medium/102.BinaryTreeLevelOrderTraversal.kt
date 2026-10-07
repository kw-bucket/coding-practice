package leetcode.binarytree.medium

import leetcode.binarytree.TreeNode

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/ (BFS / Queue)
 *
 * Given the root of a binary tree,
 * return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

 * We want:
 * [[3], [9, 20], [15, 7]]
 *
 * Meaning:
 * Level 1 → [3]
 * Level 2 → [9, 20]
 * Level 3 → [15, 7]
 */
private fun main() {
    val binaryTree = TreeNode(3).apply {
        left = TreeNode(9)
        right = TreeNode(20).apply {
            left = TreeNode(15)
            right = TreeNode(7)
        }
    }

    val output = levelOrder(binaryTree)

    println("Binary Tree Level Order: $output")
}

private fun levelOrder(root: TreeNode?): List<List<Int>> =
    levelOrderBFSQueue(root)
//    levelOrderDFSRecursive(root)

private fun levelOrderBFSQueue(root: TreeNode?): List<List<Int>> {
    // If tree is empty, return an empty list.
    if (root == null) return emptyList()
    // Store the result of each level.
    val result = mutableListOf<List<Int>>()
    // Use queue to process nodes level by level.
    val queue = ArrayDeque<TreeNode>()
    queue.add(root)

    while (!queue.isEmpty()) {
        // Store the values of the current level.
        val level = mutableListOf<Int>()
        // Get the number of nodes in the current level.
        repeat(queue.size) {
            // Remove first node from the queue.
            val node = queue.removeFirst()
            // Add the node's value to the current level.
            level.add(node.`val`)

            if (node.left != null) {
                // Add the left child to the queue.
                queue.add(node.left!!)
            }
            if (node.right != null) {
                // Add the right child to the queue.
                queue.add(node.right!!)
            }
        }
        // Add the current level to the result.
        result.add(level)
    }

    return result

    /*
        Time complexity is O(n)
            because we visit every node once.

        Space complexity is O(h)
            because we use queue to hold up data upto h nodes.
     */
}

private fun levelOrderDFSRecursive(root: TreeNode?): List<List<Int>> {
    val result = mutableListOf<MutableList<Int>>()

    fun level(current: TreeNode?, depth: Int) {
        // If the current node is null, stop.
        if (current == null) return
        // Create new list when reach a new level.
        if (depth == result.size) {
            result.add(mutableListOf())
        }
        // Add current node's value to its level.
        result[depth].add(current.`val`)

        // Visit the left subtree at the next level.
        level(current.left, depth + 1)
        // Visit the right subtree at the next level.
        level(current.right, depth + 1)
    }
    // Start from the root at depth 0.
    level(root, 0)

    return result
}
