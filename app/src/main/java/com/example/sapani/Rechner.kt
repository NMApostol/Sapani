package com.example.sapani

class Rechner constructor(ersteWunde: Double, zweiteWunde: Double) {
    var wundeEins: Double = 0.0
        get() = field
        set(value) { field = value }
    var wundeZwei: Double = 0.0
        get() = field
        set(value) { field = value }

    init {
        wundeEins = ersteWunde
        wundeZwei = zweiteWunde
    }

    fun prozent(): Double {
        var prozent = wundeZwei.div(wundeEins) * 100
        return prozent
    }
}