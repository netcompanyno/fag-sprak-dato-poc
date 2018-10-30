package no.netcompany.datotolk.parser

import no.netcompany.datotolk.datoutleder.*
import no.netcompany.datotolk.util.finnMåned
import no.netcompany.datotolk.util.finnUkedag

object DatoUtlederVisitor : DatotolkParserBaseVisitor<DatoUtleder>() {

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
}

private fun lesTall(nummer: DatotolkParser.NummerContext): Int = nummer.tall().text.toInt()
