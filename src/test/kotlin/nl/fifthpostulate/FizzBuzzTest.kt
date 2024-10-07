package nl.fifthpostulate

import nl.fifthpostulate.radix.Radix
import nl.fifthpostulate.radix.UnrollWithWhen
import nl.fifthpostulate.standard.Standard
import kotlin.test.Test
import kotlin.test.assertEquals

class FizzBuzzTest {
    @Test
    fun verify_fizzbuzz() {
        listOf(Standard(), Radix(), UnrollWithWhen()).forEach { subject ->
            with(subject) {
                verify().fizzbuzzOf(1).shouldEqual("1")
                verify().fizzbuzzOf(2).shouldEqual("2")
                verify().fizzbuzzOf(3).shouldEqual("Fizz")
                verify().fizzbuzzOf(5).shouldEqual("Buzz")
                verify().fizzbuzzOf(6).shouldEqual("Fizz")
                verify().fizzbuzzOf(10).shouldEqual("Buzz")
                verify().fizzbuzzOf(15).shouldEqual("FizzBuzz")
            }
        }
    }
}

fun FizzBuzz.verify(): FizzBuzzTestCase =
    FizzBuzzTestCase(this)

class FizzBuzzTestCase(val fizzbuzz: FizzBuzz) {
    fun fizzbuzzOf(n : Int): FizzBuzzExpectation =
        FizzBuzzExpectation(fizzbuzz, n)

}

class FizzBuzzExpectation(val fizzbuzz: FizzBuzz, val n : Int) {
    fun shouldEqual(expected: String) {
        val actual = fizzbuzz.of(n)
        assertEquals(actual, expected, "fizzbuzz.of($n) should equal \"$expected\", but was \"$actual\"")
    }
}
