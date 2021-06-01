package leetcode.contest.cur.leetcode.b49

import leetcode.contest.utils.print
import leetcode.contest.utils.swap
import kotlin.math.exp

fun main(args: Array<String>) {
    val s = Solution5707()
//    s.maxHappyGroups(4, intArrayOf(1, 3, 2, 5, 2, 2, 1, 6)).print()
//    s.maxHappyGroups(9, intArrayOf(1, 3, 2, 5, 2, 2, 1, 6, 5, 2, 2, 1, 6, 5, 2, 2, 1, 6, 5, 2, 2, 1, 6, 5, 2, 2, 1, 6)).print()
//    s.maxHappyGroups(4, intArrayOf(1, 3, 2, 2, 2, 6, 1, 5)).print()
//    s.maxHappyGroups(6, intArrayOf(369205928, 981877451, 947462486, 899465743, 737778942, 573732515, 520226542, 824581298, 571789442, 251943251, 70139785, 778962318, 43379662, 90924712, 142825931, 182207697, 178834435, 978165687)).print()
    s.maxHappyGroups(
        9,
        intArrayOf(
            589774097,
            268671484,
            581299831,
            471800878,
            914068537,
            577737427,
            486737562,
            11667847,
            424890855,
            897960632,
            363643230,
            184165630,
            276992201,
            521605648,
            26208430,
            851549284,
            694108424,
            447410911,
            612680991,
            20305507,
            66917338,
            742710889,
            381117621,
            622846033,
            148481438,
            637315521,
            134356262,
            148708729
        )
    ).print()
}

class Solution5707 {
    // 模拟退火 最大值
    fun maxHappyGroups(batchSize: Int, groups: IntArray): Int {
        // 只处理余数不对的
        val list = groups.filter { it % batchSize != 0 }.toIntArray()
        if (list.size <= 1) return groups.size

        val eps = 1e-5
        val delta = 0.98
        var ans = 0
        val n = list.size

        fun getSum(): Int {
            var cur = 0L
            var happy = 0
            list.forEach {
                if (cur % batchSize == 0L) {
                    happy++
                    cur = 0L
                }
                cur += it
            }
            ans = maxOf(ans, happy)
            return happy
        }

        fun sa() {
            var t = 1e6
            while (t > eps) {
                val x: Int = (0 until n).random()
                val y: Int = (0 until n).random()
                val last: Int = getSum()
                list.swap(x, y)
                val now: Int = getSum()
                val diff = now - last
                // 取最大值
                if (diff < 0 && exp(-1.0 * diff / t) * n > (0 until n).random()) {
                    // 还原操作
                    list.swap(x, y)
                }
                t *= delta
            }
        }
        repeat(10) {
            sa()
        }
        return ans + groups.size - n
    }

//    fun maxHappyGroups(batchSize: Int, groups: IntArray): Int {
//        var arr = ArrayList(groups.map { it % batchSize })
//        arr.sort()
//        var ans = 0
//        ans += arr.count { it % batchSize == 0 }
//        arr = ArrayList(arr.filter { it % batchSize != 0 })
//        var removed = arrayListOf<Int>()
//        for (i in 0 until arr.lastIndex) {
//            if (i in removed) continue
//            for (j in i + 1 until arr.size) {
//                if (j in removed) continue
//                if ((arr[i] + arr[j]) % batchSize == 0) {
//                    ans++
//                    println("$i, $j")
//                    removed.add(i)
//                    removed.add(j)
//                    break
//                }
//            }
//        }
//        removed.sortDescending()
//        for (i in removed) {
//            arr.removeAt(i)
//        }
//
//        val state = IntArray(10) { 0 }
//        val seen = HashMap<String, Int>()
//        fun dfs(state: IntArray, index: Int): Int {
//            val key = state.joinToString() + index
//            if (key in seen) {
//                return seen[key]!!
//            }
//            var ans = 0
//            if (index !in arr.indices) {
//                return state[0] + if ((1..state.lastIndex).all { state[it] == 0 }) 0 else 1
//            }
//            for (i in 0 until batchSize) {
//                val next0 = state.clone()
//                if (i == arr[index]) {
//                    next0[arr[index]]++
//                    ans = maxOf(ans, dfs(next0, index + 1))
//                }
//                val next1 = state.clone()
//                if (next1[i] > 0 && i != 0) {
//                    next1[i]--
//                    next1[(i + arr[index]) % batchSize]++
//                    ans = maxOf(ans, dfs(next1, index + 1))
//                }
//            }
//            return ans.also {
//                seen[key] = it
//            }
//        }
//        return ans + dfs(state, 0)
//    }
}