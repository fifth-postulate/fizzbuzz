package nl.fifthpostulate

import nl.fifthpostulate.castingnines.CastingNines
import nl.fifthpostulate.radix.Radix
import nl.fifthpostulate.radix.UnrollWithMap
import nl.fifthpostulate.radix.UnrollWithWhen
import nl.fifthpostulate.standard.Standard
import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test
import kotlin.test.assertEquals

class FizzBuzzTest {
    private lateinit var subjects: List<FizzBuzz>

    @BeforeEach
    fun subjectsUnderTest() {
        subjects = listOf(
            Standard(),
            Radix(),
            UnrollWithWhen(),
            UnrollWithMap(),
            CastingNines(),
            )
    }

    @Test
    fun verify_fizzbuzz() {
        subjects.forEach { subject ->
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
