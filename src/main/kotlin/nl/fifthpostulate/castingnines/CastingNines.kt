package nl.fifthpostulate.castingnines

import nl.fifthpostulate.FizzBuzz
import kotlin.math.absoluteValue

class CastingNines : FizzBuzz {
    override fun of(n: Int): String {
        val divisibility3 = divisibleBy3(n)
        val divisibility5 = divisibleBy5(n)
        if (divisibility5 && divisibility3) {
            return "FizzBuzz"
        }
        if (divisibility5) {
            return "Buzz"
        }
        if (divisibility3) {
            return "Fizz"
        }
        return n.toString()
    }
}

fun divisibleBy3(n : Int): Boolean =
    alternatingDigitSumResidue(2, n) == 0

fun divisibleBy5(n : Int): Boolean =
    alternatingDigitSumResidue(4, n) == 0

fun alternatingDigitSumResidue(base: Int, n: Int): Int =
    if (n.absoluteValue < base) {
        n
    } else {
        val m = alternatingDigitSum(base, 1, n)
        alternatingDigitSumResidue(base, m)
    }

fun alternatingDigitSum(base: Int, multiplier: Int, subject: Int): Int {
    val quotient = subject / base
    val addend = multiplier * (subject % base)
    return if (quotient == 0) {
        addend
    } else {
       addend + alternatingDigitSum(base, multiplier * -1, quotient)
    }
}