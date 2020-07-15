package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

  ContactData contact = new ContactData()
          .withLastname("Petrov").withFirstname("Petr").withMiddlename("Petrovich").withNickname("Pet").withTitle("Trainee")
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
    List<ContactData> before = app.contact().list();
    app.contact().create(contact);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
