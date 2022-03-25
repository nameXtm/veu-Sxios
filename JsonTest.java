import com.google.gson.Gson;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
@WebServlet("/axios03.do")
public class JsonTest extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader reader = req.getReader();
        String str = null;
        while ((str = reader.readLine()) != null) {
            stringBuilder.append(str);
        }
        str = stringBuilder.toString();
        Gson gson = new Gson();
        User user = gson.fromJson(str, User.class);
        user.getUname("tom");
        user.getPwd("591888");

        String s = gson.toJson(user);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(s);
    }


}
