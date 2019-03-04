package leetcode

class Solution {
    fun threeSumMulti(A: IntArray, target: Int): Int {
        val map = hashMapOf<Int, Int>()
        A.sort()
        A.forEach {
            var item = map.getOrDefault(it, 0)
            item++
            map[it] = item
        }

        var sum = 0
        threeSum(A, target).forEach { list ->
            var item = 1
            println()
            val temp = HashMap(map)
            list.forEach {
                println("$it ${temp[it]}")
                var value = temp[it]!!
                item *= value
                value--
                temp[it] = value
            }
            sum += item
            sum %= 1000000007
        }
        return sum
    }

    fun cal(array: List<Int>, map: HashMap<Int, Int>): Int {
        val leftMap = HashMap<Int, Int>()
        array.forEach {
            var item = leftMap.getOrDefault(it, 0)
            item++
            leftMap[it] = item
        }

        var ans: Long = 0
        leftMap.forEach { key, value ->
            val r = map[key]!!
            ans += C(r, value)
            ans %= 1000000007
        }
        return (ans % 1000000007).toInt()
    }

    private fun C(a: Int, b: Int): Int {
        var sum = 1
        for (i in a - b + 1..a) {
            sum *= i
        }
        for (i in 1..b) {
            sum /= i
        }
        return sum
    }

    fun threeSum(nums: IntArray, target: Int): List<List<Int>> {
        val result = hashSetOf<List<Int>>()
        val sorted = nums.sorted()

        sorted.forEachIndexed { index, value ->
            var left = index + 1
            var right = sorted.size - 1
            while (left < right) {
                when {
                    sorted[left] + sorted[right] < target - value -> left++
                    sorted[left] + sorted[right] == target - value -> {
                        result.add(arrayListOf(sorted[left], sorted[right], value).sorted())
                        left++
                        right--
                    }
                    else -> right--
                }
            }
        }

        return result.toMutableList()
    }
}