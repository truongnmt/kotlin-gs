package main

fun main() {
    run { println("I'm in a lambda!") }

    val employees = listOf(Employee("John", "Smith", 2012),
        Employee("Jane", "Wilson", 2015),
        Employee("Mary", "Johnson", 2010),
        Employee("Mike", "Jones", 2002),
    )
//    println(employees.minByOrNull({ e -> e.startYear }))
//    println(employees.minByOrNull { e -> e.startYear })
    println(employees.minByOrNull { it.startYear })

    var num = 10
    run {
        num += 15
        println(num)
    }
    run {
        topLevel()
    }

    // member reference
    run(::topLevel)
    println(employees.minByOrNull(Employee::startYear))

}

fun topLevel() = println("I'm top level func")

fun useParameter(employees: List<Employee>, num: Int) {
    employees.forEach {
        println(it.firstName)
        println(num)
        // println(num++) not works because func parameters are final are val variable, can't change them
    }
}

data class Employee(val firstName: String, val lastName: String, val startYear: Int) {

}
