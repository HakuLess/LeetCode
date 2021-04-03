package leetcode.contest.cur.leetcode.b49

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5707()
//    s.maxHappyGroups(4, intArrayOf(1, 3, 2, 5, 2, 2, 1, 6)).print()
//    s.maxHappyGroups(9, intArrayOf(1, 3, 2, 5, 2, 2, 1, 6, 5, 2, 2, 1, 6, 5, 2, 2, 1, 6, 5, 2, 2, 1, 6, 5, 2, 2, 1, 6)).print()
//    s.maxHappyGroups(4, intArrayOf(1, 3, 2, 2, 2, 6, 1, 5)).print()
//    s.maxHappyGroups(6, intArrayOf(369205928, 981877451, 947462486, 899465743, 737778942, 573732515, 520226542, 824581298, 571789442, 251943251, 70139785, 778962318, 43379662, 90924712, 142825931, 182207697, 178834435, 978165687)).print()
    s.maxHappyGroups(9, intArrayOf(589774097, 268671484, 581299831, 471800878, 914068537, 577737427, 486737562, 11667847, 424890855, 897960632, 363643230, 184165630, 276992201, 521605648, 26208430, 851549284, 694108424, 447410911, 612680991, 20305507, 66917338, 742710889, 381117621, 622846033, 148481438, 637315521, 134356262, 148708729)).print()
}

class Solution5707 {
    fun maxHappyGroups(batchSize: Int, groups: IntArray): Int {
        var arr = ArrayList(groups.map { it % batchSize })
        arr.sort()
        var ans = 0
        ans += arr.count { it % batchSize == 0 }
        arr = ArrayList(arr.filter { it % batchSize != 0 })
        var removed = arrayListOf<Int>()
        for (i in 0 until arr.lastIndex) {
            if (i in removed) continue
            for (j in i + 1 until arr.size) {
                if (j in removed) continue
                if ((arr[i] + arr[j]) % batchSize == 0) {
                    ans++
                    println("$i, $j")
                    removed.add(i)
                    removed.add(j)
                    break
                }
            }
        }
        removed.sortDescending()
        for (i in removed) {
            arr.removeAt(i)
        }

        val state = IntArray(10) { 0 }
        val seen = HashMap<String, Int>()
        fun dfs(state: IntArray, index: Int): Int {
            val key = state.joinToString() + index
            if (key in seen) {
                return seen[key]!!
            }
            var ans = 0
            if (index !in arr.indices) {
                return state[0] + if ((1..state.lastIndex).all { state[it] == 0 }) 0 else 1
            }
            for (i in 0 until batchSize) {
                val next0 = state.clone()
                if (i == arr[index]) {
                    next0[arr[index]]++
                    ans = maxOf(ans, dfs(next0, index + 1))
                }
                val next1 = state.clone()
                if (next1[i] > 0 && i != 0) {
                    next1[i]--
                    next1[(i + arr[index]) % batchSize]++
                    ans = maxOf(ans, dfs(next1, index + 1))
                }
            }
            return ans.also {
                seen[key] = it
            }
        }
        return ans + dfs(state, 0)
    }
}