package no.netcompany.datotolk.datoutleder

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.temporal.TemporalAdjusters

class UkedagUtleder(val ukedag: DayOfWeek, val antall: Int) : DatoUtleder {
    override fun fra(startdato: LocalDate): LocalDate {
        return startdato.with(TemporalAdjusters.dayOfWeekInMonth(antall, ukedag))
    }
}