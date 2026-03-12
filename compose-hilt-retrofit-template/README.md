

# Compose + Hilt + Retrofit Template

A minimal Android starter template with modern tools and architecture.

## Stack

* **Jetpack Compose** – UI
* **Hilt** – Dependency Injection
* **Retrofit** – Networking
* **ViewModel** – UI state management
* **KSP** – Annotation processing
* **Version Catalog** – Dependency management

---

## Project Structure

```text
com.example.template
│
├── di
│   └── NetworkModule.kt
│
├── network
│   └── PostApiService.kt
│
├── ui
│   ├── MainActivity.kt
│   └── MainViewModel.kt
│
├── ui.theme
│
└── App.kt
```

---

## Features

* Hilt dependency injection setup
* Retrofit API service example
* ViewModel injection with Hilt
* Compose UI starter
* Version catalog + KSP configuration

---


## Usage

Since this template is inside a larger repository, you have two options.

### Option 1 — Clone the Templates Repository

```bash
git clone https://github.com/Caege/android-templates.git
```

Then navigate to the template:

```bash
android-templates/compose-hilt-retrofit-template
```

---

### Option 2 — Download as ZIP

1. Open the repository:

```
https://github.com/Caege/android-templates
```

2. Click **Code → Download ZIP**

3. Extract the folder:

```
compose-hilt-retrofit-template
```

---

### After Opening the Project

Open the project in **Android Studio** and rename:

* package name
* `applicationId`
* app name


---

## Example API

Uses:

```
https://jsonplaceholder.typicode.com/posts
```

for demonstration purposes.

---

## Notes

This template is meant to **bootstrap new Android projects quickly** with a clean baseline.


