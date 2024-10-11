package nl.fifthpostulate.rules

import nl.fifthpostulate.FizzBuzz

class Engine(val rule: FizzBuzzRule): FizzBuzz {
    constructor(): this(
        Fallback(Compound(
            Divisor(15, "FizzBuzz"),
            Divisor(5, "Buzz"),
            Divisor(3, "Fizz"),
            )))

    override fun of(n: Int): String =
        rule.respondTo(n)
}

interface FizzBuzzRule {
    fun respondTo(n: Int): String
}

data class Fallback(val rule: PartialFizzBuzzRule): FizzBuzzRule {
    override fun respondTo(n: Int): String =
        rule.respondTo(n) ?: n.toString()
}

interface PartialFizzBuzzRule {
    fun respondTo(n: Int): String?
}

data class Compound(val rules: List<PartialFizzBuzzRule>): PartialFizzBuzzRule {
    constructor(vararg rules: PartialFizzBuzzRule): this(rules.toList())

    override fun respondTo(n: Int): String? =
        rules.firstNotNullOfOrNull { it.respondTo(n) }
}

data class Divisor(val divisor: Int, val response: String): PartialFizzBuzzRule {
    override fun respondTo(n: Int): String? =
        if (n % divisor == 0) {
            response
        } else {
            null
        }
}