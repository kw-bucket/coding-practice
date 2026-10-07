package leetcode.linkedlist.easy

import leetcode.linkedlist.ListNode

/**
 * https://leetcode.com/problems/linked-list-cycle/
 *
 * Internally, pos is used to denote the index of the node that tail's next pointer is connected to.
 * Note that pos is not passed as a parameter.
 */
fun main() {
    val head = ListNode(3)
        .apply { next = ListNode(2)
            .apply { next = ListNode(0)
                .apply { next = ListNode(-4) }
            }
        }

    val output = hasCycle(head)

    println("Has LinkedList Cycle: $output")
}

private fun hasCycle(head: ListNode?): Boolean =
//    hasCycleBruteForce(head)
    hasCycleOptimized(head)

private fun hasCycleBruteForce(head: ListNode?): Boolean {
    val visited = hashSetOf<ListNode>()
    var current = head

    while (current != null) {
        if (visited.contains(current)) {
            return true
        }

        visited.add(current)
        current = current.next
    }

    return false
}

private fun hasCycleOptimized(head: ListNode?): Boolean {
    var slow = head
    var fast = head

    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next

        if (slow == fast) {
            return true
        }
    }

    return false
}
