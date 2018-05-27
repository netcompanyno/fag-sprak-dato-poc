package no.netcompany.sprak.cucumber

import cucumber.api.java8.No
import java.time.LocalDate

class TestLim : No {
    private lateinit var gittDato: LocalDate
    private lateinit var tekst: String
    private lateinit var forventetDato: LocalDate

    init {
        Gitt("^at dagens dato er ([0-9\\-]+)$") { gittDatoString: String ->
            this.gittDato = LocalDate.parse(gittDatoString)
        }

        Når("^man skriver \"(.*)\"$") { tekst: String ->
            this.tekst = tekst
        }

        Så("^får man ([0-9\\-]+)$") { forventetDatoString: String ->
            this.forventetDato = LocalDate.parse(forventetDatoString)

            TODO("tolk dato (dato=$gittDato, input='$tekst', forventet=$forventetDato)")
        }
    }
}