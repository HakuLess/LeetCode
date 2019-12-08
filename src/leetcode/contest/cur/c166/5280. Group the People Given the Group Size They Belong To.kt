package leetcode.contest.cur.c166

fun main(args: Array<String>) {
    val s = Solution5280()

}
class Solution5280 {
    fun groupThePeople(groupSizes: IntArray): List<List<Int>> {
        val hashMap = HashMap<Int, ArrayList<Int>>()
        val ans = ArrayList<List<Int>>()
        groupSizes.forEachIndexed { index: Int, i: Int ->
            if (i !in hashMap.keys) {
                val item = ArrayList<Int>()
                hashMap[i] = item
            }
            hashMap[i]!!.add(index)
            if (hashMap[i]!!.size == i) {
                ans.add(hashMap[i]!!)
                hashMap.remove(i)
            }
        }
        return ans
    }
}