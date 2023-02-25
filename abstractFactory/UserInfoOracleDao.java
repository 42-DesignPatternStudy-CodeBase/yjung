package abstractFactory;

public class UserInfoOracleDao extends UserInfoDao {
    @Override
    public void insertUserInfo(UserInfo userInfo){
        System.out.println("insert into ORACLE DB userId =" + userInfo.getUserId() );
    }
    @Override
    public void updateUserInfo(UserInfo userInfo){
        System.out.println("update into ORACLE DB userId = " + userInfo.getUserId());
    }
    @Override
    public void deleteUserInf(UserInfo userInfo){
        System.out.println("delete from ORACLE DB userId = " + userInfo.getUserId());
    }
}
