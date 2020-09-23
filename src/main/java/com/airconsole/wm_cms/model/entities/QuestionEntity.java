package com.airconsole.wm_cms.model.entities;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@ToString
@Entity
@Table(name = "question")
public class QuestionEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;

    @Size(max = 255)
    @Column(name = "info")
    private String info;

    @Column(name = "next_id")
    private Integer nextId;

    @Column(name = "mile_stone")
    private Integer mileStone;

    @Column(name = "status")
    private Short status;

    @Basic(optional = false)
    @NotNull
    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "create_by")
    private String createBy;

    @Column(name = "update_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;

    @Size(max = 60)
    @Column(name = "update_by")
    private String updateBy;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idQuestion", fetch = FetchType.LAZY)
    private Collection<AnswerEntity> answerEntityCollection;

    public QuestionEntity() {
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof QuestionEntity)) {
            return false;
        }
        QuestionEntity other = (QuestionEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.airconsole.wm_cms.model.entities.QuestionEntity[ id=" + id + " ]";
    }
    
}
