package com.example.service;

import com.example.domain.Country;
import com.example.dto.CountryFormDto;
import com.example.dto.CountryViewData1;
import com.example.repositary.CountryViewData;

import java.util.List;

public interface CountryService {

    List<Country> getAll();

    String createNewCountry(List<CountryFormDto> countryFormDto);

    Country getOne(Long id);

    String updateCountry(Long id,CountryFormDto countryFormDto);

    boolean deleteCountry(Long id);

    List<CountryViewData> getCountyrViewData();
}
