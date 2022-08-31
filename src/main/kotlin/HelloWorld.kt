package helloworld

import java.util.*

fun main(args: Array<String>) {

    val str: String? = "This isn't null"

//    if (str!=null) {
//        str?.uppercase(Locale.getDefault())
//    }
    str?.uppercase(Locale.getDefault())
    val str2 = str ?: "This is the default value"

    str?.let { println(it) } // let's print it if it's not null

    val something: Any = arrayOf(1, 2, 3, 4)
    val str3 = something as? String // str3 type is String?, this is safe case operator
    println(str3)

}
