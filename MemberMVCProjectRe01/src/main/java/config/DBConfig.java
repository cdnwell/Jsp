package config;

public abstract class DBConfig {
	public static String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static String DB_DRIVER = "oracle.jdbc.OracleDriver";
	public static String DB_USER = "scott";
	public static String DB_PASSWD = "tiger"; 
}
