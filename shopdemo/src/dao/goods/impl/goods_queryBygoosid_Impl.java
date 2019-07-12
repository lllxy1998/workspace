package dao.goods.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.goods.goods_queryBygoodsid;
import entitys.Cartitems;
import entitys.Goods;
import utils.JdbcUtils;
public class goods_queryBygoosid_Impl implements goods_queryBygoodsid{
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	@Override
	public Goods queryBygoodsid(int id) {
		Goods goods = new Goods();
		try {
			conn = JdbcUtils.getConnection();
		} catch (SQLException e) {
			System.out.println("数据库连接失败");
			e.printStackTrace();
		}
		String sql = "select * from goods where id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {			
				goods.setId(rs.getInt("id"));
				goods.setName(rs.getString("gname"));
				goods.setPrice(rs.getDouble("gprice"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//关闭资源
			JdbcUtils.closeRes(conn, ps, rs);
		}
		return goods;
	}
	@Override
	public void insertitem(Goods goods,int userid) {
		
		try {
			conn = JdbcUtils.getConnection();
		} catch (SQLException e) {
			System.out.println("数据库连接失败");
			e.printStackTrace();
		}
		String sql = "select * from cartitems where goodsid = ? and userid = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, goods.getId());
			ps.setInt(2, userid);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				String sql1 = "update cartitems set count = count + 1,totalprice= ? *count where goodsid = ?";
				
				ps = conn.prepareStatement(sql1);
				ps.setDouble(1, goods.getPrice());
				ps.setInt(2, goods.getId());
				ps.executeUpdate();
			}else{
				String goodsname = goods.getName();
				double totalprice = goods.getPrice()*1;
				String sql1 ="insert into cartitems(goodsid,goodsname,totalprice,userid) values(?,?,?,?)";
				ps = conn.prepareStatement(sql1);
				ps.setInt(1, goods.getId());
				ps.setString(2, goodsname);
				ps.setDouble(3, totalprice);
				ps.setInt(4, userid);
				ps.executeUpdate();
			}		
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//关闭资源
			JdbcUtils.closeRes(conn, ps, rs);
		}
		
	}
}
