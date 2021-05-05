/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.text.ParseException;
import java.util.ArrayList;
import model.dto.KhachThue;

/**
 *
 * @author vutrongquang29092001
 */
public class KhachThueDAO {

    ArrayList<KhachThue> list = List.listKT();

    public ArrayList<KhachThue> get() {
        return this.list;
    }

    public KhachThue search(String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaGianHang().equals(id) == true) {
                return list.get(i);
            }
        }
        return null;
    }

    public Boolean add(KhachThue khachThue) {
        if (search(khachThue.getMaGianHang()) == null) {
            list.add(khachThue);
            return true;
        } else {
            return false;
        }
    }

    public Boolean delete(String id) {

        if (search(id) != null) {

            return list.remove(search(id));

        } else {
            return false;
        }
    }

    public Boolean update(KhachThue khachThue) {
        KhachThue temp = search(khachThue.getMaGianHang());
        if (temp != null) {
            temp.setName(khachThue.getName());
            temp.setAddress(khachThue.getAddress());
            temp.setStartTime(khachThue.getStartTime());
            temp.setEndsTime(khachThue.getEndsTime());
            temp.setTienCoc(khachThue.getTienCoc());
            return true;
        }
        return false;
    }
}
