package leetcode.contest.b04

class Solution1119 {
    fun removeVowels(S: String): String {
        return S.filter {
            it != 'a' && it != 'e' && it != 'i' && it != 'o' && it != 'u'
        }
    }
}