#language: no
Egenskap: Periode

  Scenariomal:
    Gitt at dagens dato er <dato>
    Når man skriver <tekst>
    Så får man <resultat>

    Eksempler:
      | dato       | tekst                               | resultat   |
      | 2018-06-13 | "for 1 måned siden"                 | 2018-05-13 |
      | 2018-06-13 | "for 10 måneder siden"              | 2017-08-13 |
      | 2018-06-13 | "for 1 år siden"                    | 2017-06-13 |
      | 2018-06-13 | "for 2 år siden"                    | 2016-06-13 |
      | 2018-06-13 | "for 1 år og 1 måned siden"         | 2017-05-13 |
      | 2018-06-13 | "for 1 år og 2 måned og 3 år siden" | 2014-04-13 |
      | 2018-06-13 | "for 1 år, 2 måneder og 3 år siden" | 2014-04-13 |
      | 2018-06-13 | "for 2 år og 1 måned siden"         | 2016-05-13 |

