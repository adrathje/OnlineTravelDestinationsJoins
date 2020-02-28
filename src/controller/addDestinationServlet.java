package controller;

import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Destination;

/**
 * Name: Austin Rathje
 * Date: 2/19/2020
 * Operating System: Windows 10
 */

/**
 * Servlet implementation class addDestinationServlet
 */
@WebServlet("/addDestinationServlet")
public class addDestinationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addDestinationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String country = request.getParameter("country");
		String city = request.getParameter("city");
		Destination dest = new Destination(country, city);
		DestinationHelper dao = new DestinationHelper();
		dao.insertDestination(dest);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
