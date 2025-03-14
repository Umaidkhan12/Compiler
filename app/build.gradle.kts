plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.compiler"
    compileSdk = 35

    val clientId = System.getenv("JDOODLE_CLIENT_ID") ?: "\"defaultClientId"
    val clientSecret = System.getenv("JDOODLE_CLIENT_SECRET") ?: "\"defaultClientSecret"

    defaultConfig {
        applicationId = "com.example.compiler"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        buildConfigField("String", "JDOODLE_CLIENT_ID", "${clientId}\"")
        buildConfigField("String", "JDOODLE_CLIENT_SECRET", "${clientSecret}\"")

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    implementation(libs.volley)
    androidTestImplementation(libs.androidx.espresso.core)
}