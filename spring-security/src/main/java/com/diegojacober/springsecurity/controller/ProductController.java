package com.diegojacober.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.diegojacober.springsecurity.dto.ProductDto;
import com.diegojacober.springsecurity.entity.Product;
import com.diegojacober.springsecurity.entity.User;
import com.diegojacober.springsecurity.repository.ProductRepository;

import jakarta.annotation.security.RolesAllowed;
import java.util.List;

@RestController
public class ProductController {

  @Autowired
  private ProductRepository productRepository;

  @PostMapping("/product")
  public void saveProduct(@RequestBody ProductDto productDto) {
    User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    Product product = new Product(productDto, user.getId());
    this.productRepository.save(product);
  }

  @GetMapping("/product")
  public List<Product> getProducts() {
    User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    Long id = user.getId();

    var role = user.getAuthorities().stream().toList().get(0).getAuthority();
    if ("ROLE_ADMIN".equals(role)) {
      return (List<Product>) productRepository.findAll();
    }
    return (List<Product>) productRepository.findyByUserId(id);
  }

  @DeleteMapping("/product/{id}")
  @RolesAllowed("ADMIN")
  public void delete(@PathVariable Long id) {
    this.productRepository.deleteById(id);
  }

}
