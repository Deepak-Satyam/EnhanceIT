package com.enhance.it.app

import android.app.Application
import com.enhance.it.app.di.component.ApplicationComponent
import com.enhance.it.app.di.component.DaggerApplicationComponent
import com.enhance.it.app.di.module.ApplicationModule

class RepositoryApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injectDependencies()
    }

    private fun injectDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }
}