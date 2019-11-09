package com.example.demka

class StringGenerator {

    private var sstring = ""

    constructor() {
        this.sstring = "CHECK"
        this.set_string()

    }

    private  fun set_string(){
        var locale_var = ""

        for (i in 1..1000)
            locale_var += i.toString()


        this.sstring = locale_var
    }

    open fun get_string(): String {
        return this.sstring
    }

}