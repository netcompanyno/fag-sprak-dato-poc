package no.netcompany.datotolk.datoutleder

import java.time.LocalDate

class DatoUtlederKjede(vararg val datoutledere: DatoUtleder) : DatoUtleder {
    override fun fra(startdato: LocalDate): LocalDate {
        return datoutledere.fold(startdato) { forrigeDato, nesteDatoFinner -> nesteDatoFinner.fra(forrigeDato) }
    }
}