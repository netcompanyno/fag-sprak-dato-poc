# language: no
Egenskap: I fjor
  Alle varianter av "i fjor" skal gi fjorårets dato.

  Scenario: ifjor
    Gitt at dagens dato er 2018-05-27
    Når man skriver "ifjor"
    Så får man 2017-05-27

  Scenario: i fjor
    Gitt at dagens dato er 2018-07-26
    Når man skriver "i fjor"
    Så får man 2017-07-26
