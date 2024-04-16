import java.sql.*;
//Также была добавлена зависимость в Maven

public class DataBaseConnectionTest {
	public static void main(String[] args) {
		Connection connection;
		Statement statement;
		String url = "jdbc:postgresql://localhost:5432/test";
		String user = "postgres";
		String password = "123";
		try {
			connection = DriverManager.getConnection(url, user, password);
			statement = connection.createStatement();
			//Добавление или удаление данных из таблицы
			statement.executeUpdate("");
			//Получение данных из таблицы
			ResultSet result = statement.executeQuery("SELECT * FROM employees ORDER BY id ASC LIMIT 100;");
			//Вывод полученных данных
			while (result.next()) {
				int id = result.getInt("id");
				String col1 = result.getString("firstname");
				String col2 = result.getString("lastname");

				System.out.println("id " + id);
				System.out.println("firstname " + col1);
				System.out.println("lastname " + col2);
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