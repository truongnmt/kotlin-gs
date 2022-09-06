package main

import java.math.BigDecimal

fun main() {
    val num = 300
    val y = 10

    when(num) {
        y + 290 -> println("300") // y + 290 == 300
        in 100..199 -> println("in range 100..199")
        100, 600 -> println("600")
        100 -> println("100")
        200 -> println("200")
        300 -> println("300")
        else -> println("Doesn't match anything")
    }

    val obj2: Any = BigDecimal(25.2)
    val something: Any = obj2

    val z = when (something) {
        is String -> println(something.toUpperCase())
        is BigDecimal -> println(something.remainder(BigDecimal(10.5)))
        is Int -> println("${something - 22}")
        else -> println("I have no idea what type it is")
    }
    println(z) // kotlin.Unit

}