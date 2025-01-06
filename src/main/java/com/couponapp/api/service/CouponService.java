package com.couponapp.api.service;

import com.couponapp.api.entity.Coupon;
import com.couponapp.api.repository.CouponRepository;
import com.couponapp.api.util.ExcelHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

@Service
public class CouponService {
    @Autowired
    private CouponRepository couponRepository;

    // For get all coupon data
    public List<Coupon> getAllCoupons() {
        return couponRepository.findAll();
    }

    // For add coupon data using coupon object
    public boolean addCoupon(Coupon coupon) {
        try {
            couponRepository.save(coupon);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    // For update coupon data using coupon object id
    public boolean updateCoupon(Coupon coupon) {

        if (couponRepository.existsById(coupon.getId())) {
            couponRepository.save(coupon);
            return true;
        }
        return false;
    }

    // For add all coupon data from Excel file
    public boolean saveExcelData(MultipartFile file) {
        if (file.isEmpty()) {
            return false;
        }
        try {
            InputStream inputStream = file.getInputStream();
            List<Coupon> coupons = ExcelHelper.parseExcel(inputStream);
            couponRepository.saveAll(coupons);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
