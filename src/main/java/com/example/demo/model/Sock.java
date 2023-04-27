package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Sock {
    private int id;

    private Color color;

    private SizeSock size;

    private int cottonPart;

    private int quantity;
    }
