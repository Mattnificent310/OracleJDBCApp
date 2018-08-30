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

    public List<Student> getStudents(int id) throws SQLException {
        List<Student> studentList = new ArrayList<>();
        Statement st = Connect().createStatement();
        ResultSet rs = st.executeQuery(String.format("SELECT * FROM student %s", (id == 0 ? "" : "WHERE STUDENT_ID = " + id)));
        while (rs.next()) {
            studentList.add(new Student(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(5),
                    rs.getString(4),
                    rs.getString(6),
                    rs.getString(7)));
        }
        return studentList;
    }

    public List<Lecturer> getLecturers(int id) throws SQLException {
        List<Lecturer> lecturerList = new ArrayList<>();
        Statement st = Connect().createStatement();
        ResultSet rs = st.executeQuery(String.format("SELECT * FROM lecturers %s", (id == 0 ? "" : "WHERE LEC_ID = " + id)));
        while (rs.next()) {
            lecturerList.add(new Lecturer(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7)));
        }
        return lecturerList;
    }

    public List<Subject> getSubjects(int id) throws SQLException {
        List<Subject> subjectList = new ArrayList<>();
        Statement st = Connect().createStatement();
        ResultSet rs = st.executeQuery(String.format("SELECT * FROM subjects %s", (id == 0 ? "" : "WHERE SUBJECT_ID = " + id)));
        while (rs.next()) {
            subjectList.add(new Subject(rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getInt(4)));
        }
        return subjectList;
    }

    public List<Course> getCourses(int id) throws SQLException {
        List<Course> courseList = new ArrayList<>();
        Statement st = Connect().createStatement();
        ResultSet rs = st.executeQuery(String.format("SELECT * FROM courses %s", (id == 0 ? "" : "WHERE COURSE_ID = " + id)));
        while (rs.next()) {
            courseList.add(new Course(rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3)));
        }
        return courseList;
    }
public List<Hostel> getHostels(int id) throws SQLException {
        List<Hostel> hostelList = new ArrayList<>();
        Statement st = Connect().createStatement();
        ResultSet rs = st.executeQuery(String.format("SELECT * FROM hostel %s", (id == 0 ? "" : "WHERE HOSTEL_ID = " + id)));
        while (rs.next()) {
            hostelList.add(new Hostel(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4)));
        }
        return hostelList;
    }
    public Student insertStudent(Student student) throws SQLException {
        String sql = "INSERT INTO student  VALUES (?, ?, ?, ?, ?, ?, ?)";
        String lastRow = "SELECT * FROM student ORDER BY STUDENT_ID DESC LIMIT 1";
        PreparedStatement ps = Connect().prepareStatement(sql);
        ps.setInt(1, 0);
        ps.setString(2, student.getName());
        ps.setString(3, student.getSurname());
        ps.setString(4, student.getGender());
        ps.setInt(5, student.getBirthDate());
        ps.setString(6, student.getPhone());
        ps.setString(7, student.getEmail());
        ps.executeUpdate();
        ResultSet rs = ps.executeQuery(lastRow);
        rs.next();
        return new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7));

    }

    public Lecturer insertLecturer(Lecturer lecturer) throws SQLException {
        String sql = "INSERT INTO lecturers VALUES (?, ?, ?, ?, ?, ?, ?)";
        String lastRow = "SELECT * FROM lecturers ORDER BY LEC_ID DESC LIMIT 1";
        PreparedStatement ps = Connect().prepareStatement(sql);
        ps.setInt(1, 0);
        ps.setString(2, lecturer.getName());
        ps.setString(3, lecturer.getSurname());
        ps.setString(4, lecturer.getGender());
        ps.setInt(5, lecturer.getBirthDate());
        ps.setString(6, lecturer.getPhone());
        ps.setString(7, lecturer.getEmail());        
        ps.executeUpdate();
        ResultSet rs = ps.executeQuery(lastRow);
        rs.next();
        return new Lecturer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7));

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
        rs.next();
        return new Subject(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));

    }

    public Course insertCourse(Course course) throws SQLException {
        String sql = "INSERT INTO courses VALUES (?, ?, ?)";
        String lastRow = "SELECT * FROM courses ORDER BY COURSE_ID DESC LIMIT 1";
        PreparedStatement ps = Connect().prepareStatement(sql);        
        ps.setInt(1, 0);
        ps.setString(2, course.getTitle());
        ps.setInt(3, course.getDuration());
        ps.executeUpdate();
        ResultSet rs = ps.executeQuery(lastRow);
        return new Course(rs.getInt(1), rs.getString(2), rs.getInt(4));

    }
