package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().goToHomePage();
    app.getContactHelper().editContact();
    app.getContactHelper().fillContactForm(new ContactData("Anna", "Ivanovna", "Ivanova", "Ann", "Junior Software Testing Engineer", "Roga and Kopyta", "Moscow", "123", "", "", "ann_ivan@mail.ru", "1", "January", "1990", "10", "May", "2020", null), false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().returnToHomePage();
  }
}
