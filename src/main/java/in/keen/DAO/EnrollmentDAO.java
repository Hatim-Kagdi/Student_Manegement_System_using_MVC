package in.keen.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.keen.Connection.DBconnection;
import in.keen.Model.Enrollment;

public class EnrollmentDAO {
	//Add New Enrollment
	public boolean addEnrollment(Enrollment enrollment) {
		boolean status = false;
		try {
			Connection con = DBconnection.getConnection();
			String query = "INSERT INTO enrollments (student_id , courses_id) VALUES (? ,?) ";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, enrollment.getStudentId());
			ps.setInt(2 , enrollment.getCourseId());
			
			int add = ps.executeUpdate();
			
			if(add > 0) {
				status = true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	//View All Enrollments
	public List<Enrollment> viewEnrollment(){
		List<Enrollment> list = new ArrayList<>();
		
		try {
			
			Connection con = DBconnection.getConnection();
			String query = "SELECT e.enrollment_id, s.students_name, c.course_name FROM enrollments e JOIN students s ON e.student_id = s.students_id JOIN courses c ON e.courses_id = c.course_id";
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Enrollment e = new Enrollment();
				e.setEnrollmentId(rs.getInt("enrollment_id"));
				e.setStudentName(rs.getString("students_name"));
				e.setCourseName(rs.getString("course_name"));
				list.add(e);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
