package no.netcompany.datotolk.parser

import java.time.Period

object PeriodeVisitor : DatotolkParserBaseVisitor<Period>() {

    override fun visitAntallAar(ctx: DatotolkParser.AntallAarContext): Period {
        val antallAar = ctx.tall().text.toInt()
        return Period.ofYears(antallAar)
    }

    override fun visitAntallMaaneder(ctx: DatotolkParser.AntallMaanederContext): Period {
        val antallMaaneder = ctx.tall().text.toInt()
        return Period.ofMonths(antallMaaneder)
    }

    override fun visitSammensattPeriode(ctx: DatotolkParser.SammensattPeriodeContext): Period {
        val periode1 = visit(ctx.periode()[0])
        val periode2 = visit(ctx.periode()[1])
        return periode1.plus(periode2)
    }

}