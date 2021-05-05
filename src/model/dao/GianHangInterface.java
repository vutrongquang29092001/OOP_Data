/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import java.util.Date;
import model.dto.GianHang;

/**
 *
 * @author vutrongquang29092001
 */
public interface GianHangInterface {
    public ArrayList<GianHang> get();
    
    public GianHang search(String id);
    
    public Boolean add(GianHang gianHang);
    
    public Boolean update(GianHang gianHang);
    
    public Boolean delete(String id);

    public double chiPhiThueGianHang(String id, Date a, Date b);

    public double chiPhiThueGianHang(String id, int soNgay);

    public double doanhThu(Date a, Date b);
    public double doanhThu(int soNagy);

}
