# S - Single Responsibility Principle (SRP)

## 🧩 Principe de responsabilité unique

### 📖 Définition :

Une classe ne doit avoir qu'une seule responsabilité, c'est-à-dire une seule raison de changer. Cela rend le code plus facile à maintenir, tester et faire évoluer.

### ✅ Exemple correct :

```java
public class Facture {
    public double calculerTotal() {
        // logique de calcul
        return 0;
    }
}

public class FacturePrinter {
    public void imprimer(Facture facture) {
        // logique d'impression
    }
}

public class FactureSaver {
    public void sauvegarder(Facture facture) {
        // logique de sauvegarde
    }
}
```

Ici, chaque classe fait une seule chose : calcul, impression, ou sauvegarde.

### ❌ Mauvais exemple :

```java
public class Facture {
    public double calculerTotal() { ... }
    public void imprimer() { ... }
    public void sauvegarder() { ... }
}
```

Cette classe a trop de responsabilités. Elle violerait SRP car elle gère à la fois la logique métier, la présentation et la persistance.

# O — Open/Closed Principle (OCP)

## 🧩 Principe d’ouverture/fermeture

### 📖 Définition :

Un module doit être ouvert à l’extension, mais fermé à la modification.
Autrement dit, on doit pouvoir ajouter de nouvelles fonctionnalités sans modifier le code existant.

### ✅ Exemple correct :

```java
public interface Remise {
    double appliquer(double montant);
}

public class RemiseStandard implements Remise {
    public double appliquer(double montant) {
        return montant;
    }
}

public class RemiseClientFidele implements Remise {
    public double appliquer(double montant) {
        return montant * 0.9;
    }
}
```

On étend le comportement en créant une nouvelle classe, sans modifier la classe de base.

### ❌ Mauvais exemple :

```java
public class Remise {
    public double appliquer(double montant, String typeClient) {
        if (typeClient.equals("fidele")) {
            return montant * 0.9;
        }
        return montant;
    }
}
```

Le code devient difficile à maintenir au fur et à mesure qu'on ajoute des cas. On modifie constamment la même méthod.

# L — Liskov Substitution Principle (LSP)

## 🧩 Principe de substitution de Liskov

### 📖 Définition :

Une sous-classe doit pouvoir remplacer sa classe parente sans provoquer d’erreur ou modifier le comportement attendu du programme.

### ✅ Exemple correct :

```java
public class Oiseau {
    public void voler() { }
}

public class Hirondelle extends Oiseau {
    @Override
    public void voler() {
        // comportement de vol
    }
}
```

Hirondelle peut remplacer Oiseau dans n'importe quel contexte sans créer de bug.

### ❌ Mauvais exemple :

```java
public class Autruche extends Oiseau {
    @Override
    public void voler() {
        throw new UnsupportedOperationException("Les autruches ne volent pas !");
    }
}
```

Autruche viole LSP : elle hérite d’un comportement qu’elle ne peut pas assumer (voler).
