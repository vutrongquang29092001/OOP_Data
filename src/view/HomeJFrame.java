/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.GianHangCCController;
import controller.GianHangTCController;
import controller.KhachThueController;
import java.awt.CardLayout;
import java.awt.Color;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

import javax.swing.border.Border;
import javax.swing.plaf.BorderUIResource;
import javax.swing.table.DefaultTableModel;
import model.dto.GianHang;
import model.dto.GianHangCC;
import model.dto.GianHangTC;

import model.dto.KhachThue;

/**
 *
 * @author vutrongquang29092001
 */
public class HomeJFrame extends javax.swing.JFrame {

    /**
     * Creates new form HomeJFrame
     */
    CardLayout cardLayout = new CardLayout();
    CardLayout c1, c2;
    Border border = BorderFactory.createLineBorder(Color.RED, 1);
    Border border1 = BorderUIResource.getBlackLineBorderUIResource();
    KhachThueController ktc = new KhachThueController();
    GianHangCCController ghcc = new GianHangCCController();
    GianHangTCController ghtc = new GianHangTCController();
    DefaultTableModel model = new DefaultTableModel();

    //method khoi tao khong tham so 
    public HomeJFrame() {
        initComponents();
        setTitle("Quản lý Gian Hàng ");

        this.select();
        this.methodKT();
        this.methodGHCC();
        this.methodGHTC();
        this.search();
    }

    //method xử lí hiện thị thông tin của đối tượng user chọn
    public void select() {
        c1 = (CardLayout) (jPanel3.getLayout());
        jPanel3.setLayout(c1);
        jPanel3.add(jPanelGianHangCC, "ghcc");
        jPanel3.add(jPanelGianHangTC, "ghtc");
        jPanel3.add(jPanelKhachThue, "kt");
        jComboBoxGianHang.addActionListener((e) -> {
            if (jComboBoxGianHang.getModel().getSelectedItem().equals("GianHangCC")) {

                c1.show(jPanel3, "ghcc");
                getAllGHCC();
            } else {
                c1.show(jPanel3, "ghtc");
                getAllGHTC();
            }
        });
        jButtonKhachThue.addActionListener((e) -> {
            c1.show(jPanel3, "kt");
            getAllKT();
        });
    }

    // method hiện thị thông tin khách thuê ra table
    public void getAllKT() {
        DateFormat df1 = new SimpleDateFormat("yyyy/MM/dd");
        DateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cl = Calendar.getInstance();
        Date date = new Date();
//        ArrayList<KhachThue> getAllKT = 
        Object colunm[] = new Object[]{"Name", "MaGianHang", "Address", "StartTime", "EndTime", "TienCoc",};
        jTableKt.setModel(model);
        model.setColumnIdentifiers(colunm);
        model.setRowCount(0);
        for (int i = 0; i < ktc.get().size(); i++) {
            KhachThue temp = ktc.get().get(i);
            String[] data = new String[6];
            data[0] = temp.getName();
            data[1] = temp.getMaGianHang();
            data[2] = temp.getAddress();
            data[3] = df1.format(temp.getStartTime());

            data[4] = df1.format(temp.getEndsTime());
            data[5] = String.valueOf(temp.getTienCoc());
            model.addRow(data);
        }

    }

    // method xóa khách thuê
    public void deleteKT() {

        String s = maGianHangkt.getText();
        ktc.delete(s);

        getAllKT();

    }

