import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = 33

    val apiKey = gradleLocalProperties(rootDir).getProperty("api.key")

    defaultConfig {
        applicationId = "com.example.lolplayertracker"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "API_KEY", "\"${apiKey}\"")

    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        getByName("debug") {
            applicationIdSuffix = ".debug"
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    //AndroidX Core
    implementation("androidx.core:core-ktx:1.9.0")

    //AppCompat
    implementation("androidx.appcompat:appcompat:1.6.1")

    //Material
    implementation("com.google.android.material:material:1.8.0")

    //Constrain Layout
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    //Orianna Riot API
    implementation("com.merakianalytics.orianna:orianna-android:4.0.0-rc8")

    //Guava
    implementation("com.google.guava:guava:27.0.1-android")

    //JUnit
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")

    //Espresso
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}

