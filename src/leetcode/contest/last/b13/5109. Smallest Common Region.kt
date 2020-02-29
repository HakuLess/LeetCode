package leetcode.contest.last.b13

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5109()
    s.findSmallestRegion(listOf(
            listOf("Earth", "North America", "South America"),
            listOf("North America", "United States", "Canada"),
            listOf("United States", "New York", "Boston"),
            listOf("Canada", "Ontario", "Quebec"),
            listOf("South America", "Brazil")
    ), "Quebec", "New York").print()
}

class Solution5109 {
    fun findSmallestRegion(regions: List<List<String>>, region1: String, region2: String): String {
        val parent = HashMap<String, String>()
        for (item in regions) {
            val top = item[0]
            item.forEachIndexed { index, s ->
                if (index != 0)
                    parent[s] = top
            }
        }

        val seen = HashSet<String>()
        var r1 = region1
        seen.add(r1)
        while (parent.containsKey(r1)) {
            r1 = parent[r1]!!
            seen.add(r1)
        }

        var r2 = region2
        while (!seen.contains(r2)) {
            r2 = parent[r2]!!
        }
        return r2
    }
}