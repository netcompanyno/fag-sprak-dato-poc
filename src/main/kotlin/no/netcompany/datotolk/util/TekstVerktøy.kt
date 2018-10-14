package no.netcompany.datotolk.util

import java.time.DayOfWeek
import java.time.Month

internal fun inneholderIdag(tekst: String): Boolean {
    return "idag" in tekst || "i dag" in tekst
}

internal fun inneholderIfjor(tekst: String): Boolean {
    return "samme dag ifjor" in tekst || "samme dag i fjor" in tekst || "for et år siden" in tekst
}

internal fun finnUkedag(tekst: String): DayOfWeek {
    return when {
        "mandag" in tekst -> DayOfWeek.MONDAY
        "tirsdag" in tekst -> DayOfWeek.TUESDAY
        "onsdag" in tekst -> DayOfWeek.WEDNESDAY
        "torsdag" in tekst -> DayOfWeek.THURSDAY
        "fredag" in tekst -> DayOfWeek.FRIDAY
        else -> throw IllegalArgumentException("Klarte ikke tolke ukedag")
    }
}

internal fun finnMåned(tekst: String): Month {
    return when {
        "juli" in tekst -> Month.JULY
        "august" in tekst -> Month.AUGUST
        else -> throw IllegalArgumentException("Klarte ikke tolke måned")
    }
}
