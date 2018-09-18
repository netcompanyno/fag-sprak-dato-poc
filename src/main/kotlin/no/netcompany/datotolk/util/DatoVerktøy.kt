package no.netcompany.datotolk.util

import no.netcompany.datotolk.datoutleder.DatoUtleder
import no.netcompany.datotolk.datoutleder.DatoUtlederKjede
import no.netcompany.datotolk.datoutleder.MånedUtleder
import no.netcompany.datotolk.datoutleder.UkedagUtleder
import java.time.DayOfWeek
import java.time.Month

internal fun finnNteUkedagIMåned(antall: Int, ukedag: DayOfWeek, måned: Month): DatoUtleder {
    val månedUtleder = MånedUtleder(måned)
    val ukedagUtleder = UkedagUtleder(ukedag, antall)

    return DatoUtlederKjede(månedUtleder, ukedagUtleder)
}

