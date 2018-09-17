package no.netcompany.datotolk

import no.netcompany.datotolk.util.finnMåned
import no.netcompany.datotolk.util.finnNteUkedagIMåned
import no.netcompany.datotolk.util.finnUkedag
import no.netcompany.datotolk.util.inneholderIdag
import java.time.LocalDate

fun tolk(gittDato: LocalDate, tekst: String): LocalDate {
    if (inneholderIdag(tekst)) {
        return gittDato
    }

    val antall = tekst.substring(0, 1).toInt()
    val ukedag = finnUkedag(tekst)
    val måned = finnMåned(tekst)

    return finnNteUkedagIMåned(gittDato, antall, ukedag, måned)
}