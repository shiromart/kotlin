plugins {
    kotlin("jvm")
    id("jps-compatible")
    application
}

dependencies {
    implementation(project(":compiler:fir:tree"))
    implementation(project(":compiler:fir:tree:tree-generator"))
    implementation(project(":kotlin-reflect"))
    implementation(project(":kotlin-reflect-api"))

    implementation(intellijCoreDep()) { includeJars("intellij-core") }
    implementation(project(":compiler:psi"))
}

val writeCopyright by task<tasks.WriteCopyrightToFile> {
    outputFile = file("$buildDir/copyright/notice.txt")
    commented = true
}

application {
    mainClassName = "org.jetbrains.kotlin.fir.checkers.generator.MainKt"
}

val processResources by tasks
processResources.dependsOn(writeCopyright)

sourceSets {
    "main" {
        projectDefault()
        resources.srcDir("$buildDir/copyright")
    }
    "test" {}
}
