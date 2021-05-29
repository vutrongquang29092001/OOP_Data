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
// class tên KhachThueDAO phạm vi truy cập public 
public class KhachThueDAO implements KhachThueInterface {
// khai báo thuộc tính tên list kiểu dữ liệu ArrayList<KhachThue>
// gán list = List.listKT()

    private ArrayList<KhachThue> list = List.listKT();

    // method lấy danh sách KhachThue kiểu dữ liệu trả về ArrayList<KhachThue>
    @Override
    public ArrayList<KhachThue> get() {
        return this.list;
    }

    // method tim kiếm khachThue bằng maGianHang , tham số truyền vào có kiểu dữ liệu String, kiểu dữ liệu trả về là một đối tượng KhachThue 
    @Override
    public KhachThue search(String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaGianHang().equals(id) == true) {
                return list.get(i);
            }
        }
        return null;
    }

    // method thêm một đối tượng KhachThue vào list, kiểu dữ liệu tham số truyền là một đối tượng KhachThue , kiểu dữ liệu trả là boolean 
    @Override
    public Boolean add(KhachThue khachThue) {
        if (search(khachThue.getMaGianHang()) == null) {
            list.add(khachThue);
            return true;
        } else {
            return false;
        }
    }

    // method xóa một KhachThue theo maGianHang , kiểu tham số truyền vào là String, kiểu dữ liệu trả về Boolean 
    @Override
    public Boolean delete(String id) {

        if (search(id) != null) {

            return list.remove(search(id));

        } else {
            return false;
        }
    }

    // method chỉnh sửa thông tin KhachThue , Kiểu dữ liệu tham số truyền vào là KhachThue , kiểu dữ liệu trả về Boolean 
    @Override
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
