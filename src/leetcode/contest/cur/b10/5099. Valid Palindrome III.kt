package leetcode.contest.cur.b10

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5099()
    s.isValidPalindrome("abcdeca", 2).print()
    s.isValidPalindrome("fcgihcgeadfehgiabegbiahbeadbiafgcfchbcacedbificicihibaeehbffeidiaiighceegbfdggggcfaiibefbgeegbcgeadcfdfegfghebcfceiabiagehhibiheddbcgdebdcfegaiahibcfhheggbheebfdahgcfcahafecfehgcgdabbghddeadecidicchfgicbdbecibddfcgbiadiffcifiggigdeedbiiihfgehhdegcaffaggiidiifgfigfiaiicadceefbhicfhbcachacaeiefdcchegfbifhaeafdehicfgbecahidgdagigbhiffhcccdhfdbd", 216).print()
}

class Solution5099 {
    val set = hashSetOf<Triple<Int, Int, Int>>()
    fun isValidPalindrome(s: String, k: Int): Boolean {
        return helper(s, k, 0, s.lastIndex)
    }

    private fun helper(s: String, k: Int, left: Int, right: Int): Boolean {
        val item = Triple(k, left, right)
        if (item in set) {
            return false
        }
        set.add(item)
//        println("$k, $left, $right")

        if (k < 0) {
            return false
        }
        var l = left
        var r = right
        while (s[l] == s[r] && l < r) {
            l++
            r--
        }
        if (l >= r) {
            return true
        } else {
            return helper(s, k - 1, l + 1, r) || helper(s, k - 1, l, r - 1)
        }
    }
}