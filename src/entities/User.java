package entities;

public class User extends Person {
  private String phone;
  private String nickName;

  public User() {
    super();
  }

  public User(String name, String email, String phone, String nickName) {
    super(name, email);
    this.phone = phone;
    this.nickName = nickName;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }
}
