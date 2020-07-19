package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  File photo = new File("src/test/resources/morty.jpg");
  ContactData contact = new ContactData()
          .withLastname("Petrov").withFirstname("Petr").withMiddlename("Petrovich").withNickname("Pet").withPhoto(photo).withTitle("Trainee")
          .withCompany("XYZ").withAddress("Moscow").withHomephone("1234567890").withMobilephone("0987654321").withWorkphone("13579")
          .withEmail("petr.petrov@mail.ru").withBday("18").withBmonth("June").withByear("1992").withGroup("Group 1");

  @BeforeMethod
  public void ensurePreconditions() {
    // check if necessary group exists before contact creation
    app.goTo().groupPage();
    if (!app.group().isThereASpecificGroup(contact.getGroup())) {
      app.group().create(new GroupData().withName(contact.getGroup()));
    }
  }

  @Test
  public void testContactCreation() throws Exception {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

  @Test (enabled = false)
  public void testCurrentDir () {
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/morty.jpg");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());

  }
}
