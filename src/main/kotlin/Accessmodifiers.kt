package main.kotlin

fun main() {
    val emp = Employee("Bob")
    println(emp.firstName)

    val emp2 = Employee("Joe")
    emp2.fullTime = false // call set()
    println(emp2.firstName)
    println(emp2.fullTime) // call get()
}

class Employee (val firstName: String, fullTime: Boolean = true) {

    var fullTime = fullTime
    get() {
        println("Running the custom get")
        return field
    }
    set(value) {
        println("Running the custom set")
        field = value
    }
}

class Demo {
    val dummy: String

    constructor() {
        dummy = "Hello"
    }
}



