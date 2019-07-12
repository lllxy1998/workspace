package dao.goods;

import java.util.List;

import entitys.Cartitems;
import entitys.Goods;

public interface goods_dao {
	List<Goods> queryAll();
	public List<Cartitems> quertallcart();
}
