package leetcode.normal

class Solution859 {
    fun buddyStrings(a: String, b: String): Boolean {
        if (a == b) return a.any { b.count { c -> c == it } >= 2 }
        if (a.length != b.length) {
            return false
        }
        val c = arrayListOf<Int>()
        for (i in a.indices) {
            if (a[i] != b[i]) {
                c.add(i)
            }
        }
        if (c.size != 2) return false
        val arr = a.toCharArray()
        arr[c[0]] = a[c[1]]
        arr[c[1]] = a[c[0]]
        return b == arr.joinToString("")
    }
}