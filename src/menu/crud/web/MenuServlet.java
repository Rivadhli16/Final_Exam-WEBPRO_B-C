package menu.crud.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import menu.crud.dao.MenuDAO;
import menu.crud.model.Drink;
import menu.crud.model.Menu;

@WebServlet("/")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MenuDAO menuDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuServlet() {
        this.menuDAO = new MenuDAO();
    }

    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String action = request.getServletPath();

		switch (action) {
		case "/new":
			showNewForm(request, response);
			break;
		case "/insert":
			try {
				insertMenu(request, response);
			}catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/delete":
			try {
				deleteMenu(request, response);
			}catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/edit":
			try {
				showEditForm(request, response);
			}catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/update":
			try {
				updateMenu(request, response);
			}catch (SQLException e) {
				e.printStackTrace();
			}
			break;
			
			//drink
		case "/new_drink":
			showNewFormDrink(request, response);
			break;
		case "/insert_drink":
			try {
				insertDrink(request, response);
			}catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/delete_drink":
			try {
				deleteDrink(request, response);
			}catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/edit_drink":
			try {
				showEditFormDrink(request, response);
			}catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/update_drink":
			try {
				updateDrink(request, response);
			}catch (SQLException e) {
				e.printStackTrace();
			}
			break;
			
		case "/list_drink":
			try {
				listDrink(request, response);
			}catch (SQLException e) {
				e.printStackTrace();
			}
			break;
			
		default:
			try {
				listMenu(request, response);
			}catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		}
	}
	
	private void listMenu(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Menu> listMenu = menuDAO.selectAllMenus();
		request.setAttribute("listMenu", listMenu);
		RequestDispatcher dispatcher = request.getRequestDispatcher("menu-list.jsp");
		dispatcher.forward(request, response);
	}
	
	//drink
	private void listDrink(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Drink> listDrink = menuDAO.selectAllDrinks();
		request.setAttribute("listDrink", listDrink);
		RequestDispatcher dispatcher = request.getRequestDispatcher("drink-list.jsp");
		dispatcher.forward(request, response);
	}
	
	private void updateMenu(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String foodname = request.getParameter("foodname");
		String releasedate = request.getParameter("releasedate");
		String category = request.getParameter("category");
		String description = request.getParameter("description");


		Menu menu = new Menu(id, foodname, releasedate, category, description);
		menuDAO.updateMenu(menu);
		response.sendRedirect("list");
	}
	
	//drink
	private void updateDrink(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String drinkname = request.getParameter("drinkname");
		String releasedate = request.getParameter("releasedate");
		String category = request.getParameter("category");
		String description = request.getParameter("description");


		Drink drink = new Drink(id, drinkname, releasedate, category, description);
		menuDAO.updateDrink(drink);
		response.sendRedirect("list");
	}
	
	private void deleteMenu(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		menuDAO.deleteMenu(id);
		response.sendRedirect("list");

	}
	
	//drink
	private void deleteDrink(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		menuDAO.deleteDrink(id);
		response.sendRedirect("list");
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Menu existingMenu = menuDAO.selectMenu(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("menu-form.jsp");
		request.setAttribute("menu", existingMenu);
		dispatcher.forward(request, response);
	}
	
	//drink
	private void showEditFormDrink(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Drink existingDrink = menuDAO.selectDrink(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("drink-form.jsp");
		request.setAttribute("drink", existingDrink);
		dispatcher.forward(request, response);
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("menu-form.jsp");
		dispatcher.forward(request, response);
	}
	
	//drink
	private void showNewFormDrink(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("drink-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertMenu(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String foodname = request.getParameter("foodname");
		String releasedate = request.getParameter("releasedate");
		String category = request.getParameter("category");
		String description = request.getParameter("description");
		Menu newMenu = new Menu(foodname, releasedate, category, description);
		menuDAO.insertMenu(newMenu);
		response.sendRedirect("list");
	}
	
	//drink
	private void insertDrink(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String drinkname = request.getParameter("drinkname");
		String releasedate = request.getParameter("releasedate");
		String category = request.getParameter("category");
		String description = request.getParameter("description");
		Drink newDrink = new Drink(drinkname, releasedate, category, description);
		menuDAO.insertDrink(newDrink);
		response.sendRedirect("list");
	}
}
