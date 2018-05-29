package no.netcompany.sprak.cucumber

import cucumber.api.java8.No
import no.netcompany.sprak.tolk
import org.junit.Assert.assertEquals
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

            val resultat = tolk(gittDato, tekst)

            assertEquals(forventetDato, resultat)
        }
    }
}