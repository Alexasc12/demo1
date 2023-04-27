package com.example.demo.repository;

import com.example.demo.model.Color;
import com.example.demo.model.SizeSock;
import com.example.demo.model.Sock;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class StockRepositoryImpl implements StockRepository {

    private final Map<Integer,Sock> map = new HashMap<>();

    private int countId;


    @Override
    public Sock addStock(Color color, SizeSock sizeSock, int cottonPart, int quantity) {
       Sock sock = new Sock( );
       sock.setId(countId++);
       sock.setColor(color);
       sock.setSize(sizeSock);
       sock.setCottonPart(cottonPart);
       sock.setQuantity(quantity);
     Sock sockAdd = map.put(sock.getId(),sock);
        return  sockAdd;
    }

    @Override
    public Sock deleteSocksInStock(Color color, int cottonPart, int quantity) {
        Sock deleteSock = null;
         for(Sock sock: map.values()){
             if (sock.getColor().equals(color) && sock.getCottonPart() == cottonPart ) {
                int newQuantity = sock.getQuantity()-quantity;
                sock.setQuantity(newQuantity);
                 deleteSock = map.remove(sock);
             }
         }
         return deleteSock;
    }

    @Override
    public int findQuantityCottonMinBySocks(Color color, SizeSock sizeSock, int cottonMin) {
        return 0;
    }

    @Override
    public int findQuantityCottonMaxBySocks(Color color, SizeSock sizeSock, int cottonMax) {
        return 0;
    }
}
