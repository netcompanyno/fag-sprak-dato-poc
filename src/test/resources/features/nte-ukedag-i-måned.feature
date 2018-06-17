#language: no
Egenskap: Nte ukedag i måned
  Skal finne nte ukedag i måned

  Scenariomal:
    Gitt at dagens dato er <dato>
    Når man skriver <tekst>
    Så får man <resultat>

    Eksempler:
      | dato       | tekst                 | resultat   |
      | 2018-06-13 | "1. mandag i juli"    | 2018-07-02 |
      | 2018-06-13 | "2. mandag i juli"    | 2018-07-09 |
      | 2018-06-13 | "1. tirsdag i juli"   | 2018-07-03 |
      | 2018-06-13 | "1. onsdag i juli"    | 2018-07-04 |
      | 2018-06-13 | "2. onsdag i juli"    | 2018-07-11 |
      | 2018-06-13 | "3. fredag i juli"    | 2018-07-20 |
      | 2018-06-13 | "4. torsdag i juli"   | 2018-07-26 |
      | 2018-06-14 | "1. tirsdag i august" | 2018-08-07 |
      | 2018-06-14 | "2. tirsdag i august" | 2018-08-14 |
      | 2018-06-14 | "3. tirsdag i august" | 2018-08-21 |
      | 2018-06-14 | "4. tirsdag i august" | 2018-08-28 |
      | 2018-06-14 | "1. onsdag i august"  | 2018-08-01 |
      | 2018-08-24 | "1. onsdag i juli"    | 2019-07-03 |
