package no.netcompany.datotolk.datoutleder

import java.time.LocalDate
import java.time.Month

class MånedUtleder(val måned: Month) : DatoUtleder {
    override fun fra(startdato: LocalDate): LocalDate {
        val antallMånederFram = (måned.ordinal - startdato.month.ordinal + 12) % 12L

        return startdato.plusMonths(antallMånederFram).withDayOfMonth(1)
    }
}