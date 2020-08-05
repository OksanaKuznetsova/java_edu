package ru.stqa.pft.addressbook.tests;

import com.google.common.io.CharSource;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddingContactToGroupTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {

    if (app.db().contacts().size() == 0) {
      app.goTo().homePage();
      app.contact().create(new ContactData()
              .withLastname("Petrov").withFirstname("Petr").withMiddlename("Petrovich").withNickname("Pet").withTitle("Trainee")
              .withCompany("XYZ").withAddress("Moscow").withHomephone("1234567890").withMobilephone("0987654321").withWorkphone("13579")
              .withEmail("petr.petrov@mail.ru").withBday("18").withBmonth("June").withByear("1992")
              .withPhoto(new File("src/test/resources/morty.jpg"))
      .inGroup(null));
    }
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("Group1"));
    }
  }

  @Test
  public void testAddingContactToGroup() {
    ContactData contact = app.db().contacts().iterator().next();
    GroupData group = app.db().groups().iterator().next();
    Groups before = contact.getGroups();
    System.out.println(before);
    app.goTo().homePage();
    app.contact().addContactToGroup(contact, group);
    Groups after = contact.getGroups();
    System.out.println(after);
//    assertThat(after, equalTo(before.withAdded(group)));
  }
}
