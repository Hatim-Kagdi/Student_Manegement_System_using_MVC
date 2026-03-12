package in.keen.Controller.CourseCRUD;

import java.io.IOException;

import in.keen.DAO.CourseDAO;
import in.keen.Model.Course;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/addCourse")
public class AddNewCourseServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String courseName = req.getParameter("name");
		int teacherId = Integer.parseInt(req.getParameter("teacherId"));
		
		Course course = new Course();
		
		course.setCourseName(courseName);
		course.setTeacherId(teacherId);
		
		CourseDAO dao = new CourseDAO();
		
		boolean status = dao.addCourse(course);
		
		if(status) {
			resp.sendRedirect("viewCourses");
		}else {
			resp.getWriter().print("Add new Course Failed!");
		}
	}
}
