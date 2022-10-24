package com.richard.backend.controller;

import com.richard.backend.exception.UserNotFoundException;
import com.richard.backend.model.Stock;
import com.richard.backend.model.User;
import com.richard.backend.repository.StockRepository;
import com.richard.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
public class StockController {
    @Autowired
    private StockRepository stockRepository;

    @PostMapping("/stock")
    Stock newStock(@RequestBody Stock newStock){
        return stockRepository.save(newStock);
    }

    @GetMapping("/stocks")
    List<Stock> getAllStocks(){
        return stockRepository.findAll();
    }

    @GetMapping("/stock/{id}")
    Stock getStockById(@PathVariable Long id){
        return stockRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException(id));
    }

    @PutMapping("/stock/{id}")
    Stock updateStock(@RequestBody Stock newStock, @PathVariable Long id){
        return stockRepository.findById(id)
                .map(stock -> {
                    stock.setName(newStock.getName());
                    stock.setPrice(newStock.getPrice());
                    stock.setQuantity(newStock.getQuantity());
                    return stockRepository.save(stock);
                }).orElseThrow(()->new UserNotFoundException(id));
    }

    @DeleteMapping("/stock/{id}")
    String deleteStock(@PathVariable Long id){
        if(!stockRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        stockRepository.deleteById(id);
        return "Stock with id " + id + " has been deleted.";
    }
}
