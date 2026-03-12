package in.keen.Controller.EnrollmentCRUD;

import java.io.IOException;
import java.util.List;

import in.keen.DAO.EnrollmentDAO;
import in.keen.Model.Enrollment;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewEnrollments")
public class ViewEnrollmentServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EnrollmentDAO dao = new EnrollmentDAO();
		
		List<Enrollment> list = dao.viewEnrollment();
		
		req.setAttribute("enrollmentList" , list);
		
		req.getRequestDispatcher("Enrollment/viewEnrollment.jsp").forward(req, resp);
	}
}
