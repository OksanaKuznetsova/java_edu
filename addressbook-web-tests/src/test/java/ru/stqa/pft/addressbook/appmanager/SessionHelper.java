package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.LoginAccountData;

public class SessionHelper extends HelperBase {

  public SessionHelper(WebDriver wd) {
    super(wd);
  }

  public void login(LoginAccountData loginAccountData) {
    type(By.name("user"), loginAccountData.getUsername());
    type(By.name("pass"), loginAccountData.getPassword());
    click(By.xpath("//input[@value='Login']"));
  }

}
