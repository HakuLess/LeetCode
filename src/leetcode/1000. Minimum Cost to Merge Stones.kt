package leetcode

fun main(args: Array<String>) {
    val s = Solution1000()
//    s.mergeStones(intArrayOf(3, 2, 4, 1), 3).print()
    s.mergeStones(intArrayOf(4, 6, 4, 7, 5), 2).print()
//    s.mergeStones(intArrayOf(3, 5, 1, 2, 6), 3).print()

}

class Solution1000 {

    var result = 0

    fun mergeStones(stones: IntArray, K: Int): Int {
        if (stones.size % (K - 1) != 1 && K != 2) {
            return -1
        }
        getValue(stones, K)
        return result
    }

    fun getValue(stones: IntArray, K: Int) {
        stones.print()
        if (stones.isEmpty() || stones.size == 1) {
            return
        }

        var min = Integer.MAX_VALUE
        var index = 0

        for (i in 0..stones.size - K) {
            var sum = 0
            for (j in 0 until K) {
                sum += stones[i + j]
            }

            if (sum < min) {
                index = i
                min = sum
            }
        }
        result += min

        // merge index i to i + k - 1
        val mergedStone = IntArray(stones.size - K + 1)
        for (i in 0 until mergedStone.size) {
            when {
                i < index -> mergedStone[i] = stones[i]
                i > index -> mergedStone[i] = stones[i + K - 1]
                else -> {
                    var sum = 0
                    for (j in 0 until K) {
                        sum += stones[index + j]
                    }
                    mergedStone[i] = sum
                }
            }
        }

        getValue(mergedStone, K)
    }
}