package no.netcompany.datotolk.datoutleder

import java.time.LocalDate

class SimpelDatoUtleder(private val funksjon: (startdato: LocalDate) -> LocalDate) : DatoUtleder {
    override fun fra(startdato: LocalDate): LocalDate = funksjon.invoke(startdato)

    companion object {
        val iDagUtleder = SimpelDatoUtleder { dato -> dato }
        val iGaarUtleder = SimpelDatoUtleder { dato -> dato.minusDays(1)}
    }
}