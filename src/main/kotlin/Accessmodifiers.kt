package main.kotlin

fun main() {
    val emp = Employee("Bob")
    println(emp.firstName)

    val emp2 = Employee("Joe")
    println(emp2.firstName)
    println(emp2.fullTime)
}

class Employee (val firstName: String, val fullTime: Boolean = true)

class Demo {
    val dummy: String

    constructor() {
        dummy = "Hello"
    }
}



