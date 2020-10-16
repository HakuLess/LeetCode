package leetcode.normal

import leetcode.contest.utils.ListNode
import leetcode.contest.utils.TypedUFS
import leetcode.contest.utils.printInt

class Solution817 {
    fun numComponents(head: ListNode?, G: IntArray): Int {
        val map = HashMap<Int, Int>()
        var cur = head
        while (cur?.next != null) {
            map[cur.`val`] = cur.next!!.`val`
            cur = cur.next
        }
        map.printInt()

        val ufs = TypedUFS<Int>(G.size)
        for (i in G.indices) {
            val it = map[G[i]]
            if (it != null && G.contains(it)) {
                ufs.union(G[i], it)
            }
        }

        val ans = HashMap<Int, Int>()
        G.forEach {
            val key = ufs.typedFind(it)
            ans[key] = ans.getOrDefault(key, 0) + 1
        }
        return ans.keys.count()
    }
}