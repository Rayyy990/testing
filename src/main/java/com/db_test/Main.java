package com.db_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**This is the testing Main Class.
Created by: Arkar
Created Date: 5/13/2025
 */
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private String ip = "localhost";
    private String port = "3306";
    private String dbname = "test_db";
    private String username = "root";
    private String password = "";

    protected Connection get_db_connnection(){
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + port +  "/" + dbname, username, password);
            System.out.println("Successful Connection.");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return con;
    }

    private ArrayList<office> report1(Connection con){
        ArrayList<office> al = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT officeCode, state, city FROM offices"); //java ka ny sql ko hlan poh lo ya ag lok//
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                office of = new office(rs.getInt(1),rs.getString(2), rs.getString(3));
                al.add(of);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        return  al;
    }

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Main m = new Main();
        Connection con = m.get_db_connnection();
        ArrayList<office> al = m.report1(con);
        System.out.println(al);

        try {
            if (con != null){
                con.close();
                System.out.println("Connection is closed!");
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        }
    }
