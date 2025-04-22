# Example Mapping

## Format de restitution
*(rappel, pour chaque US)*

```markdown
## Titre de l'US (post-it jaunes)

> Question (post-it rouge)

### Evaluation possible sans taux de change lorsqu'il n'y a pas en conversion

- A Portfolio with 5 USD and 10 EUR
    -> Evaluate in EUR
    => 15 EUR

### En cas de conversion, taux de change nécessaire devises portfolio -> devise d'évaluation

- A portfolio with 5 USD and 10 EUR
- A Bank with exchange rate EUR -> USD : 1.2
    -> Evaluate in USD 
    => 17 USD

- A portfolio with 5 USD and 10 EUR
- A Bank with exchange rate EUR -> KRW : 1344
- A Bank with exchange rate EUR -> KRW : 1100
    -> Evaluate in KRW 
    => 18940 USD

### En cas de conversion, taux de change nécessaire devises portfolio -> devise d'évaluation : échec

- A portfolio with 5 USD and 10 EUR
- A Bank with exchange rate EUR -> KRW : 1100
    -> Evaluate in KRW 
    => Error : Missing echange rate EUR -> KRW

### Règle Métier (post-it bleu)

Exemple: (post-it vert)

- [ ] 5 USD + 10 EUR = 17 USD
```

Vous pouvez également joindre une photo du résultat obtenu en utilisant les post-its.

## Évaluation d'un portefeuille




