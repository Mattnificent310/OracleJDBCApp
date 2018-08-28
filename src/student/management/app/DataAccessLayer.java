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

/**
 *
 * @author matt.maree
 */
public class DataAccessLayer {

    public Connection Connect() {
        try {
            String oracle = "jdbc:oracle:thin:@localhost:1521:orcl [sys as sysdba]";
            String orcDriver = "oracle.jdbc.OracleDriver";
            String orcUser = "marline";
            String orcPass = "oracle";
            String mysql = "jdbc:mysql://localhost:3306/studentdb?zeroDateTimeBehavior=convertToNull";
            String myDrivr = "com.mysql.jdbc.Driver";
            String myUser = "root";
            //Class.forName("oracle.jdbc.driver.OracleDriver");
            Class.forName(orcDriver);
            //return DriverManager.getConnection(oracle,orcUser,orcPass);
            return DriverManager.getConnection(mysql,myUser, "");
        } catch (Exception ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Student> GetStudent() throws SQLException {
        List<Student> studentList = new ArrayList<>();
        Statement st = Connect().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM student");
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
        ResultSet rs = st.executeQuery("SELECT * FROM lecturers");
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
        ResultSet rs = st.executeQuery("SELECT * FROM subjects");
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
        ResultSet rs = st.executeQuery("SELECT * FROM courses");
        while (rs.next()) {
            courseList.add(new Course(rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getInt(4)));
        }
        return courseList;
    }

    public Student insertStudent(Student student) throws SQLException {
        String sql = "INSERT INTO student  VALUES (?, ?, ?, ?, ?, ?, ?)";
        String lastRow = "SELECT * FROM students ORDER BY STUDENT_ID DESC LIMIT 1";
        PreparedStatement ps = Connect().prepareStatement(sql);
        ps.setInt(1, 0);
        ps.setString(2, student.getName());
        ps.setString(3, student.getSurname());
        ps.setString(4, student.getGender());
        ps.setString(5, student.getBirthDate());
        ps.setString(6, student.getPhone());
        ps.setString(7, student.getEmail());
        ps.executeUpdate();
        ResultSet rs = ps.executeQuery(lastRow);
        return new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));

    }

    public Lecturer insertLecturer(Lecturer lecturer) throws SQLException {
        String sql = "INSERT INTO lecturers VALUES (?, ?, ?, ?, ?, ?, ?)";
        String lastRow = "SELECT * FROM lecturers ORDER BY LEC_ID DESC LIMIT 1";
        PreparedStatement ps = Connect().prepareStatement(sql);
        ps.setInt(1, 0);
        ps.setString(2, lecturer.getName());
        ps.setString(3, lecturer.getSurname());
        ps.setString(4, lecturer.getGender());
        ps.setString(5, lecturer.getBirthDate());
        ps.setString(6, lecturer.getPhone());
        ps.setString(7, lecturer.getEmail());        
        ps.executeUpdate();
        ResultSet rs = ps.executeQuery(lastRow);
        System.out.println(rs.next());
        return new Lecturer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));

    }

    public Subject insertSubject(Subject subject) throws SQLException {
        String sql = "INSERT INTO subjects VALUES (?, ?, ?)";
        String lastRow = "SELECT * FROM subjects ORDER BY SUBJECT_ID DESC LIMIT 1";
        PreparedStatement ps = Connect().prepareStatement(sql);
        ps.setInt(0, 0);
        ps.setString(1, subject.getName());
        ps.setInt(2, subject.getWeight());
        ps.setInt(3, subject.getDuration());
        ps.executeUpdate();
        ResultSet rs = ps.executeQuery(lastRow);
        return new Subject(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));

    }

    public Course insertCourse(Course course) throws SQLException {
        String sql = "INSERT INTO courses VALUES (?, ?, ?, ?)";
        String lastRow = "SELECT * FROM courses ORDER BY COURSE_ID DESC LIMIT 1";
        PreparedStatement ps = Connect().prepareStatement(sql);        
        ps.setInt(1, 0);
        ps.setString(2, course.getTitle());
        ps.setInt(3, course.getWeight());
        ps.setInt(4, course.getDuration());
        ps.executeUpdate();
        ResultSet rs = ps.executeQuery(lastRow);
        return new Course(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));

    }

    public boolean updateStudent(Student student) throws SQLException {
        String sql = "UPDATE Students SET Student_Name = ?, Student_Surname = ?, Student_Age = ?, Student_Gender = ?, Student_Phone = ?, Student_Email = ?";
        PreparedStatement ps = Connect().prepareStatement(sql);
        ps.setString(1, student.getName());
        ps.setString(2, student.getSurname());
        ps.setString(3, student.getBirthDate());
        ps.setString(4, student.getGender());
        ps.setString(5, student.getPhone());
        ps.setString(6, student.getEmail());
        return ps.executeUpdate() > 0;

    }

    public boolean updateLecturer(Lecturer lecturer) throws SQLException {
        String sql = "UPDATE Lecturers SET Lecturer_Name = ?, Lecturer_Surname = ?, Lecturer_Age = ?, Lecturer_Gender = ?, Lecturer_Phone = ?, Lecturer_Email = ?";
        PreparedStatement ps = Connect().prepareStatement(sql);
        ps.setString(1, lecturer.getName());
        ps.setString(2, lecturer.getSurname());
        ps.setString(3, lecturer.getBirthDate());
        ps.setString(4, lecturer.getGender());
        ps.setString(5, lecturer.getPhone());
        ps.setString(6, lecturer.getEmail());
        return ps.executeUpdate() > 0;

    }
    public boolean updateSubject(Subject subject) throws SQLException {
        String sql = "UPDATE Subjects SET Subject_Title = ?, Subject_Weigt = ?, Subject_Duration = ?";
        PreparedStatement ps = Connect().prepareStatement(sql);
        ps.setString(1, subject.getName());
        ps.setInt(2, subject.getWeight());
        ps.setInt(3, subject.getDuration());
        return ps.executeUpdate() > 0;
    }
    public boolean updateCourse(Course course) throws SQLException {
        String sql = "UPDATE Courses SET Course_Title = ?, Course_Weigt = ?, Course_Duration = ?";
        PreparedStatement ps = Connect().prepareStatement(sql);
        ps.setString(1, course.getTitle());
        ps.setInt(2, course.getWeight());
        ps.setInt(3, course.getDuration());
        return ps.executeUpdate() > 0;        
    }
    public boolean deleteStudent(int id) throws SQLException {
        String sql = "DELETE FROM Students WHERE Student_ID = ?";
        PreparedStatement ps = Connect().prepareStatement(sql);
        ps.setInt(1, id);        
        return ps.executeUpdate() > 0;

    }

    public boolean deleteLecturer(int id) throws SQLException {
        String sql = "DELETE FROM Lecturers WHERE Lecturer_ID = ?";
        PreparedStatement ps = Connect().prepareStatement(sql);
        ps.setInt(1, id);       
        return ps.executeUpdate() > 0;

    }
    public boolean deleteSubject(int id) throws SQLException {
        String sql = "DELETE FROM Subjects WHERE Subject_ID = ?";
        PreparedStatement ps = Connect().prepareStatement(sql);
        ps.setInt(1, id);        
        return ps.executeUpdate() > 0;
    }
    public boolean deleteCourse(int id) throws SQLException {
        String sql = "DELETE FROM Courses WHERE Course_ID = ?";
        PreparedStatement ps = Connect().prepareStatement(sql);
        ps.setInt(1, id);
        return ps.executeUpdate() > 0;        
    }
}
