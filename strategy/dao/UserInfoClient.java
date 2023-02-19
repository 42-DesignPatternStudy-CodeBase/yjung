package strategy.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class UserInfoClient {
        public static UserInfoDao getUserInfoDaoFromPropertyFile() throws FileNotFoundException {
                String path = System.getProperty("user.dir");

                File file = new File(path + "/strategy_2/db.properties");
                Scanner scanner = new Scanner(file);

                if (scanner.hasNextLine()) {
                        String[] dbProperty = scanner.nextLine().split("=");
                        scanner.close();
                        if (!dbProperty[0].equals("DBTYPE") || dbProperty.length != 2)
                                throw new FileNotFoundException();

                        if (dbProperty[1].equals("ORACLE"))
                                return new UserInfoOracleDao();
                        else if (dbProperty[1].equals("MYSQL"))
                                return new UserInfoMySqlDao();
                }
                throw new FileNotFoundException();
        }

        public static void main(String[] args) throws FileNotFoundException{

                UserInfoDao userInfoDao = getUserInfoDaoFromPropertyFile();

                UserInfo userInfo = new UserInfo();
                userInfo.setUserId("12345");
                userInfo.setUserName("홍길");
                userInfoDao.insertUserInfo(userInfo);

                userInfo.setUserName("홍길동");
                userInfoDao.updateUserInfo(userInfo);
                userInfoDao.deleteUserInf(userInfo);
        }
}
