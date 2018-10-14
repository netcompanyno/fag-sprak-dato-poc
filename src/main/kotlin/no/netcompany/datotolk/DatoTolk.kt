package no.netcompany.datotolk

import no.netcompany.datotolk.datoutleder.DatoUtleder
import no.netcompany.datotolk.datoutleder.SimpelDatoUtleder
import no.netcompany.datotolk.parser.DatotolkLexer
import no.netcompany.datotolk.parser.DatotolkParser
import no.netcompany.datotolk.parser.DatotolkParserBaseVisitor
import no.netcompany.datotolk.util.finnMåned
import no.netcompany.datotolk.util.finnNteUkedagIMåned
import no.netcompany.datotolk.util.finnUkedag
import org.antlr.v4.runtime.BufferedTokenStream
import org.antlr.v4.runtime.CharStreams
import java.time.LocalDate

fun tolk(startdato: LocalDate, tekst: String): LocalDate {
    val datoUtleder: DatoUtleder = tolkTekstTilDatoUtleder(tekst)

    return datoUtleder.fra(startdato)
}

private fun tolkTekstTilDatoUtleder(tekst: String): DatoUtleder {
    val parseMedAntlr = parseMedAntlr(tekst)
    if (parseMedAntlr != null) {
        return parseMedAntlr
    }

    // Fallback for ting som ikke er implementert med Antlr ennå:
    val antall = tekst.substring(0, 1).toInt()
    val ukedag = finnUkedag(tekst)
    val måned = finnMåned(tekst)

    return finnNteUkedagIMåned(antall, ukedag, måned)
}

private fun parseMedAntlr(tekst: String): DatoUtleder? {
    val lexer = DatotolkLexer(CharStreams.fromString(tekst))
    val parser = DatotolkParser(BufferedTokenStream(lexer))
    val datoVisitor = DatoVisitor()
    return datoVisitor.visit(parser.datoRegel())
}

private class DatoVisitor : DatotolkParserBaseVisitor<DatoUtleder>() {

    override fun visitIdagUttrykk(ctx: DatotolkParser.IdagUttrykkContext): DatoUtleder {
        return SimpelDatoUtleder.iDagUtleder
    }

}
