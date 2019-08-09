import kotlin.system.exitProcess

var rowInt = 0
var colInt = 0
var turn = "X"
var win : String? = ""
var count = 0

val table: Array<Array<String>> = arrayOf(
    arrayOf(" ","0","1","2"),
    arrayOf("0","-","-","-"),
    arrayOf("1","-","-","-"),
    arrayOf("2","-","-","-"))

fun main() {
    println("Wellcome to OX game")
    printTable()
    while (true){
        try {

            print("Turn ${turn} Please input : ")
            val input: String? = readLine()
            val rcList: List<String>? = input?.split(" ")
            if (rcList?.size !=2 ) {
                println("Please input 2 number ")
                continue
            }
            rowInt = rcList[0].toInt()
            colInt = rcList[1].toInt()
            if (rowInt >= 0 && rowInt <= 2){
                if (colInt >=0 && colInt <= 2){
                    if (table[rowInt+1][colInt+1] == "-"){
                        table[rowInt+1][colInt+1] = turn
                        if (turn == "X") {
                            turn = "O"
                        } else {
                            turn = "X"
                        }
                    }
                    println("Insert in Row ${rcList[0]} Col ${rcList[1]}")
                    printTable()
                    win = checkWin()
                    if (win.equals("draw")) {
                        println("Draw")
                        break
                    } else if (win.equals("O")) {
                        println("$win win")
                        break
                    }else if (win.equals("X")) {
                        println("$win win")
                        break
                    }

                }else{
                    println("number must between 0 - 2")
                }
            }else{
                println("number must between 0 - 2")
            }

        } catch (t: Throwable) {
            println("Error ${t.message } insert 2 number ")
        }
    }
}

fun printTable() {
    for (row: Array<String> in table){
        for (col: String in row){
            print("$col ")
        }
        println()
    }
}
fun checkWin(): String? {
    for (a in 0..7) {
        var line: String? = null
        when (a) {
            0 -> line = table[0+1][0+1] + table[0+1][1+1] + table[0+1][2+1]
            1 -> line = table[1+1][0+1] + table[1+1][1+1] + table[1+1][2+1]
            2 -> line = table[2+1][0+1] + table[2+1][1+1] + table[2+1][2+1]
            3 -> line = table[0+1][0+1] + table[1+1][0+1] + table[2+1][0+1]
            4 -> line = table[0+1][1+1] + table[1+1][1+1] + table[2+1][1+1]
            5 -> line = table[0+1][2+1] + table[1+1][2+1] + table[2+1][2+1]
            6 -> line = table[0+1][2+1] + table[1+1][1+1] + table[2+1][0+1]
            7 -> line = table[0+1][0+1] + table[1+1][1+1] + table[2+1][2+1]
        }

        if (line == "XXX") {
            return "X"
        } else if (line == "OOO") {
            return "O"
        }
    }
    count += 1
    if (count >= 9) {
        return "draw"
    }
    return null
}
