package main.kotlin

fun main() {
     println(labelMultiply(3, 4))

    val emp = Employee2("Jane")
    println(emp.upperCaseFirstName())

    val emp1 = Employee2("Bob")
    val emp2 = Employee2("Joe")
    val emp3 = Employee2("Abe")

    val manyEmployees = arrayOf(emp1, emp2, emp3)
    // printEmployees(manyEmployees) // type mismatch
    printEmployees(*manyEmployees) // use spread operator to unpack an array

    val s = "this is all in lowercase"
    println(s.upperFirstAndLast())
}

fun String.upperFirstAndLast(): String {
    val upperFirst = this.substring(0, 1).toUpperCase() + this.substring(1) // can remove this
    return upperFirst.substring(0, upperFirst.length-1) + upperFirst.substring(upperFirst.length -1, upperFirst.length).toUpperCase()
}

// function with a block body
//fun labelMultiply(operant1: Int, operant2: Int, label: String): String {
//    return ("$label ${operant1 * operant2}")
//}

// inline fun xyz()
// inline function: function body will be directly generated into the byte code
// wherever the function is called rather than having a function called
// mostly used for

// function with an expression body
fun labelMultiply(operant1: Int, operant2: Int, label: String = "The answer is:") = // return type is inferred
    "$label ${operant1 * operant2}"

class Employee2(val firstName: String) {

    fun upperCaseFirstName() = firstName.toUpperCase()
}

fun printEmployees(vararg employees: Employee2) {
    for (employee in employees) {
        println(employee)
    }
}
