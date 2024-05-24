# material_3_theme_analyzer
Material 3 Theme Analyzer Library
> Step 1. Add JitPack repository to your build file


```gradle
allprojects {
	repositories {
		...
		maven { url = uri ("https://jitpack.io") }
	}
}
```

> Step 2. Add the dependenecy
```gradle
dependencies {
  implementation ("com.github.InfantAjith96:Material_3_Theme_Analyzer:1.0.0")
}
