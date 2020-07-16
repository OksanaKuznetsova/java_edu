package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAdressesTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData()
              .withLastname("Petrov").withFirstname("Petr").withMiddlename("Petrovich").withNickname("Pet").withTitle("Trainee")
              .withCompany("XYZ").withAddress("Moscow, Sovetskaya str., 18")
              .withHomephone("1234567890").withMobilephone("+0987654321").withWorkphone("13579")
              .withEmail("petr.petrov@mail.ru").withEmail2("petr.petrov@yandex.ru").withEmail3("petr.petrov@google.ru")
              .withBday("18").withBmonth("June").withByear("1992").withGroup("Group 1"));
    }
  }

  @Test
  public void testContactAddress() {
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));
  }

}
