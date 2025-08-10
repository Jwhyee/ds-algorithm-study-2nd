package chapter4

import io.kotest.core.spec.style.StringSpec
import kotlinx.coroutines.delay
import kotlin.system.measureTimeMillis

fun <T : Comparable<T>> bubbleSort(arr: Array<T>) {
    val n = arr.size
    for (i in 0 until n - 1) {
        for (j in 0 until n - i - 1) {
            if (arr[j] > arr[j + 1]) {
                val temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
            }
        }
    }
}

fun bubbleSort(arr: IntArray) {
    val n = arr.size
    for (i in 0 until n - 1) {
        for (j in 0 until n - i - 1) {
            if (arr[j] > arr[j + 1]) {
                val temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
            }
        }
    }
}

fun <T> time(
    name: String,
    block: () -> T
) = measureTimeMillis { block() }.also {
    println("$name: ${it}ms")
}

class SortTest : StringSpec({
    "IntArray vs Array<Int>" {
        val n = 10_000_000

        val a1 = IntArray(n) { Math.random().toInt() }
        val a2 = Array(n) { Math.random().toInt() }

        delay(1000L)

//        time("IntArray - bubbleSort") {
//            bubbleSort(a1)
//        }
//        time("Array<Int> - bubbleSort") {
//            bubbleSort(a2)
//        }
        time("IntArray - sorted") {
            a1.sorted()
        }
        time("IntArray - sort") {
            a1.sort()
        }
//        time("Array<Int> - sorted") {
//            a2.sorted()
//        }
//        time("Array<Int> - sort") {
//            a2.sort()
//        }
    }
})