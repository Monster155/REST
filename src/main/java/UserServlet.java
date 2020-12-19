import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        if (req.getParameter("all") != null) {
            StringBuilder sb = new StringBuilder();
            ArrayList<User> users = UsersDAO.here.getAllUsers();
            if (users.size() == 0) {
                out.print("Database is empty!");
            } else {
                for (User user : users) {
                    sb.append(user.toString()).append("\n");
                }
                out.print(sb.toString());
            }
        } else {
            out.print(UsersDAO.here.getUser(
                    new User(req.getParameter("name"), Integer.parseInt(req.getParameter("age")), false)));
        }
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String isVip = req.getParameter("isVip");
        if (name == null || age == null || isVip == null) {
            out.print("Check data for correct");
        } else {
            out.print("User added");
            UsersDAO.here.add(new User(name, Integer.parseInt(age), Boolean.parseBoolean(isVip)));
        }
        out.flush();
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String newVipState = req.getParameter("newVip");
        if (name == null || age == null || newVipState == null) {
            out.print("Check data for correct");
        } else {
            out.print("User updated");
            UsersDAO.here.update(new User(name, Integer.parseInt(age), Boolean.parseBoolean(newVipState)));
        }
        out.flush();
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        if (name == null || age == null) {
            out.print("Check data for correct");
        } else {
            out.print("User deleted");
            UsersDAO.here.delete(new User(name, Integer.parseInt(age), false));
        }
        out.flush();
    }
}
