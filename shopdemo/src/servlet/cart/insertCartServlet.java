package servlet.cart;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.goods.goods_queryBygoodsid;
import dao.goods.impl.goods_queryBygoosid_Impl;
import entitys.Cartitems;
import entitys.Goods;
import entitys.User;


@WebServlet("/insertCartServlet")
public class insertCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int goodsid = Integer.parseInt(request.getParameter("goodsid"));
		User user = (User)request.getSession().getAttribute("usersession");
		int userid = user.getId();
		goods_queryBygoodsid dao = new goods_queryBygoosid_Impl();
		Goods goods = dao.queryBygoodsid(goodsid);
		dao.insertitem(goods, userid);
		request.getSession().setAttribute("goods", goods);
		response.sendRedirect("/shopdemo/queryallcart");
		//request.getRequestDispatcher("/queryallcart").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
