/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOImplement;

import java.util.List;
import model.*;

/**
 *
 * @author Lab Informatika
 */
public interface datatokoimplement {
    public void insert(datatoko p);
    public void update(datatoko p, String namaLama);
    public void delete(String nama);
    public List <datatoko>getAll();
}
