/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author admin
 */
public class ChatLieu {
    private int idChatLieu;
    private String tenChatLieu;

    public ChatLieu() {
    }

    public ChatLieu(String tenChatLieu) {
        this.tenChatLieu = tenChatLieu;
    }

    public ChatLieu(int idChatLieu, String tenChatLieu) {
        this.idChatLieu = idChatLieu;
        this.tenChatLieu = tenChatLieu;
    }

    public int getIdChatLieu() {
        return idChatLieu;
    }

    public void setIdChatLieu(int idChatLieu) {
        this.idChatLieu = idChatLieu;
    }

    public String getTenChatLieu() {
        return tenChatLieu;
    }

    public void setTenChatLieu(String tenChatLieu) {
        this.tenChatLieu = tenChatLieu;
    }
    
    
}
