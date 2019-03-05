package leetcode

class Solution {
    fun reverseVowels(s: String): String {
        val vowels = charArrayOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
        var start = 0
        var end = s.lastIndex
        val ans = s.toCharArray()

        while (start <= end) {
            when {
                s[start] !in vowels -> {
                    start++
                }
                s[end] !in vowels -> {
                    end--
                }
                else -> {
                    ans[start] = s[end]
                    ans[end] = s[start]
                    start++
                    end--
                }
            }
        }

        return String(ans)
    }
}