package com.example.demo.repository;

import com.example.demo.dto.SockDTO;
import com.example.demo.exception.InsufficientSockQuantityException;
import com.example.demo.exception.InvalidSockRequestException;
import com.example.demo.model.Color;
import com.example.demo.model.SizeSock;
import com.example.demo.model.Sock;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class StockRepositoryImpl implements StockRepository {

    private final Map<Sock,Integer> map = new HashMap<>();

    private int countId;


    @Override
    public Sock addStock(Color color, SizeSock sizeSock, int cottonPart, int quantity) {
       Sock sock = new Sock( );
       sock.setColor(color);
       sock.setSize(sizeSock);
       sock.setCottonPart(cottonPart);
       sock.setQuantity(quantity);
        validateRequest(sock);
        if(map.containsKey(sock)){
             map.put(sock, map.get(sock) + sock.getQuantity());
       }else
            map.put(sock,sock.getQuantity());
        return  sock;
    }

    @Override
    public Sock putSock(Color color, SizeSock sizeSock, int cottonPart, int quantity) {
//        Sock newSock = null;
//        for (Sock sock : map.values()) {
//            if (sock.getColor().equals(color) && sock.getSize().equals(sizeSock) && sock.getCottonPart() == cottonPart) {
//                int sockQuantity = sock.getQuantity() + quantity ;
//                 sock.setQuantity(sockQuantity);
//                 newSock = sock;
//            }
//        }
//        return  newSock;

        {
            Sock sock = new Sock( );
            sock.setColor(color);
            sock.setSize(sizeSock);
            sock.setCottonPart(cottonPart);
            sock.setQuantity(quantity);
            validateRequest(sock);
            if(map.containsKey(sock)){
                map.put(sock, map.get(sock) - sock.getQuantity());
                return  sock;
            }else
                throw new InsufficientSockQuantityException("There is not socks");
        }
    }




    @Override
    public void deleteSocksInStock(Color color, int cottonPart, int quantity) {
        for(Sock sock: map.keySet()){
             if (sock.getColor().equals(color) && sock.getCottonPart() == cottonPart ) {
                int newQuantity = sock.getQuantity()-quantity;
                sock.setQuantity(newQuantity);
             }
         }
    }

    @Override
    public SockDTO findQuantityCottonMinBySocks(Color color, SizeSock sizeSock, int cottonMin) {
        SockDTO dto = null;
        int countSocksMin=0;
        for (Sock sock: map.keySet() )

        if (sock.getColor().equals(color) && sock.getSize().equals(sizeSock) && sock.getCottonPart() > cottonMin) {
                countSocksMin= countSocksMin+1;
                  dto = SockDTO.builder()
                        .cottonPart(sock.getCottonPart())
                        .quantity(countSocksMin)
                        .build();
            }return dto;
        }



    @Override
    public SockDTO findQuantityCottonMaxBySocks(Color color, SizeSock sizeSock, int cottonMax) {
        SockDTO dto = null;
        int countSocksMax=0;
        for (Sock sock : map.keySet()) {
            if (sock.getColor().equals(color) && sock.getSize().equals(sizeSock) && sock.getCottonPart() > cottonMax) {
                countSocksMax= countSocksMax+1;
                dto = SockDTO.builder()
                        .cottonPart(sock.getCottonPart())
                        .quantity(countSocksMax)
                        .build();
            }
            else {
                throw new InsufficientSockQuantityException("There is no socks");
            }
        }
        return dto;
    }

    private void validateRequest(Sock sock) {
        if(sock.getColor() == null || sock.getSize() == null){
            throw new InvalidSockRequestException("All fields should be filled");
        }
        if(sock.getCottonPart() < 0  || sock.getCottonPart() > 100){
            throw new InvalidSockRequestException("Cotton percentage should be between 0 and 100");
        }
        if(sock.getQuantity() <= 0){
            throw new InvalidSockRequestException("Quantity should be more than 0");
        }
    }



}

