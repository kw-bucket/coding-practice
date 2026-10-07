package leetcode.linkedlist

internal class ListNode(var `val`: Int) {
    var next: ListNode? = null

    override fun toString(): String {
        val result = StringBuilder()
        var current: ListNode? = this

        while (current != null) {
            result.append(current.`val`)
            if (current.next != null) {
                result.append(" -> ")
            }
            current = current.next
        }

        return result.toString()
    }
}
