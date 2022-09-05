package main.inheritance

fun main() {
    val laserPrinter = LaserPrinter("Brother 1234")
    laserPrinter.printModel()
}

// class is final by default => can't be inheritance by default, need add open
abstract class Printer (val modelName: String) {
    // when want something to be extendable or to be able to be overridden
    // have to use open keywords, unless it's abstract
    open fun printModel() = println("THe model name of this printer is $modelName")
    abstract fun bestSellingPrice(): Double
}

class LaserPrinter(modelName: String): Printer(modelName) {
    // use primary constructor or use constructor
    // constructor(): super()
    override fun printModel() = println("The model name of this laser printer is $modelName")
    override fun bestSellingPrice(): Double = 129.99
}