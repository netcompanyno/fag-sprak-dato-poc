package no.netcompany.datotolk.datoutleder

import java.time.LocalDate

interface DatoUtleder {
    fun fra(startdato: LocalDate): LocalDate
}