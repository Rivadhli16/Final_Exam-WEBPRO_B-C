package menu.crud.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import menu.crud.model.Menu;
import menu.crud.model.Drink;

public class MenuDAO {
	private String url = "jdbc:mysql://localhost:3306/food";
	private String user = "root";
	private String pass = "";

	private static final String INSERT_MENUS_SQL = "INSERT INTO menus" + "  (foodname, releasedate, category, description) VALUES "
			+ " (?, ?, ?, ?);";

	private static final String SELECT_MENU_BY_ID = "select id,foodname,releasedate,category,description from menus where id =?";
	private static final String SELECT_ALL_MENUS = "select * from menus";
	private static final String DELETE_MENUS_SQL = "delete from menus where id = ?;";
	private static final String UPDATE_MENUS_SQL = "update menus set foodname = ?, releasedate= ?, category =?, description =? where id = ?;";

	private static final String INSERT_DRINKS_SQL = "INSERT INTO menus" + "  (drinkname, releasedate, category, description) VALUES "
			+ " (?, ?, ?, ?);";

	private static final String SELECT_DRINK_BY_ID = "select id,drinkname,releasedate,category,description from drinks where id =?";
	private static final String SELECT_ALL_DRINKS = "select * from drinks";
	private static final String DELETE_DRINKS_SQL = "delete from drinks where id = ?;";
	private static final String UPDATE_DRINKS_SQL = "update drinks set drinkname = ?, releasedate= ?, category =?, description =? where id = ?;";
	
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	// insert menu
	public void insertMenu(Menu menu) throws SQLException {
//		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MENUS_SQL)) {
			preparedStatement.setString(1, menu.getFoodname());
			preparedStatement.setString(2, menu.getReleasedate());
			preparedStatement.setString(3, menu.getCategory());
			preparedStatement.setString(4, menu.getDescription());
//			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//insert drink
	public void insertDrink(Drink drink) throws SQLException {
//		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DRINKS_SQL)) {
			preparedStatement.setString(1, drink.getDrinkname());
			preparedStatement.setString(2, drink.getReleasedate());
			preparedStatement.setString(3, drink.getCategory());
			preparedStatement.setString(4, drink.getDescription());
//			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// update menu
	public boolean updateMenu(Menu menu) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_MENUS_SQL);) {
			statement.setString(1, menu.getFoodname());
			statement.setString(2, menu.getReleasedate());
			statement.setString(3, menu.getCategory());
			statement.setString(4, menu.getDescription());
			statement.setInt(5, menu.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	// update drink
	public boolean updateDrink(Drink drink) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_DRINKS_SQL);) {
			statement.setString(1, drink.getDrinkname());
			statement.setString(2, drink.getReleasedate());
			statement.setString(3, drink.getCategory());
			statement.setString(4, drink.getDescription());
			statement.setInt(5, drink.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	// select menu by id
	public Menu selectMenu(int id) {
		Menu menu = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MENU_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String foodname = rs.getString("foodname");
				String releasedate = rs.getString("releasedate");
				String category = rs.getString("category");
				String description = rs.getString("description");
				menu = new Menu(id, foodname, releasedate, category, description);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return menu;
	}
	
	// select drink by id
	public Drink selectDrink(int id) {
		Drink drink = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DRINK_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String drinkname = rs.getString("drinkname");
				String releasedate = rs.getString("releasedate");
				String category = rs.getString("category");
				String description = rs.getString("description");
				drink = new Drink(id, drinkname, releasedate, category, description);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return drink;
	}
	
	// select Menu
	public List<Menu> selectAllMenus() {
		List<Menu> menus = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MENUS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String foodname = rs.getString("foodname");
				String releasedate = rs.getString("releasedate");
				String category = rs.getString("category");
				String description = rs.getString("description");
				menus.add(new Menu(id, foodname, releasedate, category, description));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return menus;
	}
	
	// select Menu
		public List<Drink> selectAllDrinks() {
			List<Drink> drinks = new ArrayList<>();
			// Step 1: Establishing a Connection
			try (Connection connection = getConnection();
					// Step 2:Create a statement using connection object
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DRINKS);) {
				System.out.println(preparedStatement);
				// Step 3: Execute the query or update query
				ResultSet rs = preparedStatement.executeQuery();

				// Step 4: Process the ResultSet object.
				while (rs.next()) {
					int id = rs.getInt("id");
					String drinkname = rs.getString("drinkname");
					String releasedate = rs.getString("releasedate");
					String category = rs.getString("category");
					String description = rs.getString("description");
					drinks.add(new Drink(id, drinkname, releasedate, category, description));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return drinks;
		}
	
	public boolean deleteMenu(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_MENUS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	
	//delete drink
	public boolean deleteDrink(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_DRINKS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	
}
