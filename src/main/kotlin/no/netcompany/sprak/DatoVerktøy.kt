package no.netcompany.sprak

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.Month
import java.time.temporal.TemporalAdjusters

internal fun finnNteUkedagIMåned(fraDato: LocalDate, antall: Int, ukedag: DayOfWeek, måned: Month): LocalDate {
    val startdatoForMåned = finnStartdatoForMåned(måned, fraDato)

    return finnNteUkedag(startdatoForMåned, antall, ukedag)
}

internal fun finnNteUkedag(fraDato: LocalDate, antall: Int, ukedag: DayOfWeek): LocalDate {
    val nesteUkedag = finnUkedag(fraDato, ukedag)

    if (antall == 1) {
        return nesteUkedag;
    }

    return finnNteUkedag(nesteUkedag.plusDays(1), antall - 1, ukedag)
}

internal fun finnUkedag(fraDato: LocalDate, ukedag: DayOfWeek): LocalDate {
    var dag = fraDato

    while (dag.dayOfWeek != ukedag) {
        dag = dag.plusDays(1)
    }

    return dag;
}

internal fun finnStartdatoForMåned(måned: Month, fraDato: LocalDate): LocalDate {
    var dato = fraDato

    while (dato.month != måned) {
        dato = dato.with(TemporalAdjusters.firstDayOfNextMonth())
    }

    return dato
}