public Hostel insertHostel(Hostel hostel) throws SQLException {
        String sql = "INSERT INTO hostel VALUES (?, ?, ?, ?)";
        String lastRow = "SELECT * FROM hostel ORDER BY HOSTEL_ID DESC LIMIT 1";
        PreparedStatement ps = Connect().prepareStatement(sql);        
        ps.setInt(1, 0);
        ps.setString(2, hostel.getName());
        ps.setString(3, hostel.getType());
        ps.setInt(4, hostel.getCapacity());
        ps.executeUpdate();
        ResultSet rs = ps.executeQuery(lastRow);
        return new Hostel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));

    }
public Assessment insertAssessment(Assessment assessment) throws SQLException {
        String sql = "INSERT INTO assessments VALUES (?, ?, ?, ?)";
        String lastRow = "SELECT * FROM assessments ORDER BY ASSESS_ID DESC LIMIT 1";
        PreparedStatement ps = Connect().prepareStatement(sql);        
        ps.setInt(1, 0);
        ps.setString(2, assessment.getType());
        ps.setString(3, assessment.getDate());
        ps.setString(4, assessment.getCriteria());        
        ps.setInt(5, assessment.getSubject().getId());
        ps.executeUpdate();
        ResultSet rs = ps.executeQuery(lastRow);
        return new Assessment(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), getSubjects(rs.getInt(5)).get(0));

    }
public Classroom insertClassroom(Classroom classroom) throws SQLException {
        String sql = "INSERT INTO classroom VALUES (?, ?, ?, ?)";
        String lastRow = "SELECT * FROM classroom ORDER BY CLASS_ID DESC LIMIT 1";
        PreparedStatement ps = Connect().prepareStatement(sql);        
        ps.setInt(1, 0);
        ps.setString(2, classroom.getName());
        ps.setInt(3, classroom.getCapacity());
        ps.executeUpdate();
        ResultSet rs = ps.executeQuery(lastRow);
        return new Classroom(rs.getInt(1), rs.getString(2), rs.getInt(3));

    }
public Room insertRoom(Room room) throws SQLException {
        String sql = "INSERT INTO classroom VALUES (?, ?, ?, ?)";
        String lastRow = "SELECT * FROM classroom ORDER BY CLASS_ID DESC LIMIT 1";
        PreparedStatement ps = Connect().prepareStatement(sql);        
        ps.setInt(1, 0);
        ps.setInt(2, room.getCapacity());
        ps.setString(3, room.getLayout());
        ps.setInt(3, room.getHostel().getHostelId());
        ps.executeUpdate();
        ResultSet rs = ps.executeQuery(lastRow);
        return new Room(rs.getInt(1), rs.getInt(2), rs.getString(3), getHostels(rs.getInt(4)).get(0));

    }
public Session insertSession(Session session) throws SQLException {
        String sql = "INSERT INTO session VALUES (?, ?, ?, ?)";
        String lastRow = "SELECT * FROM session ORDER BY CLASS_ID DESC LIMIT 1";
        PreparedStatement ps = Connect().prepareStatement(sql);        
        ps.setInt(1, 0);
        ps.setString(2, session.getType());
        ps.setInt(3, session.getDuration());
        ps.executeUpdate();
        ResultSet rs = ps.executeQuery(lastRow);
        return new Session(rs.getInt(1), rs.getString(2), rs.getInt(3));

    }
