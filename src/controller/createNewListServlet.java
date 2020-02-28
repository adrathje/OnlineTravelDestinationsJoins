package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Destination;
import model.ListInfo;
import model.Traveler;

/**
 * Servlet implementation class createNewListServlet
 */
@WebServlet("/createNewListServlet")
public class createNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public createNewListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DestinationHelper destinationHelper = new DestinationHelper();
		String listName = request.getParameter("listName");
		System.out.println("List Name: " + listName);

		String travelerName = request.getParameter("travelerName");
		String[] selectedDestinations = request.getParameterValues("allDestinationsToAdd");
		List<Destination> selectedDestinationsInList = new ArrayList<Destination>();
		if (selectedDestinations != null && selectedDestinations.length > 0) {
			for (int i = 0; i < selectedDestinations.length; i++) {
				System.out.println(selectedDestinations[i]);
				Destination dest = destinationHelper.searchForCityById(Integer.parseInt(selectedDestinations[i]));
				selectedDestinationsInList.add(dest);

			}
		}

		Traveler traveler = new Traveler(travelerName);
		ListInfo listInfo = new ListInfo(listName, traveler);
		listInfo.setListOfItems(selectedDestinationsInList);
		ListInfoHelper listInfoHelper = new ListInfoHelper();
		listInfoHelper.insertNewListDetails(listInfo);

		System.out.println("Success!");
		System.out.println(listInfo.toString());

		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
