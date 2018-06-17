package no.netcompany.sprak

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