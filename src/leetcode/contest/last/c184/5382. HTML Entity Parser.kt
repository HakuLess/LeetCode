package leetcode.contest.last.c184

class Solution5382 {
    fun entityParser(text: String): String {
        val map = HashMap<String, String>()
        map["&quot;"] = "\""
        map["&apos;"] = "'"
        map["&amp;"] = "&"
        map["&gt;"] = ">"
        map["&lt;"] = "<"
        map["&frasl;"] = "/"

        var ans = text
        map.forEach { s, s2 ->
            ans = ans.replace(s, s2)
        }
        return ans
    }
}