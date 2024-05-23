// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id ("com.google.dagger.hilt.android") version "2.48.1" apply false
    id("com.google.devtools.ksp") version "1.9.20-1.0.14" apply false
    id ("com.android.application") version "8.2.0" apply false
    id( "com.android.library") version "8.1.1" apply false
    kotlin("android") version "1.9.20" apply false
    kotlin("jvm") version "1.9.20" apply false
    kotlin("plugin.parcelize") version "1.9.20" apply false
    kotlin("plugin.serialization") version "1.9.20" apply false
}