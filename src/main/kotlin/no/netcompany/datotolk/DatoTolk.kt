package no.netcompany.datotolk

import no.netcompany.datotolk.datoutleder.*
import no.netcompany.datotolk.parser.DatotolkLexer
import no.netcompany.datotolk.parser.DatotolkParser
import no.netcompany.datotolk.parser.DatotolkParserBaseVisitor
import no.netcompany.datotolk.util.finnMåned
import no.netcompany.datotolk.util.finnUkedag
import org.antlr.v4.runtime.BufferedTokenStream
import org.antlr.v4.runtime.CharStreams
import java.time.LocalDate

fun tolk(startdato: LocalDate, tekst: String): LocalDate {
    val datoUtleder: DatoUtleder = tolkTekstTilDatoUtleder(tekst)

    return datoUtleder.fra(startdato)
}

private fun tolkTekstTilDatoUtleder(tekst: String): DatoUtleder {
    val lexer = DatotolkLexer(CharStreams.fromString(tekst))
    val parser = DatotolkParser(BufferedTokenStream(lexer))

    return DatoUtlederVisitor.visit(parser.dato())
}

private object DatoUtlederVisitor : DatotolkParserBaseVisitor<DatoUtleder>() {

    override fun visitIdag(ctx: DatotolkParser.IdagContext): DatoUtleder {
        return SimpelDatoUtleder.iDagUtleder
    }

    override fun visitIgaar(ctx: DatotolkParser.IgaarContext): DatoUtleder {
        return SimpelDatoUtleder.iGaarUtleder
    }

    override fun visitNteUkedagIMaaned(ctx: DatotolkParser.NteUkedagIMaanedContext): DatoUtleder {
        val maanedUtleder = visit(ctx.maaned())
        val ukedagUtleder = visit(ctx.flytendeUkedag())

        return DatoUtlederKjede(maanedUtleder, ukedagUtleder)
    }

    override fun visitNteUkedag(ctx: DatotolkParser.NteUkedagContext): DatoUtleder {
        val dayOfWeek = finnUkedag(ctx.ukedag().text)
        val n = lesTall(ctx.nummer())

        return UkedagUtleder(dayOfWeek, n)
    }

    override fun visitMaaned(ctx: DatotolkParser.MaanedContext): DatoUtleder {
        val month = finnMåned(ctx.text)

        return MånedUtleder(month)
    }

    private fun lesTall(nummer: DatotolkParser.NummerContext): Int = nummer.tall().text.toInt()
}

