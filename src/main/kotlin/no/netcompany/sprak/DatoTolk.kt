package no.netcompany.sprak

import java.time.DayOfWeek
import java.time.DayOfWeek.*
import java.time.LocalDate
import java.time.Month

fun tolk(gittDato: LocalDate, tekst: String): LocalDate {
    if(finnIDagITekst(tekst)){
        return gittDato
    }
    return finnDagIUken(gittDato, tekst.substring(0, 1).toLong(), finnDag(tekst))
}

private fun finnIDagITekst(tekst: String): Boolean {
    return "idag" in tekst || "i dag" in tekst
}

private fun finnDag(tekst: String): DayOfWeek {
    return when {
        tekst.contains("mandag") -> MONDAY
        tekst.contains("onsdag") -> WEDNESDAY
        tekst.contains("torsdag") -> THURSDAY
        tekst.contains("fredag") -> FRIDAY
        else -> throw Exception()
    }
}

private fun finnDagIUken(gittDato: LocalDate, antall: Long, dayOfWeek: DayOfWeek): LocalDate {
    if(antall == 1L){
        return finnDagIUke(gittDato, dayOfWeek);
    }
    return finnDagIUken(finnDagIUke(gittDato, dayOfWeek).plusDays(1), antall - 1L, dayOfWeek)
}

private fun finnDagIUke(gittDato: LocalDate, dayOfWeek: DayOfWeek): LocalDate {
    var dag = gittDato
    while (dag.dayOfWeek != dayOfWeek || dag.month != Month.JULY) {
        dag = dag.plusDays(1)
    }
    return dag;
}
