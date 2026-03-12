package in.keen.Controller.StudentCRUD;
import java.io.IOException;
import java.util.List;
import in.keen.DAO.StudentDAO;
import in.keen.Model.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/viewStudents")	
	public class ViewStudentServlet extends HttpServlet{
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			StudentDAO dao = new StudentDAO();
			
			List<Student> students = dao.getAllStudents();
			
			req.setAttribute("studentList", students);
			
			req.getRequestDispatcher("Student/viewStudents.jsp").forward(req, resp);
		}
	}

