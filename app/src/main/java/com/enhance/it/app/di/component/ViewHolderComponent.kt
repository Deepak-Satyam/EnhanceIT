package com.enhance.it.app.di.component

import com.enhance.it.app.di.ViewModelScope
import com.enhance.it.app.di.module.ViewHolderModule
import com.enhance.it.app.ui.repos.RepoItemViewHolder
import dagger.Component

@ViewModelScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ViewHolderModule::class]
)
interface ViewHolderComponent {

    fun inject(viewHolder: RepoItemViewHolder)
}