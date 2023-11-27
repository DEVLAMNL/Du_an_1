/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import models.ChatLieu;
import repository.ChatLieuRepository;

public class ChatLieuServiceImpl extends ChatLieuRepository {

    ChatLieuRepository repo = new ChatLieuRepository();

    public ArrayList<ChatLieu> getAllChatLieu() {
        return this.repo.getAllChatLieu();
    }
    
    public void insertChatLieu(ChatLieu cl) {
        this.repo.insertChatLieu(cl);
    }
    
    public void updateChatLieu(int id, ChatLieu cl) {
        this.repo.updateChatLieu(id, cl);
    }
    
    public void deleteChatLieu(int id) {
        this.repo.deleteChatLieu(id);
    }
    
    public List<ChatLieu> searchChatLieu(String searchCode) {
        return this.repo.searchChatLieu(searchCode);
    }
}

