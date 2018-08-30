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
@Table(name = "courses", catalog = "studentdb", schema = "")
@NamedQueries({
    @NamedQuery(name = "Courses.findAll", query = "SELECT c FROM Courses c")
    , @NamedQuery(name = "Courses.findByCourseId", query = "SELECT c FROM Courses c WHERE c.courseId = :courseId")
    , @NamedQuery(name = "Courses.findByCourseTitle", query = "SELECT c FROM Courses c WHERE c.courseTitle = :courseTitle")
    , @NamedQuery(name = "Courses.findByCourseDuration", query = "SELECT c FROM Courses c WHERE c.courseDuration = :courseDuration")})
public class Courses implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COURSE_ID")
    private Integer courseId;
    @Basic(optional = false)
    @Column(name = "COURSE_TITLE")
    private String courseTitle;
    @Basic(optional = false)
    @Column(name = "COURSE_DURATION")
    private int courseDuration;

    public Courses() {
    }

    public Courses(Integer courseId) {
        this.courseId = courseId;
    }

    public Courses(Integer courseId, String courseTitle, int courseDuration) {
        this.courseId = courseId;
        this.courseTitle = courseTitle;
        this.courseDuration = courseDuration;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        Integer oldCourseId = this.courseId;
        this.courseId = courseId;
        changeSupport.firePropertyChange("courseId", oldCourseId, courseId);
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        String oldCourseTitle = this.courseTitle;
        this.courseTitle = courseTitle;
        changeSupport.firePropertyChange("courseTitle", oldCourseTitle, courseTitle);
    }

    public int getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(int courseDuration) {
        int oldCourseDuration = this.courseDuration;
        this.courseDuration = courseDuration;
        changeSupport.firePropertyChange("courseDuration", oldCourseDuration, courseDuration);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseId != null ? courseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Courses)) {
            return false;
        }
        Courses other = (Courses) object;
        if ((this.courseId == null && other.courseId != null) || (this.courseId != null && !this.courseId.equals(other.courseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "student.management.app.Courses[ courseId=" + courseId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
