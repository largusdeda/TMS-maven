package tms_maven.homework24;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/check_age")
public class AgeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String ageParam = req.getParameter("age");

            if (ageParam == null || ageParam.isEmpty()) {
                resp.sendError(400, "Параметр 'age' обязателен");
                return;
            }

            int age;
            try {
                age = Integer.parseInt(ageParam);
            } catch (NumberFormatException e) {
                resp.sendError(400, "Параметр 'age' должен быть целым числом");
                return;
            }

            if (age < 0 || age > 120) {
                resp.sendError(400, "Введен некорректный возраст");
                return;
            }

            boolean isAdult = age >= 18;

            resp.setContentType("text/html;charset=UTF-8");
            resp.getWriter().println(isAdult ? "Совершеннолетний" : "Несовершеннолетний");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
