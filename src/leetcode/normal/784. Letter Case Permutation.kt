package leetcode.normal

fun letterCasePermutation(S: String): List<String> {
    val ans = arrayListOf<String>()
    val s = S.toLowerCase()
    ans.add(s)
    for (i in 0 until s.length) {
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