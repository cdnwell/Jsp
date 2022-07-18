package config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBManager {
	private static DBManager instance = new DBManager();
	private SqlSessionFactory sqlSessionFactory;
	
	private DBManager() {
		String resource = "config/mybatis-config.xml";
		
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static DBManager getInstance() {
		if(instance == null)
			instance = new DBManager();
		
		return instance;
	}
	
	public SqlSession getSession() {
		return sqlSessionFactory.openSession(true);		//true값을 넣어주면 자동으로 커밋이 된다.
//		return sqlSessionFactory.openSession();			//수동으로 커밋을 해주어야 한다.
	}
	
}
