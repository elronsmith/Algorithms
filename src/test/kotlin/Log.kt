private const val SECOND = 1000
private const val MINUTE = 1000 * 60

fun printFound(count: Int, max: Int, time: Long) {
    val timeString = formatTime(time)
    println("Found $count / $max users. Time taken: $timeString")
}

fun formatTime(_time: Long): String {
    val sb = StringBuilder()
    var time: Long = _time

    if (time >= MINUTE) {
        val min = time / MINUTE
        time -= (min * MINUTE)
        val sec = time / SECOND
        val msec = time % SECOND
        sb.append("$min min. $sec sec. $msec ms.")
    } else if (time >= SECOND) {
        val sec = time / SECOND
        val msec = time % SECOND
        sb.append("0 min. $sec sec. $msec ms.")
    } else
        sb.append("0 min. 0 sec. $time ms.")

    return sb.toString()
}
