package leetcode.contest.last.c237

class Solution5734 {
    fun checkIfPangram(sentence: String): Boolean {
        return sentence.toCharArray().toSet().size == 26
    }
}