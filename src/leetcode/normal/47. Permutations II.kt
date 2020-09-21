package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution47()
    s.permuteUnique(intArrayOf(1, 2, 3, 2)).print()
}

class Solution47 {
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        nums.sort()
        val res = ArrayList<List<Int>>()
        val visited = IntArray(nums.size)
        fun dfs(nums: IntArray, tmp: ArrayList<Int>, visited: IntArray) {
            if (tmp.size == nums.size) {
                res.add(ArrayList(tmp))
                return
            }
            for (i in nums.indices) {
                if (visited[i] == 1) continue
                if (i > 0 && nums[i - 1] == nums[i] && visited[i - 1] == 0) {
                    continue
                }
                visited[i] = 1
                tmp.add(nums[i])
                dfs(nums, tmp, visited)
                visited[i] = 0
                tmp.removeAt(tmp.size - 1)
            }
        }
        dfs(nums, ArrayList(), visited)
        return res
    }
}