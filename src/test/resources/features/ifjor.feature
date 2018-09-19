# language: no
Egenskap: I fjor
  Alle varianter av "samme dag i fjor" skal gi fjorårets dato.

  Scenario: samme dag ifjor
    Gitt at dagens dato er 2018-05-27
    Når man skriver "samme dag ifjor"
    Så får man 2017-05-27

  Scenario: samme dag i fjor
    Gitt at dagens dato er 2018-07-26
    Når man skriver "samme dag i fjor"
    Så får man 2017-07-26

  Scenario: for et år siden
    Gitt at dagens dato er 2018-09-19
    Når man skriver "for et år siden"
    Så får man 2017-09-19