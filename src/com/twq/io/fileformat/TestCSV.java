package com.twq.io.fileformat;

import com.twq.io.Person;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;

public class TestCSV {
    public static void main(String[] args) {
        // readPersonCSV();

        // writePersonCSV();

        // readCSVWithApacheCommons();

        writeCSVWithApacheCommons();
    }

    private static void writeCSVWithApacheCommons() {
        List<Person> roster = Person.createRoster();
        // 将花名册以 CSV 文件格式保存到 person_apache_commons.csv 这个文件中
        try (BufferedWriter writer =
                     new BufferedWriter(
                             new FileWriter(".\\data\\person_apache_commons.csv"))) {
            // 1. 拿到解析 CSV 的格式
            CSVFormat csvFormat = CSVFormat.DEFAULT
                    .withHeader("name", "year", "month", "day", "gender", "emailAddress");
            // 2. 构造一个 CSV 打印器，写 CSV 数据的
            CSVPrinter csvPrinter = csvFormat.print(writer);

            for (Person person : roster) {
                // 将 Person 中的属性的值转成一个 List 集合
                List<String> fields = new ArrayList<>();
                fields.add(person.getName());
                fields.add(String.valueOf(person.getBirthday().getYear()));
                fields.add(String.valueOf(person.getBirthday().getMonth().getValue()));
                fields.add(String.valueOf(person.getBirthday().getDayOfMonth()));
                fields.add(person.getGender().toString());
                fields.add(person.getEmailAddress());
                // 写一行记录
                csvPrinter.printRecord(fields);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *  使用 apache commons csv 读取并解析 CSV 文件
     */
    private static void readCSVWithApacheCommons() {
        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(".\\data\\person_new.csv"))) {
            // 1. 拿到解析 CSV 的格式
            CSVFormat csvFormat = CSVFormat.newFormat('\t').withFirstRecordAsHeader();
            // 2. t通过解析格式解析 CSV 文件内容
            // String line -> CSVRecord
            Iterable<CSVRecord> csvRecords = csvFormat.parse(reader);

            List<Person> people = new ArrayList<>();
            for (CSVRecord record : csvRecords) {
                // CSVRecord -> Person 类型
                String name = record.get("name");
                int year = Integer.parseInt(record.get("year"));
                int month = Integer.parseInt(record.get("month"));
                int day = Integer.parseInt(record.get("day"));
                LocalDate birthday = IsoChronology.INSTANCE.date(year, month, day);

                Person.Sex gender = Person.Sex.valueOf(record.get("gender"));

                String emailAddress = record.get("emailAddress");

                // 根据值构建 Person 对象
                Person person = new Person(name, birthday, gender, emailAddress);
                people.add(person);
            }
            System.out.println(people);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *  将 Person 类型的对象转成 CSV 文件格式的数据，并保存
     */
    private static void writePersonCSV() {
        List<Person> roster = Person.createRoster();
        // 将花名册以 CSV 文件格式保存到 person_new.csv 这个文件中
        try (BufferedWriter writer =
                     new BufferedWriter(
                             new FileWriter(".\\data\\person_new.csv"))) {
            // 定义分隔符
            String separator = "\t";
            // 写入 CSV 头(Head)
            writer.write("name" + separator + "year" + separator
                    + "month" + separator + "day" + separator + "gender"
                    + separator + "emailAddress");
            writer.newLine();
            for (Person person : roster) {
                // Person 类型的对象 --> String 类型的 line
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(person.getName());
                stringBuilder.append(separator);
                stringBuilder.append(person.getBirthday().getYear());
                stringBuilder.append(separator);
                stringBuilder.append(person.getBirthday().getMonth().getValue());
                stringBuilder.append(separator);
                stringBuilder.append(person.getBirthday().getDayOfMonth());
                stringBuilder.append(separator);
                stringBuilder.append(person.getGender().toString());
                stringBuilder.append(separator);
                stringBuilder.append(person.getEmailAddress());

                // 将一行的数据写入到文件
                writer.write(stringBuilder.toString());
                // 换行
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *  CSV 文件内容的读取和解析
     *  line -> Person 对象
     */
    private static void readPersonCSV() {
        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(".\\data\\person.csv"))) {
            List<Person> people = new ArrayList<>();
            String line = null;
            while ((line = reader.readLine()) != null) {
                // 按照逗号分隔
                String[] fields = line.split(",");

                // 计算 Person 的所有的字段的值
                String name = fields[0];

                int year = Integer.parseInt(fields[1]);
                int month = Integer.parseInt(fields[2]);
                int day = Integer.parseInt(fields[3]);
                LocalDate birthday = IsoChronology.INSTANCE.date(year, month, day);

                Person.Sex gender = Person.Sex.valueOf(fields[4]);

                String emailAddress = fields[5];

                // 根据值构建 Person 对象
                Person person = new Person(name, birthday, gender, emailAddress);

                // 将对象放到 List 集合中
                people.add(person);
            }
            System.out.println(people);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
