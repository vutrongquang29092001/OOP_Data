/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import model.dto.KhachThue;

/**
 *
 * @author vutrongquang29092001
 */
public interface KhachThueInterface {

    public ArrayList<KhachThue> get();

    public KhachThue search(String id);

    public Boolean add(KhachThue khachThue);

    public Boolean delete(String id);

    public Boolean update(KhachThue khachThue);
}
