# 🗂️ Project structure

```text
com.example.demo.student
├── controller/
│   └── StudentController.java
├── dto/
│   └── StudentDTO.java
├── mapper/
│   └── StudentMapper.java
├── model/
│   └── Student.java
├── repository/
│   └── StudentRepository.java
├── service/
│   ├── StudentService.java
│   └── interface/
│       └── StudentServiceInterface.java
```

# 🧭 Étapes de développement

## ✅ 1. Définir le modèle (model)

📄 **model/Student.java**  
C’est l’entité JPA qui correspond à la table en base de données.

> On y définit les attributs comme `id`, `name`, `email`, etc.

- [Exemple](Code/model/Student.java)

## ✅ 2. Créer le DTO

📄 **dto/StudentDTO.java**  
Ce fichier représente les données échangées avec le client (REST API).

> Il est séparé du modèle pour éviter d’exposer directement l’entité.

- [Exemple](Code/dto/StudentDTO.java)

## ✅ 3. Créer le Mapper

📄 **dto/StudentDTO.java**  
Il convertit un `Student` ↔ `StudentDTO`.

> Il est séparé du modèle pour éviter d’exposer directement l’entité.

- [Exemple](Code/mapper/StudentMapper.java)

## ✅ 4. Créer le Repository

📄 **repository/StudentRepository.java**  
Utilise `JpaRepository` pour accéder à la base.

> Par exemple, `findStudentByEmail(String email)`.

- [Exemple](Code/repository/StudentRepository.java)

## ✅ 5. Définir l’interface service

📄 **service/impl/StudentServiceImpl.java**  
Tu définis les méthodes du service :

- `getStudents()`
- `addNewStudent(...)`
- `deleteStudent(...)`
- `updateStudent(...)`

> C’est une abstraction, utile pour séparer le contrat de l’implémentation.

- [Exemple](Code/service/interface/StudentServiceInterface.java)

## ✅ 6. Implémenter le service métier

📄 **service/StudentService.java**  
C’est ici que tu implémentes la logique métier réelle.

Tu utilises :

- le repository
- le mapper
- tu appliques la validation métier

- [Exemple](Code/service/StudentService.java)

## ✅ 7. Créer le contrôleur (API)

📄 **controller/StudentController.java**  
C’est le point d’entrée des appels REST (`GET`, `POST`, etc.)

> Le contrôleur appelle le service et renvoie des `ResponseEntity`.

- [Exemple](Code/controller/StudentController.java)

# 📝 Résumé en chaîne logique :

1. **Modèle (model)** : structure de l'entité.

2. **DTO** : structure d’échange (évite d'exposer l'entité).

3. **Mapper** : conversion entre DTO ↔ Entity.

4. **Repository** : accès à la BDD.

5. **Interface du service** : contrat métier.

6. **Implémentation du service** : logique métier.

7. **Contrôleur** : exposition REST de la logique.

# 🤔 Pourquoi cet ordre ?

**Cela respecte** :

- Le principe de séparation des responsabilités (**SRP**).
- Le principe de dépendance à l’abstraction (**DIP**).
- Et facilite les tests unitaires et l’évolution du code.
