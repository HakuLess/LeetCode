package leetcode.normal

class MinStack() {

    /** initialize your data structure here. */
    private val data = arrayListOf<Int>()

    private val minList = arrayListOf<Int>()

    fun push(x: Int) {
        data.add(x)
        if (minList.isEmpty() || x <= minList.last()) {
            minList.add(x)
        }
    }

    fun pop() {
        val value = data[data.size - 1]
        if (value == minList.last()) {
            minList.removeAt(minList.size - 1)
        }
        data.removeAt(data.size - 1)
    }

    fun top(): Int {
        return data.last()
    }

    fun getMin(): Int {
        return minList.last()
    }

}