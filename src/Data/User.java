package Data;

import java.io.Serializable;

/**
 * @author Chuxing, Fang
 * @version 1.0
 * Abstract class of all the users in the software
 */
public  class User implements Serializable {
    private String userId;
    private String userName;
    private String passWord;
    private String telephone;
    private String sex;

    public User(String userId, String userName, String passWord, String telephone, String sex) {
        this.userId = userId;
        this.userName = userName;
        this.passWord = passWord;
        this.telephone = telephone;
        this.sex = sex;
    }

    public User(){

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

}
