package leetcode.normal

import kotlin.collections.ArrayList

class Solution819 {
    fun mostCommonWord(paragraph: String, banned: Array<String>): String {
        val l = ArrayList<Pair<String, Int>>()
        val map = hashMapOf<String, Int>()
        String(paragraph.toLowerCase()
            .replace(',', ' ')
            .replace('.', ' ')
            .toCharArray().filter {
                it in 'a'..'z' || it == ' '
            }.toCharArray()
        ).split(' ').forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }
        map.forEach { t, u ->
            if (t.isNotBlank() && t !in banned) {
                l.add(Pair(t, u))
            }
        }
        return l.sortedBy { -it.second }[0].first
    }
}