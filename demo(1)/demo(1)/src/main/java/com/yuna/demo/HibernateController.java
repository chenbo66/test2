package com.yuna.demo;

import com.yuna.entity.Fruits;
import com.yuna.repostitory.FruitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hibernate")
public class HibernateController {

    @Autowired
    private FruitsRepository fruitsRepository;

    @RequestMapping("/getFruitsById")
    @ResponseBody
    public Fruits getFruitsById(Long id) {
        Fruits u = fruitsRepository.findById(id).get();
        System.out.println("userRepository: " + fruitsRepository);
        System.out.println("id: " + id);
        return u;
    }


    @RequestMapping("saveFruits")
    @ResponseBody
    public void saveFruits() {
        Fruits fruitsEntity = new Fruits();
        fruitsEntity.setName("苹果");
        fruitsEntity.setPrice(10.9f);

        fruitsRepository.save(fruitsEntity);
    }
}
