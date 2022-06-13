package com.example.service;

import com.example.domain.Country;
import com.example.dto.CountryFormDto;
import com.example.dto.CountryViewData1;
import com.example.repositary.CountryRepositary;
import com.example.repositary.CountryViewData;
import com.example.service.exception.CountryNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(Transactional.TxType.REQUIRES_NEW)
public class CountryServiceImpl implements CountryService{

    @Autowired
    private CountryRepositary countryRepositary;


    @Override
    public List<Country> getAll() {
        return countryRepositary.findAll();
    }

    @Override
    public String createNewCountry(List<CountryFormDto> countryFormDtos) {
        String response="update fail";
        ModelMapper modelMapper=new ModelMapper();
        List<Country> countries=new ArrayList<>();

        for(CountryFormDto countryFormDto: countryFormDtos){
        Country country=modelMapper.map(countryFormDto,Country.class);
            countries.add(country);
        }
        countryRepositary.saveAll(countries);
        return "Updated Successfully";
    }

    @Override
    public Country getOne(Long id) {
        return getCountry(id);
    }

    @Override
    public String updateCountry(Long id, CountryFormDto countryFormDto) {
        String response="Country not exist";

        ModelMapper modelMapper=new ModelMapper();
        Country country=getCountry(id);

        if(country!=null){
            countryRepositary.save(modelMapper.map(countryFormDto,Country.class));
            response="Updated Succesfully";
        }
        return response;
    }

    @Override
    public boolean deleteCountry(Long id) {
        boolean isDelete=false;
        if(countryRepositary.existsById(id)){
            countryRepositary.deleteById(id);
            isDelete=true;
        }
        return isDelete;
    }

    @Override
    public List<CountryViewData> getCountyrViewData() {
        return countryRepositary.getCountrtyViewData();
    }

    protected Country getCountry(Long id){
        return countryRepositary.findById(id).orElseThrow(() -> new CountryNotFoundException("Country Not found for given Id"));
    }


}
