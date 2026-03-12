package in.keen.Controller.TeacherCRUD;

import java.io.IOException;

import in.keen.DAO.TeacherDAO;
import in.keen.Model.Teacher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/updateTeacher")
public class UpdateTeacherServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String department = req.getParameter("department");
		
		Teacher teacher = new Teacher();
		
		teacher.setTeacherId(id);
		teacher.setTeacherName(name);
		teacher.setTeacherEmail(email);
		teacher.setTeacherDepartment(department);
		
		TeacherDAO dao = new TeacherDAO();
		
		boolean status = dao.updateTeacher(teacher);
		
		if(status) {
			resp.sendRedirect("viewTeachers");
		}else {
			resp.getWriter().print("UPDATE FAILED!");
		}
	
	}
}
