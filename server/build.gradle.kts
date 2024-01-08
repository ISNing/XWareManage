plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.ktor)
    alias(libs.plugins.detekt)
    application
}

group = "cn.edu.buct.snc.xware.manage"
version = "1.0.0"
application {
    mainClass.set("cn.edu.buct.snc.xware.manage.ApplicationKt")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=${extra["development"] ?: "false"}")
}

dependencies {
    implementation(projects.shared)
    implementation(libs.logback)
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.netty)
    testImplementation(libs.ktor.server.tests)
    testImplementation(libs.kotlin.test.junit)
}

detekt {
    source.setFrom(
        "src/main/kotlin",
    )
    config.setFrom("detekt.yml")
    buildUponDefaultConfig = true
    debug = false
    basePath = projectDir.absolutePath
}
