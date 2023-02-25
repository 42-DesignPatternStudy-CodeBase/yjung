package abstractFactory;

public abstract class UserInfoDao {
    public abstract void insertUserInfo(UserInfo userInfo);
    public abstract void updateUserInfo(UserInfo userInfo);
    public abstract void deleteUserInf(UserInfo userInfo);
}
