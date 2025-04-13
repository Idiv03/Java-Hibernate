package com.divya.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Answer {
	
	@Id
	@Column(name="ans_id")
	 private Integer id;
	 private String answer;
	 
	 @OneToOne(cascade = CascadeType.ALL)
	 private Question question;
	
	 public Question getQuestion() {
		 return question;
		 
	 }
	 
	 public void setQuestion(Question question) {
		 this.question = question;
	 }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Answer [id=" + id + ", answer=" + answer + ", question=" + question + "]";
	}

	

}
