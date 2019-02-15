package leetcode

fun main(args: Array<String>) {
    val c = MyCalendar()
    c.book(10, 20).print() // returns true
    c.book(15, 25).print() // returns false
    c.book(20, 30).print() // returns true
}

class MyCalendar() {

    val booked = ArrayList<Pair<Int, Int>>()

    fun book(start: Int, end: Int): Boolean {
        booked.forEach {
            if (it.second <= start || it.first >= end) {

            } else {
                return false
            }
        }
        booked.add(Pair(start, end))
        return true
    }

}