fun alter(): Int {
    var NewString = "ХЫ"

    var max: Int = 0
    var min: Int = 99999
    var BufString: String  = ""
    var conc: Int = 1

    for (i in 1..1000) {
        println(i)
        conc *= i
        if (max < i)
            max = i
        if (min > i)
            min = i

        BufString += i.toString()
    }

    println("$NewString $BufString\nMin: $min\nMax: $max");

    return conc
}

fun substring_example()
{
    var A: Int = 8;
    var B: Int = 10
    println("Сумма: ${A+B}")
}
fun main() {
    var check: String = "MEOW"
    println("Что говорят Koshkas?\n$check")

    //Поч резульатт не объявляется?
    var result: Int = alter();
    println("MEEWEKWOKKO");
    println(result);

    substring_example();
}