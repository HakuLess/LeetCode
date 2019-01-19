package leetcode

inline fun String.print() {
    println("String is " + this)
}

inline fun Int.print() {
    println("Int is " + this)
}

inline fun ListNode?.print() {
    var node = this
    while (node != null) {
        node.`val`.print()
        node = node.next
    }
}

inline fun List<List<Int>>.print() {
    this.forEach {
        it.forEach {
            print("$it, ")
        }
        println()
    }
}

inline fun IntArray.print() {
    this.forEach {
        print("$it, ")
    }
    println()
}

inline fun Boolean.print() {
    println(this)
}