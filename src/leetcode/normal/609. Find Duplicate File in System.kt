package leetcode.normal

fun main(args: Array<String>) {
    val s = Solution609()
    s.findDuplicate(
            arrayOf(
                    "root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)",
                    "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"
            )
    )
}

class Solution609 {
    fun findDuplicate(paths: Array<String>): List<List<String>> {
        val map = hashMapOf<String, ArrayList<String>>()
        paths.forEach {
            val s = it.split(' ')
            for (i in 1..s.lastIndex) {
                println(s[i])
                val t = s[i].split("(")
                map[t[1]] = map.getOrDefault(t[1], arrayListOf())
                map[t[1]]?.add(s[0] + "/" + t[0])
            }
        }
        val ans = arrayListOf<List<String>>()
        map.forEach { (t, u) ->
            println("$t, $u")
            if (u.size > 1) {
                ans.add(u)
            }
        }
        return ans
    }
}