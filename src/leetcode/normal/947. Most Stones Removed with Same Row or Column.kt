package leetcode.normal

import leetcode.contest.utils.TypedUFS

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

        val set = hashSetOf<Int>()
        stones.forEach {
            val root = ufs.typedFind(it)
            set.add(root)
        }

        return stones.size - set.size
    }
}