/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.management.app;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author matt.maree
 */
@Entity
@Table(name = "assessments", catalog = "studentdb", schema = "")
@NamedQueries({
    @NamedQuery(name = "Assessments.findAll", query = "SELECT a FROM Assessments a")
    , @NamedQuery(name = "Assessments.findByAssessId", query = "SELECT a FROM Assessments a WHERE a.assessId = :assessId")
    , @NamedQuery(name = "Assessments.findByAssessType", query = "SELECT a FROM Assessments a WHERE a.assessType = :assessType")
    , @NamedQuery(name = "Assessments.findByAssessDate", query = "SELECT a FROM Assessments a WHERE a.assessDate = :assessDate")
    , @NamedQuery(name = "Assessments.findByAssessCriteria", query = "SELECT a FROM Assessments a WHERE a.assessCriteria = :assessCriteria")
    , @NamedQuery(name = "Assessments.findBySubjectId", query = "SELECT a FROM Assessments a WHERE a.subjectId = :subjectId")})
public class Assessments implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ASSESS_ID")
    private Integer assessId;
    @Basic(optional = false)
    @Column(name = "ASSESS_TYPE")
    private String assessType;
    @Basic(optional = false)
    @Column(name = "ASSESS_DATE")
    @Temporal(TemporalType.DATE)
    private Date assessDate;
    @Basic(optional = false)
    @Column(name = "ASSESS_CRITERIA")
    private String assessCriteria;
    @Basic(optional = false)
    @Column(name = "SUBJECT_ID")
    private String subjectId;

    public Assessments() {
    }

    public Assessments(Integer assessId) {
        this.assessId = assessId;
    }

    public Assessments(Integer assessId, String assessType, Date assessDate, String assessCriteria, String subjectId) {
        this.assessId = assessId;
        this.assessType = assessType;
        this.assessDate = assessDate;
        this.assessCriteria = assessCriteria;
        this.subjectId = subjectId;
    }

    public Integer getAssessId() {
        return assessId;
    }

    public void setAssessId(Integer assessId) {
        Integer oldAssessId = this.assessId;
        this.assessId = assessId;
        changeSupport.firePropertyChange("assessId", oldAssessId, assessId);
    }

    public String getAssessType() {
        return assessType;
    }

    public void setAssessType(String assessType) {
        String oldAssessType = this.assessType;
        this.assessType = assessType;
        changeSupport.firePropertyChange("assessType", oldAssessType, assessType);
    }

    public Date getAssessDate() {
        return assessDate;
    }

    public void setAssessDate(Date assessDate) {
        Date oldAssessDate = this.assessDate;
        this.assessDate = assessDate;
        changeSupport.firePropertyChange("assessDate", oldAssessDate, assessDate);
    }

    public String getAssessCriteria() {
        return assessCriteria;
    }

    public void setAssessCriteria(String assessCriteria) {
        String oldAssessCriteria = this.assessCriteria;
        this.assessCriteria = assessCriteria;
        changeSupport.firePropertyChange("assessCriteria", oldAssessCriteria, assessCriteria);
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        String oldSubjectId = this.subjectId;
        this.subjectId = subjectId;
        changeSupport.firePropertyChange("subjectId", oldSubjectId, subjectId);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (assessId != null ? assessId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Assessments)) {
            return false;
        }
        Assessments other = (Assessments) object;
        if ((this.assessId == null && other.assessId != null) || (this.assessId != null && !this.assessId.equals(other.assessId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "student.management.app.Assessments[ assessId=" + assessId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
