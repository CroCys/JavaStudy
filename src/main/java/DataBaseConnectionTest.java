import java.sql.*;
//Также была добавлена зависимость в Maven

public class DataBaseConnectionTest {
	public static void main(String[] args) {
		Connection connection;
		Statement statement;
		String url = "jdbc:postgresql://localhost:5432/test";
		String user = "postgres";
		String password = "qwertylang";
		try {
			connection = DriverManager.getConnection(url, user, password);
			statement = connection.createStatement();
			//Добавление или удаление данных из таблицы
			statement.executeUpdate("");
			//Получение данных из таблицы
			ResultSet result = statement.executeQuery("SELECT * FORM banks;");
			//Вывод полученных данных
			while (result.next()) {
				int id = result.getInt("id");
				String col1 = result.getString("name");
				String col2 = result.getString("address");

				System.out.println("id " + id);
				System.out.println("name " + col1);
				System.out.println("address " + col2);
			}

			result.close();
			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}
}