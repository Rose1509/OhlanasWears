package com.OhlanasWears.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.OhlanasWears.service.ProductService;

/**
 * Controller for handling requests to view the clothing collection.
 * <p>
 * LMU ID: 23048677<br>
 * NAME: Rose Khatiwada
 * </p>
 */
@WebServlet("/collection")
public class CollectionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ProductService service;

	/**
	 * Constructs a new CollectionController and initializes the ProductService.
	 */
	public CollectionController() {
		super();
		service = new ProductService();
	}

	/**
	 * Handles GET requests to display the collection of clothes.
	 *
	 * @param request  the {@link HttpServletRequest} object containing the request from the client
	 * @param response the {@link HttpServletResponse} object used to respond to the client
	 * @throws ServletException if an input or output error occurs while handling the request
	 * @throws IOException      if the request for the GET cannot be handled
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("collection", service.getAllClothes());
		System.out.println(service.getAllClothes());
		request.getRequestDispatcher("/WEB-INF/pages/collection.jsp").forward(request, response);
	}

	/**
	 * Handles POST requests by redirecting them to the {@link #doGet(HttpServletRequest, HttpServletResponse)} method.
	 *
	 * @param request  the {@link HttpServletRequest} object containing the request from the client
	 * @param response the {@link HttpServletResponse} object used to respond to the client
	 * @throws ServletException if an input or output error occurs while handling the request
	 * @throws IOException      if the request for the POST cannot be handled
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
