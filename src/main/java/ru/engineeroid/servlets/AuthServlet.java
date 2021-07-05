package ru.engineeroid.servlets;

import ru.engineeroid.model.User;
import ru.engineeroid.store.StoreManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(value = "/auth")
public class AuthServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        if (StoreManager.instOf().findAllUsers().isEmpty()) {
            try {
                User admin = new User().setName("Admin").setEmail("root@local").setPassword("root");
                StoreManager.instOf().add(admin);
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ("exit".equals(req.getParameter("op"))) {
            req.getSession().setAttribute("user", null);
        }
        req.getRequestDispatcher("WEB-INF/auth.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = StoreManager.instOf().findUserByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("index");
        } else {
            req.setAttribute("error", "Неверный пароль, либо пользователь с таким email не зарегистрирован!");
            req.getRequestDispatcher("WEB-INF/auth.jsp").forward(req, resp);
        }
    }
}