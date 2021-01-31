package leetcode.normal

import leetcode.contest.utils.TypedUFS

class Solution839 {
    fun numSimilarGroups(strs: Array<String>): Int {
        val n = strs.size
        val ufs = TypedUFS<String>(n)

        fun check(a: String, b: String): Boolean {
            var ans = 0
            for (i in a.indices) {
                if (a[i] != b[i]) {
                    ans++
                }
                if (ans > 2) return false
            }
            return ans == 2
        }

        for (i in 0 until n - 1) {
            for (j in i + 1 until n) {
                if (ufs.typedFind(strs[i]) != ufs.typedFind(strs[j])) {
                    if (check(strs[i], strs[j])) {
                        ufs.union(strs[i], strs[j])
                    }
                }
            }
        }

        val set = HashSet<Int>()
        strs.forEach {
            set.add(ufs.typedFind(it))
        }
        return set.size
    }
}