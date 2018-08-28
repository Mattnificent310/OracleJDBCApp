/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.management.app;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataAccessLayer {

    public Connection Connect() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL [ [sys as sysdba on MARLINE]", "MARLINE", "oracle");
        } catch (Exception ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Student> GetStudent() throws SQLException {
        List<Student> studentList = new ArrayList<>();
        Statement st = Connect().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM Students");
        while (rs.next()) {
            studentList.add(new Student(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7)));
        }
        return studentList;
    }

    public List<Lecturer> GetLecturers() throws SQLException {
        List<Lecturer> lecturerList = new ArrayList<>();
        Statement st = Connect().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM Lecturers");
        while (rs.next()) {
            lecturerList.add(new Lecturer(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7)));
        }
        return lecturerList;
    }

    public List<Subject> GetSubjects() throws SQLException {
        List<Subject> subjectList = new ArrayList<>();
        Statement st = Connect().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM Subjects");
        while (rs.next()) {
            subjectList.add(new Subject(rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getInt(4)));
        }
        return subjectList;
    }

    public List<Course> GetCourses() throws SQLException {
        List<Course> courseList = new ArrayList<>();
        Statement st = Connect().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM Courses");
        while (rs.next()) {
            courseList.add(new Course(rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getInt(4)));
        }
        return courseList;
    }

    public Student insertStudent(Student student) throws SQLException {
        String sql = "INSERT INTO Students (Student_Name, Student_Surname, Student_Age, Student_Gender, Student_Phone, Student_Email) VALUES (?, ?, ?, ?, ?, ?)";
        String lastRow = "SELECT TOP 1 FROM Students ORDER BY DESC";
        PreparedStatement ps = Connect().prepareStatement(sql);
        ps.setString(0, student.getName());
        ps.setString(1, student.getSurname());
        ps.setString(2, student.getBirthDate());
        ps.setString(3, student.getGender());
        ps.setString(4, student.getPhone());
        ps.setString(5, student.getEmail());
        ps.executeUpdate();
        ResultSet rs = ps.executeQuery(lastRow);
        return new Student(rs.getInt(0), rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));

    }

    public Lecturer insertLecturer(Lecturer lecturer) throws SQLException {
        String sql = "INSERT INTO Lecturers (Lecturer_Name, Lecturer_Surname, Lecturer_Age, Lecturer_Gender, Lecturer_Phone, Lecturer_Email) VALUES (?, ?, ?, ?, ?, ?)";
        String lastRow = "SELECT TOP 1 FROM Lecturers ORDER BY DESC";
        PreparedStatement ps = Connect().prepareStatement(sql);
        ps.setString(0, lecturer.getName());
        ps.setString(1, lecturer.getSurname());
        ps.setString(2, lecturer.getBirthDate());
        ps.setString(3, lecturer.getGender());
        ps.setString(4, lecturer.getPhone());
        ps.setString(5, lecturer.getEmail());
        ps.executeUpdate();
        ResultSet rs = ps.executeQuery(lastRow);
        return new Lecturer(rs.getInt(0), rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));

    }

    public Subject insertSubject(Subject subject) throws SQLException {
        String sql = "INSERT INTO Subjects (Subject_Title, Subject_Weigt, Subject_Duration) VALUES (?, ?, ?)";
        String lastRow = "SELECT TOP 1 FROM Subjects ORDER BY DESC";
        PreparedStatement ps = Connect().prepareStatement(sql);
        ps.setString(0, subject.getName());
        ps.setInt(1, subject.getWeight());
        ps.setInt(2, subject.getDuration());
        ps.executeUpdate();
        ResultSet rs = ps.executeQuery(lastRow);
        return new Subject(rs.getInt(0), rs.getString(1), rs.getInt(2), rs.getInt(3));

    }

    public Course insertCourse(Course course) throws SQLException {
        String sql = "INSERT INTO Courses (Course_Title, Course_Weigt, Course_Duration) VALUES (?, ?, ?)";
        String lastRow = "SELECT TOP 1 FROM Courses ORDER BY DESC";
        PreparedStatement ps = Connect().prepareStatement(sql);
        ps.setString(0, course.getTitle());
        ps.setInt(1, course.getWeight());
        ps.setInt(2, course.getDuration());
        ps.executeUpdate();
        ResultSet rs = ps.executeQuery(lastRow);
        return new Course(rs.getInt(0), rs.getString(1), rs.getInt(2), rs.getInt(3));

    }

    public boolean updateStudent(Student student) throws SQLException {
        String sql = "UPDATE Students SET Student_Name = ?, Student_Surname = ?, Student_Age = ?, Student_Gender = ?, Student_Phone = ?, Student_Email = ?";
        PreparedStatement ps = Connect().prepareStatement(sql);
        ps.setString(0, student.getName());
        ps.setString(1, student.getSurname());
        ps.setString(2, student.getBirthDate());
        ps.setString(3, student.getGender());
        ps.setString(4, student.getPhone());
        ps.setString(5, student.getEmail());
        return ps.executeUpdate() > 0;

    }

    public boolean updateLecturer(Lecturer lecturer) throws SQLException {
        String sql = "UPDATE Lecturers SET Lecturer_Name = ?, Lecturer_Surname = ?, Lecturer_Age = ?, Lecturer_Gender = ?, Lecturer_Phone = ?, Lecturer_Email = ?";
        PreparedStatement ps = Connect().prepareStatement(sql);
        ps.setString(0, lecturer.getName());
        ps.setString(1, lecturer.getSurname());
        ps.setString(2, lecturer.getBirthDate());
        ps.setString(3, lecturer.getGender());
        ps.setString(4, lecturer.getPhone());
        ps.setString(5, lecturer.getEmail());
        return ps.executeUpdate() > 0;

    }
    public boolean updateSubject(Subject subject) throws SQLException {
        String sql = "UPDATE Subjects SET Subject_Title = ?, Subject_Weigt = ?, Subject_Duration = ?";
        PreparedStatement ps = Connect().prepareStatement(sql);
        ps.setString(0, subject.getName());
        ps.setInt(1, subject.getWeight());
        ps.setInt(2, subject.getDuration());
        return ps.executeUpdate() > 0;
    }
    public boolean updateCourse(Course course) throws SQLException {
        String sql = "UPDATE Courses SET Course_Title = ?, Course_Weigt = ?, Course_Duration = ?";
        PreparedStatement ps = Connect().prepareStatement(sql);
        ps.setString(0, course.getTitle());
        ps.setInt(1, course.getWeight());
        ps.setInt(2, course.getDuration());
        return ps.executeUpdate() > 0;        
    }
    public boolean deleteStudent(int id) throws SQLException {
        String sql = "DELETE FROM Students WHERE Student_ID = ?";
        PreparedStatement ps = Connect().prepareStatement(sql);
        ps.setInt(0, id);        
        return ps.executeUpdate() > 0;

    }

    public boolean deleteLecturer(int id) throws SQLException {
        String sql = "DELETE FROM Lecturers WHERE Lecturer_ID = ?";
        PreparedStatement ps = Connect().prepareStatement(sql);
        ps.setInt(0, id);       
        return ps.executeUpdate() > 0;

    }
    public boolean deleteSubject(int id) throws SQLException {
        String sql = "DELETE FROM Subjects WHERE Subject_ID = ?";
        PreparedStatement ps = Connect().prepareStatement(sql);
        ps.setInt(0, id);        
        return ps.executeUpdate() > 0;
    }
    public boolean deleteCourse(int id) throws SQLException {
        String sql = "DELETE FROM Courses WHERE Course_ID = ?";
        PreparedStatement ps = Connect().prepareStatement(sql);
        ps.setInt(0, id);
        return ps.executeUpdate() > 0;        
    }
}
