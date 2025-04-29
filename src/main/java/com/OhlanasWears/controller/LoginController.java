package com.OhlanasWears.controller;

import java.io.IOException;

import com.OhlanasWears.util.RedirectionUtil;
import com.OhlanasWears.util.ValidationUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



/**
 * LMU ID: 23048677
 * NAME: Rose Khatiwada
 */
/**

 * Servlet implementation class LoginController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/login" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ValidationUtil validationUtil;
	private RedirectionUtil redirectionUtil;

	@Override
	public void init() throws ServletException {
		this.validationUtil = new ValidationUtil();
		this.redirectionUtil = new RedirectionUtil();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(RedirectionUtil.loginUrl).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		if (validationUtil.isNullOrEmpty("username") || validationUtil.isNullOrEmpty("password")) {
			redirectionUtil.setMsgAndRedirect(req, resp, "error", "Please fill all the fields!",
					RedirectionUtil.loginUrl);
		} else {
			if (username.equals("Rose") && password.equals("Rose1509")) {
				redirectionUtil.setMsgAndRedirect(req, resp, "success", "Successfully Logged In!",
						RedirectionUtil.admindashboardUrl);
			} else {
				redirectionUtil.setMsgAndRedirect(req, resp, "error", "Either username or password is mistake!",
						RedirectionUtil.loginUrl);
			}
		}

	}
}