package com.airconsole.wm_cms.model.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Answer {
    private int id;
    private String name;
    private boolean isTrue;
    private int idQuestion;
    private Question questionByIdQuestion;

    public Answer() {
    }

    public Answer(String name, int idQuestion, boolean isTrue) {
        this.name = name;
        this.idQuestion = idQuestion;
        this.isTrue = isTrue;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "is_true")
    public boolean isTrue() {
        return isTrue;
    }

    public void setTrue(boolean aTrue) {
        isTrue = aTrue;
    }

    @Basic
    @Column(name = "id_question")
    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return id == answer.id &&
                isTrue == answer.isTrue &&
                idQuestion == answer.idQuestion &&
                Objects.equals(name, answer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, isTrue, idQuestion);
    }

    @ManyToOne
    @JoinColumn(name = "id_question", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
    public Question getQuestionByIdQuestion() {
        return questionByIdQuestion;
    }

    public void setQuestionByIdQuestion(Question questionByIdQuestion) {
        this.questionByIdQuestion = questionByIdQuestion;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isTrue=" + isTrue +
                ", idQuestion=" + idQuestion +
                '}';
    }
}
