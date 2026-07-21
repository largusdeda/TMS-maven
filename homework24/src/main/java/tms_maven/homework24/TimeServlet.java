package tms_maven.homework24;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@WebServlet("/time")
public class TimeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String city = req.getParameter("city");

            if (city == null || city.isEmpty()) {
                resp.sendError(400, "Параметр 'city' обязателен");
                return;
            }

            city = city.toLowerCase();

            ZoneId zone;
            switch (city) {
                case "minsk":
                    zone = ZoneId.of("Europe/Minsk");
                    break;
                case "washington":
                    zone = ZoneId.of("America/New_York");
                    break;
                case "beijing":
                    zone = ZoneId.of("Asia/Shanghai");
                    break;
                default:
                    resp.sendError(400, "Город не найден. Доступны Минск, Вашингот, Пекин");
                    return;
            }

            LocalDateTime now = LocalDateTime.now(zone);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd.MM.yyyy");
            String formattedTime = now.format(formatter);

            resp.getWriter().println(formattedTime);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
