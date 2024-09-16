import kotlin.system.exitProcess

fun main(args: Array<String>) {
    if (args.size != 2 || args[0] != "-E") {
        println("Usage: ./your_program.sh -E <pattern>")
        exitProcess(1)
    }

    val pattern = args[1]
    val inputLine = System.`in`.bufferedReader().readText()

    if (matchPattern(inputLine, pattern)) println("success").also { exitProcess(0) }
    else println("failure").also { exitProcess(1) }
}

fun matchPattern(inputLine: String, pattern: String): Boolean =
    when {
        pattern == "\\d" -> inputLine.any { it.isDigit() }
        pattern.length == 1 -> pattern in inputLine
        else -> throw RuntimeException("Unhandled pattern: $pattern")
    }

