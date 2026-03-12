

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

1. Clone the template

```bash
git clone https://github.com/<your-username>/compose-hilt-retrofit-template
```

2. Open in **Android Studio**

3. Rename the following:

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


