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
 * Servlet implementation class editDestinationServlet
 */
@WebServlet("/editDestinationServlet")
public class EditDestinationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditDestinationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DestinationHelper dao = new DestinationHelper();
		String country = request.getParameter("country");
		String city = request.getParameter("city");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		Destination destinationToUpdate = dao.searchForCityById(tempId);
		destinationToUpdate.setCity(city);
		destinationToUpdate.setCountry(country);
		
		dao.updateDestination(destinationToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllDestinationsServlet").forward(request, response);		
	}                                             

}
