/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.management.app;

public class Mentorship {
    private int mentorId;
    private String type;
    private int level;
    private String responsibility;
    private String criteria;
    private Student student;

    public int getMentorId() {
        return mentorId;
    }

    public void setMentorId(int mentorId) {
        this.mentorId = mentorId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Mentorship(int mentorId, String type, int level, String responsibility, String criteria, Student student) {
        this.mentorId = mentorId;
        this.type = type;
        this.level = level;
        this.responsibility = responsibility;
        this.criteria = criteria;
        this.student = student;
    }
    
}
