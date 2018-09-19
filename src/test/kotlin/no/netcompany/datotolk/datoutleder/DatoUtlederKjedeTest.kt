package no.netcompany.datotolk.datoutleder

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.junit.Assert.assertEquals
import java.time.LocalDate

object DatoUtlederKjedeTest : Spek({
    given("noen datoutledere") {
        val leggTil1dag = SimpelDatoUtleder { startdato -> startdato.plusDays(1) }
        val leggTil2dager = SimpelDatoUtleder { startdato -> startdato.plusDays(2) }
        val leggTil4dager = SimpelDatoUtleder { startdato -> startdato.plusDays(4) }

        describe("DatoUtlederKjede") {
            val datoUtlederKjede = DatoUtlederKjede(leggTil1dag, leggTil2dager, leggTil4dager)

            it("kjører alle datoutlederne etterhverandre") {
                val startdato = LocalDate.now()

                val resultat = datoUtlederKjede.fra(startdato)

                assertEquals(startdato.plusDays(7), resultat)
            }
        }
    }
})