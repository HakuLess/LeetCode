package leetcode

class Solution49 {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val hashMap = hashMapOf<Int, ArrayList<String>>()
        strs.forEach {
            val key = geneKey(it)
            hashMap[key] = hashMap.getOrDefault(key, arrayListOf())
            hashMap[key]!!.add(it)
        }

        val ans = arrayListOf<List<String>>()
        hashMap.forEach { t, u ->
            ans.add(u)
        }
        return ans
    }

    fun geneKey(it: String): Int {
        val data = it.toCharArray()
        data.sort()
        var sum = 0
        var step = 1
        data.forEach {
            sum += (it - 'a') * step
            step *= 30
        }
        return sum
    }
}
