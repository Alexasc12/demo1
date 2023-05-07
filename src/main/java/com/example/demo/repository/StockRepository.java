package com.example.demo.repository;

import com.example.demo.dto.SockDTO;
import com.example.demo.model.Color;
import com.example.demo.model.SizeSock;
import com.example.demo.model.Sock;

import java.util.Collection;
import java.util.List;

public interface StockRepository {
    Sock addStock(Color color, SizeSock sizeSock, int cottonPart, int quantity);

    Sock putSock(Color color, SizeSock sizeSock, int cottonPart, int quantity);

    void deleteSocksInStock(Color color, int cottonPart, int quantity);

    SockDTO findQuantityCottonMinBySocks(Color color, SizeSock sizeSock, int cottonMin);

    SockDTO findQuantityCottonMaxBySocks(Color color,SizeSock sizeSock, int cottonMax);

}
