package chapter9

import org.junit.jupiter.api.Test

class RecursiveTest {
//    @Test
//    fun testFactorial() {
//        val number = 5
//        val result = factorial(number)
//        println("Factorial of $number is $result")
//    }
//
//
//    fun factorial(n: Int): Int {
//        return if (n <= 1) 1 else n * factorial(n - 1)
//    }
//
//    @Test
//    fun testStep() {
//        val number = 11
//        val result = step(number)
//        println("Step of $number is $result")
//    }
//
//    fun step(n: Int): Int {
//        return if(n <= 0) 0
//        else if(n == 1) 1
//        else if(n == 2) 2
//        else if(n == 3) 4
//        else step(n - 1) + step(n - 2) + step(n - 3)
//    }

    @Test
    fun testFactorialTail() {
        val number = 3
        val result = factorialTail(number)
        println("Factorial of $number is $result")
    }

    fun factorialTail(n: Int, acc: Long = 1): Long {
        if (n == 1) return acc
        return factorialTail(n - 1, acc * n) // 재귀 호출이 "마지막 동작"
    }
}