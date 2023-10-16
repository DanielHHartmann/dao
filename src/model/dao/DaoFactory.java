package model.dao;

import db.DB;
import model.dao.impl.TesteDaoJDBC;

public class DaoFactory {
	public static TesteDao createTesteDao() {
		return new TesteDaoJDBC(DB.getConnection());
	}
}
