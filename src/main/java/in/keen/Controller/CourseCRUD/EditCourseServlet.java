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

@WebServlet("/editCourse")
public class EditCourseServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("courseId"));
		TeacherDAO tdao = new TeacherDAO();
		CourseDAO dao = new CourseDAO();
		
		List<Teacher> teacher = tdao.viewAllTeachers();
		
		Course course = dao.getCourseById(id);
		
		req.setAttribute("course", course);
		req.setAttribute("teacherList", teacher);
		
		req.getRequestDispatcher("/Course/editCourse.jsp").forward(req, resp);
		
	}
}
