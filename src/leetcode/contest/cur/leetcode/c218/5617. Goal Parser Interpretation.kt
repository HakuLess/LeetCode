package leetcode.contest.cur.leetcode.c218

class Solution5617 {
    fun interpret(command: String): String {
        return command.replace("(al)", "al").replace("()", "o")
    }
}