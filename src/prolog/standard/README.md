# Prolog
[Prolog][lang:prolog] is a

> Prolog is a logic programming language that has its origins in artificial
> intelligence, automated theorem proving and computational linguistics.

## Development
For this you need a Prolog runtime like [swi-prolog][swi-prolog] or an online
environment like [swish][swish].

The following database will suffice

```prolog
fizzbuzz(N, "FizzBuzz") :- Q is mod(N, 15), Q == 0.
fizzbuzz(N, "Buzz") :- Q is mod(N, 5), Q == 0.
fizzbuzz(N, "Fizz") :- Q is mod(N, 3), Q == 0.
fizzbuzz(N, N).
```

One then can ask questions like

```plain
?- fizzbuzz(9, X).
X = "Fizz"
```

[lang:prolog]: https://en.wikipedia.org/wiki/Prolog
[swi-prolog]: https://www.swi-prolog.org/
[swish]: https://wasm.swi-prolog.org/wasm/shell
