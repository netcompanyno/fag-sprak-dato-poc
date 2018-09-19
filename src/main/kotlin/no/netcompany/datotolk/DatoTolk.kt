package no.netcompany.datotolk

import no.netcompany.datotolk.datoutleder.DatoUtleder
import no.netcompany.datotolk.datoutleder.SimpelDatoUtleder
import no.netcompany.datotolk.util.finnMåned
import no.netcompany.datotolk.util.finnNteUkedagIMåned
import no.netcompany.datotolk.util.finnUkedag
import no.netcompany.datotolk.util.inneholderIdag
import java.time.LocalDate

fun tolk(startdato: LocalDate, tekst: String): LocalDate {
    val datoUtleder: DatoUtleder = tolkTekstTilDatoUtleder(tekst)

    return datoUtleder.fra(startdato)
}

private fun tolkTekstTilDatoUtleder(tekst: String): DatoUtleder {
    if (inneholderIdag(tekst)) {
        return SimpelDatoUtleder.iDagUtleder
    } else {
        val antall = tekst.substring(0, 1).toInt()
        val ukedag = finnUkedag(tekst)
        val måned = finnMåned(tekst)

        return finnNteUkedagIMåned(antall, ukedag, måned)
    }
}