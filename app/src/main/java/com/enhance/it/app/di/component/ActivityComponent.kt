package com.enhance.it.app.di.component

import com.enhance.it.app.di.ActivityScope
import com.enhance.it.app.di.module.ActivityModule
import com.enhance.it.app.ui.repo.RepositoryActivity
import dagger.Component

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ActivityModule::class]
)
interface ActivityComponent {
    fun inject(activity: RepositoryActivity)
}