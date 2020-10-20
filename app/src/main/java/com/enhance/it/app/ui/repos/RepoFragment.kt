package com.enhance.it.app.ui.repos

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.enhance.it.app.R
import com.enhance.it.app.di.component.FragmentComponent
import com.enhance.it.app.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_repos.*
import javax.inject.Inject

class RepoFragment : BaseFragment<RepoViewModel>() {

    companion object {

        const val TAG = "DummiesFragment"

        fun newInstance(): RepoFragment {
            val args = Bundle()
            val fragment = RepoFragment()
            fragment.arguments = args
            return fragment
        }
    }

    @Inject
    lateinit var linearLayoutManager: LinearLayoutManager

    @Inject
    lateinit var reposAdapter: ReposAdapter

    override fun provideLayoutId(): Int = R.layout.fragment_repos

    override fun injectDependencies(fragmentComponent: FragmentComponent) {
        fragmentComponent.inject(this)
    }

    override fun setupObservers() {
        viewModel.getDummies().observe(this, Observer {
            it?.run { reposAdapter.appendData(this) }
        })
    }

    override fun setupView(view: View) {
        rv_dummy.layoutManager = linearLayoutManager
        rv_dummy.adapter = reposAdapter
    }

}