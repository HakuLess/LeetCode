package leetcode.normal

class Solution491 {
    fun findSubsequences(nums: IntArray): List<List<Int>> {
        val ans = HashSet<ArrayList<Int>>()
        nums.forEach {
            val tmp = ArrayList<ArrayList<Int>>()
            ans.forEach { list ->
                if (list.last() <= it) {
                    val cur = ArrayList(list)
                    cur.add(it)
                    tmp.add(cur)
                }
            }
            ans.addAll(tmp)
            ans.add(arrayListOf(it))
        }
        return ans.filter { it.size >= 2 }
    }
}