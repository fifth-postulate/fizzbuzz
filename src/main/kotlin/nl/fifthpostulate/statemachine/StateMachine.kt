package nl.fifthpostulate.statemachine

import nl.fifthpostulate.FizzBuzz

sealed class State : FizzBuzz {
    lateinit var next: State
}
class FizzState : State() {
    override fun of(n: Int): String = "Fizz"
}
class BuzzState : State() {
    override fun of(n: Int): String = "Buzz"
}
class FizzBuzzState : State() {
    override fun of(n: Int): String = "FizzBuzz"
}
class NumberState : State() {
    override fun of(n: Int): String = n.toString()
}

fun buildStates(): State {
    val l = listOf(
        FizzBuzzState(), NumberState(), NumberState(), FizzState(), NumberState(),
        BuzzState(), FizzState(), NumberState(), NumberState(), FizzState(),
        BuzzState(), NumberState(), FizzState(), NumberState(), NumberState(),
    )

    var state = l.first()
    for (s in l.drop(1)) {
        state.next = s
        state = s
    }
    state.next = l.first()

    return l.first()
}

class StateMachine : FizzBuzz {
    private val start = buildStates()
    override fun of(n: Int): String {
        var state = start
        repeat(n) {
            state = state.next
        }
        return state.of(n)
    }
}
