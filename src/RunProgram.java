import java.util.List;
import java.util.Scanner;

import controller.DestinationHelper;
import model.Destination;

/**
 * Name: Austin Rathje
 * Date: 2/19/2020
 * Operating System: Windows 10
 */

public class RunProgram {
	// create scanner and Destination objects
	static Scanner input = new Scanner(System.in);
	static DestinationHelper destinationHelper = new DestinationHelper();

	public static void main(String[] args) {
		menuDisplay();
	}

	public static void menuDisplay() {
		// local variable
		boolean readyToExit = false;

		// display menu options
		System.out.println(" __________________________________");
		System.out.println("|                                  |");
		System.out.println("|        The Destination Hub       |");
		System.out.println("|__________________________________|");
		System.out.println("| Where would you like to go vist? |");
		while (!readyToExit) {
			System.out.println("|    ~ Please pick an option ~     |");
			System.out.println("|                                  |");
			System.out.println("|  1 -- Display all destinations   |");
			System.out.println("|  2 -- Add a destination          |");
			System.out.println("|  3 -- Delete a destination       |");
			System.out.println("|  4 -- Edit a destination         |");
			System.out.println("|  5 -- Exit                       |");
			System.out.println("|__________________________________|");
			System.out.print("Your choice: ");

			// prompt user for input, then run their choice
			int choice = input.nextInt();
			input.nextLine();

			if (choice == 1) {
				displayDestinations();
			} else if (choice == 2) {
				addDestination();
			} else if (choice == 3) {
				deleteDestination();
			} else if (choice == 4) {
				editDestination();
			} else if (choice == 5) {
				destinationHelper.cleanUp();
				System.out.println("   Ciao!   ");
				readyToExit = true;
			} else {
				System.out.println("That is not an option, please try again.");
			}
		}
	}

	/**
	 * prints out each destination in the table
	 */
	private static void displayDestinations() {
		List<Destination> allDestinations = destinationHelper.displayAllDestinations();
		for (Destination oneDestination : allDestinations) {
			System.out.println(oneDestination.returnDestinationDetails());
		}
	}

	/**
	 * inserts a destination into the table
	 */
	private static void addDestination() {
		// prompt user which country and city they want to add
		System.out.print("Enter a country: ");
		String store = input.nextLine();
		System.out.print("Enter a city: ");
		String item = input.nextLine();

		// create a destination object with the user's input then add it
		Destination toAdd = new Destination(store, item);
		destinationHelper.insertDestination(toAdd);
	}

	/**
	 * deletes a destination from the table
	 */
	private static void deleteDestination() {
		// prompt user which country and city they want to delete
		System.out.print("Enter the country you want to delete: ");
		String country = input.nextLine();
		System.out.print("Enter the city you want to delete: ");
		String city = input.nextLine();

		// create a destination object with the user's input and delete its equivalence
		Destination toDelete = new Destination(country, city);
		destinationHelper.deleteDestination(toDelete);
	}

	/**
	 * searches for an existing city or country, if found, allows the user to update
	 * it
	 */
	private static void editDestination() {
		// prompt the user for search preference
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by country");
		System.out.println("2 : Search by city");
		int searchPref = input.nextInt();
		input.nextLine();

		// create a blank destination to hold the findings
		List<Destination> foundLocation;

		if (searchPref == 1) {
			// search by country name based on user input
			System.out.print("Enter the country you want to search for: ");
			String country = input.nextLine();
			foundLocation = destinationHelper.searchForCityByCountry(country);
		} else {
			// search by city name based on user input
			System.out.print("Enter the city you want to search for: ");
			String city = input.nextLine();
			foundLocation = destinationHelper.searchForCityByCity(city);
		}

		// print out found results
		if (!foundLocation.isEmpty()) {
			System.out.println("Found Results.");
			for (Destination dest : foundLocation) {
				System.out.println(dest.getId() + " : " + dest.toString());
			}
			System.out.print("Which ID to edit: ");
			int idNum = input.nextInt();

			// update the country or city
			Destination toEdit = destinationHelper.searchForCityById(idNum);
			System.out.println("Retrieved " + toEdit.getCity() + " from " + toEdit.getCountry());
			System.out.println("1 : Update country");
			System.out.println("2 : Update city");
			int update = input.nextInt();
			input.nextLine();

			if (update == 1) {
				System.out.print("New country: ");
				String newCountry = input.nextLine();
				toEdit.setCountry(newCountry);
			} else if (update == 2) {
				System.out.print("New city: ");
				String newCity = input.nextLine();
				toEdit.setCity(newCity);
			}

			destinationHelper.updateDestination(toEdit);

		} else {
			System.out.println("~ Did not find any results. ~");
		}
	}
}
