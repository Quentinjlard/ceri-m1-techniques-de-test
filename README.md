# UCE Génie Logiciel Avancé : Techniques de tests

## Introduction

Vous allez à travers ces projet mettre en application une partie des aspects évoqués en cours vis à vis des techniques de tests.  
Pour cela nous allons réaliser un projet logiciel de petite taille, en suivant la roadmap suivante : 
- Setup du projet
- Mise en place des outils d’intégration continue
- Écriture des tests unitaires
- Écriture des mocks, et validation des tests
- Développement dirigé par les tests
- Documentation et conventions de style
- Test d'une implémentation donnée

Durant cette série de TPs, le gestionnaire de version Git sera utilisé à foison, à travers la plateforme GitHub. Si vous n’êtes pas à l’aise avec cet outil[^1], [voici](http://rogerdudler.github.io/git-guide/) un petit guide à garder sous la main.

## Sujets

L'ensemble des sujets de TPs peut être trouvé dans le dossier `TPs`.

Le dossier `src` contient la définition de l'ensemble des interfaces qui seront l'objet de vos travaux.

## Rendus

Le rendu des TPs se fait au rythme suivant :

- TP1 : 2ème séance
- TP2 : 2ème séance
- TP3 : 3ème séance
- TP4 : 5ème séance
- TP5 : dernière séance
- TP6 : dernière séance

Pour chaque rendu vous devez créer un tag à partir du commit qui correspond à la complétion du TP.  
Si vous ne spécifiez pas de tag, le dernier commit à la date-heure de la fin de séance sera celui considéré.

[^1]: Si vous n’êtes vraiment pas à l’aise avec cet outil nous vous conseillons quand même vivement de vous y mettre.

## Inforamtion concernant l'étudiant et le projet

- Nom : JUILLIARD
- Prénom : Quentin
- Groupe : Master IA - Groupe IA - alt




[![CircleCI](https://circleci.com/gh/circleci/circleci-docs.svg?style=svg)](https://app.circleci.com/pipelines/circleci/4pTDtLg5hUaDMd85yZjtX5/M47uwUrhPaVPDdsfFE2pGu)

[![codecov](https://codecov.io/gh/Quentinjlard/ceri-m1-techniques-de-test/graph/badge.svg?token=KEMV4XR2ZF)](https://codecov.io/gh/Quentinjlard/ceri-m1-techniques-de-test)

[![Checkstyle](https://img.shields.io/badge/checkstyle-passing-brightgreen)](https://circleci-tasks-prod.s3.us-east-1.amazonaws.com/storage/artifacts/a26643bf-8981-4dad-8c48-7bad3b573e6e/2f2248c6-1a0e-4be2-848d-582095ecb9ea/0/target/checkstyle-result.xml?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=ASIAQVFQINEOJN2Q3VOD%2F20240409%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20240409T080958Z&X-Amz-Expires=60&X-Amz-Security-Token=IQoJb3JpZ2luX2VjENj%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FwEaCXVzLWVhc3QtMSJHMEUCIQCOI8XYibK2T0PqzUrCW5YJMH253Sw9qdU0C%2BjW1mLAZgIgbFWPIf88wDVT1g1BKzM%2B0Unf2fEb7AOv8jTe0lyNjVwqqwIIERADGgwwNDU0NjY4MDY1NTYiDI2ed81wnRG7C1JAjyqIAjX%2BSWEBF6pOE6hEKF7nBMz9UJEcRBHamne4PGTi9b19PGoPuHez4j%2B%2FHFp0kIhaHygEnwgYdKhg8aIsrpxWvaTsHhtK4D46HKno0g%2FoZ6zDR%2BWknhY59T75fedscslrXR4YKZAWv1WgPEXQAGuxIkRjWcGk02PVY6oIOz9KlTRrngzT51QrJi7bQEK1sixG1V71v8%2FYN5TRPYuxZRjIl4dOw6442vkTG2PaBKuK7BBcrIzR02fQYSfvfbHXOd67TKihaAm2ROoDSYSGsrHFjzLYmr9pUMD1LcwweRW4CoW8ySV37J74BSXmlP0V4RdwjME6%2BiSrxZziuWquPkj21U9APquGQyo3UjCN7NOwBjqdAZnHOhDzISp4ZOm4vgrV571RjbGCq7hW7k2K83x9t83Ngm%2Fnnw9JQTEKuZPJI6kxlnRG1anUaxFxNHgRlYnUJ1pzStgZtJ9JLcHoYPkQhZzaFOlGQxC7vFM6k%2F8T3BimdluXVklpiWv7U9k9zNdh2l0U2OiOepU1BYwEDBrzJhdNn1M8qH0UX7%2FMECG8HDsbEHaesuD3paqwTgwfu3c%3D&X-Amz-SignedHeaders=host&x-id=GetObject&X-Amz-Signature=01752d43cd53bf50ae277ba33a0537a7726fa87f319d596a1b4663e7ca39ea8d)

[Documentation de l'application ](https://quentinjlard.github.io/ceri-m1-techniques-de-test/target/site/apidocs/fr/univavignon/pokedex/api/package-summary.html)

## Retour de TP

Certain Test dont ceux PokemonTrainerFactory.java ne sont pas visible sur Codecov néanmois, lors de la compilation de 
l'intégralité du projet ceux-ci sont bein focntionne.

Quelques probléme / complication sur la mise en place de certains outils de la CI/CD, mais tout est fonctionnel.

Probléme majeur lors de la création de la clé entre GitHub et Circle Ci car celle ci était unqiuement en Read et non en Write / Read.
Ce qui a posé des problémes lors de la mise en place de la Javadoc.

Lors de la mise en place du code de la Team Rocket, j'ai mis en place un fichier de test lié à la team rockets sur la 
même principe que pokemon factory. L'ensemble des test passe.

Pour le team rocket, probléme sur le fait que si l'index > 0 les méthode qu'elle met en place ne sont pas couverte par un test.