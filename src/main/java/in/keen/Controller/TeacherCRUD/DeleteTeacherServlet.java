package in.keen.Controller.TeacherCRUD;

import java.io.IOException;

import in.keen.DAO.TeacherDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteTeacher")
public class DeleteTeacherServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("teacherId"));
		
		TeacherDAO dao = new TeacherDAO();
		
		boolean status = dao.deleteById(id);
		
		if(status) {
			resp.sendRedirect("viewTeachers");
		}else {
			resp.getWriter().print("DELETE FAILED!");
		}
	}
}
