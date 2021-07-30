package leetcode.normal

class Solution884 {
    fun uncommonFromSentences(s1: String, s2: String): Array<String> {
        val hashMap = HashMap<String, Int>()
        s1.split(' ').forEach {
            hashMap[it] = hashMap.getOrDefault(it, 0) + 1
        }
        s2.split(' ').forEach {
            hashMap[it] = hashMap.getOrDefault(it, 0) + 1
        }
        val ans = arrayListOf<String>()
        hashMap.forEach { t, u ->
            if (u == 1) {
                ans.add(t)
            }
        }
        return ans.toTypedArray()
    }
}