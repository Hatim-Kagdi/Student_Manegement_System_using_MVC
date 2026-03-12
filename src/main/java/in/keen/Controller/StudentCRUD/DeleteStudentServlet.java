package in.keen.Controller.StudentCRUD;
	import java.io.IOException;

	import in.keen.DAO.StudentDAO;
	import jakarta.servlet.ServletException;
	import jakarta.servlet.annotation.WebServlet;
	import jakarta.servlet.http.HttpServlet;
	import jakarta.servlet.http.HttpServletRequest;
	import jakarta.servlet.http.HttpServletResponse;

	@WebServlet("/deleteStudent")
	public class DeleteStudentServlet extends HttpServlet {
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			int id = Integer.parseInt(req.getParameter("studentId"));
			StudentDAO dao = new StudentDAO();
			
			boolean status = dao.deleteStudent(id);
			
			if(status) {
				resp.sendRedirect("viewStudents");
			}else {
				resp.getWriter().print("Delete Failed!");
			}
		}
	}

