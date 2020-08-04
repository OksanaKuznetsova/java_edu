package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().homePage();
      app.contact().create(new ContactData()
              .withLastname("Petrov").withFirstname("Petr").withMiddlename("Petrovich").withNickname("Pet").withTitle("Trainee")
              .withCompany("XYZ").withAddress("Moscow").withHomephone("1234567890").withMobilephone("0987654321").withWorkphone("13579")
              .withEmail("petr.petrov@mail.ru").withBday("18").withBmonth("June").withByear("1992"));
    }
  }

  @Test
  public void testContactModification() {
    Groups groups = app.db().groups();
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withLastname("Ivanova").withFirstname("Anna")
            .withMiddlename("Ivanovna").withNickname("Ann").withTitle("SET").withCompany("Roga&Kopyta").withAddress("Ryazan")
            .withHomephone("1234567890").withMobilephone("0987654321").withWorkphone("13579").withEmail("petr.petrov@mail.ru")
            .withBday("18").withBmonth("June").withByear("1992")
            .withPhoto(new File("src/test/resources/morty.jpg"))
            .inGroup(groups.iterator().next());
    app.goTo().homePage();
    app.contact().modify(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    verifyContactListInUi();
  }
}
