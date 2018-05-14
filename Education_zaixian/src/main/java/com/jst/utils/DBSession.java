package com.jst.utils;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBSession {
	private static SqlSessionFactory sf;
	private static SqlSession ss;
	
	public static SqlSession getSession() {
		try {
			Reader reader = Resources.getResourceAsReader("sqlMapConfig-1.xml");
			sf = new SqlSessionFactoryBuilder().build(reader);
			ss = sf.openSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ss;
	}
	
	public static void closeSession(SqlSession ss) {
		ss.commit();
		ss.close();
	}

}
