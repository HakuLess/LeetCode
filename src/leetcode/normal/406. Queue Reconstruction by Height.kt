package leetcode.normal

class Solution406 {
    fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
        people.sortWith(compareBy({ -it[0] }, { it[1] }))
        val ans = ArrayList<IntArray>()
        for (i in people.indices) {
            ans.add(people[i][1], people[i])
        }
        return ans.toTypedArray()
    }
}