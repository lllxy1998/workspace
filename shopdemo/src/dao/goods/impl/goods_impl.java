package dao.goods.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.goods.goods_dao;
import entitys.Cartitems;
import entitys.Goods;
import entitys.User;
import utils.JdbcUtils;

public class goods_impl implements goods_dao{
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	@Override
	public List<Goods> queryAll() {
		List<Goods> list = new ArrayList<>();
		Goods goods = null;
		try {
			conn = JdbcUtils.getConnection();
		} catch (SQLException e) {
			System.out.println("数据库连接失败");
			e.printStackTrace();
		}
		String sql = "select * from goods";
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				goods = new Goods();
				goods.setId(rs.getInt("id"));
				goods.setName(rs.getString("gname"));
				goods.setPrice(rs.getDouble("gprice"));
				list.add(goods);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//关闭资源
			JdbcUtils.closeRes(conn, ps, rs);
		}
		
		return list;
	}
	
	public List<Cartitems> quertallcart() {
		List<Cartitems> list = new ArrayList<>();
		try {
			conn = JdbcUtils.getConnection();
		} catch (SQLException e) {
			System.out.println("数据库连接失败");
			e.printStackTrace();
		}
		String selectsql = "select * from cartitems";
		try {
			ps =conn.prepareStatement(selectsql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Cartitems cartitem = new Cartitems();
				cartitem.setCount(rs.getInt("count"));
				cartitem.setGoodsid(rs.getInt("goodsid"));
				cartitem.setGoodsname(rs.getString("goodsname"));
				cartitem.setId(rs.getInt("id"));
				cartitem.setTotalprice(rs.getDouble("totalprice"));
				cartitem.setUserid(rs.getInt("userid"));
				list.add(cartitem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//关闭资源
			JdbcUtils.closeRes(conn, ps, rs);
		}
		return list;
	}


}
