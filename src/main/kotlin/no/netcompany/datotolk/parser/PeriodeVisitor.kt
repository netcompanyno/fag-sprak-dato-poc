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

    override fun visitPerioder(ctx: DatotolkParser.PerioderContext): Period {
        val period1 = visit(ctx.periode()[0])
        val period2 = visit(ctx.periode()[1])
        return period1.plus(period2)
    }
}