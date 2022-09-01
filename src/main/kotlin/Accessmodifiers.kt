package main.kotlin

fun main() {
    val emp = Employee("Bob")
    println(emp.firstName)

    val emp2 = Employee("Joe")
    emp2.fullTime = false // call set()
    println(emp2.firstName)
    println(emp2.fullTime) // call get()

    val car = Car("blue", "Toyota", 2015)
    println(car)
    val car2 = car.copy()
    println(car2)
    val car4 = car.copy(year = 2016, color = "green")
    println(car4)
}

data class Car(val color: String, val model: String, val year: Int)

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



