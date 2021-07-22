package leetcode.contest.last.b30

class Solution5177 {
    fun reformatDate(date: String): String {
        val m = arrayOf("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec")
        return "${date.takeLast(4)}-${
            (m.indexOf(date.split(" ")[1]) + 1).toString().padStart(2, '0')
        }-${date.takeWhile { it !in '0'..'9' }.padStart(2, '0')}"
    }
}