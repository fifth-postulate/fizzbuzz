package nl.fifthpostulate.standard

import nl.fifthpostulate.FizzBuzz
import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test
import kotlin.test.assertEquals

class StandardTest {
    lateinit var fizzbuzz : FizzBuzz

    @BeforeEach
    fun createFizzBuzz() {
        fizzbuzz = Standard()
    }

    @Test
    fun verify_fizzbuzz() {
        fizzbuzzOf(1).shouldEqual("1")
        fizzbuzzOf(2).shouldEqual("2")
        fizzbuzzOf(3).shouldEqual("Fizz")
        fizzbuzzOf(5).shouldEqual("Buzz")
        fizzbuzzOf(6).shouldEqual("Fizz")
        fizzbuzzOf(10).shouldEqual("Buzz")
        fizzbuzzOf(15).shouldEqual("FizzBuzz")
    }

    fun fizzbuzzOf(n: Int): FizzBuzzTestCase =
       FizzBuzzTestCase(fizzbuzz, n)
}

class FizzBuzzTestCase(val fizzbuzz: FizzBuzz, val n: Int) {
    fun shouldEqual(expected: String) {
        val actual = fizzbuzz.of(n)
        assertEquals(actual, expected, "fizzbuzz.of($n) should equal \"$expected\", but was \"$actual\"")
    }
}
