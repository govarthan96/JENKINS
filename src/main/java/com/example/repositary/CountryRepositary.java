package com.example.repositary;

import com.example.domain.Country;
import com.example.dto.CountryViewData1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CountryRepositary extends JpaRepository<Country,Long> {

    @Query(value = "SELECT cn FROM Country cn")
    List<CountryViewData> getCountrtyViewData();
}
