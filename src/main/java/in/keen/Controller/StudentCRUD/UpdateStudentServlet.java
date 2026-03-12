package in.keen.Controller.StudentCRUD;
	import java.io.IOException;
	import java.sql.Date;

	import in.keen.DAO.StudentDAO;
	import in.keen.Model.Student;
	import jakarta.servlet.ServletException;
	import jakarta.servlet.annotation.WebServlet;
	import jakarta.servlet.http.HttpServlet;
	import jakarta.servlet.http.HttpServletRequest;
	import jakarta.servlet.http.HttpServletResponse;

	@WebServlet("/updateStudent")
	public class UpdateStudentServlet extends HttpServlet{
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String department = req.getParameter("department");
			int year = Integer.parseInt(req.getParameter("year"));
			Date addmission = Date.valueOf(req.getParameter("addmissionDate"));
			
			Student student = new Student();
			
			student.setStudentId(id);
			student.setStudentName(name);
			student.setStudentEmail(email);
			student.setStudentDepartment(department);
			student.setStudentYear(year);
			student.setStudentAddmissionYear(addmission);
			
			StudentDAO dao = new StudentDAO();
			
			boolean status = dao.updateStudent(student);
			
			if(status) {
				resp.sendRedirect("viewStudents");
			}else {
				resp.getWriter().print("Update failed!");
			}
		}
	}

