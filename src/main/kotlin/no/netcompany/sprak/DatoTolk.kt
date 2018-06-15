package no.netcompany.sprak

import java.time.DayOfWeek
import java.time.DayOfWeek.*
import java.time.LocalDate
import java.time.Month
import java.time.temporal.TemporalAdjusters

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

private fun finnNteUkedagIMåned(fraDato: LocalDate, antall: Int, ukedag: DayOfWeek, måned: Month): LocalDate {
    val startdatoForMåned = finnStartdatoForMåned(måned, fraDato)

    return finnNteUkedag(startdatoForMåned, antall, ukedag)
}

private fun finnNteUkedag(fraDato: LocalDate, antall: Int, ukedag: DayOfWeek): LocalDate {
    val nesteUkedag = finnUkedag(fraDato, ukedag)

    if (antall == 1) {
        return nesteUkedag;
    }

    return finnNteUkedag(nesteUkedag.plusDays(1), antall - 1, ukedag)
}

private fun finnUkedag(fraDato: LocalDate, ukedag: DayOfWeek): LocalDate {
    var dag = fraDato

    while (dag.dayOfWeek != ukedag) {
        dag = dag.plusDays(1)
    }

    return dag;
}

private fun finnStartdatoForMåned(måned: Month, fraDato: LocalDate): LocalDate {
    var dato = fraDato

    while (dato.month != måned) {
        dato = dato.with(TemporalAdjusters.firstDayOfNextMonth())
    }

    return dato
}