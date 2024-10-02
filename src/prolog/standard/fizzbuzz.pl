fizzbuzz(N, "FizzBuzz") :- Q is mod(N, 15), Q == 0.
fizzbuzz(N, "Buzz") :- Q is mod(N, 5), Q == 0.
fizzbuzz(N, "Fizz") :- Q is mod(N, 3), Q == 0.
fizzbuzz(N, N).
