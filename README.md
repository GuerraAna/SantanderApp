# SantanderApp

App desenvolvido no **Bootcamp Santander Mobile (DIO)** — réplica do app do banco Santander com integração Firebase.

## Objetivo

Projeto final do bootcamp: telas do app bancário com monitoramento via Firebase (Analytics, Crashlytics e Performance).

## Tecnologias

- Kotlin
- **Firebase** — Analytics, Crashlytics, Performance (`google-services.json` já incluído)
- AppCompat, Material, ConstraintLayout
- ViewModel + LiveData
- AGP 4.2.1 / Gradle 6.7.1

## Pré-requisitos

- **JDK 11**
- Android SDK
- O `app/google-services.json` já está no repositório — aponta para o projeto Firebase original do bootcamp

## Como rodar

```bash
echo "sdk.dir=$HOME/Library/Android/sdk" > local.properties   # macOS
./gradlew assembleDebug
```
