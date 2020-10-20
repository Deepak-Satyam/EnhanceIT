package com.enhance.it.app.ui.repo

import android.os.Bundle
import com.enhance.it.app.R
import com.enhance.it.app.di.component.ActivityComponent
import com.enhance.it.app.ui.base.BaseActivity
import com.enhance.it.app.ui.repos.RepoFragment

class RepositoryActivity : BaseActivity<RepositoryViewModel>() {

    companion object {
        const val TAG = "DummyActivity"
    }

    override fun provideLayoutId(): Int = R.layout.activity_repo

    override fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun setupView(savedInstanceState: Bundle?) {
        addDummiesFragment()
    }

    private fun addDummiesFragment() {
        supportFragmentManager.findFragmentByTag(RepoFragment.TAG) ?: supportFragmentManager
            .beginTransaction()
            .add(R.id.container_fragment, RepoFragment.newInstance(), RepoFragment.TAG)
            .commitAllowingStateLoss()
    }
}