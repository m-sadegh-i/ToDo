package ir.maktab.todo.domain;

import ir.maktab.todo.base.domain.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
public class User extends BaseEntity<Long> {

    public User(String userName, String passWord, String nationalCode) {
        this.userName = userName;
        this.passWord = passWord;
        this.nationalCode = nationalCode;
    }

    public User(Long id, String userName, String passWord, String nationalCode, List<Activity> activities) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.nationalCode = nationalCode;
        this.activities = activities;
    }

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;

    private String passWord;

    private String nationalCode;

    @OneToMany
    private List<Activity> activities;

    @Override
    public String toString() {
        return "User{" +
                "activities=" + activities +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
