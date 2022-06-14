package com.example.carolinagt_quizapp

object Constants {

    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTIONS : String = "total_questions"
    const val CORRECT_ANSWER : String = "correct_answer"


    fun getQuestions(): ArrayList<Questions>{
        val questionsList = ArrayList<Questions>()

        //Questão 1
        val que1 = Questions(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina, "Argentina",
            "Australia", "Armenia", "Austria",
            1
        )
        questionsList.add(que1)

        //Questão 2
        val que2 = Questions(
            2, "What country does this flag belong to?",
            R.drawable.ic_flag_of_australia, "Argentina",
            "Australia", "Armenia", "Austria",
            2
        )
        questionsList.add(que2)

        //Questão 3
        val que3 = Questions(
            3, "What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium, "Germany",
            "Italy", "Belgium", "Portugal",
            3
        )
        questionsList.add(que3)

        //Questão 4
        val que4 = Questions(
            4, "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil, "Brazil",
            "Bolivia", "Belgium", "Portugal",
            1
        )
        questionsList.add(que4)

        //Questão 5
        val que5 = Questions(
            5, "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark, "Norway",
            "Switzerland", "Sweden", "Denmark",
            4
        )
        questionsList.add(que5)

        //Questão 6
        val que6 = Questions(
            6, "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji, "Norway",
            "Switzerland", "United Kingdom", "Fiji",
            4
        )
        questionsList.add(que6)

        //Questão 7
        val que7 = Questions(
            7, "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany, "Germany",
            "Belgium", "United Kingdom", "Poland",
            1
        )
        questionsList.add(que7)

        //Questão 8
        val que8 = Questions(
            8, "What country does this flag belong to?",
            R.drawable.ic_flag_of_india, "Qatar",
            "India", "Somalia", "Sudan",
            2
        )
        questionsList.add(que8)

        //Questão 9
        val que9 = Questions(
            9, "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait, "Kenya",
            "Qatar", "Kwait", "Sudan",
            3
        )
        questionsList.add(que9)

        return questionsList


    }
}