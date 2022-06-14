package com.example.carolinagt_quizapp

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionsList:ArrayList<Questions>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mUserName : String? = null
    private var mCorrectAnswer : Int = 0

    private var progressBar : ProgressBar? = null
    private var tvProgress : TextView? = null
    private var tvQuestions : TextView? = null
    private var ivImage : ImageView? = null

    private var tvOption1 : TextView? = null
    private var tvOption2 : TextView? = null
    private var tvOption3 : TextView? = null
    private var tvOption4 : TextView? = null
    private var buttonSubmit : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tvProgress)
        tvQuestions = findViewById(R.id.tvQuestion)
        ivImage = findViewById(R.id.ivImage)
        tvOption1 = findViewById(R.id.tvOption1)
        tvOption2 = findViewById(R.id.tvOption2)
        tvOption3 = findViewById(R.id.tvOption3)
        tvOption4 = findViewById(R.id.tvOption4)
        buttonSubmit = findViewById(R.id.buttonSubmit)

        tvOption1?.setOnClickListener(this)
        tvOption2?.setOnClickListener(this)
        tvOption3?.setOnClickListener(this)
        tvOption4?.setOnClickListener(this)
        buttonSubmit?.setOnClickListener(this)


        mQuestionsList = Constants.getQuestions()

        setQuestion()



    }

    private fun setQuestion() {
        defaultOptionsView()
        val question: Questions =  mQuestionsList!![mCurrentPosition - 1]
        ivImage?.setImageResource(question.image)
        progressBar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition/${progressBar?.max}"
        tvQuestions?.text = question.question
        tvOption1?.text = question.option1
        tvOption2?.text = question.option2
        tvOption3?.text = question.option3
        tvOption4?.text = question.option4

        if (mCurrentPosition == mQuestionsList!!.size){
            buttonSubmit?. text = "FINISH"
        }else{
            buttonSubmit?.text = "SUBMIT"
        }
    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        tvOption1?.let {
            options.add(0,it)
        }
        tvOption2?.let {
            options.add(1,it)
        }
        tvOption3?.let {
            options.add(2,it)
        }
        tvOption4?.let {
            options.add(3,it)
        }

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,R.drawable.defult_option_border_bg)
        }
    }

    private fun selectedOptionView(tv:TextView,selectedOptionNum: Int ){
        defaultOptionsView()

        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this,R.drawable.selected_option_border_bg)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.tvOption1 -> {
                tvOption1?.let {
                    selectedOptionView(it,1)
                }
            }
            R.id.tvOption2 -> {
                tvOption2?.let {
                    selectedOptionView(it,2)
                }
            }
            R.id.tvOption3 -> {
                tvOption3?.let {
                    selectedOptionView(it,3)
                }
            }
            R.id.tvOption4 -> {
                tvOption4?.let {
                    selectedOptionView(it,4)
                }
            }

            R.id.buttonSubmit ->{
                if (mSelectedOptionPosition == 0){
                    mCurrentPosition++

                    when{
                        mCurrentPosition <= mQuestionsList!!.size ->{
                            setQuestion()
                        }
                        else ->{
                            Toast.makeText(this,"You finish the quiz",Toast.LENGTH_LONG).show()
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWER, mCorrectAnswer)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList?.size)
                            startActivity(intent)
                            finish()
                        }

                    }
                }else{
                    val question = mQuestionsList?.get(mCurrentPosition-1)
                    if (question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswer++
                    }
                        answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if (mCurrentPosition == mQuestionsList!!.size){
                        buttonSubmit?.text = "FINISH"
                    }else{
                        buttonSubmit?.text = "GO TO THE NEXT QUESTION"
                    }

                    mSelectedOptionPosition = 0
                }

            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int){
        when(answer){
            1 ->{
                tvOption1?.background = ContextCompat.getDrawable(this,drawableView)
            }
            2 ->{
                tvOption2?.background = ContextCompat.getDrawable(this,drawableView)
            }
            3 ->{
                tvOption3?.background = ContextCompat.getDrawable(this,drawableView)
            }
            4 ->{
                tvOption4?.background = ContextCompat.getDrawable(this,drawableView)
            }
        }
    }
}