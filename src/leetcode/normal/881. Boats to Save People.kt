package leetcode.normal

class Solution881 {

    fun numRescueBoats(people: IntArray, limit: Int): Int {
        people.sort()
        var left = 0
        var right = people.lastIndex
        var ans = 0
        while (left < right) {
            if (people[left] + people[right] > limit) {
                right--
                ans++
            } else if (people[left] + people[right] <= limit) {
                right--
                left++
                ans++
            }
        }
        if (right == left) {
            ans++
        }
        return ans
    }

}