# Android CropImage

![Screenshots](https://raw.githubusercontent.com/afollestad/android-cropimage/master/art/screenshot.png)

# Gradle Dependency

[![Release](https://img.shields.io/github/release/afollestad/android-cropimage.svg?label=jitpack)](https://jitpack.io/#afollestad/android-cropimage)

### Repository

First, add the following to your app's `build.gradle` file:

```Gradle
repositories {
    maven { url "https://jitpack.io" }
}
```

### Dependency

```gradle
dependencies {

    // ... other dependencies here
    
    compile('com.github.afollestad.android-cropimage:core:1.0.0@aar') {
        transitive = true
    }
}
```

### 