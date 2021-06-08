package com.hfad.quizzapp.ui.fragments.quiz

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hfad.quizzapp.data.model.quizModel.Results
import com.hfad.quizzapp.databinding.QuizItemBinding

class QuizAdapter(
    private val quizResult: List<Results>,
    private val listener: OnQuiz
) :
    RecyclerView.Adapter<QuizAdapter.ViewHolder>() {

    private var context: Context? = null

//    fun swapData(quizResult: List<Results>){
//        this.quizResult = quizResult
//        notifyDataSetChanged()
//    }


//    fun addData(quizResult: List<Results>){
//        this.quizResult.addAll(quizResult)
//        notifyDataSetChanged()
//    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(
            QuizItemBinding.inflate(LayoutInflater.from(context), parent, false)
        )
    }

    override fun getItemCount() = quizResult.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(quizResult[position])
//        holder.itemView.setOnClickListener {
//            quizResult[position].answer =
//            notifyItemChanged(position)
//            listener.onQuizClick(quizResult[position], position)
//        }
    }

   inner class ViewHolder(private val view: QuizItemBinding) : RecyclerView.ViewHolder(view.root) {

        @SuppressLint("SetTextI18n")
        fun onBind(quiz: Results) {

            if (quiz.type == "multiple") {

                view.groupDouble.visibility = View.GONE
                view.groupMultiple.visibility = View.VISIBLE

                val listToShuffle = quiz.shuffleAnswers

                view.textQuestion.text = quiz.question

                view.textFirst.text = listToShuffle[0]
                view.textSecond.text = listToShuffle[1]
                view.textThird.text = listToShuffle[2]
                view.textFour.text = listToShuffle[3]

                view.textFirst.setBackgroundColor(Color.GRAY)
                view.textSecond.setBackgroundColor(Color.GRAY)
                view.textThird.setBackgroundColor(Color.GRAY)
                view.textFour.setBackgroundColor(Color.GRAY)

                view.skip.setOnClickListener {
                    quiz.isSkip = true
                    notifyItemChanged(adapterPosition)
                    listener.onSkipClick(quiz,adapterPosition)
                }

                view.textFirst.setOnClickListener { it: View? ->
                    quiz.answer = (it as TextView).text.toString()
                    listener.onQuizClick(quiz,adapterPosition)
                    notifyItemChanged(adapterPosition)
                }
                  view.textSecond.setOnClickListener { it: View? ->
                    quiz.answer = (it as TextView).text.toString()
                    listener.onQuizClick(quiz,adapterPosition)
                      notifyItemChanged(adapterPosition)
                  }
                  view.textThird.setOnClickListener { it: View? ->
                    quiz.answer = (it as TextView).text.toString()
                    listener.onQuizClick(quiz,adapterPosition)
                      notifyItemChanged(adapterPosition)
                  }
                  view.textFour.setOnClickListener { it: View? ->
                    quiz.answer = (it as TextView).text.toString()
                    listener.onQuizClick(quiz,adapterPosition)
                      notifyItemChanged(adapterPosition)
                  }


                if (quiz.answer != null) {

                    if (quiz.answer == quiz.correctAnswer) {

                        if (view.textFirst.text.toString() == quiz.answer) {
                            view.textFirst.setBackgroundColor(Color.GREEN)
                        }
                        if (view.textSecond.text.toString() == quiz.answer) {
                            view.textSecond.setBackgroundColor(Color.GREEN)
                        }
                        if (view.textThird.text.toString() == quiz.answer) {
                            view.textThird.setBackgroundColor(Color.GREEN)
                        }
                        if (view.textFour.text.toString() == quiz.answer) {
                            view.textFour.setBackgroundColor(Color.GREEN)
                        }
                    } else {

                        if (view.textFirst.text.toString() == quiz.answer) {
                            view.textFirst.setBackgroundColor(Color.RED)
                        }
                        if (view.textSecond.text.toString() == quiz.answer) {
                            view.textSecond.setBackgroundColor(Color.RED)
                        }
                        if (view.textThird.text.toString() == quiz.answer) {
                            view.textThird.setBackgroundColor(Color.RED)
                        }
                        if (view.textFour.text.toString() == quiz.answer) {
                            view.textFour.setBackgroundColor(Color.RED)
                        }
                    }

                } else {
                    if (!quiz.isSkip) {

                    } else {

                        if (view.textFirst.text.toString() == quiz.correctAnswer) {
                            view.textFirst.setBackgroundColor(Color.BLUE)
                        }
                        if (view.textSecond.text.toString() == quiz.correctAnswer) {
                            view.textSecond.setBackgroundColor(Color.BLUE)
                        }
                        if (view.textThird.text.toString() == quiz.correctAnswer) {
                            view.textThird.setBackgroundColor(Color.BLUE)
                        }
                        if (view.textFour.text.toString() == quiz.correctAnswer) {
                            view.textFour.setBackgroundColor(Color.BLUE)
                        }
                    }
                }
            } else {

                view.groupDouble.visibility = View.VISIBLE
                view.groupMultiple.visibility = View.GONE

                val listToShuffle = mutableListOf(
                    quiz.incorrectAnswers[0],
                    quiz.correctAnswer,
                )
                listToShuffle.shuffle()

                view.textFive.text = listToShuffle[0]
                view.textSix.text = listToShuffle[1]

            }
        }
    }
}

interface OnQuiz {
    fun onQuizClick(quizResult: Results, position: Int)
    fun onSkipClick(quizResult: Results, position: Int)
}