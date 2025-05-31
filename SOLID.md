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
