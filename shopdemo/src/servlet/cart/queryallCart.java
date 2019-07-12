package servlet.cart;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.goods.goods_dao;
import dao.goods.impl.goods_impl;
import entitys.Cartitems;


@WebServlet("/queryallcart")
public class queryallCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		goods_dao queryalldao= new goods_impl();
		List<Cartitems> list = queryalldao.quertallcart();
		request.setAttribute("cartitemslist", list);
		request.getRequestDispatcher("/jsps/cart/cart.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
