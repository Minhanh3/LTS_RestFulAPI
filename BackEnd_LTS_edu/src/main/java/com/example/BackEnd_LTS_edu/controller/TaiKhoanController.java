package com.example.BackEnd_LTS_edu.controller;

import com.example.BackEnd_LTS_edu.entity.TaiKhoan;
import com.example.BackEnd_LTS_edu.service.QuyenHanService;
import com.example.BackEnd_LTS_edu.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("taikhoan")
public class TaiKhoanController {

    @Autowired
    private TaiKhoanService taiKhoanService;

    @Autowired
    private QuyenHanService quyenHanService;

    @GetMapping("getAllTaiKhoan")
    public List<TaiKhoan> getAllTaiKhoan() {
        return taiKhoanService.getAllTaiKhoan();
    }

    @PostMapping("addTaiKHoan")
    public ResponseEntity<String> addTaiKhoan(@RequestBody TaiKhoan taiKhoan) {
        taiKhoanService.addTaiKhoan(taiKhoan);
        return ResponseEntity.ok("Add Tài Khoản thành công");
    }

    @PutMapping("updateTKhoan")
    public ResponseEntity<String> updatelkh(@RequestBody TaiKhoan taiKhoan) {
        taiKhoanService.updateTaiKhoan(taiKhoan);
        return ResponseEntity.ok("Update success");
    }

    @DeleteMapping("deleteTaiKhoan/{id}")
    public ResponseEntity<String> deleteLkh(@PathVariable int id) {
        taiKhoanService.deletetTaiKhoan(id);
        return ResponseEntity.ok("Delete success");
    }

    @GetMapping("searchTenTk")
    public List<TaiKhoan> searchTaiKhoan(@RequestParam String tenTk) {
        return taiKhoanService.findByTenTK(tenTk);
    }

    @GetMapping("phantrang")
    public List<TaiKhoan> phantrangTaiKhoan(Integer number, Integer size) {
        if (number == null) {
            number = 0;
        }
        if (size == null) {
            size = 10;
        }
        Pageable pageable = PageRequest.of(number, size);
        return taiKhoanService.phantrang(pageable);
    }

}
