package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    ContactData contact = new ContactData("Petr", "Petrovich", "Petrov", "Pet", "Trainee", "XYZ", "Moscow", "1234567890", "0987654321", "13579", "petr.petrov@mail.ru", "18", "June", "1992", "18", "December", "2020", "Group 1" );

    // check if necessary group exists before contact creation
    app.getNavigationHelper().gotoGroupPage();
    if (!app.getGroupHelper().isThereASpecificGroup(contact.getGroup())) {
      app.getGroupHelper().createGroup(new GroupData(contact.getGroup(), null, null));
    }
    app.getNavigationHelper().goToHomePage();
    int before = app.getContactHelper().countContacts();
    app.getContactHelper().createContact(contact);
    app.getNavigationHelper().goToHomePage();
    int after = app.getContactHelper().countContacts();
    Assert.assertEquals(after, before + 1);
  }
}
