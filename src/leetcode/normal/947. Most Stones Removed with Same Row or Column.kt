package leetcode.normal

import leetcode.TypedUFS

class Solution947 {
    fun removeStones(stones: Array<IntArray>): Int {
        val max = stones.size
        val ufs = TypedUFS<IntArray>(max)
        for (i in 0 until max) {
            for (j in i + 1 until max) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    ufs.union(stones[i], stones[j])
                }
            }
        }

        var ans = 0
        val set = hashSetOf<Int>()
        stones.forEach {
            val root = ufs.typedFind(it)
            ans++
            set.add(root)
        }

        return ans - set.size
    }
}