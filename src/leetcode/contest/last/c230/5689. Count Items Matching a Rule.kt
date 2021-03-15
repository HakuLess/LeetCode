package leetcode.contest.last.c230

class Solution5689 {
    fun countMatches(items: List<List<String>>, ruleKey: String, ruleValue: String): Int {
        return items.count {
            when (ruleKey) {
                "type" -> it[0] == ruleValue
                "color" -> it[1] == ruleValue
                else -> it[2] == ruleValue
            }
        }
    }
}