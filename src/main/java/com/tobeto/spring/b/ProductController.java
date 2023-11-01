package com.tobeto.spring.b;

import org.springframework.web.bind.annotation.*;

@RestController // Bu sınıfın bir Controller olduğunu belirtir.
@RequestMapping("/api/products") // Bu Controller'daki tüm metotların "/api/products" yoluna sahip olduğunu belirtir.
public class ProductController {

    @GetMapping // HTTP GET isteğine yanıt verecek metodu belirtir.
    public String getProducts() {
        return "Tüm ürünleri getir"; // Basit bir dize döndürüyor, gerçek veritabanından veri alınmıyor.
    }

    @PostMapping // HTTP POST isteğine yanıt verecek metodu belirtir.
    public String createProduct() {
        return "Yeni bir ürün oluşturuldu"; // Yeni bir ürün oluşturduğunu varsayar, veritabanına kaydetmez.
    }

    @PutMapping("/{id}") // Belirli bir ürünü güncellemek için HTTP PUT isteğine yanıt verecek metodu belirtir.
    public String updateProduct(@PathVariable Long id) {
        return "Ürün güncellendi: " + id; // Verilen ID'ye sahip ürünü güncellediğini varsayar.
    }

    @DeleteMapping("/{id}") // Belirli bir ürünü silmek için HTTP DELETE isteğine yanıt verecek metodu belirtir.
    public String deleteProduct(@PathVariable Long id) {
        return "Ürün silindi: " + id; // Verilen ID'ye sahip ürünü sildiğini varsayar.
    }
}