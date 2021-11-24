package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
// request mapping dung de anh xa den cac pt xu ly cua mvc

public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("home")
    public String showList(Model model){
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customerList",customerList);
    return  "/index";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("customer",new Customer());
        return "/create";
    }
    @PostMapping("/save")
    public String save(Customer customer){
        customer.setId((int) (Math.random() * 1000));
        customerService.save(customer);
        return "redirect:/home";
    }
    // redirect la dua ve trang chu
    @GetMapping("customer/{id}/edit")
    public String edit (@PathVariable int id,Model model){
        model.addAttribute("customer",customerService.findCustomerById(id));
        return "/edit";
    }
    @GetMapping("customer/{id}/delete")
    public String delete(@PathVariable int id, Model model){
        model.addAttribute("customer",customerService.findCustomerById(id));
        return "/delete";
    }
    @PostMapping("customer/delete")
    public String delete(@RequestParam int id) {
        customerService.remove(id);
        return "redirect:/home";
    }
    @GetMapping("customer/{id}/view")
    public String view (@PathVariable int id,Model model){
        model.addAttribute("customer",customerService.findCustomerById(id));
        return "/view";

    }


}
