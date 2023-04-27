package com.example.demo.repository;

import com.example.demo.model.Color;
import com.example.demo.model.SizeSock;
import com.example.demo.model.Sock;

import java.util.Collection;
import java.util.List;

public interface StockRepository {
    Sock addStock(Color color, SizeSock sizeSock, int cottonPart, int quantity);

    Sock deleteSocksInStock(Color color, int cottonPart, int quantity);

    int findQuantityCottonMinBySocks(Color color,SizeSock sizeSock,int cottonMin);

    int findQuantityCottonMaxBySocks(Color color,SizeSock sizeSock, int cottonMax);

}
