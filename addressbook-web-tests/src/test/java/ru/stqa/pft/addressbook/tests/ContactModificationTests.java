package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().goToHomePage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Petr", "Petrovich", "Petrov", "Pet", "Trainee", "XYZ", "Moscow", "1234567890", "0987654321", "13579", "petr.petrov@mail.ru", "18", "June", "1992", "18", "December", "2020", null));
    }
    int before = app.getContactHelper().countContacts();
    app.getContactHelper().editContact(before - 1);
    app.getContactHelper().fillContactForm(new ContactData("Anna", "Ivanovna", "Ivanova", "Ann", "Junior Software Testing Engineer", "Roga and Kopyta", "Moscow", "123", "", "", "ann_ivan@mail.ru", "1", "January", "1990", "10", "May", "2020", null), false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().goToHomePage();
    int after = app.getContactHelper().countContacts();
    Assert.assertEquals(after, before);
  }
}
