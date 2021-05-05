/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_oop;

import java.util.ArrayList;
import model.dao.GianHangCCDAO;

import model.dto.GianHangCC;

/**
 *
 * @author vutrongquang29092001
 */
public class Project_OOP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*   public static ArrayList<GianHangCC> listGhCC() {
        ArrayList<GianHangCC> list = new ArrayList<>();
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

    }*/
        ArrayList<GianHangCC> list = new ArrayList<>();
        GianHangCCDAO ghCCDao = new GianHangCCDAO();
        GianHangCC gh = new GianHangCC("232", 234, "fgggrg", 21, 23);
        GianHangCC gh1 = new GianHangCC("1", 234, "fgggrg", 21, 23);
//        list = ghCCDao.get();
        list.add(gh);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println(list.remove(gh1));
         System.out.println(list.remove(gh));
//        System.out.println(ghCCDao.search("1"));
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}
