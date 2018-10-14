package no.netcompany.datotolk.datoutleder

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.Assert.assertEquals
import java.time.LocalDate

object SimpelDatoUtlederTest : Spek({
    describe("iDagUtleder") {
        it("returnerer samme dato") {
            val startdato1 = LocalDate.parse("2018-09-18")
            assertEquals(startdato1, SimpelDatoUtleder.iDagUtleder.fra(startdato1))

            val startdato2 = LocalDate.parse("2019-10-19")
            assertEquals(startdato2, SimpelDatoUtleder.iDagUtleder.fra(startdato2))
        }
    }
    describe("iGårUtleder") {
        it("returnerer gårsdagens dato") {
            val startdato = LocalDate.parse("2018-09-19")
            val forventet = LocalDate.parse("2018-09-18")

            val resultat = SimpelDatoUtleder.iGaarUtleder.fra(startdato)

            assertEquals(forventet, resultat)
        }
    }
})