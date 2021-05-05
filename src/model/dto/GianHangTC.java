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
public class GianHangTC extends GianHang {
private String chatLieuMaiChe;
private String chatLieuVachNgan;

    public GianHangTC() {
        super();
    }

    public GianHangTC(String maGianHang, double dienTich, String viTri,String chatLieuMaiChe, String chatLieuVachNgan) {
        super(maGianHang, dienTich, viTri);
        this.chatLieuMaiChe = chatLieuMaiChe;
        this.chatLieuVachNgan = chatLieuVachNgan;
    }

    public String getChatLieuMaiChe() {
        return chatLieuMaiChe;
    }

    public void setChatLieuMaiChe(String chatLieuMaiChe) {
        this.chatLieuMaiChe = chatLieuMaiChe;
    }

    public String getChatLieuVachNgan() {
        return chatLieuVachNgan;
    }

    public void setChatLieuVachNgan(String chatLieuVachNgan) {
        this.chatLieuVachNgan = chatLieuVachNgan;
    }
    

    @Override
    public String toString() {
     return "GianHangTC {" + "maGianHang=" + this.getMaGianHang() + ", dienTich=" + this.getDienTich() + ", viTri=" + this.getViTri() + ", chatLieuMaiChe="+ this.chatLieuMaiChe+ ", chatLieuVachNgan="+ this.chatLieuVachNgan +'}';

    }
    
}
