/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.management.app;

/**
 *
 * @author matt.maree
 */
public class Assessment {
    private int assessId;
    private String type;
    private String date;
    private String criteria;
    private Subject subject;

    public int getAssessId() {
        return assessId;
    }

    public void setAssessId(int assessId) {
        this.assessId = assessId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Assessment(int assessId, String type, String date, String criteria, Subject subject) {
        this.assessId = assessId;
        this.type = type;
        this.date = date;
        this.criteria = criteria;
        this.subject = subject;
    }
    
}
