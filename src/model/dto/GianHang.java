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
public abstract class GianHang { // tạo một abstract class tên GianHang

    protected String maGianHang;  // Attribute tên là maGianHang kiểu dữ liệu String phạm vi truy cập private
    protected double dienTich;    // Attribute tên là dienTich  kiểu dữ liệu double phạm vi truy cập private
    protected String viTri;       // Attribute tên là vitri kiểu dữ kiệu String phạm vi truy cập private
/*
    bình thường viết là 
     public GianHang() {
        maGianHang = null;
        dienTich = 0;
        viTri = null  
    
    }
     */
    public GianHang() { // hàm khởi tạo không tham số , phạm vi truy cập public 

    }

    public void setMaGianHang(String maGianHang) {  // hàm chỉnh sửa thuộc tính maGianHang có tên
        //là setMaGianHang kiểu dữa liệu không trả về void
        // tham số truyền vào có kiểu dữ liệu String 
        // phạm vi truy cập public 
        this.maGianHang = maGianHang;    // this là chỉ đối tượng đang gọi đến method setMaGianHang 
        // gán thuộc tính maGianhang của đối tượng đang gọi method bằng tham số truyền vào
    }

    public GianHang(String maGianHang, double dienTich, String viTri) { // method constructor có 3 paramater 
        this.maGianHang = maGianHang;
        this.dienTich = dienTich;
        this.viTri = viTri;
    }

    public void setDienTich(double dienTich) { // hàm chỉnh sửa thuộc tính dienTich tên là setDienTich 
        // kiểu dữ liệu không trả về void tham số truyền vào có kiểu dữ liệu double
        this.dienTich = dienTich; // gắn thuộc tính dienTich của đối tương gọi đến hàm băng tham số truyền vào
    }

    public void setViTri(String viTri) {
        /* hàm chỉnh sửa thuộc tính viTri có tên setViTri 
                                            kiểu dữ liệu không trả về void , tham số truyền vào kiểu dữ kiệu String 
                                            phạm vi truy ca
         */
        this.viTri = viTri; // gán thuộc tính viTri của đối tượng gọi hàm bằng tham số truyền vào 
    }

    public String getMaGianHang() { // method lấy giá trị thuộc tính maGianHang của đối tượng gọi method
        return maGianHang;
    }

    public double getDienTich() { // method lấy giá trị thuộc tính dienTich của đối tượng gọi method 
        return dienTich;
    }

    public String getViTri() { // method lấy giá trị thuôc tính viTri của đối tượng gọi method
        return viTri;
    }

}
