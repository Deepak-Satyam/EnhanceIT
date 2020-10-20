package com.enhance.it.app.di.module

import androidx.lifecycle.LifecycleRegistry
import com.enhance.it.app.di.ViewModelScope
import com.enhance.it.app.ui.base.BaseItemViewHolder
import dagger.Module
import dagger.Provides

@Module
class ViewHolderModule(private val viewHolder: BaseItemViewHolder<*, *>) {

    @Provides
    @ViewModelScope
    fun provideLifecycleRegistry(): LifecycleRegistry = LifecycleRegistry(viewHolder)
}