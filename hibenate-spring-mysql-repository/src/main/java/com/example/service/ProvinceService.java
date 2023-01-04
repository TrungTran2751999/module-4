package com.example.service;

import com.example.model.Customer;
import com.example.model.Province;
import com.example.repository.IProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProvinceService implements IProvinceService {
    @Autowired
    private IProvinceRepository provinceRepository;
    @Override
    public List<Province> findAll() {
        List<Province> provinces = provinceRepository.findAll();
        return provinces;
    }

    @Override
    public Optional<Province> findById(long id) {
        Optional<Province> province = provinceRepository.findById(id);
        return province;
    }

    @Override
    public void save(Province province) {
        provinceRepository.save(province);
    }

    @Override
    public void remove(long id) {
        provinceRepository.deleteById(id);
    }
}
