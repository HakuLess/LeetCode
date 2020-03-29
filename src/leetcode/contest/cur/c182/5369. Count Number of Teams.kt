package leetcode.contest.cur.c182

class Solution5369 {
    fun numTeams(rating: IntArray): Int {
        var ans = 0
        for (i in 0 until rating.size - 2) {
            for (j in i + 1 until rating.size - 1) {
                for (k in j + 1 until rating.size) {
                    if (rating[j] > rating[i]) {
                        if (rating[k] > rating[j]) {
                            ans++
                        }
                    }

                    if (rating[j] < rating[i]) {
                        if (rating[k] < rating[j]) {
                            ans++
                        }
                    }
                }
            }
        }
        return ans
    }
}