package com.hfad.quizzapp.ui.fragments.discover

import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SeekBar
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.navigation.fragment.findNavController
import com.hfad.quizzapp.core.ui.base.BaseFragment
import com.hfad.quizzapp.R
import com.hfad.quizzapp.data.model.category.TriviaCategories
import com.hfad.quizzapp.databinding.FragmentDiscoverBinding

class DiscoverFragment : BaseFragment<FragmentDiscoverBinding>(FragmentDiscoverBinding::inflate),
    AdapterView.OnItemSelectedListener {

    override val viewModel: DiscoverViewModel by viewModel()
    private  var listA: List<TriviaCategories>? = null

    override fun setupLiveData() {

        viewModel.getCategory().observe(viewLifecycleOwner) { it ->

            // separate to functions
            listA = it.body()?.triviaCategories

            val list = ArrayList<String>()
            it.body()?.triviaCategories?.map { it.name }?.let { it1 -> list.addAll(it1) }

            val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, list)

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerCategory.adapter = adapter
            binding.spinnerCategory.onItemSelectedListener = this
        }
    }


    override fun setupUI() {

        binding.startBtn.setOnClickListener {
            findNavController().navigate(R.id.quizFragment)
        }
        setUpSpinnerDifficulty()
        setUpSeekBarListener()
    }

    private fun setUpSpinnerDifficulty() {
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.difficulty,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerDifficulty.adapter = adapter
        }
        binding.spinnerDifficulty.onItemSelectedListener = this
    }

    private fun setUpSeekBarListener() {
        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                binding.textAmount.text = p0?.progress.toString()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                binding.textAmount.text = p0?.progress.toString()
                viewModel.amount = p0?.progress ?: 0
            }
        })
    }

    companion object {
        fun newInstance() = DiscoverFragment()
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        if (parent?.id == binding.spinnerCategory.id ){
            viewModel.category = listA?.get(position)?.id ?: 0
        } else if(parent?.id == binding.spinnerDifficulty.id){
            viewModel.difficulty = parent.getItemAtPosition(position) as String
        }
    }
    override fun onNothingSelected(parent: AdapterView<*>?) {}
}