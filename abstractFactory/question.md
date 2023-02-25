### 서로 연관있는 인스턴스를 한꺼번에 생성

→ 서로 연관성 있는 여러 인스턴스를 한꺼번에 생성하는 패턴

→ 추상화된 팩토리가 제공되고 그 상황에 맞는 인스턴스 세트가 생성되도록 한다

예) DAO, Widget

```java
public abstract class DaoFactory {
	public abstract UserInfoDao createUserInfoDao();
	public abstract ProductDao createProductDao();
}

public class MySqlDaoFactory extends DaoFactory{
	@Override
	public UserInfoDao createUserInfoDao() {
		return new UserInfoMySqlDao();
	}
	@Override
	public ProductDao createProductDao() {
		return new ProductMySqlDao();
	}
}
```

```java
public class UserInfoClient {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("db.properties");
        Properties prop = new Properties();
        prop.load(fis);
        String dbType = prop.getProperty("DBTYPE");
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("12345");
        userInfo.setPasswd("!@#$%");
        userInfo.setUserName("Tomas");

        Product product = new Product();
        product.setProductId("0011AA");
        product.setProductName("TV");

        DaoFactory daoFactory = null;
        UserInfoDao userInfoDao = null;
        ProductDao productDao = null;

        if (dbType.equals("ORACLE")) {
            daoFactory = new OracleDaoFactory();
        } else if (dbType.endsWith("MYSQL")) {
            daoFactory = new MySqlDaoFactory();
        } else {
            System.out.println("db support error");
            return;
        }

        userInfoDao = daoFactory.createUserInfoDao();
        productDao = daoFactory.createProductDao();

        System.out.println("==USERINFO TRANSACTION==");
        userInfoDao.insertUserInfo(userInfo);
        userInfoDao.updateUserInfo(userInfo);
        userInfoDao.deleteUserInf(userInfo);

        System.out.println("==PRODUCT TRANSACTION==");
        productDao.insertProduct(product);
        productDao.updateProduct(product);
        productDao.deleteProduct(product);
    }
}
```