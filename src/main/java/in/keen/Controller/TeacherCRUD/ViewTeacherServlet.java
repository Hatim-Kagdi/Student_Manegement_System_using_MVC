package in.keen.Controller.TeacherCRUD;

import java.io.IOException;
import java.util.List;

import in.keen.DAO.TeacherDAO;
import in.keen.Model.Teacher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewTeachers")
public class ViewTeacherServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TeacherDAO dao = new TeacherDAO();
		
		List<Teacher> teacher = dao.viewAllTeachers();
		
		req.setAttribute("teacherList", teacher);
		
		req.getRequestDispatcher("Teacher/viewTeacher.jsp").forward(req, resp);
	}
}
