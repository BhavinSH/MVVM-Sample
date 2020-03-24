package com.mvvm.sample.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mvvm.sample.R
import com.mvvm.sample.databinding.ItemUserBinding
import com.mvvm.sample.model.UserData

class UserAdapter(private var context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var mUserList = mutableListOf<UserData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = DataBindingUtil.inflate<ItemUserBinding>(
            LayoutInflater.from(context),
            R.layout.item_user, parent, false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount() = mUserList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as ViewHolder
        viewHolder.bindData(mUserList[position])
    }

    /**
     * Add all user data
     */
    fun addAll(list: List<UserData>) {
        list.forEach {
            add(it)
        }
    }

    /**
     * Add and notify the item
     */
    private fun add(user: UserData) {
        mUserList.add(user)
        notifyItemInserted(mUserList.size - 1)
    }

    internal inner class ViewHolder(var item: ItemUserBinding) :
        RecyclerView.ViewHolder(item.root) {

        fun bindData(user: UserData) {
            item.userData = user
        }
    }
}