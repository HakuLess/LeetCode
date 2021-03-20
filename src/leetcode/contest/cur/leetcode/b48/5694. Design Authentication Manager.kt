package leetcode.contest.cur.leetcode.b48

class AuthenticationManager(val timeToLive: Int) {

    val map = HashMap<String, Int>()

    fun generate(tokenId: String, currentTime: Int) {
        map[tokenId] = currentTime
    }

    fun renew(tokenId: String, currentTime: Int) {
        if (tokenId in map.keys && map[tokenId]!! + timeToLive > currentTime) {
            map[tokenId] = currentTime
        } else {
            map.remove(tokenId)
        }
        println(map.size)
    }

    fun countUnexpiredTokens(currentTime: Int): Int {
        return map.filter {
            it.value + timeToLive > currentTime
        }.size
    }

}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * var obj = AuthenticationManager(timeToLive)
 * obj.generate(tokenId,currentTime)
 * obj.renew(tokenId,currentTime)
 * var param_3 = obj.countUnexpiredTokens(currentTime)
 */