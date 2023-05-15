package com.example.demo.controller;

import com.example.demo.dto.SockDTO;
import com.example.demo.model.Color;
import com.example.demo.model.SizeSock;
import com.example.demo.model.Sock;
import com.example.demo.repository.StockRepositoryImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/api/socks")
public class SockController {
   private final StockRepositoryImpl stockRepository;

    public SockController(StockRepositoryImpl stockRepository) {
        this.stockRepository = stockRepository;
    }


    @PostMapping
       public ResponseEntity<Void> addSocks(@RequestBody Sock sock){
         stockRepository.addStock(sock.getColor(),sock.getSize(),sock.getCottonPart(),sock.getQuantity());
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> putSocks(@RequestBody Sock sock) {
        stockRepository.putSock(sock.getColor(), sock.getSize(),sock.getCottonPart(),sock.getQuantity());
        return  ResponseEntity.ok().build();
    }

    @GetMapping("/min")
    public ResponseEntity<SockDTO> getQuantitySocksMin(@RequestParam(required = false, name = "color") Color color ,
                                                    @RequestParam(required = false, name = "size") SizeSock size ,
                                                    @RequestParam(required = false, name = "cotonMin") int  cottonMin
                                                    ){
      SockDTO newSock =  stockRepository.findQuantityCottonMinBySocks(color, size,cottonMin);
        return ResponseEntity.ok().body(newSock);
    }
    @GetMapping("/max")
    public ResponseEntity<SockDTO> getQuantitySocksMax(@RequestParam(required = false, name = "color") Color color ,
                                                       @RequestParam(required = false, name = "size") SizeSock size ,
                                                       @RequestParam(required = false, name = "cotonMax") int  cottonMax
    ){
        SockDTO newSock =  stockRepository.findQuantityCottonMaxBySocks(color, size,cottonMax);
        return ResponseEntity.ok().body(newSock);
    }
}
