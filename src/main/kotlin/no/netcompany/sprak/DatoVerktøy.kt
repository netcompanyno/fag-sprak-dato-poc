package no.netcompany.sprak

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.Month
import java.time.temporal.TemporalAdjusters

internal fun finnNteUkedagIMåned(fraDato: LocalDate, antall: Int, ukedag: DayOfWeek, måned: Month): LocalDate {
    val startdatoForMåned = finnStartdatoForMåned(måned, fraDato)

    return finnNteUkedag(startdatoForMåned, antall, ukedag)
}

private fun finnNteUkedag(fraDato: LocalDate, antall: Int, ukedag: DayOfWeek): LocalDate {
    return fraDato.with(TemporalAdjusters.dayOfWeekInMonth(antall, ukedag))
}

private fun finnStartdatoForMåned(måned: Month, fraDato: LocalDate): LocalDate {
    val antallMånederFram = (måned.ordinal - fraDato.month.ordinal) % 12L

    return fraDato.plusMonths(antallMånederFram).withDayOfMonth(1)
}
