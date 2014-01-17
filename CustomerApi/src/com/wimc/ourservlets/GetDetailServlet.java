package com.wimc.ourservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.wimc.classes.Customer;
import com.wimc.dao.CustomerDao;

/**
 * Servlet implementation class GetDetailServlet
 */
@WebServlet("/GetDetailServlet")
public class GetDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       CustomerDao dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		dao = new CustomerDao();
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session  = request.getSession();
		System.out.println("SESSION ID :" + session.getId());
		session.setMaxInactiveInterval(10);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		Customer cs = dao.getCustomer();
		
		//out.println(cs.toString());
		
		Gson gs = new Gson();
		String j_str = gs.toJson(cs);
		
		out.println(j_str);
		
		
		//out.println("{\"name\":\"Galaxy S4\",\"Price\":\"GH 2000\"}");
		
			
	}

}
