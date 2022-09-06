package main.inheritance

import java.time.Year

fun main() {
    println(CompanyCommunication.getTagLine())
    println(CompanyCommunication.getCopyrightLine())

    println(SomeClass.accessPrivateVar())

    // factory pattern
    val someClass1 = SomeClass.justAssign("this is a string as is")
    val someClass2 = SomeClass.upperOrLowerCase("this isn't the string as is", false)
    println(someClass1.someString)
    println(someClass2.someString)
    // val someClass3 = SomeClass()

    var thisIsMutable = 45

    // use object to create anonymous instance - object expression
    wantsSomeInterface(object: SomeInterface {
        override fun mustImplement(num: Int): String {
            thisIsMutable++
            return "This is from mustImplement: ${num * 100}"
        }
    })
    println(thisIsMutable)
}

// declare the class and it's instance at the same time => object keyword
// usage: singleton, companion object, object expression

// singleton
object CompanyCommunication {
    val currentYear = Year.now().value

    fun getTagLine() = "Our company rocks!"
    fun getCopyrightLine() = "Copyright \u00A9 $currentYear Our Company. All rights reserved."
}

// have something in a class, but not need instance to access it
// => companion object
// grouping static member in companion

class SomeClass private constructor(val someString: String) {
//    private val privateVar = 6
//
//    fun accessPrivateVar() {
//        println("I'm accessing privateVar: $privateVar")
//    }

//    val someString: String
//    constructor(str: String) {
//        someString = str
//    }
//    constructor(str: String, lowerCase: Boolean) {
//        if (lowerCase) {
//            someString = str.toLowerCase()
//        } else {
//            someString = str.toUpperCase()
//        }
//    }

    // grouping static member (java context) in companion
    companion object {
        private var privateVar = 6

        fun accessPrivateVar() = "I'm accessing privateVar: $privateVar"

        // call private constructor, can use to implement factory pattern
        fun justAssign(str: String) = SomeClass(str)
        fun upperOrLowerCase(str: String, lowerCase: Boolean): SomeClass {
            if (lowerCase) {
                return SomeClass(str.toLowerCase())
            } else {
                return SomeClass(str.toUpperCase())
            }
        }
    }
}

interface SomeInterface {
    fun mustImplement(num: Int): String
}

fun wantsSomeInterface(si: SomeInterface) {
    println("printing from wantsSomeInterface ${si.mustImplement(22)}")
}
