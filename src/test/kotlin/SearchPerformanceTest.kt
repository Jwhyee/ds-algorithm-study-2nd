import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldNotBe
import kotlin.random.Random
import kotlin.system.measureTimeMillis

class SearchPerformanceTest : StringSpec({

    val size = 10_000_000
    val repeat = 100
    val randomData = List(size) { Random.nextInt() }.toIntArray()

    // 웜업
    repeat(repeat) {
        val targetData = List(repeat) { randomData.random() }
        linearSearch(randomData, targetData.random())
    }

    "선형 탐색" {
        val targetData = List(repeat) { randomData.last() }
        val linearTime = measureTimeMillis {
            for (target in targetData) {
                val index = linearSearch(randomData, target)
                index shouldNotBe -1
            }
        }
        println("[Linear Search] Took $linearTime ms")
    }

    "정렬 + 이진 탐색" {
        val sortedData: IntArray
        val sortTime = measureTimeMillis {
            sortedData = randomData.sortedArray()
        }

        val targetData = List(repeat) { randomData.last() }

        val binaryTime = measureTimeMillis {
            for (target in targetData) {
                val index = binarySearch(sortedData, target)
                index shouldNotBe -1
            }
        }

        val totalTime = sortTime + binaryTime
        println("[Sort Time]        $sortTime ms")
        println("[Binary Search]    $binaryTime ms")
        println("[Total (Sort + Binary)] $totalTime ms")
    }
})

fun linearSearch(array: IntArray, target: Int): Int {
    for (i in array.indices) {
        if (array[i] == target) return i
    }
    return -1
}

fun binarySearch(array: IntArray, target: Int): Int {
    return array.binarySearch(target)
}