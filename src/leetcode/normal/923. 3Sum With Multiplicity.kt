package leetcode.normal

class Solution923 {

    fun threeSumMulti(A: IntArray, target: Int): Int {
        val MOD = 1000000007

        // Initializing as long saves us the trouble of
        // managing count[x] * count[y] * count[z] overflowing later.
        val count = LongArray(101)
        var uniq = 0
        for (x in A) {
            count[x]++
            if (count[x] == 1L)
                uniq++
        }

        val keys = IntArray(uniq)
        var t = 0
        for (i in 0..100)
            if (count[i] > 0)
                keys[t++] = i

        var ans: Long = 0
        // Now, let's do a 3sum on "keys", for i <= j <= k.
        // We will use count to add the correct contribution to ans.

        for (i in keys.indices) {
            val x = keys[i]
            val t = target - x
            var j = i
            var k = keys.size - 1
            while (j <= k) {
                val y = keys[j]
                val z = keys[k]
                when {
                    y + z < t -> j++
                    y + z > t -> k--
                    else -> {  // # x+y+z == T, now calc the size of the contribution
                        ans += if (j in (i + 1)..(k - 1)) {
                            count[x] * count[y] * count[z]
                        } else if (i == j && j < k) {
                            count[x] * (count[x] - 1) / 2 * count[z]
                        } else if (i < j && j == k) {
                            count[x] * count[y] * (count[y] - 1) / 2
                        } else {  // i == j == k
                            count[x] * (count[x] - 1) * (count[x] - 2) / 6
                        }

                        ans %= MOD.toLong()
                        j++
                        k--
                    }
                }
            }
        }

        return ans.toInt()
    }

//    fun threeSumMulti(A: IntArray, target: Int): Int {
//        val MOD = 1000000007
//        val map = hashMapOf<Int, Long>()
//        A.sort()
//        A.forEach {
//            var item = map.getOrDefault(it, 0)
//            item++
//            map[it] = item
//        }
//
//        var sum = 0L
//        threeSum(A, target).forEach { list ->
//            sum += if (list[0] == list[1] && list[1] == list[2]) {
//                map[list[0]]!! * (map[list[1]]!! - 1) * (map[list[2]]!! - 2) / 6
//            } else if (list[0] == list[1]) {
//                map[list[0]]!! * (map[list[1]]!! - 1) * (map[list[2]]!!) / 2
//            } else if (list[1] == list[2]) {
//                map[list[0]]!! * (map[list[1]]!! - 1) * (map[list[2]]!!) / 2
//            } else {
//                map[list[0]]!! * map[list[1]]!! * map[list[2]]!!
//            }
////            sum %= 1000000007
//            sum %= MOD.toLong()
//        }
//        return sum.toInt()
//    }
//
//    fun threeSum(nums: IntArray, target: Int): List<List<Int>> {
//        val result = hashSetOf<List<Int>>()
//        val sorted = nums.sorted()
//
//        sorted.forEachIndexed { index, value ->
//            var left = index + 1
//            var right = sorted.size - 1
//            while (left < right) {
//                when {
//                    sorted[left] + sorted[right] < target - value -> left++
//                    sorted[left] + sorted[right] == target - value -> {
//                        result.add(arrayListOf(sorted[left], sorted[right], value).sorted())
//                        left++
//                        right--
//                    }
//                    else -> right--
//                }
//            }
//        }
//
//        return result.toMutableList()
//    }
}