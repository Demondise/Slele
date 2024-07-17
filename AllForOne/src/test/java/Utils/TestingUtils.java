package Utils;

public class TestingUtils {

	public static void main(String[] args) {
		JdbcDataManager.setupDB();
		JdbcDataManager.runSqlquerry("create table employees(\r\n"
				+ "id INT,\r\n"
				+ "name TEXT\r\n"
				+ ");");
		JdbcDataManager.runSqlquerry("insert into employees(id,name)\r\n"
				+ "values (1,Shivam),(2,Rahu),(3,Duggu);");
		JdbcDataManager.getResult();

	}

}
