package com.example.FirstSpring.Service;

import com.example.FirstSpring.Entity.Employee;
import com.example.FirstSpring.Entity.Spouse;
import com.example.FirstSpring.Entity.SpouseDTO;
import com.example.FirstSpring.Repository.SpouseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SpouseService {
    @Autowired
    SpouseRepository spouseRepository;

    public List<Spouse> getAllSpouses() {
        return spouseRepository.findAll();
    }

    public Spouse getSpouse(int id) throws Exception {
        if (!spouseRepository.existsById(id)) {
            throw new Exception("getSpouse(): Incorrect ID!");
        }
        return spouseRepository.findById(id).get();
    }

    public void createSpouse(Spouse spouse) {
        spouseRepository.save(spouse);
    }

    public void updateSpouse(int id, Spouse spouse) throws Exception {
        if (!spouseRepository.existsById(id)) {
            throw new Exception("updateSpouse(): Incorrect ID!");
        }
        if (spouse.getAge() < 18) {
            throw new Exception("Validation Error: Spouse age must be over 18!");
        }
        if (spouse.getPhone().length() < 10) {
            throw new Exception("Validation Error: Phone numbers must contain 10 digits!");
        }
        Spouse spouseToUpdate = spouseRepository.getOne(id);
        spouseToUpdate.setAge(spouse.getAge());
        spouseToUpdate.setName(spouse.getName());
        spouseToUpdate.setPhone(spouse.getPhone());
        spouseToUpdate.setWorking(spouse.isWorking());
        spouseRepository.save(spouseToUpdate);
    }

    public void deleteSpouse(int id) throws Exception {
        if (!spouseRepository.existsById(id)) {
            throw new Exception("deleteSpouse(): Incorrect ID!");
        }
        spouseRepository.deleteById(id);
    }

    public List<Spouse> findSpouseByAge(int age) {
        return spouseRepository.findByAgeGreaterThan(age);
    }

    public List<Spouse> findSpouseByAgeImpl(int age) {
        List<Spouse> spouseList = new ArrayList<>();
        spouseList = spouseRepository.findAll().stream()
                .filter(s -> s.getAge() > age)
                .sorted(Comparator.comparingInt(Spouse::getAge))
                .collect(Collectors.toList());
        return spouseList;
    }

    public List<SpouseDTO> getComparison() {
        return spouseRepository.findAll().stream()
                .map(spouse -> new SpouseDTO(spouse.getId(), spouse.getName(), spouse.getPhone(), spouse.getAge(), spouse.isWorking()))
                .sorted().collect(Collectors.toList());
    }
}
