package in.keen.Controller.CourseCRUD;

import java.io.IOException;

import in.keen.DAO.CourseDAO;
import in.keen.Model.Course;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateCourse")
public class UpdateCourseServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int cId = Integer.parseInt(req.getParameter("courseId"));
		String name = req.getParameter("name");
		int tId = Integer.parseInt(req.getParameter("teacherId"));
		
		Course c = new Course();
		
		c.setCourseId(cId);
		c.setCourseName(name);
		c.setTeacherId(tId);
		
		CourseDAO dao = new CourseDAO();
		
		boolean status = dao.updateCourse(c);
		
		if(status) {
			resp.sendRedirect("viewCourses");
		}else {
			resp.getWriter().print("Update failed!");
		}
	}
}
