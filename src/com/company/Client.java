package com.company;

import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new Client();
    }
    Client() throws IOException, ClassNotFoundException {
        Socket socket = new Socket("127.0.0.1",5000);
        ObjectOutputStream out1 = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in1 = new ObjectInputStream(socket.getInputStream());
        Register ob1 = (Register) in1.readObject();
        System.out.println(ob1.getFname());
        String fname,lname,gender,mm,mob,city,pass,mail;
        int dd,yyyy,pin;
        fname = ob1.getFname();
        lname = ob1.getLname();
        gender = ob1.getGender();
        dd = ob1.getDd();
        mm = ob1.getMm();
        mail = ob1.getMail();
        yyyy = ob1.getYyyy();
        mob = ob1.getMob();
        city = ob1.getCity();
        pin = ob1.getPin();
        pass = ob1.getPass();
        System.out.println("First Name: " + fname);
        System.out.println("Last Name: " + lname);
        System.out.println("Gender" + gender);
        System.out.println("Date: " + dd);
        System.out.println("Month: " + mm);
        System.out.println("Year: " + yyyy);
        System.out.println("Mobile: " + mob);
        System.out.println("E-Mail" + mail);
        System.out.println("City: " + city);
        System.out.println("Pin Code: " + pin);
        System.out.println("Password: " + pass);
        dbinsert(fname,lname,gender,mm,mob,city,pass,mail,dd,yyyy,pin);
    }
    void dbinsert(String fname,String lname,String gender,String mm,String mob,String city,String pass,String mail,int dd,int yyyy,int pin) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "nithish", "pass");
            Statement st = con.createStatement();
            String query = "insert into register values('"+fname+"','"+lname+"','"+gender+"','"+mm+"','"+mail+"','"+mob+"','"+city+"','"+pass+"',"+dd+","+yyyy+","+pin+")";
            st.executeUpdate(query);
            con.close();
            JOptionPane.showMessageDialog(null, "Success!");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"  Exception   -->"+e);
        }
    }
}