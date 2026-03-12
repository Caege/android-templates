To migrate your project to **Hilt (Dependency Injection)**, you mainly need to:

1️⃣ Add Hilt dependencies  
2️⃣ Enable Hilt in the application  
3️⃣ Create a **DI module** for Retrofit  
4️⃣ Inject dependencies into your ViewModel and Activity

Your structure will stay almost the same, but you’ll add a **di package**.

---

# 📁 Project Structure After Hilt

```text
kotlin+java
└── com.example.retrofitdi
    │
    ├── network
    │   └── PostApi.kt
    │
    ├── di
    │   └── NetworkModule.kt
    │
    ├── ui.theme
    │
    ├── MainActivity.kt
    │
    ├── MainViewModel.kt
    │
    └── App.kt
```

New files:

```
App.kt
NetworkModule.kt
```

---

# 1️⃣ Add Hilt Dependencies



First, add the plugins to your **root `build.gradle`**:

```kotlin
plugins {
  id("com.google.dagger.hilt.android") version "2.59.2" apply false
  id("com.google.devtools.ksp") version "2.2.10-2.0.2" // must match Kotlin version
}
```

`hilt-android-gradle-plugin` enables **Hilt code generation**.  
`ksp` runs **annotation processors** used by Hilt.

---

Then apply the plugins in **`app/build.gradle`**:

```kotlin
plugins {
  id("org.jetbrains.kotlin.android")
  id("com.google.devtools.ksp")
  id("com.google.dagger.hilt.android")
}
```

Add Hilt dependencies:

```kotlin
dependencies {
  implementation("com.google.dagger:hilt-android:2.59.2")
  ksp("com.google.dagger:hilt-compiler:2.59.2")
}
```

These provide **Hilt runtime** and the **compiler that generates DI code**.

---
# 2️⃣ Add Retrofit  Dependencies

```kotlin
// Retrofit
implementation("com.squareup.retrofit2:retrofit:2.9.0")

// Retrofit Scalar Converter
implementation("com.squareup.retrofit2:converter-scalars:2.9.0")
```

# 3️⃣  Create the Application Class

Create:

```
App.kt
```

```kotlin
@HiltAndroidApp
class App : Application()
```

Register it in **AndroidManifest.xml**

```xml
<application
    android:name=".App"
>
```

This tells Hilt to **generate the dependency container**.

---

# 4️⃣ Create a Hilt Network Module

Create:

```
di/NetworkModule.kt
```

This tells Hilt **how to build Retrofit and PostApi**.



```kotlin
data class NetworkConfig(  
    val baseUrl: String  
)  
  
  
@Module  
@InstallIn(SingletonComponent::class)  
object NetworkModule {  
  
    @Provides
    @Singleton  
    fun provideNetworkConfig(): NetworkConfig {  
        return NetworkConfig(  
            baseUrl = "https://jsonplaceholder.typicode.com/"  
        )  
    }  
  
    @Provides  
    @Singleton    
    fun provideRetrofit(config: NetworkConfig): Retrofit {  
        return Retrofit.Builder()  
            .baseUrl(config.baseUrl)  
            .addConverterFactory(ScalarsConverterFactory.create())  
            .build()  
    }  
  
    @Provides  
    @Singleton    
    fun providePostApi(retrofit: Retrofit): PostApiService {  
        return retrofit.create(PostApiService::class.java)  
    }  
}
```

---

#  5️⃣Inject the API into ViewModel

Modify your **MainViewModel**

```kotlin
@HiltViewModel
class MainViewModel @Inject constructor(
    private val postApi: PostApiService
) : ViewModel()
```

Hilt now automatically **provides PostApiService**.

---

#  6️⃣Enable Hilt in Activity

Annotate your activity:

```kotlin
@AndroidEntryPoint
class MainActivity : ComponentActivity()
```

Now Hilt can inject dependencies used by the ViewModel.

---

# 🔄 Final Dependency Flow

```
Application (@HiltAndroidApp)
        ↓
Activity (@AndroidEntryPoint)
        ↓
ViewModel (@HiltViewModel)
        ↓
PostApiService
        ↓
Retrofit
        ↓
NetworkConfig
```

---


# 🧠 Quick Rule for Hilt

```
@Module → how to create dependency
@Inject → where dependency is needed
```

Example:

```
@Module
provides Retrofit

@Inject
uses Retrofit
```

---

