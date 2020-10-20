package com.enhance.it.app.ui.repos

import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import com.enhance.it.app.data.model.Repo
import com.enhance.it.app.ui.base.BaseAdapter

class ReposAdapter(
    parentLifecycle: Lifecycle,
    private val repos: ArrayList<Repo>
) : BaseAdapter<Repo, RepoItemViewHolder>(parentLifecycle, repos) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = RepoItemViewHolder(parent)
}