
fun main() {
    var n: Int
    while(true)
    { n = readLine()!!.toInt()
    if ((n >= 2) && (n<=1000))
    {break}
    }
    var count = 0
    var box: String
    var answer = String()
    val str = readLine()!!
    val strArray = str.split(" ").toTypedArray().sliceArray(0 until n)
    val sortedStrArray = strArray.copyOf()
    sortedStrArray.sortWith(compareBy({ it.length }, { it }))
    for (i in 1 until n) {
        for (j in 0 until n) {
            if (evenCheck(strArray[i].toInt()) != evenCheck(i + 1)) {
                if ((evenCheck(strArray[j].toInt()) != evenCheck(j + 1)) && (j != i)) {
                    box = strArray[j]
                    strArray[j] = strArray[i]
                    strArray[i] = box
                    answer = strArray[i] + " " + strArray[j]
                    count += 1
                    break
                }
                answer = "-1 -1"
                count += 1
            }
        }
    }
    if (count == 0) {
        answer = "-1 -1"
    }
    val answerArray = answer.split(" ").toTypedArray()
    answerArray.sortWith(compareBy({ it.length }, { it }))
    answer = answerArray.joinToString(separator = " ")
    print(answer)
}


fun evenCheck(i: Int): Boolean {
    return i % 2 == 0
}

