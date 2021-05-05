/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dto.GianHang;
import model.dto.GianHangCC;
import model.dto.GianHangTC;
import model.dto.KhachThue;

/**
 *
 * @author vutrongquang29092001
 */
public class List {

    public static ArrayList<GianHang> listGhCC() {
        ArrayList<GianHang> list = new ArrayList<>();

        GianHangCC gh = new GianHangCC("1", 234, "fgggrg", 21, 23);

        GianHangCC gh1 = new GianHangCC("2", 234, "fgggrg", 21, 23);
        GianHangCC gh2 = new GianHangCC("3", 234, "fgggrg", 21, 23);
        GianHangCC gh3 = new GianHangCC("4", 234, "fgggrg", 21, 23);
        GianHangCC gh4 = new GianHangCC("5", 234, "fgggrg", 21, 23);
        GianHangCC gh5 = new GianHangCC("6", 234, "fgggrg", 21, 23);
        GianHangCC gh6 = new GianHangCC("7", 234, "fgggrg", 21, 23);
        GianHangCC gh7 = new GianHangCC("8", 234, "fgggrg", 21, 23);
        list.add(gh);
        list.add(gh1);
        list.add(gh2);
        list.add(gh3);
        list.add(gh4);
        list.add(gh5);
        list.add(gh6);
        list.add(gh7);
        return list;

    }

    public static ArrayList<GianHang> listGhTC() {
        ArrayList<GianHang> list = new ArrayList<>();
        GianHangTC gh = new GianHangTC("1", 23, "DHBK", "tot", "tot");
        GianHangTC gh1 = new GianHangTC("2", 23, "DHBK", "tot", "tot");
        GianHangTC gh2 = new GianHangTC("3", 23, "DHBK", "tot", "tot");
        GianHangTC gh3 = new GianHangTC("4", 23, "DHBK", "tot", "tot");
        GianHangTC gh4 = new GianHangTC("5", 23, "DHBK", "tot", "tot");
        GianHangTC gh5 = new GianHangTC("6", 23, "DHBK", "tot", "tot");
        GianHangTC gh6 = new GianHangTC("7", 23, "DHBK", "tot", "tot");
        GianHangTC gh7 = new GianHangTC("8", 23, "DHBK", "tot", "tot");
        GianHangTC gh8 = new GianHangTC("9", 23, "DHBK", "tot", "tot");
        list.add(gh);
        list.add(gh1);
        list.add(gh2);
        list.add(gh3);
        list.add(gh4);
        list.add(gh5);
        list.add(gh6);
        list.add(gh7);
        list.add(gh8);
        return list;
    }

    public static ArrayList<KhachThue> listKT() {
        ArrayList<KhachThue> list = new ArrayList<>();
        Calendar c1 = Calendar.getInstance();
        DateFormat df1 = new SimpleDateFormat("yyyy/MM/dd");
        Date date1;
        try {
            date1 = df1.parse("2001/12/11");
            c1.setTime(date1);
        } catch (ParseException ex) {
              System.out.println("erre");
            Logger.getLogger(List.class.getName()).log(Level.SEVERE, null, ex);
          
        }
        
        KhachThue kt = new KhachThue("quang", "dhbk", c1.getTime(), c1.getTime(), "1", 343);
        KhachThue kt1 = new KhachThue("khoa", "dhbk", c1.getTime(), c1.getTime(), "2", 343);
        KhachThue kt2 = new KhachThue("khoi", "dhbk", c1.getTime(), c1.getTime(), "3", 343);
        KhachThue kt3 = new KhachThue("hieu", "dhbk", c1.getTime(), c1.getTime(), "4", 343);
        KhachThue kt4 = new KhachThue("khanh", "dhbk", c1.getTime(), c1.getTime(), "5", 343);
        KhachThue kt5 = new KhachThue("son", "dhbk", c1.getTime(), c1.getTime(), "6", 343);
        KhachThue kt6 = new KhachThue("huy", "dhbk", c1.getTime(), c1.getTime(), "7", 343);
        list.add(kt);
        list.add(kt1);
        list.add(kt2);
        list.add(kt3);
        list.add(kt4);
        list.add(kt5);
        list.add(kt6);
        return list;


        /*   private String name;
    private String address;
    private Date startTime;
    private Date endTime;
    private String maGianHang;
    private int tienCoc;*/
    }
}
