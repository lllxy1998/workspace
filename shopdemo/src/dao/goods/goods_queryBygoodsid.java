package dao.goods;

import entitys.Goods;

public interface goods_queryBygoodsid {
	public Goods queryBygoodsid(int id);
	public void insertitem(Goods goods,int userid);
}
