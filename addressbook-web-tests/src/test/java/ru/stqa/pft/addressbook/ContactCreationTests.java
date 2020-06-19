package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    initContactCreation();
    fillContactForm(new ContactData("Petr", "Petrovich", "Petrov", "Pet", "Trainee", "XYZ", "Moscow", "1234567890", "0987654321", "13579", "petr.petrov@mail.ru", "18", "June", "1992", "18", "December", "2020", "Test group 1"));
    submitContactCreation();
    gotoHomePage();
  }
}
