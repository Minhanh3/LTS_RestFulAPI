package com.example.BackEnd_LTS_edu.controller;

import com.example.BackEnd_LTS_edu.entity.KhoaHoc;
import com.example.BackEnd_LTS_edu.service.KhoaHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
@RequestMapping("khoahoc")
public class KhoahocController {

    @Autowired
    private KhoaHocService khoaHocService;

    @GetMapping("getAllKh")
    public List<KhoaHoc> getLoaiKhoaHoc() {
        return khoaHocService.getAllKhoaHoc();
    }

    @PostMapping("addKh")
    public ResponseEntity<String> addLKh(@RequestBody KhoaHoc khoaHoc) {
        khoaHocService.addKhoaHoc(khoaHoc);
        return ResponseEntity.ok("Add Khoa học thành công");
    }

    @PutMapping("updateKh")
    public KhoaHoc updatelkh(@RequestBody KhoaHoc khoaHoc) {
//        return ResponseEntity.ok("Update success");
        return khoaHocService.updateKhoaHoc(khoaHoc);
    }

    @DeleteMapping("deleteLkh/{id}")
    public ResponseEntity<String> deleteLkh(@PathVariable int id) {
        khoaHocService.deleteKHoc(id);
        return ResponseEntity.ok("Delete success");
    }

    @GetMapping("searchTenKhoaHoc")
    public List<KhoaHoc> searchTenKhoaHoc(@RequestParam String tenKhoaHoc) {
        return khoaHocService.findByTenKhoaHoc(tenKhoaHoc);
    }

    @GetMapping("phanTrang")
    public List<KhoaHoc> phanTrang(Integer number, Integer size) {
        if (number == null) {
            number = 0;
        }
        if (size == null) {
            size = 5;
        }
        Pageable khoaHocs = PageRequest.of(number, size);
        return khoaHocService.getAllKhoaHocList(khoaHocs);
    }
}
