/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dto;



/**
 *
 * @author Admin
 */
 public abstract class GianHang {
    private String maGianHang;
    private double dienTich;
    private String viTri;

    public GianHang() {
        
    }

    public void setMaGianHang(String maGianHang) {
        this.maGianHang = maGianHang;
    }

    public void setDienTich(double dienTich) {
        this.dienTich = dienTich;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public GianHang(String maGianHang, double dienTich, String viTri) {
        this.maGianHang = maGianHang;
        this.dienTich = dienTich;
        this.viTri = viTri;
    }

    public String getMaGianHang() {
        return maGianHang;
    }

   

    public double getDienTich() {
        return dienTich;
    }

    

    public String getViTri() {
        return viTri;
    } 
    
}
