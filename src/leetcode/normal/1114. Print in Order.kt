package leetcode.normal

import java.util.concurrent.CountDownLatch
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.thread

fun main(args: Array<String>) {
    val max = 1000
    val s = Foo()
    thread {
        for (i in 0..max)
            s.first()
    }
    thread {
        for (i in 0..max)
            s.second()
    }
    thread {
        for (i in 0..max)
            s.third()
    }
}

class Foo {
    var cur = 1

    @Synchronized
    fun first() {
        while (cur != 1) {
            (this as Object).wait()
        }
        println("first")
        cur = 2
        (this as Object).notifyAll()
    }

    @Synchronized
    fun second() {
        while (cur != 2) {
            (this as Object).wait()
        }
        println("second")
        cur = 3
        (this as Object).notifyAll()
    }

    @Synchronized
    fun third() {
        while (cur != 3) {
            (this as Object).wait()
        }
        println("third")
        cur = 1
        (this as Object).notifyAll()
    }
}

//class Foo {
//
//    private val lock = ReentrantLock()
//
//    var cur = 1
//    private val c1 = lock.newCondition()
//    private val c2 = lock.newCondition()
//    private val c3 = lock.newCondition()
//
//    fun first() {
//        lock.lock()
//        if (cur != 1) {
//            c1.await()
//        }
//        println("first")
//        cur = 2
//        c2.signal()
//        lock.unlock()
//    }
//
//    fun second() {
//        lock.lock()
//        if (cur != 2) {
//            c2.await()
//        }
//        println("second")
//        cur = 3
//        c3.signal()
//        lock.unlock()
//    }
//
//    fun third() {
//        lock.lock()
//        if (cur != 3) {
//            c3.await()
//        }
//        println("third")
//        cur = 1
//        c1.signal()
//        lock.unlock()
//    }
//}

//class Foo {
//    private var c0 = CountDownLatch(0)
//    private var c1 = CountDownLatch(1)
//    private var c2 = CountDownLatch(1)
//
//    fun first() {
//        c0.await()
//        println("first")
//        c0 = CountDownLatch(1)
//        c1.countDown()
//    }
//
//    fun second() {
//        c1.await()
//        println("second")
//        c1 = CountDownLatch(1)
//        c2.countDown()
//    }
//
//    fun third() {
//        c2.await()
//        println("third")
//        c2 = CountDownLatch(1)
//        c0.countDown()
//    }
//}