    // method them một khách thuê
    public void addKT() {
        DateFormat df1 = new SimpleDateFormat("yyyy/MM/dd");
        DateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cl = Calendar.getInstance();
        Date date = new Date();
        KhachThue kt = new KhachThue();
        if (namekt.getText().equals("")) {
            namekt.setBorder(border);
        } else {
            namekt.setBorder(border1);
            kt.setName(namekt.getText());
        }
        if (addresskt.getText().equals("")) {
            addresskt.setBorder(border);
        } else {
            addresskt.setBorder(border1);
            kt.setAddress(addresskt.getText());
        }
        if (maGianHangkt.getText().equals("")) {
            maGianHangkt.setBorder(border);
        } else {
            maGianHangkt.setBorder(border1);
            kt.setMaGianHang(maGianHangkt.getText());
        }
        if (startTime.getText().equals("")) {
            startTime.setBorder(border);
        } else {
            try {
                startTime.setBorder(border1);
                date = df1.parse(startTime.getText());
                cl.setTime(date);
                kt.setStartTime(cl.getTime());
            } catch (ParseException e) {
                startTime.setBorder(border);
                JOptionPane.showMessageDialog(rootPane, "Hint: yyyy/MM/dd", "Format error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();

            }

        }
        if (endTime.getText().equals("")) {
            endTime.setBorder(border);
        } else {
            try {
                endTime.setBorder(border1);
                date = df1.parse(endTime.getText());
                cl.setTime(date);
                kt.setEndsTime(cl.getTime());
            } catch (ParseException e) {
                endTime.setBorder(border);
                JOptionPane.showMessageDialog(rootPane, "Hint: yyyy/MM/dd", "Format error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();

            }
        }
        if (tienCockt.getText().equals("")) {
            tienCockt.setBorder(border);
        } else {
            tienCockt.setBorder(border1);
            kt.setTienCoc(Integer.parseInt(tienCockt.getText()));
        }
        int result = JOptionPane.showConfirmDialog(this,
                "Bạn có chắc muốn thêm khách thuê này",
                "Xác nhận",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            ktc.add(kt);

        } else if (result == JOptionPane.NO_OPTION) {

        } else {

        }
        getAllKT();
    }

    //method sửa thông tin khách thuê
    public void updateKT() {
        DateFormat df1 = new SimpleDateFormat("yyyy/MM/dd");
        DateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cl = Calendar.getInstance();
        Date date = new Date();
        KhachThue kt = new KhachThue();
        if (namekt.getText().equals("")) {
            namekt.setBorder(border);
        } else {
            namekt.setBorder(border1);
            kt.setName(namekt.getText());
        }
        if (maGianHangkt.getText().equals("")) {
            maGianHangkt.setBorder(border);
        } else {
            maGianHangkt.setBorder(border1);
            kt.setMaGianHang(maGianHangkt.getText());

        }
        if (addresskt.getText().equals("")) {
            addresskt.setBorder(border);
        } else {
            addresskt.setBorder(border1);
            kt.setAddress(addresskt.getText());
        }
        if (startTime.getText().equals("")) {
            startTime.setBorder(border);
        } else {
            try {
                startTime.setBorder(border1);
                date = df1.parse(startTime.getText());
                cl.setTime(date);
                kt.setStartTime(cl.getTime());
            } catch (ParseException e) {
                startTime.setBorder(border);
                JOptionPane.showMessageDialog(rootPane, "Hint: yyyy/MM/dd", "Format error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();

            }

        }
        if (endTime.getText().equals("")) {
            endTime.setBorder(border);
        } else {
            try {
                endTime.setBorder(border1);
                date = df2.parse(endTime.getText());
                cl.setTime(date);
                kt.setEndsTime(cl.getTime());
            } catch (ParseException e) {
                endTime.setBorder(border);
                JOptionPane.showMessageDialog(rootPane, "Hint: yyyy/MM/dd", "Format error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();

            }
        }
        if (tienCockt.getText().equals("")) {
            tienCockt.setBorder(border);
        } else {
            tienCockt.setBorder(border1);
            System.out.println("sdsd");
            kt.setTienCoc(Integer.parseInt(tienCockt.getText()));
            System.out.println(kt.getTienCoc());
        }
        int result = JOptionPane.showConfirmDialog(this,
                "Bạn có chắc muốn update khách thuê này",
                "Xác nhận",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            ktc.update(kt);

        } else if (result == JOptionPane.NO_OPTION) {

        } else {

        }
        getAllKT();
    }

    //method tìm kiếm thông tin khách thuê
    public void searchKT() {
        DateFormat df1 = new SimpleDateFormat("yyyy/MM/dd");
        DateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cl = Calendar.getInstance();
        Date date = new Date();
        ArrayList<KhachThue> getAllKT = ktc.get();
        Object colunm[] = new Object[]{"Name", "MaGianHang", "Address", "StartTime", "EndTime", "TienCoc",};
        jTableKt.setModel(model);
        model.setColumnIdentifiers(colunm);
        model.setRowCount(0);
        KhachThue temp = ktc.search(jTextField1.getText());
        String[] data = new String[6];
        data[0] = temp.getName();
        data[1] = temp.getMaGianHang();
        data[2] = temp.getAddress();
        data[3] = df1.format(temp.getStartTime());
        data[4] = df2.format(temp.getEndsTime());
        data[5] = String.valueOf(temp.getTienCoc());
        model.addRow(data);

    }

    // method xử lí sự kiện khi nhấn các nút chọn button
    public void methodKT() {
        getkt.addActionListener((ae) -> {
            getAllKT();
            restartKT();
        });
        updatekt.addActionListener((ae) -> {
            updateKT();
            restartKT();
        });
        deletekt.addActionListener((ae) -> {
            deleteKT();
            restartKT();
        });
        addkt.addActionListener((ae) -> {
            addKT();
            restartKT();
        });
    }

    // method reset lại ô điền thông tin khách thuê
    public void restartKT() {
        namekt.setText("");
        maGianHangkt.setText("");
        addresskt.setText("");
        startTime.setText("");
        endTime.setText("");
        tienCockt.setText("");
    }

    //method xử lí logic đưa thông tin khách thuê ra table
    public void getDataFromTableKT() {
        DateFormat df1 = new SimpleDateFormat("yyyy/MM/dd");
        DateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");

        ArrayList<KhachThue> getAllkt = ktc.get();
        int i = jTableKt.getSelectedRow();
        KhachThue s = getAllkt.get(i);
        namekt.setText(s.getName());
        maGianHangkt.setText(s.getMaGianHang());
        addresskt.setText(s.getAddress());
        startTime.setText(df1.format(s.getStartTime()));
        endTime.setText(df2.format(s.getEndsTime()));
        tienCockt.setText(String.valueOf(s.getTienCoc()));
    }

    // method xử lí logic lấy thông tin khách thuê từ table đưa vào textfile
    public void getAllGHCC() {

        Object columns[] = new Object[]{"MaGianHang", "Area", "Address", "SoLuongBanGhe", "SoLuongQuat"};
        jTableGHCC.setModel(model);
        model.setColumnIdentifiers(columns);
        model.setRowCount(0);
        for (GianHang gh : ghcc.get()) {
            GianHangCC temp = (GianHangCC) gh;
            String[] data = new String[5];
            data[0] = temp.getMaGianHang();
            data[1] = String.valueOf(temp.getDienTich());
            data[2] = temp.getViTri();
            data[3] = String.valueOf(temp.getSoLuongBanGhe());
            data[4] = String.valueOf(temp.getSoLuongQuatLamMat());
            model.addRow(data);
        }
    }
    // method xử lí logic lấy thông tin gian hàng cc từ table đưa vào textfile

    public void getDataFromTableGHCC() {
        ArrayList<GianHang> listGH = ghcc.get();
        int i = jTableGHCC.getSelectedRow();
        GianHangCC temp = (GianHangCC) listGH.get(i);
        maGHCC.setText(temp.getMaGianHang());
        areaGHCC.setText(String.valueOf(temp.getDienTich()));
        addressGHCC.setText(temp.getViTri());
        slbgGHCC.setText(String.valueOf(temp.getSoLuongBanGhe()));
        slqGHCC.setText(String.valueOf(temp.getSoLuongQuatLamMat()));

    }

    // method them gian hàng cc 
    public void addGHCC() {
        GianHangCC temp = new GianHangCC();
        if (maGHCC.getText().equals("")) {
            maGHCC.setBorder(border);
        } else {
            maGHCC.setBorder(border1);
            temp.setMaGianHang(maGHCC.getText());
        }
        if (areaGHCC.getText().equals("")) {
            areaGHCC.setBorder(border);
        } else {
            areaGHCC.setBorder(border1);
            temp.setDienTich(Double.parseDouble(areaGHCC.getText()));
        }
        if (addressGHCC.getText().equals("")) {
            addressGHCC.setBorder(border);
        } else {
            addressGHCC.setBorder(border1);
            temp.setViTri(addressGHCC.getText());
        }
        if (slbgGHCC.getText().equals("")) {
            slbgGHCC.setBorder(border);
        } else {
            slbgGHCC.setBorder(border1);
            temp.setSoLuongBanGhe(Integer.parseInt(slbgGHCC.getText()));
        }
        if (slqGHCC.getText().equals("")) {
            slqGHCC.setBorder(border);
        } else {
            slqGHCC.setBorder(border1);
            temp.setSoLuongQuatLamMat(Integer.parseInt(slqGHCC.getText()));
        }
        int result = JOptionPane.showConfirmDialog(this,
                "Bạn có chắc muốn thêm gian hang này",
                "Xác nhận",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            ghcc.add(temp);

        } else if (result == JOptionPane.NO_OPTION) {

        } else {

        }
        getAllGHCC();
    }

    // method chỉnh sửa thông tin gian hàng cc 
    public void updateGHCC() {
        GianHangCC temp = new GianHangCC();
        if (maGHCC.getText().equals("")) {
            maGHCC.setBorder(border);
        } else {
            maGHCC.setBorder(border1);
            temp.setMaGianHang(maGHCC.getText());
        }
        if (areaGHCC.getText().equals("")) {
            areaGHCC.setBorder(border);
        } else {
            areaGHCC.setBorder(border1);
            temp.setDienTich(Double.parseDouble(areaGHCC.getText()));
        }
        if (addressGHCC.getText().equals("")) {
            addressGHCC.setBorder(border);
        } else {
            addressGHCC.setBorder(border1);
            temp.setViTri(addressGHCC.getText());
        }
        if (slbgGHCC.getText().equals("")) {
            slbgGHCC.setBorder(border);
        } else {
            slbgGHCC.setBorder(border1);
            temp.setSoLuongBanGhe(Integer.parseInt(slbgGHCC.getText()));
        }
        if (slqGHCC.getText().equals("")) {
            slqGHCC.setBorder(border);
        } else {
            slqGHCC.setBorder(border1);
            temp.setSoLuongQuatLamMat(Integer.parseInt(slqGHCC.getText()));
        }
        int result = JOptionPane.showConfirmDialog(this,
                "Bạn có chắc muốn update gian hang này",
                "Xác nhận",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            ghcc.update(temp);

        } else if (result == JOptionPane.NO_OPTION) {

        } else {

        }
        getAllGHCC();
    }

    // method xóa gian hàng cc 
    public void deleteGHCC() {
        int result = JOptionPane.showConfirmDialog(this,
                "Bạn có chắc muốn delete gian hang này",
                "Xác nhận",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            ghcc.delete(maGHCC.getText());

        } else if (result == JOptionPane.NO_OPTION) {

        } else {

        }
        getAllGHCC();
    }

    // method tìm kiếm thông tin gian hàng cc
    public void searchGHCC() {
        Object columns[] = new Object[]{"MaGianHang", "Area", "Address", "SoLuongBanGhe", "SoLuongQuat"};
        jTableGHCC.setModel(model);
        model.setColumnIdentifiers(columns);
        model.setRowCount(0);

        GianHangCC temp = (GianHangCC) ghcc.search(jTextField1.getText());
        String[] data = new String[6];
        data[0] = temp.getMaGianHang();
        data[1] = String.valueOf(temp.getDienTich());
        data[2] = temp.getViTri();
        data[3] = String.valueOf(temp.getSoLuongBanGhe());
        data[4] = String.valueOf(temp.getSoLuongQuatLamMat());
        model.addRow(data);

    }

    // method reset ô điền textfile của gian hàng cc
    public void restartGHCC() {
        maGHCC.setText("");
        areaGHCC.setText("");
        addressGHCC.setText("");
        slbgGHCC.setText("");
        slqGHCC.setText("");
    }

    //method xử lí các sự kiên khị nhấn các nút chọn button
    public void methodGHCC() {
        addGHCC.addActionListener((ae) -> {
            addGHCC();
            restartGHCC();
        });
        getGHCC.addActionListener((ae) -> {
            getAllGHCC();
            restartGHCC();
        });
        updateGHCC.addActionListener((ae) -> {
            updateGHCC();
            restartGHCC();
        });
        deleteGHCC.addActionListener((ae) -> {
            deleteGHCC();
            restartGHCC();
        });
        chiPhiGHCC.addActionListener((ae) -> {
            new ChiphiJframe("ghcc", maGHCC.getText()).setVisible(true);
        });
        doanhThuGHCC.addActionListener((ae) -> {
            new DoanhThuJframe("ghcc").setVisible(true);
        });
    }

    // method xử lí logic lấy thông tin gian hàng tc từ table đưa vào textfile
    public void getDataFromTableGHTC() {

        ArrayList<GianHang> listGH = ghtc.get();
        int i = jTableGHTC.getSelectedRow();
        GianHangTC temp = (GianHangTC) listGH.get(i);
        maGHTC.setText(temp.getMaGianHang());
        areaGHTC.setText(String.valueOf(temp.getDienTich()));
        addressGHTC.setText(temp.getViTri());
        clmcGHTC.setText(temp.getChatLieuMaiChe());
        clvnGHTC.setText(temp.getChatLieuVachNgan());
    }

    //method hiện thị thông tin gian hàng tc ra table
    public void getAllGHTC() {

        Object columns[] = new Object[]{"MaGianHang", "Area", "Address", "ChatLieuMaiChe", "ChatLieuVachNgan"};
        jTableGHTC.setModel(model);
        model.setColumnIdentifiers(columns);
        model.setRowCount(0);
        for (GianHang gh : ghtc.get()) {
            GianHangTC temp = (GianHangTC) gh;
            String[] data = new String[5];
            data[0] = temp.getMaGianHang();
            data[1] = String.valueOf(temp.getDienTich());
            data[2] = temp.getViTri();
            data[3] = temp.getChatLieuMaiChe();
            data[4] = temp.getChatLieuVachNgan();
            model.addRow(data);
        }
    }

    //method them gian hàng tc
    public void addGHTC() {
        GianHangTC temp = new GianHangTC();
        if (maGHTC.getText().equals("")) {
            maGHTC.setBorder(border);
        } else {
            maGHTC.setBorder(border1);
            temp.setMaGianHang(maGHTC.getText());
        }
        if (areaGHTC.getText().equals("")) {
            areaGHTC.setBorder(border);
        } else {
            areaGHTC.setBorder(border1);
            temp.setDienTich(Double.parseDouble(areaGHTC.getText()));
        }
        if (addressGHTC.getText().equals("")) {
            addressGHTC.setBorder(border);
        } else {
            addressGHTC.setBorder(border1);
            temp.setViTri(addressGHTC.getText());
        }
        if (clmcGHTC.getText().equals("")) {
            clmcGHTC.setBorder(border);
        } else {
            clmcGHTC.setBorder(border1);
            temp.setChatLieuMaiChe(clmcGHTC.getText());
        }
        if (clvnGHTC.getText().equals("")) {
            clvnGHTC.setBorder(border);
        } else {
            clvnGHTC.setBorder(border1);
            temp.setChatLieuVachNgan(clvnGHTC.getText());
        }
        int result = JOptionPane.showConfirmDialog(this,
                "Bạn có chắc muốn thêm gian hang này",
                "Xác nhận",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            ghtc.add(temp);

        } else if (result == JOptionPane.NO_OPTION) {

        } else {

        }
        getAllGHTC();
    }

    // method chỉnh sửa thông tin gian hàng tc
    public void updateGHTC() {
        GianHangTC temp = new GianHangTC();
        if (maGHTC.getText().equals("")) {
            maGHTC.setBorder(border);
        } else {
            maGHTC.setBorder(border1);
            temp.setMaGianHang(maGHTC.getText());
        }
        if (areaGHTC.getText().equals("")) {
            areaGHCC.setBorder(border);
        } else {
            areaGHTC.setBorder(border1);
            temp.setDienTich(Double.parseDouble(areaGHTC.getText()));
        }
        if (addressGHTC.getText().equals("")) {
            addressGHTC.setBorder(border);
        } else {
            addressGHTC.setBorder(border1);
            temp.setViTri(addressGHTC.getText());
        }
        if (clmcGHTC.getText().equals("")) {
            clmcGHTC.setBorder(border);
        } else {
            clmcGHTC.setBorder(border1);
            temp.setChatLieuMaiChe(clmcGHTC.getText());
        }
        if (clvnGHTC.getText().equals("")) {
            clvnGHTC.setBorder(border);
        } else {
            clvnGHTC.setBorder(border1);
            temp.setChatLieuVachNgan(clvnGHTC.getText());
        }
        int result = JOptionPane.showConfirmDialog(this,
                "Bạn có chắc muốn update gian hang này",
                "Xác nhận",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            ghtc.update(temp);

        } else if (result == JOptionPane.NO_OPTION) {

        } else {

        }
        getAllGHTC();
    }

    // method xóa một gian hàng tc
    public void deleteGHTC() {
        int result = JOptionPane.showConfirmDialog(this,
                "Bạn có chắc muốn delete gian hang này",
                "Xác nhận",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            ghtc.delete(maGHTC.getText());

        } else if (result == JOptionPane.NO_OPTION) {

        } else {

        }
        getAllGHTC();
    }

    // method tìm kiếm gian hàng tc
    public void searchGHTC() {
        Object columns[] = new Object[]{"MaGianHang", "Area", "Address", "ChatLieuMaiChe", "ChatLieuVachNgan"};
        jTableGHTC.setModel(model);
        model.setColumnIdentifiers(columns);
        model.setRowCount(0);

        GianHangTC temp = (GianHangTC) ghtc.search(jTextField1.getText());
        String[] data = new String[6];
        data[0] = temp.getMaGianHang();
        data[1] = String.valueOf(temp.getDienTich());
        data[2] = temp.getViTri();
        data[3] = temp.getChatLieuMaiChe();
        data[4] = temp.getChatLieuVachNgan();
        model.addRow(data);

    }
    // method reset ô điền textfile của gian hàng tc

    public void restartGHTC() {
        maGHTC.setText("");
        areaGHTC.setText("");
        addressGHTC.setText("");
        clmcGHTC.setText("");
        clvnGHTC.setText("");
    }

    //method xử lí các sự kiên khị nhấn các nút chọn button
    public void methodGHTC() {
        addGHTC.addActionListener((ae) -> {
            addGHTC();
            restartGHTC();
        });
        getGHTC.addActionListener((ae1) -> {
            getAllGHTC();
            restartGHTC();
        });
        updateGHTC.addActionListener((ae) -> {
            updateGHTC();
            restartGHTC();
        });
        deleteGHTC.addActionListener((ae) -> {
            deleteGHTC();
            restartGHTC();
        });
        chiPhiGHTC.addActionListener((ae) -> {
            new ChiphiJframe("ghtc", maGHTC.getText()).setVisible(true);
        });
        doanhThuGHTC.addActionListener((ae) -> {
            new DoanhThuJframe("ghtc").setVisible(true);
        });
    }

    // method xử lí tìm kiếm thông tin của ghcc, ghtc , khachthue khi nhấn nút button
    public void search() {
        search.addActionListener((ae) -> {
            if (jComboBoxSearch.getModel().getSelectedItem().equals("GianHangCC")) {
                c1.show(jPanel3, "ghcc");
                searchGHCC();
            }
            if (jComboBoxSearch.getModel().getSelectedItem().equals("GianHangTC")) {
                searchGHTC();
                c1.show(jPanel3, "ghtc");
            }
            if (jComboBoxSearch.getModel().getSelectedItem().equals("KhachThue")) {
                searchKT();
                c1.show(jPanel3, "kt");
            }

        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jComboBoxGianHang = new javax.swing.JComboBox<>();
        jButtonKhachThue = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jComboBoxSearch = new javax.swing.JComboBox<>();
        search = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanelGianHangCC = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        maGHCC = new javax.swing.JTextField();
        areaGHCC = new javax.swing.JTextField();
        addressGHCC = new javax.swing.JTextField();
        slbgGHCC = new javax.swing.JTextField();
        slqGHCC = new javax.swing.JTextField();
        getGHCC = new javax.swing.JButton();
        addGHCC = new javax.swing.JButton();
        deleteGHCC = new javax.swing.JButton();
        updateGHCC = new javax.swing.JButton();
        chiPhiGHCC = new javax.swing.JButton();
        doanhThuGHCC = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableGHCC = new javax.swing.JTable();
        jPanelGianHangTC = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        maGHTC = new javax.swing.JTextField();
        areaGHTC = new javax.swing.JTextField();
        addressGHTC = new javax.swing.JTextField();
        clmcGHTC = new javax.swing.JTextField();
        clvnGHTC = new javax.swing.JTextField();
        getGHTC = new javax.swing.JButton();
        deleteGHTC = new javax.swing.JButton();
        updateGHTC = new javax.swing.JButton();
        chiPhiGHTC = new javax.swing.JButton();
        doanhThuGHTC = new javax.swing.JButton();
        addGHTC = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableGHTC = new javax.swing.JTable();
        jPanelKhachThue = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        namekt = new javax.swing.JTextField();
        maGianHangkt = new javax.swing.JTextField();
        addresskt = new javax.swing.JTextField();
        startTime = new javax.swing.JTextField();
        endTime = new javax.swing.JTextField();
        tienCockt = new javax.swing.JTextField();
        addkt = new javax.swing.JButton();
        getkt = new javax.swing.JButton();
        deletekt = new javax.swing.JButton();
        updatekt = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableKt = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBoxGianHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "GianHangCC", "GianHangTC" }));
        jPanel1.add(jComboBoxGianHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 50));

        jButtonKhachThue.setText("KhachThue");
        jPanel1.add(jButtonKhachThue, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 150, 50));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 160, 50));

        jComboBoxSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "GianHangCC", "GianHangTC", "KhachThue" }));
        jPanel1.add(jComboBoxSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 170, 50));

        search.setText("Search");
        jPanel1.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, 160, 50));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 50));

        jPanel3.setBackground(java.awt.Color.white);
        jPanel3.setLayout(new java.awt.CardLayout());

        jPanelGianHangCC.setBackground(new java.awt.Color(48, 225, 55));
        jPanelGianHangCC.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(java.awt.Color.gray);

        jLabel12.setText("MaGianHang");

        jLabel13.setText("Area");

        jLabel14.setText("Address");

        jLabel15.setText("SoLuongBanGhe");

        jLabel16.setText("SoLuongQuat");

        areaGHCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                areaGHCCActionPerformed(evt);
            }
        });

        getGHCC.setText("get");

        addGHCC.setText("add");

        deleteGHCC.setText("delete");

        updateGHCC.setText("update");

        chiPhiGHCC.setText("ChiPhi");

        doanhThuGHCC.setText("DoanhThu");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(slqGHCC, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(slbgGHCC)
                            .addComponent(addressGHCC)
                            .addComponent(areaGHCC)
                            .addComponent(maGHCC)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(chiPhiGHCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deleteGHCC, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                            .addComponent(getGHCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(updateGHCC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(doanhThuGHCC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                            .addComponent(addGHCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(maGHCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(areaGHCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(addressGHCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(slbgGHCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(slqGHCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(getGHCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addGHCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteGHCC)
                    .addComponent(updateGHCC))
                .addGap(28, 28, 28)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chiPhiGHCC)
                    .addComponent(doanhThuGHCC))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanelGianHangCC.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 450));

        jTableGHCC.setForeground(java.awt.Color.gray);
        jTableGHCC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "MaGianHang", "Area", "Address", "SoLuongBanGhe", "SoLuongQuat"
            }
        ));
        jTableGHCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableGHCCMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableGHCC);

        jPanelGianHangCC.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 500, 450));

        jPanel3.add(jPanelGianHangCC, "card2");

        jPanelGianHangTC.setBackground(new java.awt.Color(48, 225, 55));
        jPanelGianHangTC.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(java.awt.Color.gray);

        jLabel7.setText("MaGianHang");

        jLabel8.setText("Area");

        jLabel9.setText("Address");

        jLabel10.setText("ChatLieuMaiChe");

        jLabel11.setText("ChatLieuVachngan");

        areaGHTC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                areaGHTCActionPerformed(evt);
            }
        });

        getGHTC.setText("get");

        deleteGHTC.setText("delete");

        updateGHTC.setText("update");

        chiPhiGHTC.setText("ChiPhi");

        doanhThuGHTC.setText("DoanhThu");

        addGHTC.setText("add");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(clvnGHTC, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(clmcGHTC)
                            .addComponent(addressGHTC)
                            .addComponent(areaGHTC)
                            .addComponent(maGHTC)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(deleteGHTC, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                            .addComponent(getGHTC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(chiPhiGHTC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addGHTC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(updateGHTC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(doanhThuGHTC, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                        .addGap(12, 12, 12)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(maGHTC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(areaGHTC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(addressGHTC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(clmcGHTC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(clvnGHTC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(getGHTC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addGHTC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(deleteGHTC, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(updateGHTC))
                .addGap(22, 22, 22)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(doanhThuGHTC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chiPhiGHTC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanelGianHangTC.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 450));

        jScrollPane2.setBackground(java.awt.Color.gray);

        jTableGHTC.setForeground(java.awt.Color.gray);
        jTableGHTC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "MaGianHang", "Area", "Address", "ChatLieuMaiChe", "ChatLeuVachNgan"
            }
        ));
        jTableGHTC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableGHTCMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableGHTC);
        jTableGHTC.getAccessibleContext().setAccessibleDescription("");

        jPanelGianHangTC.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 500, 450));

        jPanel3.add(jPanelGianHangTC, "card3");

        jPanelKhachThue.setBackground(new java.awt.Color(48, 225, 55));
        jPanelKhachThue.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(java.awt.Color.gray);

        jLabel1.setText("Name");

        jLabel2.setText("MaGianHang");

        jLabel3.setText("Address");

        jLabel4.setText("StartTime");

        jLabel5.setText("EndTime");

        jLabel6.setText("TienCoc");

        endTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endTimeActionPerformed(evt);
            }
        });

        addkt.setText("add");

        getkt.setText("get");

        deletekt.setText("delete");

        updatekt.setText("update");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 26, Short.MAX_VALUE))
                    .addComponent(addkt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deletekt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(namekt)
                    .addComponent(tienCockt)
                    .addComponent(maGianHangkt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addresskt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startTime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endTime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(getkt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(updatekt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(namekt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(maGianHangkt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(addresskt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(startTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(endTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tienCockt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addkt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(getkt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(deletekt)
                    .addComponent(updatekt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanelKhachThue.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 450));

        jScrollPane1.setBackground(java.awt.Color.gray);

        jTableKt.setForeground(java.awt.Color.gray);
        jTableKt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Name", "MaGianHang", "Address ", "StartTime", "EndTime", "TienCoc"
            }
        ));
        jTableKt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableKtMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableKt);

        jPanelKhachThue.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 500, 450));

        jPanel3.add(jPanelKhachThue, "card4");

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 800, 450));

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void endTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_endTimeActionPerformed

    private void areaGHTCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areaGHTCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_areaGHTCActionPerformed

    private void areaGHCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areaGHCCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_areaGHCCActionPerformed
    //method xử lí sử kiện khi click chuột vào table của khách thuê
    private void jTableKtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableKtMouseClicked
        getDataFromTableKT();
    }//GEN-LAST:event_jTableKtMouseClicked
    //method xử lí sử kiện khi click chuột vào table của gian hàng cc
    private void jTableGHCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableGHCCMouseClicked
        getDataFromTableGHCC();
    }//GEN-LAST:event_jTableGHCCMouseClicked
    //method xử lí sử kiện khi click chuột vào table của gian hàng tc
    private void jTableGHTCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableGHTCMouseClicked
        getDataFromTableGHTC();
    }//GEN-LAST:event_jTableGHTCMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addGHCC;
    private javax.swing.JButton addGHTC;
    private javax.swing.JButton addkt;
    private javax.swing.JTextField addressGHCC;
    private javax.swing.JTextField addressGHTC;
    private javax.swing.JTextField addresskt;
    private javax.swing.JTextField areaGHCC;
    private javax.swing.JTextField areaGHTC;
    private javax.swing.JButton chiPhiGHCC;
    private javax.swing.JButton chiPhiGHTC;
    private javax.swing.JTextField clmcGHTC;
    private javax.swing.JTextField clvnGHTC;
    private javax.swing.JButton deleteGHCC;
    private javax.swing.JButton deleteGHTC;
    private javax.swing.JButton deletekt;
    private javax.swing.JButton doanhThuGHCC;
    private javax.swing.JButton doanhThuGHTC;
    private javax.swing.JTextField endTime;
    private javax.swing.JButton getGHCC;
    private javax.swing.JButton getGHTC;
    private javax.swing.JButton getkt;
    private javax.swing.JButton jButtonKhachThue;
    private javax.swing.JComboBox<String> jComboBoxGianHang;
    private javax.swing.JComboBox<String> jComboBoxSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelGianHangCC;
    private javax.swing.JPanel jPanelGianHangTC;
    private javax.swing.JPanel jPanelKhachThue;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableGHCC;
    private javax.swing.JTable jTableGHTC;
    private javax.swing.JTable jTableKt;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField maGHCC;
    private javax.swing.JTextField maGHTC;
    private javax.swing.JTextField maGianHangkt;
    private javax.swing.JTextField namekt;
    private javax.swing.JButton search;
    private javax.swing.JTextField slbgGHCC;
    private javax.swing.JTextField slqGHCC;
    private javax.swing.JTextField startTime;
    private javax.swing.JTextField tienCockt;
    private javax.swing.JButton updateGHCC;
    private javax.swing.JButton updateGHTC;
    private javax.swing.JButton updatekt;
    // End of variables declaration//GEN-END:variables
}
