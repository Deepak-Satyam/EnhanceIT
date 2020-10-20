package com.enhance.it.app.di.component

import com.enhance.it.app.di.FragmentScope
import com.enhance.it.app.di.module.FragmentModule
import com.enhance.it.app.ui.repos.RepoFragment
import dagger.Component

@FragmentScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [FragmentModule::class]
)
interface FragmentComponent {

    fun inject(fragment: RepoFragment)
}