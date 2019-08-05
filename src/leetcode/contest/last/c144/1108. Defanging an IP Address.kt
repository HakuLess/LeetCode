package leetcode.contest.last.c144

class Solution1106 {
    fun defangIPaddr(address: String): String {
        return address.replace(".", "[.]")
    }
}