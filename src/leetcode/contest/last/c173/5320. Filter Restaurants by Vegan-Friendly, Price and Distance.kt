package leetcode.contest.last.c173

class Solution5320 {
    fun filterRestaurants(restaurants: Array<IntArray>, veganFriendly: Int, maxPrice: Int, maxDistance: Int): List<Int> {
        return restaurants.filter {
            it[3] <= maxPrice && it[4] <= maxDistance && (veganFriendly == 0 || it[2] == 1)
        }.sortedWith(compareBy ({ -it[1] }, { -it[0] })).map {
            it[0]
        }
    }
}