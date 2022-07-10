package config;

public interface DBConfig {
	final static public String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String DB_DRIVER = "oracle.jdbc.OracleDriver";
	public static final String DB_USER = "scott";
	public static final String DB_PASS = "tiger";
}
