plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.greeting"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.greeting"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "com.greeting.test.TestRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled  = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    sourceSets {
        getByName("androidTest").assets.srcDirs("src/androidTest")
        getByName("main").java.srcDirs("src/main")
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("androidx.activity:activity-compose:1.9.0")
    implementation("com.google.accompanist:accompanist-themeadapter-appcompat:0.28.0")
    implementation("com.google.dagger:hilt-android:2.51.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.test.uiautomator:uiautomator:2.3.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.6.8")
    androidTestImplementation("com.google.dagger:hilt-android-testing:2.50")
    androidTestImplementation("io.cucumber:cucumber-android:7.14.0")
}
