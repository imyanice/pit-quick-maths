plugins {
    java
    id("com.github.weave-mc.weave-gradle") version "649dba7468"
}

group = "me.yanjobs.pitquickmathslunar"
version = "1.0"

minecraft.version("1.8.9")

repositories {
    maven("https://jitpack.io")
    maven("https://repo.spongepowered.org/maven/")
}

dependencies {
    compileOnly("com.github.weave-mc:weave-loader:v0.1.0")

    compileOnly("org.spongepowered:mixin:0.8.5")
}

//tasks.compileJava {
//    options.release.set(11)
//}