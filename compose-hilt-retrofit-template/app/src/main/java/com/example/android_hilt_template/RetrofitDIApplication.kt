package com.example.android_hilt_template

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp // 👈 triggers Hilt's code generation, including a base class for your application that serves as the application-level dependency container.
class RetrofitDIApplication: Application() {
}