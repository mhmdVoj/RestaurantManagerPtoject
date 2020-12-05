package com.project.farjad.restaurantproject

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

class ApplicationLoader : Application() {

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(applicationContext)
    }
}