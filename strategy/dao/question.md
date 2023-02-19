### **DataBase 가 변경될 때 적용될 수 있는 코드 작성하기**

---
사용하는 데이터베이스 플랫폼을 자유롭게 변경해야 하는 상황이라 가정하자.

다음 코드를 참고하여 추가적인 코드 수정없이 db.properties 환경파일의 내용만 변경하면 연결되는 DB도 바뀔 수 있도록 구현하라
```
// db.properties
DBTYPE=MYSQL
```
```java
public class UserInfo {
	private String userId;
	private String passwd;
	private String userName;
    
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
```

