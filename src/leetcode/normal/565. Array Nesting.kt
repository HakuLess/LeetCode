package leetcode.normal

class Solution565 {
    fun arrayNesting(nums: IntArray): Int {
        val seen = HashMap<Int, Int>()
        fun dfs(cur: Int, set: HashSet<Int>) {
            if (cur in seen) {
                return
            }
            if (cur in set) {
                set.forEach {
                    seen[it] = set.size
                }
            } else {
                set.add(cur)
                dfs(nums[cur], set)
            }
        }

        for (i in nums.indices) {
            dfs(i, hashSetOf<Int>())
        }
        return seen.values.max()!!
    }
}