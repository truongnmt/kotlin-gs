package main

fun main() {
//    println(countTo100())

    val employees = listOf(Employee("John", "Smith", 2012),
        Employee("Jane", "Wilson", 2015),
        Employee("Mary", "Johnson", 2010),
        Employee("Mike", "Jones", 2002),
    )

    findByLastName(employees, "Wilson")
    findByLastName(employees, "Smithson")

    "Some String".apply someString@ {
        "Another String".apply {
            println(this.toLowerCase()) // this is Another String
            println(this@someString.toUpperCase()) // label with nested lambda
        }
    }
}

fun countTo100(): String {
    val numbers = StringBuilder()
    // with function takes an instance and a lambda
    // but if lambda is the last argument, can put the lambda outside the parentheses
    return with(numbers) {
        for (i in 1..99) {
            this.append(i) // can remove this
            numbers.append(", ") // can remove numbers
        }
        append(100)
        toString()
    }
}

// apply: the same with but always return the receiver obj
fun countTo200() =
    StringBuilder().apply() {
        for (i in 1..99) {
            append(i)
            append(", ")
        }
        append(100)
    }.toString()


fun findByLastName(employees: List<Employee>, lastName: String) {
    employees.forEach returnBlock@ {
        if (it.lastName == lastName) {
            println("Yes, there's an employee with the last «name $lastName")
            // return // return from lambda and function, non-local return
            return@returnBlock
        }
    }

    println("nope there's no employee with the last name $lastName")
}

//fun countTo100(): String {
//    val numbers = StringBuilder()
//    for (i in 1..99) {
//        numbers.append(i)
//        numbers.append(", ")
//    }
//    numbers.append(100)
//    return numbers.toString()
//}

