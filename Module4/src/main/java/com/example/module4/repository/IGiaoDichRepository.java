package com.example.module4.repository;

import com.example.module4.model.GiaoDich;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IGiaoDichRepository extends JpaRepository<GiaoDich, Integer> {

    @Query(value="select * from giao_dich where khach_hang like concat(\"%\" , ? , \"%\") and loai_dich_vu like concat(\"%\" , ? , \"%\");", nativeQuery=true)
    List<GiaoDich> findByKhachHangAndAndLoaiDichVu(String khachHang, String dichVu);
}
