package in.keen.Controller.StudentCRUD;
	import java.io.IOException;

	import in.keen.DAO.StudentDAO;
	import in.keen.Model.Student;
	import jakarta.servlet.RequestDispatcher;
	import jakarta.servlet.ServletException;
	import jakarta.servlet.annotation.WebServlet;
	import jakarta.servlet.http.HttpServlet;
	import jakarta.servlet.http.HttpServletRequest;
	import jakarta.servlet.http.HttpServletResponse;

	@WebServlet("/editStudent")
	public class EditStudentServlet extends HttpServlet{
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			int id = Integer.parseInt(req.getParameter("studentId"));
			
			StudentDAO dao = new StudentDAO();
			
			Student student = dao.getStudentById(id);
			
			req.setAttribute("student", student);
			
			RequestDispatcher rd = req.getRequestDispatcher("/Student/editStudent.jsp");
			rd.forward(req, resp);
		}
	}

