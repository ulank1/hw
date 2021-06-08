package com.hfad.quizzapp.ui.fragments.map

import com.hfad.quizzapp.core.ui.base.BaseFragment
import com.hfad.quizzapp.databinding.FragmentMapBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MapFragment : BaseFragment<FragmentMapBinding>(FragmentMapBinding::inflate) {

    override val viewModel: MapViewModel by viewModel()

    override fun setupLiveData() {}
    override fun setupUI() {}

    companion object {
        fun newInstance() = MapFragment()
    }

}