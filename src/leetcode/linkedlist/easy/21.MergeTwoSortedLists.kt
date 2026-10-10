package leetcode.linkedlist.easy

import leetcode.linkedlist.ListNode


/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 *
 * You have two sorted linked lists:
 * list1: 1 → 2 → 4
 * list2: 1 → 3 → 4
 *
 * Merge them into one sorted list:
 * 1 → 1 → 2 → 3 → 4 → 4
 *
 */
private fun main() {
    val list1 = ListNode(1).apply { next = ListNode(2).apply { next = ListNode(4) } }
    val list2 = ListNode(1).apply { next = ListNode(3).apply { next = ListNode(4) } }

    println(
        """
            Input:-
                List1: $list1
                List2: $list2
        """.trimIndent()
    )

    val output = mergeTwoLists(list1, list2)

    println("Merge Two Lists Solution: $output")
}

private fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    // Create a dummy node as a starting point for the merged list.
    // Now we have: dummy -> 0 -> null
    var dummy = ListNode(0)
    // `tail` point to the same node as `dummy`.
    var tail = dummy

    // Create mutable references to the current nodes in list1 and list2.
    var current1 = list1
    var current2 = list2
    // Compare the two lists while both current nodes are not null.
    while (current1 != null && current2 != null) {
        if (current1.`val` < current2.`val`) {
            // Set current1 as the next node of tail.
            tail.next = current1
            // Move current1 to the next node.
            current1 = current1.next
        } else {
            // Set current2 as the next node of tail.
            tail.next = current2
            // Move current2 to the next node.
            current2 = current2.next
        }
        // Move tail to the newly added node.
        tail = tail.next!!
    }
    // Attach the remaining nodes from the non-empty list.
    tail.next = current1 ?: current2

    return dummy.next

    /*
        Time complexity is O(n + m)
            Because each node from both lists is visited once.

        Space complexity is O(1)
            Because we don't create new nodes.
            We reuse the existing nodes and only use a few pointers.
     */
}
