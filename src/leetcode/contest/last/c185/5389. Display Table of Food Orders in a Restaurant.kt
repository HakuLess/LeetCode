package leetcode.contest.last.c185

fun main(args: Array<String>) {
    val s = Solution5389()
}

class Solution5389 {
    fun displayTable(orders: List<List<String>>): List<List<String>> {

        val map = HashMap<Int, ArrayList<String>>()
        val set = arrayListOf<String>()
        val key = arrayListOf<Int>()
        orders.forEach {
            val t = it[1].toInt()
            map[t] = map.getOrDefault(t, arrayListOf())
            map[t]!!.add(it[2])
            set.add(it[2])
            key.add(t)
        }
        val menu = set.distinct().sorted()
        val top = arrayListOf<String>()
        top.add("Table")
        menu.forEach { top.add(it) }

        val ans = ArrayList<ArrayList<String>>()
        ans.add(top)

        key.sort()
        val k = key.distinct()
        k.forEach {
            val list = arrayListOf<String>()
            list.add(it.toString())
            val m = map[it]
            menu.forEach {
                list.add(m!!.count { str->
                    str == it
                }.toString())
            }
            ans.add(list)
        }
        return ans
    }
}