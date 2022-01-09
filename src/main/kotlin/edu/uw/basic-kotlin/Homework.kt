package edu.uw.basickotlin

class Library {
    // This is just here as a placeholder, to make sure tests run and pass
    // before you add any code
    fun someLibraryMethod(): Boolean {
        return true
    }
}

// write a "whenFn" that takes an arg of type "Any" and returns a String
fun whenFn(arg: Any): String {
    return when (arg) {
        "Hello" -> "world"
        is String -> "Say what?"
        0 -> "zero"
        1 -> "one"
        in 2..10 -> "low number"
        is Int -> "a number"
        else -> "I don't understand"
    }
}

// write an "add" function that takes two Ints, returns an Int, and adds the values
fun add(a: Int, b: Int): Int {
    return a + b
}

// write a "sub" function that takes two Ints, returns an Int, and subtracts the values
fun sub(a: Int, b: Int): Int {
    return a - b
}

// write a "mathOp" function that takes two Ints and a function (that takes two Ints and returns an Int), returns an Int, and applies the passed-in-function to the arguments
fun mathOp(a: Int, b: Int, func: (input1: Int, input2: Int) -> Int): Int {
    return func(a, b)
}

// write a class "Person" with first name, last name and age
class Person(var firstName: String, val lastName: String, var age: Int) {
    val debugString: String = "[Person firstName:$firstName lastName:$lastName age:$age]"
}

// write a class "Money" with amount and currency, and define a convert() method and the "+" operator
class Money (var amt: Int, var curr: String) {
    var amount: Int = 0
    var currency: String = ""

    init {
        if (amt < 0) {
            println(amt)
            throw IllegalArgumentException("amount can never be less than zero")
        }
        else
            amount = amt
        
        val types = listOf("USD", "EUR", "CAN", "GBP")
        if (types.none { it == curr })
            throw IllegalArgumentException("currency can only be one of the following: USD, EUR, CAN, or GBP")
        else
            currency = curr
    }
    
    public fun convert(type: String): Money {
        var tempAmt: Int = when (currency) {
            "GBP" -> amount * 2
            "EUR" -> (amount / 3) * 2
            "CAN" -> (amount / 5) * 4
            else -> amount
        }
        var finalAmt: Int = when(type) {
            "GBP" -> tempAmt / 2
            "EUR" -> (tempAmt / 2) * 3
            "CAN" -> (tempAmt / 4) * 5
            else -> tempAmt
        }
        return Money(finalAmt, type)
    }

    operator fun plus(other: Money): Money {
        return Money(this.amount + other.convert(this.currency).amount, this.currency)
    }
}