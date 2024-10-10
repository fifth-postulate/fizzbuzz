package nl.fifthpostulate.random

import nl.fifthpostulate.FizzBuzz
import nl.fifthpostulate.standard.Standard
import kotlin.random.Random

data class RandomSeed(val seed: Int) : FizzBuzz {
    private val data: Map<Int, String>

    constructor(): this(92)

    init {
        val rng = Random(seed)
        data = listOf(0, 3, 5, 6, 9, 10, 12).associateWith { rng.nextFizzBuzz() }
    }

    override fun of(n: Int): String =
        data[n % 15] ?: n.toString()
}

fun Random.nextFizzBuzz(): String =
    when (this.nextInt(0, 3)) {
        0 -> "Fizz"
        1 -> "Buzz"
        else -> "FizzBuzz"
    }

fun main() {
    val reference: FizzBuzz = Standard()
    for (seed in 0 .. Int.MAX_VALUE) {
        val subject: FizzBuzz = RandomSeed(seed)
        if ((1..15).all { n -> subject.of(n) == reference.of(n) }) {
            println(seed)
            break
        }
    }
}