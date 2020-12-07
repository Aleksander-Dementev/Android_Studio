package com.example.myapplication;

public class Questions {
    private int questionResId; //переменная привязка вопроса и iD
    private boolean answerTrue; //переменная определяющая правду или лож

    public int getQuestionResId() {
        return questionResId;
    }

    public void setQuestionResId(int questionResId) {
        this.questionResId = questionResId;
    }

    public boolean isAnswerTrue() {
        return answerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        this.answerTrue = answerTrue;
    }

    public Questions(int questionResId, boolean answerTrue) {
        this.questionResId = questionResId;
        this.answerTrue = answerTrue;


    }
}
