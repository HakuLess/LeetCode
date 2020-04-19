package leetcode.contest.cur.c185

class Solution5388 {
    fun reformat(s: String): String {
        var a = ArrayList<Char>()
        var b = ArrayList<Char>()
        s.forEach {
            if (it in '0'..'9') {
                a.add(it)
            } else {
                b.add(it)
            }
        }
        if (a.size > b.size + 1 || a.size < b.size - 1) {
            return ""
        }
        var i = 0
        var ans = ""
        var temp = arrayListOf<Char>()
        if (b.size > a.size) {
            temp = b
            b = a
            a = temp
        }
        if (a.size >= b.size) {
            for (i in 0 until a.size) {
                ans += a[i]
                if (i in b.indices)
                    ans += b[i]
            }
        }
        return ans
    }
}