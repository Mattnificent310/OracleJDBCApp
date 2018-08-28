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
@Table(name = "lecturers", catalog = "studentdb", schema = "")
@NamedQueries({
    @NamedQuery(name = "Lecturers_1.findAll", query = "SELECT l FROM Lecturers_1 l")
    , @NamedQuery(name = "Lecturers_1.findByLecId", query = "SELECT l FROM Lecturers_1 l WHERE l.lecId = :lecId")
    , @NamedQuery(name = "Lecturers_1.findByLecName", query = "SELECT l FROM Lecturers_1 l WHERE l.lecName = :lecName")
    , @NamedQuery(name = "Lecturers_1.findByLecSurname", query = "SELECT l FROM Lecturers_1 l WHERE l.lecSurname = :lecSurname")
    , @NamedQuery(name = "Lecturers_1.findByLecGender", query = "SELECT l FROM Lecturers_1 l WHERE l.lecGender = :lecGender")
    , @NamedQuery(name = "Lecturers_1.findByLecAge", query = "SELECT l FROM Lecturers_1 l WHERE l.lecAge = :lecAge")
    , @NamedQuery(name = "Lecturers_1.findByLecPhone", query = "SELECT l FROM Lecturers_1 l WHERE l.lecPhone = :lecPhone")
    , @NamedQuery(name = "Lecturers_1.findByLecEmail", query = "SELECT l FROM Lecturers_1 l WHERE l.lecEmail = :lecEmail")})
public class Lecturers_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LEC_ID")
    private Integer lecId;
    @Basic(optional = false)
    @Column(name = "LEC_NAME")
    private String lecName;
    @Basic(optional = false)
    @Column(name = "LEC_SURNAME")
    private String lecSurname;
    @Column(name = "LEC_GENDER")
    private Character lecGender;
    @Basic(optional = false)
    @Column(name = "LEC_AGE")
    private int lecAge;
    @Basic(optional = false)
    @Column(name = "LEC_PHONE")
    private String lecPhone;
    @Basic(optional = false)
    @Column(name = "LEC_EMAIL")
    private String lecEmail;

    public Lecturers_1() {
    }

    public Lecturers_1(Integer lecId) {
        this.lecId = lecId;
    }

    public Lecturers_1(Integer lecId, String lecName, String lecSurname, int lecAge, String lecPhone, String lecEmail) {
        this.lecId = lecId;
        this.lecName = lecName;
        this.lecSurname = lecSurname;
        this.lecAge = lecAge;
        this.lecPhone = lecPhone;
        this.lecEmail = lecEmail;
    }

    public Integer getLecId() {
        return lecId;
    }

    public void setLecId(Integer lecId) {
        Integer oldLecId = this.lecId;
        this.lecId = lecId;
        changeSupport.firePropertyChange("lecId", oldLecId, lecId);
    }

    public String getLecName() {
        return lecName;
    }

    public void setLecName(String lecName) {
        String oldLecName = this.lecName;
        this.lecName = lecName;
        changeSupport.firePropertyChange("lecName", oldLecName, lecName);
    }

    public String getLecSurname() {
        return lecSurname;
    }

    public void setLecSurname(String lecSurname) {
        String oldLecSurname = this.lecSurname;
        this.lecSurname = lecSurname;
        changeSupport.firePropertyChange("lecSurname", oldLecSurname, lecSurname);
    }

    public Character getLecGender() {
        return lecGender;
    }

    public void setLecGender(Character lecGender) {
        Character oldLecGender = this.lecGender;
        this.lecGender = lecGender;
        changeSupport.firePropertyChange("lecGender", oldLecGender, lecGender);
    }

    public int getLecAge() {
        return lecAge;
    }

    public void setLecAge(int lecAge) {
        int oldLecAge = this.lecAge;
        this.lecAge = lecAge;
        changeSupport.firePropertyChange("lecAge", oldLecAge, lecAge);
    }

    public String getLecPhone() {
        return lecPhone;
    }

    public void setLecPhone(String lecPhone) {
        String oldLecPhone = this.lecPhone;
        this.lecPhone = lecPhone;
        changeSupport.firePropertyChange("lecPhone", oldLecPhone, lecPhone);
    }

    public String getLecEmail() {
        return lecEmail;
    }

    public void setLecEmail(String lecEmail) {
        String oldLecEmail = this.lecEmail;
        this.lecEmail = lecEmail;
        changeSupport.firePropertyChange("lecEmail", oldLecEmail, lecEmail);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lecId != null ? lecId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lecturers_1)) {
            return false;
        }
        Lecturers_1 other = (Lecturers_1) object;
        if ((this.lecId == null && other.lecId != null) || (this.lecId != null && !this.lecId.equals(other.lecId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "student.management.app.Lecturers_1[ lecId=" + lecId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
