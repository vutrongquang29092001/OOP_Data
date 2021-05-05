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
public class KhachThueController {
    KhachThueDAO khachThueDAO = new KhachThueDAO();
    public ArrayList<KhachThue> get(){
        return khachThueDAO.get();
    }
    public KhachThue search(String id){
        return khachThueDAO.search(id);
    }
    public Boolean add(KhachThue khachThue){
        return khachThueDAO.add(khachThue);
    }
    public Boolean delete(String id){
        return khachThueDAO.delete(id);
    }
    public Boolean update(KhachThue khachThue){
        return khachThueDAO.update(khachThue);
    }
}
