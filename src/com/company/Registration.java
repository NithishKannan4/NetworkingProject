package com.company;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

class Register implements Serializable {
    private String fname,lname,gender,mm,mob,city,pass,mail;
    private int dd,yyyy,pin;
    public String getFname() {
        return fname;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }
    public String getLname() {
        return lname;
    }
    public void setLname(String lname) {
        this.lname = lname;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getMm() {
        return mm;
    }
    public void setMm(String mm) {
        this.mm = mm;
    }
    public String getMob() {
        return mob;
    }
    public void setMob(String mob) {
        this.mob = mob;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public int getDd() {
        return dd;
    }
    public void setDd(int dd) {
        this.dd = dd;
    }
    public int getYyyy() {
        return yyyy;
    }
    public void setYyyy(int yyyy) {
        this.yyyy = yyyy;
    }
    public int getPin() {
        return pin;
    }
    public void setPin(int pin) {
        this.pin = pin;
    }
}

public class Registration extends Frame {
    Register obj1 = new Register();
    Registration() throws IOException, ClassNotFoundException {
        ServerSocket ss = new ServerSocket(5000);
        Socket s = ss.accept();
        setTitle("Registration");
        setBounds(100,80,564,750);
        setLayout(null);
        setBackground(new Color(97, 146, 213));
        setResizable(false);
        setVisible(true);
        setFont(new Font("Times New Roman", Font.PLAIN,22));
        Label title,fname,lname,gen,dob,mail,mob,city,pin,pass,cpass;
        TextField fnameT,lnameT,mailT,mobT,pinT,passT,cpassT;
        title = new Label("REGISTRATION PAGE"); title.setBounds(122,53,320,33);
        title.setFont(new Font("Times New Roman",Font.BOLD,30)); add(title);
        fname = new Label("First Name:"); fname.setBounds(33,170,119,27);
        lname = new Label("Last Name:"); lname.setBounds(33,217,116,27);
        gen = new Label("Gender:"); gen.setBounds(33,264,81,27);
        dob = new Label("Date of Birth:"); dob.setBounds(33,311,139,27);
        mail = new Label("E - Mail:"); mail.setBounds(33,358,90,27);
        mob = new Label("Mobile Number:"); mob.setBounds(33,405,168,27);
        city = new Label("City:"); city.setBounds(33,452,50,27);
        pin = new Label("Pin Code:"); pin.setBounds(33,499,99,27);
        pass = new Label("Password:"); pass.setBounds(33,546,103,27);
        cpass = new Label("Confirm Password:"); cpass.setBounds(33,593,194,27);
        add(title);add(fname);add(lname);add(gen);add(dob);add(mail);add(mob);add(city);add(pin);add(pass);add(cpass);
        fnameT = new TextField(); fnameT.setBounds(235,170,296,27);
        lnameT = new TextField(); lnameT.setBounds(235,217,296,27);
        mailT = new TextField(); mailT.setBounds(235,358,296,27);
        mobT = new TextField(); mobT.setBounds(235,405,296,27);
        pinT = new TextField(); pinT.setBounds(235,499,296,27);
        passT = new TextField(); passT.setBounds(235,546,296,27);
        cpassT = new TextField(); cpassT.setBounds(235,593,296,27);
        passT.setEchoChar('●');
        cpassT.setEchoChar('●');
        add(fnameT); add(lnameT); add(mailT); add(mobT); add(pinT); add(passT); add(cpassT);
        CheckboxGroup genC = new CheckboxGroup();
        Checkbox male = new Checkbox("Male",genC,false); male.setBounds(235,264,148,27); add(male);
        Checkbox female = new Checkbox("Female",genC,false); female.setBounds(383,264,148,27); add(female);
        Choice date = new Choice(); date.setBounds(235,311,83,27); add(date);
        date.add("1"); date.add("2"); date.add("3"); date.add("4"); date.add("5"); date.add("6"); date.add("7"); date.add("8"); date.add("9"); date.add("10");
        date.add("11"); date.add("12"); date.add("13"); date.add("14"); date.add("15"); date.add("16"); date.add("17"); date.add("18"); date.add("19"); date.add("20");
        date.add("21"); date.add("22"); date.add("23"); date.add("24"); date.add("25"); date.add("26"); date.add("27"); date.add("28"); date.add("29"); date.add("30"); date.add("31");
        Choice month = new Choice(); month.setBounds(342,311,83,27); add(month);
        month.add("Jan"); month.add("Feb"); month.add("Mar"); month.add("April"); month.add("May"); month.add("June");
        month.add("July"); month.add("Aug"); month.add("Sep"); month.add("Oct"); month.add("Nov"); month.add("Dec");
        Choice year = new Choice(); year.setBounds(449,311,83,27); add(year);
        year.add("1997"); year.add("1998"); year.add("1999"); year.add("2000"); year.add("2001"); year.add("2002");
        Choice cityL = new Choice(); cityL.setBounds(235,452,296,27); add(cityL);
        cityL.add("Coimbatore"); cityL.add("Chennai"); cityL.add("Trichy"); cityL.add("Thanjavur"); cityL.add("Bangalore"); cityL.add("Madurai");
        Checkbox term = new Checkbox(" I accept the terms & conditions.");
        term.setBounds(33,640,330,27); add(term);
        Label err = new Label("Passwords does not match"); err.setBounds(33,123,260,27); add(err); err.setVisible(false);
        Button submit = new Button("Submit"); submit.setBounds(223,683,118,33); add(submit);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if((!(passT.getText().equals(cpassT.getText()))) || genC.equals(false) || !(term.getState())) {
                    err.setVisible(true);
                    return;
                }
                else {
                    err.setVisible(false);
                    obj1.setFname(fnameT.getText());
                    obj1.setLname(lnameT.getText());
                    obj1.setGender(genC.getSelectedCheckbox().getLabel());
                    obj1.setDd(Integer.parseInt(date.getSelectedItem()));
                    obj1.setMm(month.getSelectedItem());
                    obj1.setMail(mailT.getText());
                    obj1.setYyyy(Integer.parseInt(year.getSelectedItem()));
                    obj1.setMob(mobT.getText());
                    obj1.setCity(cityL.getSelectedItem());
                    obj1.setPin(Integer.parseInt(pinT.getText()));
                    obj1.setPass(passT.getText());
                    try {
                        ObjectOutputStream out1 = new ObjectOutputStream(s.getOutputStream());
                        out1.writeObject(obj1);
                        ss.close();
                    }
                    catch (Exception e11) {}
                }
            }
        });
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new Registration();
    }
}