package ir.maktab.todo.domain;

import ir.maktab.todo.base.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import java.time.LocalDate;

@Entity
public class Activity extends BaseEntity<Long> {

    public Activity(String subject, String status, Date createdDate, Date updateDate) {
        this.subject = subject;
        this.status = status;
        this.createdDate = createdDate;
        this.updateDate = updateDate;
    }

    public Activity() {
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", status='" + status + '\'' +
                ", createdDate=" + createdDate +
                ", updateDate=" + updateDate +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String subject;

    private String status;

    private Date createdDate = Date.valueOf(LocalDate.now());

    private Date updateDate;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

}
