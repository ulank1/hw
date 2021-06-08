package com.hfad.quizzapp.ui.fragments.profile

import com.hfad.quizzapp.core.ui.base.BaseFragment
import com.hfad.quizzapp.databinding.FragmentProfileBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {

    override val viewModel: ProfileViewModel by viewModel()

    override fun setupLiveData() {}
    override fun setupUI() {}

    companion object {
        fun newInstance() = ProfileFragment()
    }
}