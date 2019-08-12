package leetcode.contest.last.b06

fun main(args: Array<String>) {
    val s = Solution1152()
    s.mostVisitedPattern(
            arrayOf("joe", "joe", "joe", "james", "james", "james", "james", "mary", "mary", "mary"),
            intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
            arrayOf("home", "about", "career", "home", "cart", "maps", "home", "home", "about", "career")
    ).forEach {
        print("$it, ")
    }
}

class Solution1152 {
    val t = ArrayList<String>()
    fun mostVisitedPattern(username: Array<String>, timestamp: IntArray, website: Array<String>): List<String> {
        val list = ArrayList<A>()
        for (i in 0..timestamp.lastIndex) {
            list.add(A(username[i], timestamp[i], website[i]))
        }
        list.sortBy {
            it.time
        }
        val map = hashMapOf<String, ArrayList<String>>()
        list.forEach {
            map[it.name] = map.getOrDefault(it.name, arrayListOf())
            map[it.name]!!.add(it.site)
        }
        val result = HashMap<String, HashSet<String>>()
        map.forEach { (name, u) ->
            t.clear()
            getList(arrayListOf(), u, 0)
            t.forEach {
                result[it] = result.getOrDefault(it, hashSetOf())
                result[it]!!.add(name)
            }
        }

//        result.forEach { t, u ->
//            println(t)
//            u.forEach {
//                print("$it, ")
//            }
//            println()
//        }

        var ans = Pair("", 0)
        result.forEach { str, set ->
            if (set.size > ans.second) {
                ans = Pair(str, set.size)
            } else if (set.size == ans.second && str < ans.first) {
                ans = Pair(str, set.size)
            }
        }
        return ans.first.split(",")
    }

    private fun getList(cur: ArrayList<String>, all: ArrayList<String>, index: Int) {
        if (cur.size == 3) {
            t.add(cur.joinToString(","))
            return
        }
        for (i in index..all.lastIndex) {
            cur.add(all[i])
            getList(cur, all, i + 1)
            cur.remove(all[i])
        }
    }
}

data class A(val name: String, val time: Int, val site: String)