public Mentorship insertMentorship(Mentorship mentor) throws SQLException {
        String sql = "INSERT INTO mentorship VALUES (?, ?, ?, ?)";
        String lastRow = "SELECT * FROM mentorship ORDER BY MENT_ID DESC LIMIT 1";
        PreparedStatement ps = Connect().prepareStatement(sql);        
        ps.setInt(1, 0);
        ps.setString(2, mentor.getType());
        ps.setInt(3, mentor.getLevel());
        ps.setString(4, mentor.getResponsibility());
        ps.setString(5, mentor.getCriteria());
        ps.setInt(6, mentor.getStudent().getId());
        ps.executeUpdate();
        ResultSet rs = ps.executeQuery(lastRow);
        return new Mentorship(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), getStudents(rs.getInt(6)).get(0));

    }
    public boolean updateStudent(Student student) throws SQLException {
        String sql = "UPDATE student SET STUDENT_NAME = ?, STUDENT_SURNAME = ?, STUDENT_AGE = ?, STUDENT_GENDER = ?, STUDENT_PHONE = ?, STUDENT_EMAIL = ? WHERE STUDENT_ID = ?";
        PreparedStatement ps = Connect().prepareStatement(sql);
        ps.setString(1, student.getName());
        ps.setString(2, student.getSurname());
        ps.setInt(3, student.getBirthDate());
        ps.setString(4, student.getGender());
        ps.setString(5, student.getPhone());
        ps.setString(6, student.getEmail());
        ps.setInt(7, student.getId());
        return ps.executeUpdate() > 0;

    }

    public boolean updateLecturer(Lecturer lecturer) throws SQLException {
        String sql = "UPDATE lecturers SET LEC_NAME = ?, LEC_SURNAME = ?, LEC_AGE = ?, LEC_GENDER = ?, LEC_PHONE = ?, LEC_EMAIL = ? WHERE LEC_ID = ?";
        PreparedStatement ps = Connect().prepareStatement(sql);
        ps.setString(1, lecturer.getName());
        ps.setString(2, lecturer.getSurname());
        ps.setInt(3, lecturer.getBirthDate());
        ps.setString(4, lecturer.getGender());
        ps.setString(5, lecturer.getPhone());
        ps.setString(6, lecturer.getEmail());        
        ps.setInt(7, lecturer.getId());
        return ps.executeUpdate() > 0;

    }
    public boolean updateSubject(Subject subject) throws SQLException {
        String sql = "UPDATE subjects SET SUBJECT_TITLE = ?, SUBJECT_WEIGHT = ?, SUBJECT_DURATION = ? WHERE SUBJECT_ID = ?";
        PreparedStatement ps = Connect().prepareStatement(sql);
        ps.setString(1, subject.getName());
        ps.setInt(2, subject.getWeight());
        ps.setInt(3, subject.getDuration());
        ps.setInt(4, subject.getId());
        return ps.executeUpdate() > 0;
    }
    public boolean updateCourse(Course course) throws SQLException {
        String sql = "UPDATE courses SET COURSE_TITLE = ?, COURSE_DURATION = ? WHERE COURSE_ID = ?";
        PreparedStatement ps = Connect().prepareStatement(sql);
        ps.setString(1, course.getTitle());
        ps.setInt(2, course.getDuration());
        ps.setInt(3, course.getCourseId());
        return ps.executeUpdate() > 0;        
    }
    public boolean updateHostel(Hostel hostel) throws SQLException {
        String sql = "UPDATE courses SET HOSTEL_NAME = ?, HOSTEL_TYPE = ?, HOSTEL_CAPACITY = ?WHERE HOSTEL_ID = ?";
        PreparedStatement ps = Connect().prepareStatement(sql);
        ps.setString(1, hostel.getName());
        ps.setString(2, hostel.getType());
        ps.setInt(3, hostel.getCapacity());
        ps.setInt(4, hostel.getHostelId());
        return ps.executeUpdate() > 0;        
    }
    public boolean deleteStudent(int id) throws SQLException {
        String sql = "DELETE FROM student WHERE STUDENT_ID = ?";
        PreparedStatement ps = Connect().prepareStatement(sql);
        ps.setInt(1, id);        
        return ps.executeUpdate() > 0;

    }

    public boolean deleteLecturer(int id) throws SQLException {
        String sql = "DELETE FROM lecturers WHERE LECTURER_ID = ?";
        PreparedStatement ps = Connect().prepareStatement(sql);
        ps.setInt(1, id);       
        return ps.executeUpdate() > 0;

    }
    public boolean deleteSubject(int id) throws SQLException {
        String sql = "DELETE FROM subjects WHERE SUBJECT_ID = ?";
        PreparedStatement ps = Connect().prepareStatement(sql);
        ps.setInt(1, id);        
        return ps.executeUpdate() > 0;
    }
    public boolean deleteCourse(int id) throws SQLException {
        String sql = "DELETE FROM courses WHERE COURSE_ID = ?";
        PreparedStatement ps = Connect().prepareStatement(sql);
        ps.setInt(1, id);
        return ps.executeUpdate() > 0;        
    }
    public boolean deleteHostel(int id) throws SQLException {
        String sql = "DELETE FROM hostel WHERE HOSTELe_ID = ?";
        PreparedStatement ps = Connect().prepareStatement(sql);
        ps.setInt(1, id);
        return ps.executeUpdate() > 0;        
    }
    public boolean deleteAssessment(int id) throws SQLException {
        String sql = "DELETE FROM assessments WHERE ASSESS_ID = ?";
        PreparedStatement ps = Connect().prepareStatement(sql);
        ps.setInt(1, id);
        return ps.executeUpdate() > 0;        
    }
    public boolean deleteClassroom(int id) throws SQLException {
        String sql = "DELETE FROM classroom WHERE CLASS_ID = ?";
        PreparedStatement ps = Connect().prepareStatement(sql);
        ps.setInt(1, id);
        return ps.executeUpdate() > 0;        
    }
    public boolean deleteRoom(int id) throws SQLException {
        String sql = "DELETE FROM rooms WHERE ROOM_NO = ?";
        PreparedStatement ps = Connect().prepareStatement(sql);
        ps.setInt(1, id);
        return ps.executeUpdate() > 0;        
    }
    public boolean deleteMentorship(int id) throws SQLException {
        String sql = "DELETE FROM mentorship WHERE MENT_ID = ?";
        PreparedStatement ps = Connect().prepareStatement(sql);
        ps.setInt(1, id);
        return ps.executeUpdate() > 0;        
    }
    public boolean deleteSession(int id) throws SQLException {
        String sql = "DELETE FROM sessions WHERE SESSION_ID = ?";
        PreparedStatement ps = Connect().prepareStatement(sql);
        ps.setInt(1, id);
        return ps.executeUpdate() > 0;        
    }
     public boolean delinkRoom(int studentId, int roomNo) throws SQLException {
        String sql = "DELETE FROM student_room WHERE STUDENT_ID = ? AND ROOM_NO = ?";
        PreparedStatement ps = Connect().prepareStatement(sql);
        ps.setInt(1, studentId);
        ps.setInt(2, roomNo);
        return ps.executeUpdate() > 0;        
    }
     public boolean delinkSubject(int studentId, int subId) throws SQLException {
        String sql = "DELETE FROM student_subject WHERE STUDENT_ID = ? AND SUBJECT_ID = ?";
        PreparedStatement ps = Connect().prepareStatement(sql);
        ps.setInt(1, studentId);
        ps.setInt(2, subId);
        return ps.executeUpdate() > 0;        
    }
}
