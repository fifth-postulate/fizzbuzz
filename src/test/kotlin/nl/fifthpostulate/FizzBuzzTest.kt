package nl.fifthpostulate

import nl.fifthpostulate.castingnines.CastingNines
import nl.fifthpostulate.radix.Radix
import nl.fifthpostulate.radix.UnrollWithMap
import nl.fifthpostulate.radix.UnrollWithWhen
import nl.fifthpostulate.standard.Standard
import org.junit.jupiter.api.BeforeEach
import kotlin.random.Random
import kotlin.random.nextInt
import kotlin.test.Test
import kotlin.test.assertEquals

class FizzBuzzTest {
    private lateinit var subjects: List<FizzBuzz>
    private lateinit var standard: FizzBuzz

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

    @BeforeEach
    fun createStandard() {
        standard = Standard()
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

    @Test
    fun compare_fizzbuzz() {
        subjects.forEach {subject ->
            with(subject) {
                verify().fizzbuzzAgrees().withOther(standard)
            }
        }
    }
}

fun FizzBuzz.verify(): FizzBuzzTestCase =
    FizzBuzzTestCase(this)

data class FizzBuzzTestCase(val fizzbuzz: FizzBuzz) {
    fun fizzbuzzOf(n : Int): InstanceExpectation =
        InstanceExpectation(fizzbuzz, n)

    fun fizzbuzzAgrees() =
        ComparisonExpectation(fizzbuzz)

}

data class InstanceExpectation(val fizzbuzz: FizzBuzz, val n : Int) {
    fun shouldEqual(expected: String) {
        val actual = fizzbuzz.of(n)
        assertEquals(actual, expected, "[${fizzbuzz::class.simpleName}]: fizzbuzz.of($n) should equal \"$expected\", but was \"$actual\"")
    }
}

data class ComparisonExpectation(val fizzbuzz: FizzBuzz) {
    fun withOther(standard: FizzBuzz) {
        (1..100).map(Random::nextInt).forEach { n ->
            val actual = fizzbuzz.of(n)
            val expected = standard.of(n)
            assertEquals(actual, expected, "[${fizzbuzz::class.simpleName}|${standard::class.simpleName}]: fizzbuzz.of($n) should agree with standard.of($n), but was (\"${actual}\"|\"${expected}\").")
        }
    }
}