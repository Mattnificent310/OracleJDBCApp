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

@Entity
@Table(name = "subjects", catalog = "studentdb", schema = "")
@NamedQueries({
    @NamedQuery(name = "Subjects.findAll", query = "SELECT s FROM Subjects s")
    , @NamedQuery(name = "Subjects.findBySubjectId", query = "SELECT s FROM Subjects s WHERE s.subjectId = :subjectId")
    , @NamedQuery(name = "Subjects.findBySubjectTitle", query = "SELECT s FROM Subjects s WHERE s.subjectTitle = :subjectTitle")
    , @NamedQuery(name = "Subjects.findBySubjectWeight", query = "SELECT s FROM Subjects s WHERE s.subjectWeight = :subjectWeight")
    , @NamedQuery(name = "Subjects.findBySubjectDuration", query = "SELECT s FROM Subjects s WHERE s.subjectDuration = :subjectDuration")
    , @NamedQuery(name = "Subjects.findByLecIdfk", query = "SELECT s FROM Subjects s WHERE s.lecIdfk = :lecIdfk")
    , @NamedQuery(name = "Subjects.findByClassId", query = "SELECT s FROM Subjects s WHERE s.classId = :classId")
    , @NamedQuery(name = "Subjects.findBySessionId", query = "SELECT s FROM Subjects s WHERE s.sessionId = :sessionId")
    , @NamedQuery(name = "Subjects.findByCourseId", query = "SELECT s FROM Subjects s WHERE s.courseId = :courseId")})
public class Subjects implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SUBJECT_ID")
    private Integer subjectId;
    @Column(name = "SUBJECT_TITLE")
    private String subjectTitle;
    @Column(name = "SUBJECT_WEIGHT")
    private Integer subjectWeight;
    @Column(name = "SUBJECT_DURATION")
    private Integer subjectDuration;
    @Column(name = "LEC_IDFK")
    private String lecIdfk;
    @Column(name = "CLASS_ID")
    private String classId;
    @Column(name = "SESSION_ID")
    private String sessionId;
    @Column(name = "COURSE_ID")
    private String courseId;

    public Subjects() {
    }

    public Subjects(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        Integer oldSubjectId = this.subjectId;
        this.subjectId = subjectId;
        changeSupport.firePropertyChange("subjectId", oldSubjectId, subjectId);
    }

    public String getSubjectTitle() {
        return subjectTitle;
    }

    public void setSubjectTitle(String subjectTitle) {
        String oldSubjectTitle = this.subjectTitle;
        this.subjectTitle = subjectTitle;
        changeSupport.firePropertyChange("subjectTitle", oldSubjectTitle, subjectTitle);
    }

    public Integer getSubjectWeight() {
        return subjectWeight;
    }

    public void setSubjectWeight(Integer subjectWeight) {
        Integer oldSubjectWeight = this.subjectWeight;
        this.subjectWeight = subjectWeight;
        changeSupport.firePropertyChange("subjectWeight", oldSubjectWeight, subjectWeight);
    }

    public Integer getSubjectDuration() {
        return subjectDuration;
    }

    public void setSubjectDuration(Integer subjectDuration) {
        Integer oldSubjectDuration = this.subjectDuration;
        this.subjectDuration = subjectDuration;
        changeSupport.firePropertyChange("subjectDuration", oldSubjectDuration, subjectDuration);
    }

    public String getLecIdfk() {
        return lecIdfk;
    }

    public void setLecIdfk(String lecIdfk) {
        String oldLecIdfk = this.lecIdfk;
        this.lecIdfk = lecIdfk;
        changeSupport.firePropertyChange("lecIdfk", oldLecIdfk, lecIdfk);
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        String oldClassId = this.classId;
        this.classId = classId;
        changeSupport.firePropertyChange("classId", oldClassId, classId);
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        String oldSessionId = this.sessionId;
        this.sessionId = sessionId;
        changeSupport.firePropertyChange("sessionId", oldSessionId, sessionId);
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        String oldCourseId = this.courseId;
        this.courseId = courseId;
        changeSupport.firePropertyChange("courseId", oldCourseId, courseId);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subjectId != null ? subjectId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subjects)) {
            return false;
        }
        Subjects other = (Subjects) object;
        if ((this.subjectId == null && other.subjectId != null) || (this.subjectId != null && !this.subjectId.equals(other.subjectId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "student.management.app.Subjects[ subjectId=" + subjectId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
