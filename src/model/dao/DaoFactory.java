package model.dao;

import db.DB;

import model.dao.impl.ItemDaoJDBC;


public class DaoFactory {

	public static ItemDao createItemDao() {
		return new ItemDaoJDBC(DB.getConnection());
	}

}
