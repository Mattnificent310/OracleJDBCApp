/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.management.app;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author matt.maree
 */
@Entity
@Table(name = "student", catalog = "studentdb", schema = "")
@NamedQueries({
    @NamedQuery(name = "Student_1.findAll", query = "SELECT s FROM Student_1 s")
    , @NamedQuery(name = "Student_1.findByStudentId", query = "SELECT s FROM Student_1 s WHERE s.studentId = :studentId")
    , @NamedQuery(name = "Student_1.findByStudentName", query = "SELECT s FROM Student_1 s WHERE s.studentName = :studentName")
    , @NamedQuery(name = "Student_1.findByStudentSurname", query = "SELECT s FROM Student_1 s WHERE s.studentSurname = :studentSurname")
    , @NamedQuery(name = "Student_1.findByStudentGender", query = "SELECT s FROM Student_1 s WHERE s.studentGender = :studentGender")
    , @NamedQuery(name = "Student_1.findByStudentAge", query = "SELECT s FROM Student_1 s WHERE s.studentAge = :studentAge")
    , @NamedQuery(name = "Student_1.findByStudentPhone", query = "SELECT s FROM Student_1 s WHERE s.studentPhone = :studentPhone")
    , @NamedQuery(name = "Student_1.findByStudentEmail", query = "SELECT s FROM Student_1 s WHERE s.studentEmail = :studentEmail")})
public class Student_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "STUDENT_ID")
    private Integer studentId;
    @Basic(optional = false)
    @Column(name = "STUDENT_NAME")
    private String studentName;
    @Basic(optional = false)
    @Column(name = "STUDENT_SURNAME")
    private String studentSurname;
    @Column(name = "STUDENT_GENDER")
    private Character studentGender;
    @Basic(optional = false)
    @Column(name = "STUDENT_AGE")
    private int studentAge;
    @Basic(optional = false)
    @Column(name = "STUDENT_PHONE")
    private String studentPhone;
    @Basic(optional = false)
    @Column(name = "STUDENT_EMAIL")
    private String studentEmail;

    public Student_1() {
    }

    public Student_1(Integer studentId) {
        this.studentId = studentId;
    }

    public Student_1(Integer studentId, String studentName, String studentSurname, int studentAge, String studentPhone, String studentEmail) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentSurname = studentSurname;
        this.studentAge = studentAge;
        this.studentPhone = studentPhone;
        this.studentEmail = studentEmail;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        Integer oldStudentId = this.studentId;
        this.studentId = studentId;
        changeSupport.firePropertyChange("studentId", oldStudentId, studentId);
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        String oldStudentName = this.studentName;
        this.studentName = studentName;
        changeSupport.firePropertyChange("studentName", oldStudentName, studentName);
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public void setStudentSurname(String studentSurname) {
        String oldStudentSurname = this.studentSurname;
        this.studentSurname = studentSurname;
        changeSupport.firePropertyChange("studentSurname", oldStudentSurname, studentSurname);
    }

    public Character getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(Character studentGender) {
        Character oldStudentGender = this.studentGender;
        this.studentGender = studentGender;
        changeSupport.firePropertyChange("studentGender", oldStudentGender, studentGender);
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        int oldStudentAge = this.studentAge;
        this.studentAge = studentAge;
        changeSupport.firePropertyChange("studentAge", oldStudentAge, studentAge);
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        String oldStudentPhone = this.studentPhone;
        this.studentPhone = studentPhone;
        changeSupport.firePropertyChange("studentPhone", oldStudentPhone, studentPhone);
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        String oldStudentEmail = this.studentEmail;
        this.studentEmail = studentEmail;
        changeSupport.firePropertyChange("studentEmail", oldStudentEmail, studentEmail);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentId != null ? studentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student_1)) {
            return false;
        }
        Student_1 other = (Student_1) object;
        if ((this.studentId == null && other.studentId != null) || (this.studentId != null && !this.studentId.equals(other.studentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "student.management.app.Student_1[ studentId=" + studentId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
