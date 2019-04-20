package leetcode.normal

class Solution139 {

    val hashSet = hashSetOf<String>()
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        println(s)
        if (s in hashSet) {
            return false
        }
        hashSet.add(s)
        if (s.isNotEmpty()) {
            var res = false
            wordDict.forEach {
                if (s.startsWith(it)) {
                    res = res || wordBreak(s.substringAfter(it), wordDict)
                }
            }
            if (!res) {
                return false
            }
        }

        return true
    }
}