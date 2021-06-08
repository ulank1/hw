package com.hfad.quizzapp.ui.fragments.quiz

import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.hfad.quizzapp.core.ui.base.BaseFragment
import com.hfad.quizzapp.data.model.quizModel.Results
import com.hfad.quizzapp.databinding.QuizFragmentBinding
import kotlinx.android.synthetic.main.quiz_fragment.view.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class QuizFragment : BaseFragment<QuizFragmentBinding>(
    QuizFragmentBinding::inflate,
), OnQuiz {

    override val viewModel: QuizViewModel by viewModel()

    override fun setupUI() {

    }

    override fun setupLiveData() {
        viewModel.getQuiz()
        viewModel.quizLiveData.observe(viewLifecycleOwner) {
            binding.recyclerView.apply {
                this.adapter = QuizAdapter(it.results, this@QuizFragment)
            }
        }
        
        val snapHelper: SnapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(binding.recyclerView)
    }

    override fun onQuizClick(quizResult: Results, position: Int) {
        lifecycleScope.launch {
            delay(1000)
            binding.recyclerView.smoothScrollToPosition(position + 1)
        }
    }

    override fun onSkipClick(quizResult: Results, position: Int) {
        lifecycleScope.launch {
            delay(1000)
            binding.recyclerView.smoothScrollToPosition(position + 1)
        }
    }
}