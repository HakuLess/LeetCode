package leetcode.normal

class Solution784 {
    fun letterCasePermutation(S: String): List<String> {
        val ans = arrayListOf<String>()
        val s = S.toLowerCase()
        ans.add(s)
        for (i in s.indices) {
            if (s[i] in 'a'..'z') {
                val append = ans.map {
                    val charArray = it.toCharArray()
                    charArray[i] = charArray[i].toUpperCase()
                    String(charArray)
                }
                ans.addAll(append)
            }
        }
        return ans
    }
}