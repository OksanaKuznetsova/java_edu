package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getContactHelper().createContact(new ContactData("Petr", "Petrovich", "Petrov", "Pet", "Trainee", "XYZ", "Moscow", "1234567890", "0987654321", "13579", "petr.petrov@mail.ru", "18", "June", "1992", "18", "December", "2020", "Renamed name 1"));
    app.getNavigationHelper().goToHomePage();
  }
}
