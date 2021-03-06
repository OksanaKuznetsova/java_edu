package ru.stqa.pft.addressbook.model;

public class LoginAccountData {
  private final String username;
  private final String password;

  public LoginAccountData(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }
}
