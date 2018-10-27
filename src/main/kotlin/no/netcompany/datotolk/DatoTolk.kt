package no.netcompany.datotolk

import no.netcompany.datotolk.parser.DatoUtlederVisitor
import no.netcompany.datotolk.parser.DatotolkLexer
import no.netcompany.datotolk.parser.DatotolkParser
import org.antlr.v4.runtime.BufferedTokenStream
import org.antlr.v4.runtime.CharStreams
import java.time.LocalDate

fun tolk(startdato: LocalDate, tekst: String): LocalDate {
    val lexer = DatotolkLexer(CharStreams.fromString(tekst))
    val parser = DatotolkParser(BufferedTokenStream(lexer))
    val datoUtleder = DatoUtlederVisitor.visit(parser.dato())

    return datoUtleder.fra(startdato)
}

