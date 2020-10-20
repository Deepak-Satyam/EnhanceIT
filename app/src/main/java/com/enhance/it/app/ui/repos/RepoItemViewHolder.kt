package com.enhance.it.app.ui.repos

import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.enhance.it.app.R
import com.enhance.it.app.data.model.Repo
import com.enhance.it.app.di.component.ViewHolderComponent
import com.enhance.it.app.ui.base.BaseItemViewHolder
import kotlinx.android.synthetic.main.item_view_repos.view.*

class RepoItemViewHolder(parent: ViewGroup) :
    BaseItemViewHolder<Repo, RepoItemViewModel>(R.layout.item_view_repos, parent) {

    override fun injectDependencies(viewHolderComponent: ViewHolderComponent) {
        viewHolderComponent.inject(this)
    }

    override fun setupObservers() {
        super.setupObservers()

        viewModel.name.observe(this, Observer {
            itemView.name.text = it
        })

        viewModel.description.observe(this, Observer {
            itemView.description.text = it
        })
    }

    override fun setupView(view: View) {
        view.setOnClickListener {
            viewModel.onItemClick(adapterPosition)
        }
    }
}