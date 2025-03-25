# Backlog

## What can be improved in the codebase ?

- Les comparaisons entre deux objets doivent être réalisées avec un .equals() au lieu d'un ==
- Pas de fonction get() adaptée
- Pas assez de couverture de test dans MoneyCalculatorTest et les tests ne sont pas assez complets.
- Pas de vérification de doublons sur les taux de change.
- MoneyCalculator n'est pas utilisé
- MoneyCalculator effectue des opérations de base, inutile.
- Les méthodes de MoneyCalculator ont un paramètre Currency qui n'est pas utilisé, on peut faire des calculs avec des monnaies différentes
- Méthodes non documentées sur les classes métier
- Nommages des variables peu clair
- Répétitions de code
- Méthode à réaliser pour tester une condition complexe (convert() de Bank.Java)
- Manque de Guard sur plusieurs méthodes (Echange vers la même devise, division par zéro)