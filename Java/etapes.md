# Étapes réalisées

Voici les étapes que j'ai réalisées pour le refactoring:

1. Simplifier au maximum updateQuality() sans en changer la logique
   1. foreach au lieu de for avec index
   2. Créer des constantes pour les nombres et noms
   3. Raccourcir les opérations (++, --)
2. J'ai écrit les tests les plus exhaustif possible
   1. Tout les types possibles
   2. Tout les cas spéciaux de changement de quality (maximum, minimum, +2, +3, etc.)
   3. J'ai pu voir avec mes tests que tout les cas n'étaient pas implémentés
3. J'ai commencé par scinder updateQuality() en plusieur plus petite fonction, une par type d'objet
4. J'ai remplacé des bouts de logique par l'appel de ces fonctions
5. A partir de cette étape je me suis rendu compte qu'un switch case pourrait être idéal
6. J'ai retiré l'appel des fonctions et j'ai mis les modifications de sellIn et quality dans le switch car ce n'est que 2 lignes, cela reste lisible dans le switch
    . J'aurais gardé les fonctions séparés si plusieurs types d'item avaient la même logique mais ce n'est pas le cas ici.
7. J'ai créé setOverflowingQualityToMaxOrMin() que j'appel à la fin de la boucle pour corriger la quality > 50 ou quality < 0
8. J'ai décidé d'appeler setOverflowingQualityToMaxOrMin() aussi au début pour corriger les items avec une quality qui ne respect pas les règles avant de les traiter.

Amélioration possible: Polymorphisme.
Créer une classe par type d'objet et implémenter updateQuality dedans.
