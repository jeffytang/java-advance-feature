package com.twq.io.fileformat;

import com.twq.io.Person;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestXML {
    public static void main(String[] args) {
        readXMLWithDom4j();

        // writeXMLWithDom4j();
    }

    /**
     *  写 XML 文件
     */
    private static void writeXMLWithDom4j() {
        List<Person> roster = Person.createRoster();
        // 将花名册以 XML 的格式写入保存到 person_new.xml 文件中
        // 构造一个 XML 文档
        Document document = DocumentHelper.createDocument();
        // 文档下面的所有的元素构造
        Element root = document.addElement("persons");

        for (Person person : roster) {
            Element personElement = root.addElement("person");

            personElement.addElement("name").addText(person.getName());

            Element birthdayElement = personElement.addElement("birthday");
            birthdayElement.addElement("year")
                    .addText(String.valueOf(person.getBirthday().getYear()));
            birthdayElement.addElement("month")
                    .addText(String.valueOf(person.getBirthday().getMonth().getValue()));
            birthdayElement.addElement("day")
                    .addText(String.valueOf(person.getBirthday().getDayOfMonth()));

            personElement.addElement("gender").addText(person.getGender().toString());

            personElement.addElement("email").addText(person.getEmailAddress());
        }

        // 把 document 写到一个文件
        try (FileWriter writer = new FileWriter(".\\data\\person_new.xml")) {
            document.write(writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void readXMLWithDom4j() {
        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(".\\data\\person_new.xml"))) {
            // 构建一个 XML 读的实例
            SAXReader saxReader = new SAXReader();
            // 转成 Document
            Document document = saxReader.read(reader);
            // 拿到 XML 的根元素
            Element rootElement = document.getRootElement();
            // 遍历所有的 person 标签
            Iterator<Element> elementIterator = rootElement.elementIterator("person");

            List<Person> people = new ArrayList<>();
            while (elementIterator.hasNext()) {
                Element element = elementIterator.next();
                // 将一个 Element -> Person 类型的对象
                String name = element.elementText("name");

                Element birthdayElement = element.element("birthday");
                int year = Integer.parseInt(birthdayElement.elementText("year"));
                int month = Integer.parseInt(birthdayElement.elementText("month"));
                int day = Integer.parseInt(birthdayElement.elementText("day"));
                LocalDate birthday = IsoChronology.INSTANCE.date(year, month, day);

                Person.Sex gender = Person.Sex.valueOf(element.elementText("gender"));

                String emailAddress = element.elementText("email");

                Person person = new Person(name, birthday, gender, emailAddress);
                people.add(person);
            }

            System.out.println(people);
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }
    }
}
