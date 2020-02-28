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
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NavigationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String act = request.getParameter("doThisToDestination");
		String path = "/viewAllDestinationsServlet";
		DestinationHelper dao = new DestinationHelper();
		
		if (act.equals("Delete Destination")) {
			
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Destination destinationToDelete = dao.searchForCityById(tempId);
				dao.deleteDestination(destinationToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a destination, please try again.");
			}
			
		} else if (act.equals("Edit Destination")) {
			
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Destination destinationToEdit = dao.searchForCityById(tempId);
				request.setAttribute("destinationToEdit", destinationToEdit);
				path = "/edit-destination.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a destination, please try again.");
			}
			
		} else if (act.equals("Add Destination")) {
			path = "/index.html";
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
