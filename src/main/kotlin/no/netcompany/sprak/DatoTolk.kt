package no.netcompany.sprak

import java.time.DayOfWeek
import java.time.DayOfWeek.*
import java.time.LocalDate
import java.time.Month

fun tolk(gittDato: LocalDate, tekst: String): LocalDate {
    if (finnIDagITekst(tekst)) {
        return gittDato
    }

    val antall = tekst.substring(0, 1).toInt()
    val ukedag = finnUkedag(tekst)
    val måned = finnMåned(tekst)

    return finnNteUkedagIMåned(gittDato, antall, ukedag, måned)
}

private fun finnIDagITekst(tekst: String): Boolean {
    return "idag" in tekst || "i dag" in tekst
}

private fun finnUkedag(tekst: String): DayOfWeek {
    return when {
        "mandag" in tekst -> MONDAY
        "tirsdag" in tekst -> TUESDAY
        "onsdag" in tekst -> WEDNESDAY
        "torsdag" in tekst -> THURSDAY
        "fredag" in tekst -> FRIDAY
        else -> throw IllegalArgumentException("Klarte ikke tolke ukedag")
    }
}

private fun finnMåned(tekst: String): Month {
    return when {
        "juli" in tekst -> Month.JULY
        "august" in tekst -> Month.AUGUST
        else -> throw IllegalArgumentException("Klarte ikke tolke måned")
    }
}

private fun finnNteUkedagIMåned(gittDato: LocalDate, antall: Int, ukedag: DayOfWeek, måned: Month): LocalDate {
    val nesteUkedag = finnUkedagIMåned(gittDato, ukedag, måned)

    if (antall == 1) {
        return nesteUkedag;
    }

    return finnNteUkedagIMåned(nesteUkedag.plusDays(1), antall - 1, ukedag, måned)
}

private fun finnUkedagIMåned(gittDato: LocalDate, ukedag: DayOfWeek, måned: Month): LocalDate {
    var dag = gittDato

    while (dag.dayOfWeek != ukedag || dag.month != måned) {
        dag = dag.plusDays(1)
    }

    return dag;
}
