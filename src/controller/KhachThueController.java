/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.dao.KhachThueDAO;
import model.dto.KhachThue;

/**
 *
 * @author vutrongquang29092001
 */
// class tên KhachThueController phạm vi truy cập public 
public class KhachThueController {
    KhachThueDAO khachThueDAO = new KhachThueDAO();
    //method lấy danh sách khách thuê
    public ArrayList<KhachThue> get(){
        return khachThueDAO.get();
    }
    //method tìm kiếm khách thuê
    public KhachThue search(String id){
        return khachThueDAO.search(id);
    }
    //method thêm gian hàng 
    public Boolean add(KhachThue khachThue){
        return khachThueDAO.add(khachThue);
    }
    //method xóa khách thuê
    public Boolean delete(String id){
        return khachThueDAO.delete(id);
    }
    //method chỉnh sửa khách thuê
    public Boolean update(KhachThue khachThue){
        return khachThueDAO.update(khachThue);
    }
}
