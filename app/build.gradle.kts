plugins {
    id("com.android.application")
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
    kotlin("android")
    kotlin("plugin.serialization")
    kotlin("plugin.parcelize")

}

android {
    namespace = "com.example.practicaltest"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.practicaltest"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.4"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    //implementation(libs.androidx.material3.android)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation(libs.ktorSerializer)
    implementation(libs.ktorClientCore)
    implementation(libs.ktorClientAndroid)
    implementation(libs.ktorClientAuth)
    implementation(libs.ktorNegotiation)
    implementation(libs.ktorLogging)
    implementation(libs.ktorOkhttp)
    implementation(libs.ktorNetwork)
    implementation(libs.ktorNetworkTls)


    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.12")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.12")
    implementation("com.squareup.retrofit2:retrofit-mock:2.9.0")
    implementation("com.squareup.okhttp3:mockwebserver:4.12.0")

    // view model
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.7.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")

    //coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.0")

    implementation("org.jetbrains.kotlinx:kotlinx-collections-immutable:0.3.6")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.1")
    implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:1.0.0")


    implementation("com.jakewharton.timber:timber:5.0.1")

    // dagger hilt
    implementation ("com.google.dagger:hilt-android:2.51.1")
    ksp ("com.google.dagger:hilt-compiler:2.51.1")

    implementation ("androidx.hilt:hilt-navigation-compose:1.2.0")
    implementation ("androidx.navigation:navigation-compose:2.7.7")

    ksp("androidx.hilt:hilt-compiler:1.2.0")
    implementation("androidx.hilt:hilt-common:1.2.0")

    implementation("io.coil-kt:coil:2.6.0")
    implementation("io.coil-kt:coil-compose:2.6.0")
    implementation("com.google.code.gson:gson:2.7")


}