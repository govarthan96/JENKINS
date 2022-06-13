package com.example.contoller;

import com.example.domain.Country;
import com.example.dto.CountryFormDto;
import com.example.repositary.CountryViewData;
import com.example.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    ResponseEntity<List<Country> >getAll(){

        return ResponseEntity.ok(countryService.getAll());
    }

    @PostMapping
    ResponseEntity<String> createCountry(@RequestBody List<CountryFormDto> countryFormDto){

        return ResponseEntity.ok(countryService.createNewCountry(countryFormDto));
    }

    @GetMapping("/{id}")
    ResponseEntity<Country> getOne(@PathVariable Long id){

        return ResponseEntity.ok(countryService.getOne(id));
    }

    @PutMapping()
    ResponseEntity<String> updateCountry(@RequestParam(name = "id")Long id,@RequestBody CountryFormDto countryFormDto){

        return ResponseEntity.ok(countryService.updateCountry(id,countryFormDto));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Boolean> deleteCountry(@PathVariable Long id){

        return ResponseEntity.ok(countryService.deleteCountry(id));
    }

    @GetMapping("/view")
    ResponseEntity<List<CountryViewData>> getViewData(){

        return ResponseEntity.ok(countryService.getCountyrViewData());
    }

}
