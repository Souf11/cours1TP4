# TP JPA : Strategies d'Heritage avec Hibernate

Projet Maven illustrant les trois strategies d'heritage en JPA avec Hibernate et H2 :
- SINGLE_TABLE (Vehicule -> Voiture, Moto)
- JOINED (Employe -> Developpeur, Manager)
- TABLE_PER_CLASS (Produit -> Livre, Electronique)

## Execution
```bash
mvn clean compile exec:java
```
