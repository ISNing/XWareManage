This is a Kotlin Multiplatform project targeting Android, iOS, Desktop, Server.

* `/server` is for the Ktor server application.

* `/shared` is for the code that will be shared between all targets in the project.
  The most important subfolder is `commonMain`. If preferred, you can add code to the platform-specific folders here too.

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

* `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform, 
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.


Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…  

To run server target:
`./gradlew :server:run`  
To build server distribution target:
`./gradlew :server:assembleDist`  
To run desktop target:
`./gradlew :composeApp:run`  
To build desktop distribution target:
`./gradlew :composeApp:createDistributable`  
To run js browser target:
`./gradlew :composeApp:jsBrowserRun`  
To build js browser target:
`./gradlew :composeApp:jsBrowserDistribution`  
To run wasmJs browser distribution target:
`./gradlew :composeApp:wasmJsBrowserRun`  
To build wasmJs browser distribution target:
`./gradlew :composeApp:wasmJsBrowserDistribution`

To run android and ios targets, please use Android Studio and Android Studio with Xcode respectively.