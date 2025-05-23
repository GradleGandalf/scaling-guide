# Compose Guide Demo

This sample demonstrates a simple-to-advanced Jetpack Compose setup using Material3 components and navigation.

## Modules
- **SimpleScreen** shows a welcome message and navigation button.
- **AdvancedScreen** demonstrates a basic animation using `AnimatedVisibility`.

## Running
Use Android Studio or Gradle to build the `app` module. The project uses Material 3 and Navigation Compose.

## Continuous Integration
A GitHub Actions workflow builds the project on every push or pull request. The workflow uses the latest Ubuntu runner with JDK 17 and installs the Android SDK before running `./gradlew assembleRelease`. This setup is free to use on public repositories.
