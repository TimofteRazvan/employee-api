package com.example.FirstSpring.Controller;

import com.example.FirstSpring.Entity.Employee;
import com.example.FirstSpring.Entity.Spouse;
import com.example.FirstSpring.Entity.Spouse;
import com.example.FirstSpring.Entity.SpouseDTO;
import com.example.FirstSpring.Service.SpouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
public class SpouseController {
    @Autowired
    SpouseService spouseService;

    @GetMapping("/spouses")
    public List<Integer> findAllSpouses() {
        List<Spouse> spouseList = spouseService.getAllSpouses();
        ArrayList<Integer> idList = new ArrayList<>();
        for (Spouse spouse : spouseList) {
            idList.add(spouse.getId());
        }
        return idList;
    }

    @GetMapping("/spouses-details")
    public List<Spouse> findAllSpousesDetails() {
        return spouseService.getAllSpouses();
    }

    @GetMapping("/spouses/{id}")
    public Spouse findSpouse(@PathVariable int id) {
        try {
            return spouseService.getSpouse(id);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping("/spouses")
    public void createSpouse(@RequestBody Spouse spouse) {
        spouseService.createSpouse(spouse);
    }

    @PutMapping("/spouses/{id}")
    public void updateSpouse(@PathVariable int id, @RequestBody Spouse spouse) {
        try {
            spouseService.updateSpouse(id, spouse);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @DeleteMapping("/spouses/{id}")
    public void deleteSpouse(@PathVariable int id) {
        try {
            spouseService.deleteSpouse(id);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @GetMapping("/spouses/filter/age/{age}")
    public List<Spouse> findSpouseByAge(@PathVariable int age) {
        return spouseService.findSpouseByAge(age);
    }

    @GetMapping("/spouses/compare/age")
    public List<SpouseDTO> getComparison() {
        return spouseService.getComparison();
    }
}
