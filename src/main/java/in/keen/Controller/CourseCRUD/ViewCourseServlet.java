package in.keen.Controller.CourseCRUD;

import java.io.IOException;
import java.util.List;

import in.keen.DAO.CourseDAO;
import in.keen.DAO.TeacherDAO;
import in.keen.Model.Course;
import in.keen.Model.Teacher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewCourses")
public class ViewCourseServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//TO get data of Course
		CourseDAO dao = new CourseDAO();
		List<Course> course = dao.getAllCourses();
		req.setAttribute("courseList", course);
		
		
		//To get data of Teacher
		TeacherDAO tdao = new TeacherDAO();
		List<Teacher> teacher = tdao.viewAllTeachers();
		req.setAttribute("teacherList", teacher);
		
		req.getRequestDispatcher("Course/viewCourses.jsp").forward(req, resp);
	}
}
