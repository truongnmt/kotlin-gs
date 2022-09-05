package main.inheritance

fun main() {
    val laserPrinter = LaserPrinter("Brother 1234", 15)
    laserPrinter.printModel()
}

// class is final by default => can't be inheritance by default, need add open
abstract class Printer (val modelName: String) {
    // when want something to be extendable or to be able to be overridden
    // have to use open keywords, unless it's abstract
    open fun printModel() = println("THe model name of this printer is $modelName")
    abstract fun bestSellingPrice(): Double
}

open class LaserPrinter(modelName: String, ppm: Int): Printer(modelName) {
    // use primary constructor or use constructor
    // constructor(): super()
    final override fun printModel() = println("The model name of this laser printer is $modelName")
    // override fun is open => subclass can continue override this function
    // can use final like L19 if don't want this behavior
    override fun bestSellingPrice(): Double = 129.99
}

class SpecialLaserPrinter(modelName: String): LaserPrinter(modelName, 1000) {

    // override fun printModel() = println("this is my way of doing it")
}

// every constructor has to delegate to primary constructor (if has primary constructor)
// if not primary constructor, secondary constructor must call to parent constructor by super
open class Something {
    val someProp: String

    constructor(someParam: String) {
        someProp = someParam
    }
}

class SomethingElse: Something {
    constructor(someOtherParam: String): super(someOtherParam)
}

// data class can't be open, abstract or inner class
data class DataClass(val number: Int) {

}


