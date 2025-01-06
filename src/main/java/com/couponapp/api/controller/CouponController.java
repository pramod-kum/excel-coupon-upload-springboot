package com.couponapp.api.controller;

import com.couponapp.api.entity.Coupon;
import com.couponapp.api.repository.CouponRepository;
import com.couponapp.api.service.CouponService;
import com.couponapp.api.util.ExcelHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CouponController {

    @Autowired
    private CouponRepository couponRepository;

    @Autowired
    private CouponService couponService;

    // List all coupons
    @GetMapping("/coupons")
    public List<Coupon> listAllCoupons() {

        return couponService.getAllCoupons();
    }

    // Create a coupon
    @PostMapping("/coupon")
    public ResponseEntity<Boolean> createCoupon(@RequestBody Coupon coupon) {
        boolean flag = couponService.addCoupon(coupon);
        if (flag) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.ok(false);
        }
    }

    // Update a coupon
    @PutMapping("/coupon")
    public ResponseEntity<Boolean> updateCoupon(@RequestBody Coupon coupon) {
        boolean flag = couponService.updateCoupon(coupon);
        if (flag) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.ok(false);
        }
    }

    // Upload Excel to create coupons
    @PostMapping("/upload")
    public ResponseEntity<Boolean> uploadCoupons(@RequestParam("file") MultipartFile file) {
        boolean flag = couponService.saveExcelData(file);
        if (flag) {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.ok(false);
    }
}
