package leetcode.normal

class Solution412 {
    fun fizzBuzz(n: Int): List<String> {
        val result = arrayListOf<String>()
        for (i in 1..n) {
            var item = ""
            if (i % 3 == 0) {
                item += "Fizz"
            }
            if (i % 5 == 0) {
                item += "Buzz"
            }
            if (item.isEmpty()) {
                result.add(i.toString())
            } else {
                result.add(item)
            }
        }
        return result
    }
}