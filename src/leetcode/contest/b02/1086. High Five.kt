package leetcode.contest.b02

fun main(args: Array<String>) {
    val a = Solution1086()
}

class Solution1086 {
    fun highFive(items: Array<IntArray>): Array<IntArray> {
        val list = Array<ArrayList<Int>>(1006) { arrayListOf() }
        items.forEach {
            list[it[0]].add(it[1])
        }

        list.forEach {
            it.sortDescending()
        }

        val ans = arrayListOf<IntArray>()

        list.forEachIndexed { index, arrayList ->
            if (arrayList.isNotEmpty()) {
                ans.add(intArrayOf(index, arrayList.filterIndexed { index, i ->
                    index < 5
                }.sum() / 5))
            }
        }

        return ans.toTypedArray()
    }
}