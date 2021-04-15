package leetcode.contest.utils

class MultiSet<T : Comparable<T>>(private val sumBy: (T) -> Int = { 0 }) {

    private val valueList = ArrayList<T>()
    private val countMap = HashMap<T, Int>()
    var size = 0
    var sum = 0L
    val min: T
        get() = valueList.first()
    val max: T
        get() {
            return valueList.last()
        }

    fun add(value: T) {
        val index = valueList.binarySearch(value)
        if (index < 0) {
            valueList.add(-index - 1, value)
            countMap[value] = 1
        } else {
            countMap[value] = countMap[value]!! + 1
        }
        size++
        sum += sumBy(value)
    }

    fun remove(value: T): Boolean {
        if (value !in countMap.keys) return false
        val index = valueList.binarySearch(value)
        if (countMap[value] == 1) {
            countMap.remove(value)
            valueList.removeAt(index)
        } else {
            countMap[value] = countMap[value]!! - 1
        }
        size--
        sum -= sumBy(value)
        return true
    }

    fun popLeft(): T {
        return valueList.first().also {
            remove(it)
        }
    }

    fun popRight(): T {
        return valueList.last().also {
            remove(it)
        }
    }
}