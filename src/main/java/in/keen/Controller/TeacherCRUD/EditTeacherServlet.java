package in.keen.Controller.TeacherCRUD;

import java.io.IOException;

import in.keen.DAO.TeacherDAO;
import in.keen.Model.Teacher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/editTeacher")
public class EditTeacherServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("teacherId"));
		
		TeacherDAO dao = new TeacherDAO();
		
		Teacher teacher = dao.getTeacherById(id);
		
		req.setAttribute("teacher", teacher);
		
		req.getRequestDispatcher("/Teacher/editTeacher.jsp").forward(req, resp);
		
		
	}
}
