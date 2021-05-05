/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_oop;

import model.dao.List;
import java.util.ArrayList;
import java.util.Date;
import model.dao.GianHangCCDAO;
import model.dao.KhachThueDAO;
import model.dto.GianHang;
import model.dto.GianHangCC;
import model.dto.KhachThue;

/**
 *
 * @author vutrongquang29092001
 */
public class NewClass {

    public static void main(String[] args) {
//        GianHangCCDAO dao = new GianHangCCDAO();
//        ArrayList<GianHang> list = dao.get();
//        GianHang gh;
//        GianHang gh1 = new GianHangCC("3", 234, "uuuuu", 21, 23);
////        GianHangCC gh1 = new GianHangCC();
////        GianHang g = gh;
////        System.out.println(g);
////         gh = (GianHangCC) g;
////         System.out.println(gh);
////        GianHangCC gh2 = new GianHangCC("3", 234, "fgggrg", 21, 23);
////        GianHangCC gh3 = new GianHangCC("4", 234, "fgggrg", 21, 23);
////        GianHangCC gh4 = new GianHangCC("5", 234, "fgggrg", 21, 23);
////        GianHangCC gh5 = new GianHangCC("6", 234, "fgggrg", 21, 23);
////        GianHangCC gh6 = new GianHangCC("7", 234, "fgggrg", 21, 23);
////        GianHangCC gh7 = new GianHangCC("8", 234, "fgggrg", 21, 23);
////        list.add(gh);
////        list.add(gh1);
////        list.add(gh2);
////        list.add(gh3);
////        list.add(gh4);
////        list.add(gh5);
////        list.add(gh6);
////        list.add(gh7);
//
//        list = List.listGhCC();
//        gh = dao.search("3");
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
//        dao.add(gh);
//        System.out.println("...................");
//        System.out.println(gh);
//
//        System.out.println("...................");
//        for (int i = 0; i < dao.get().size(); i++) {
//            System.out.println(dao.get().get(i));
//        }
//        System.out.println(dao.get().remove(gh));
//        System.out.println( dao.update(gh1));
//        list = dao.get();
//        System.out.println("..................");
//        for (int i = 0; i < dao.get().size(); i++) {
//            System.out.println(dao.get().get(i));
//        }

        KhachThue kt = new KhachThue();
        KhachThueDAO ktdao = new KhachThueDAO();
        KhachThue kt6 = new KhachThue("huy", "ktxbk", new Date(2001, 12, 11), new Date(2001, 12, 11), "7", 343);
        System.out.println(ktdao.delete("7"));
        for (int i = 0; i < ktdao.get().size(); i++) {
            System.out.println(ktdao.get().get(i));
        };
    }

}
