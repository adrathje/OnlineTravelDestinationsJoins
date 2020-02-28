
import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.DestinationHelper;
import model.Destination;

/**
 * Servlet implementation class AddDestinationServlet
 */
@WebServlet("/addDestinationServlet")
public class AddDestinationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDestinationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String country = request.getParameter("country");
		String city = request.getParameter("city");
		if (country.isEmpty() || city.isEmpty() || country == null || city == null) {
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		} else {
			Destination dest = new Destination(country, city);
			DestinationHelper dao = new DestinationHelper();
			dao.insertDestination(dest);

			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		}
	}

}
