#language: no
Egenskap: Nte ukedag i måned
  Skal finne nte ukedag i måned

  Scenariomal:
    Gitt at dagens dato er <dato>
    Når man skriver <tekst>
    Så får man <resultat>

    Eksempler:
      | dato       | tekst               | resultat   |
      | 2018-06-13 | "1. mandag i juli"  | 2018-07-02 |
      | 2018-06-13 | "2. mandag i juli"  | 2018-07-09 |
      | 2018-06-13 | "1. onsdag i juli"  | 2018-07-04 |
      | 2018-06-13 | "2. onsdag i juli"  | 2018-07-11 |
      | 2018-06-13 | "3. fredag i juli"  | 2018-07-20 |
      | 2018-06-13 | "4. torsdag i juli" | 2018-07-26 |
