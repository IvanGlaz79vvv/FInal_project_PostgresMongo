package org.example;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
       /* String sqlUsers = "create table if not exists \"Users\" (\n" +
                "id int generated always as identity,\n" +
                "name varchar(50) not null,\n" +
                "primary key(id)\n" +
                ");";

//        String sqlContacts = "create table \"Contacts\"(\n" +
//                "id int generated always as identity,\n" +
//                "\"customerId\" int,\n" +
//                "\"contactName\" varchar(255) not null,\n" +
//                "phone varchar(50),\n" +
//                "email varchar(100),\n" +
//                "primary key (id),\n" +
//                "constraint \"fk_Users_Contacts\"\n" +
//                "foreign key(\"customerId\")\n" +
//                "references \"Users\"(id)\n" +
//                ");";

        String sqlContacts = "create table if not exists \"Contacts\"(\n" +
                "id int generated always as identity,\n" +
                "customerId int ,\n" +
                "contactName varchar(255) not null,\n" +
                "phone varchar(20),\n" +
                "email varchar(100),\n" +
                "primary key(id),\n" +
                "constraint fk_Users_Contacts\n" +              //fk_Users_Contacts\n" +       //fk_customer\n" +
                "foreign key(\"customerid\")\n" +
                "references \"Users\"(id)\n" +
                ");";

        String sqlTest = "create table \"tablicatest\"\n(" +
                "    employe_id int \n" +
                "    primary key,\n" +
                "    first_name    text,\n" +
                "    last_name     text,\n" +
                "    email         text,\n" +
                "    phone_number  text,\n" +
                "    hire_date     text,\n" +
                "    job_id        text,\n" +
                "    salary        text,\n" +
                "    comission_pct text\n" +
                ");";

        //////////////////////////////////////////
        *//**Создание таблицы*//*
        CreateTable.getcreateTable(sqlUsers);
        CreateTable.getcreateTable(sqlContacts);
        CreateTable.getcreateTable(sqlTest);

        *//**Внесение данных*//*
        String insertUsers = "INSERT INTO \"Users\" (name) VALUES(";
        BufferedReader brUsers = new BufferedReader(new FileReader("Binder1_work (2).csv"));
        while (brUsers.ready()) {
            InsertToTable.getInsertToTable(insertUsers, brUsers);
        }
        System.out.println("Users end\n");
        brUsers.close();

        //>>>>>>>>>>>>>>>>>>>>>>>
        String insertContacts = "INSERT INTO \"Contacts\" (contactName, phone, email) VALUES(";
        BufferedReader brContacts = new BufferedReader(new FileReader("Binder1_work (3).csv"));
        while (brContacts.ready()) {
            InsertToTable.getInsertToTable(insertContacts, brContacts);
        }
        System.out.println("Contacts end\n");
        brContacts.close();

        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        String insertTest = "INSERT INTO \"tablicatest\" (employe_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, comission_pct) VALUES(";
        BufferedReader brTest = new BufferedReader(new FileReader("Binder1_work.csv"));
        while (brTest.ready()) {
            InsertToTable.getInsertToTable(insertTest, brTest);
        }
        System.out.println("tablicatest end\n");
        brTest.close();
*/
//-------------Задания-----------------------------
        /**
         //<<<<<<вывод всех имен и Employee ID>>>>>>>get_Id_Name()
         System.out.println();
         for (String s : SelectFormTable.get_Id_Name()) {
         System.out.println(s);
         }

         //<<<<<<вывод фамилии и даты рождения>>>>>>>get_LastName_HireDate()
         System.out.println();
         for (String s : SelectFormTable.get_LastName_HireDate()) {
         System.out.println(s);
         }

         //<<<<<<вывод имени и фамилии и Employee ID в порядке убывания номера Employee ID>>>>>>>get_Id_FirstName_LastName_HireDate_DescendingOrder()
         System.out.println();
         for (String s : SelectFormTable.get_Id_FirstName_LastName_HireDate_DescendingOrder()) {
         System.out.println(s);
         }
         */
//<<<<<<получение и вывод Json>>>>>>>get_All_to_JSONArray
        for (JSONArray s : SelectFormTable.get_All_to_JSONArray())
//            System.out.println(s.get(0) + " " + s.get(1) + " " + s.get(7));
            System.out.println(
                    "employe_id: " + s.get(0) + "\n\t" +
                            "first_name: " + s.get(1) + "\n\t" +
                            "last_name: " + s.get(2) + "\n\t" +
                            "email: " + s.get(3) + "\n\t" +
                            "phone_number: " + s.get(4) + "\n\t" +
                            "hire_date: " + s.get(5) + "\n\t" +
                            "job_id: " + s.get(6) + "\n\t" +
                            "salary: " + s.get(7) + "\n\t" +
                            "comission_pct: " + s.get(8) + "\n\t"
            );
    }
}