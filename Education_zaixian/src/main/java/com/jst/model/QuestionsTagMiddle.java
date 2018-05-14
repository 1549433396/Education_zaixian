package com.jst.model;

public class QuestionsTagMiddle {
         private Questions questions;
         private QuestionsTag questionsTag;
		public Questions getQuestions() {
			return questions;
		}
		public void setQuestions(Questions questions) {
			this.questions = questions;
		}
		public QuestionsTag getQuestionsTag() {
			return questionsTag;
		}
		public void setQuestionsTag(QuestionsTag questionsTag) {
			this.questionsTag = questionsTag;
		}
		@Override
		public String toString() {
			return "QuestionsTagMiddle [questions=" + questions + ", questionsTag=" + questionsTag + "]";
		}
         
         
}
