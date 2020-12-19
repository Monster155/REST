import java.sql.*;
import java.util.ArrayList;

public class UsersDAO {
    public static UsersDAO here;

    static {
        here = new UsersDAO();
    }

    private final String host, loginDB, passwordDB, table;

    private UsersDAO() {
        host = "jdbc:postgresql://localhost:5432/REST";
        loginDB = "postgres";
        passwordDB = "12345678";
        table = "users";
    }

    public User getUser(User user) {
        try (Connection connection = DriverManager.getConnection(host, loginDB, passwordDB);
             PreparedStatement statement = connection.prepareStatement(
                     "select * from " + table + " where name=? AND age=?;")) {
            Class.forName("org.postgresql.Driver");
            statement.setString(1, user.getName());
            statement.setInt(1, user.getAge());
            ResultSet rs = statement.executeQuery();
            if (!rs.next()) return new User("None", -1, false);
            return new User(rs.getString("name"), rs.getInt("age"), rs.getBoolean("isVip"));
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage() + " : " + e.getCause());
            return new User("None", -1, false);
        }
    }

    public ArrayList<User> getAllUsers() {
        try (Connection connection = DriverManager.getConnection(host, loginDB, passwordDB);
             PreparedStatement statement = connection.prepareStatement("select * from " + table + ";")) {
            Class.forName("org.postgresql.Driver");
            ArrayList<User> users = new ArrayList<>();
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                users.add(new User(rs.getString("name"), rs.getInt("age"), rs.getBoolean("isVip")));
            }
            return users;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage() + " : " + e.getCause());
            return null;
        }
    }

    public boolean add(User user) {
        try (Connection connection = DriverManager.getConnection(host, loginDB, passwordDB);
             PreparedStatement statement = connection.prepareStatement(
                     "insert into " + table + " (name, age, isVip) values (?, ?, ?);")) {
            Class.forName("org.postgresql.Driver");

            statement.setString(1, user.getName());
            statement.setInt(2, user.getAge());
            statement.setBoolean(3, user.isVip());

            return statement.execute();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage() + " : " + e.getCause());
            return false;
        }
    }

    public boolean update(User user) {
        try (Connection connection = DriverManager.getConnection(host, loginDB, passwordDB);
             PreparedStatement statement = connection.prepareStatement(
                     "update " + table + " set isVip=? where name=? AND age=?;")) {
            Class.forName("org.postgresql.Driver");

            statement.setBoolean(1, user.isVip());
            statement.setString(2, user.getName());
            statement.setInt(3, user.getAge());

            return statement.execute();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage() + " : " + e.getCause());
            return false;
        }
    }

    public boolean delete(User user) {
        try (Connection connection = DriverManager.getConnection(host, loginDB, passwordDB);
             PreparedStatement statement = connection.prepareStatement(
                     "delete from " + table + " where name=? AND age=?;")) {
            Class.forName("org.postgresql.Driver");

            statement.setString(1, user.getName());
            statement.setInt(2, user.getAge());

            return statement.execute();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage() + " : " + e.getCause());
            return false;
        }
    }

}
