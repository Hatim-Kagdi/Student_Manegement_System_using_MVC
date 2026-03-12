package in.keen.Controller.CourseCRUD;

import java.io.IOException;
import java.util.List;

import in.keen.DAO.TeacherDAO;
import in.keen.Model.Teacher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addCoursePage")
public class AddCourseServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TeacherDAO dao = new TeacherDAO();
		
		List<Teacher> list = dao.viewAllTeachers();
		
		req.setAttribute("teacherList", list);
		
		req.getRequestDispatcher("/Course/addCourse.jsp").forward(req, resp);
	}
}
