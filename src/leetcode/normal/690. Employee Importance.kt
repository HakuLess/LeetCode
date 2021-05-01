package leetcode.normal

import java.util.*
import kotlin.collections.HashMap


// Definition for Employee.
class Employee {
    var id: Int = 0
    var importance: Int = 0
    var subordinates: List<Int> = listOf()
}

class Solution690 {
    fun getImportance(employees: List<Employee?>, id: Int): Int {
        val map = HashMap<Int, Pair<Int, List<Int>>>()
        employees.filterNotNull().forEach {
            map[it.id] = Pair(it.importance, it.subordinates)
        }
        val queue: Queue<Int> = LinkedList<Int>()
        queue.add(id)
        var ans = 0
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val item = queue.poll()
                ans += map[item]!!.first
                map[item]!!.second.forEach {
                    queue.offer(it)
                }
            }
        }
        return ans
    }
}