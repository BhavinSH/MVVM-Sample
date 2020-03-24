package com.mvvm.sample.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.mvvm.sample.R
import com.mvvm.sample.databinding.ActivityMainBinding
import com.mvvm.sample.view.adapter.UserAdapter
import com.mvvm.sample.viewmodel.UserViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    private val mUserViewModel: UserViewModel by viewModel()
    private lateinit var mAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mBinding.lifecycleOwner = this
        initUI()
        subscribeObservers()
    }

    /**
     * Initialise the UI
     */
    private fun initUI() {
        mBinding.rv.layoutManager = LinearLayoutManager(this)

        mAdapter = UserAdapter(this)
        mBinding.rv.adapter = mAdapter
    }

    /**
     * Subscribe the observers
     */
    private fun subscribeObservers() {
        mUserViewModel.getUserList().observe(this, Observer {
            mAdapter.addAll(it) // Add user data to adapter
        })
    }
}
