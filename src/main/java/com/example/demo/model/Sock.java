package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Sock {

    private int id;

    private Color color;

    private SizeSock size;

    private int cottonPart;

    private int quantity;
    }
