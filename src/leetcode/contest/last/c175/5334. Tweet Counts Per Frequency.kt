package leetcode.contest.last.c175

import leetcode.contest.utils.print
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

fun main(args: Array<String>) {
    val s = TweetCounts()
    s.recordTweet("a", 0)
    s.recordTweet("a", 60)
    s.recordTweet("a", 10)
    s.getTweetCountsPerFrequency("minute","a",0,59).forEach {
        it.print()
    }
    s.getTweetCountsPerFrequency("minute","a",0,60).forEach {
        it.print()
    }
    s.recordTweet("a", 120)
    s.getTweetCountsPerFrequency("hour","a",0,210).forEach {
        it.print()
    }
}
class TweetCounts() {

    private val map = HashMap<String, PriorityQueue<Int>>()

    fun recordTweet(tweetName: String, time: Int) {
        val list = map.getOrDefault(tweetName, PriorityQueue())
        list.offer(time)
        map[tweetName] = list
    }

    fun getTweetCountsPerFrequency(freq: String, tweetName: String, startTime: Int, endTime: Int): List<Int> {
        val list = map.getOrDefault(tweetName, PriorityQueue())
        val d = when (freq) {
            "minute" -> 60
            "hour" -> 3600
            else -> 86400
        }

        list.print()
        val ans = ArrayList<Int>()
        var start = startTime
        var end = startTime
        while (start <= endTime) {
            end += d
            println("$start, $end, $endTime")
            val size = list.filter {
                it in start..minOf(end - 1, endTime)
            }.size
            ans.add(size)
            start = end
        }
        return ans
    }

}

/**
 * Your TweetCounts object will be instantiated and called as such:
 * var obj = TweetCounts()
 * obj.recordTweet(tweetName,time)
 * var param_2 = obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime)
 */