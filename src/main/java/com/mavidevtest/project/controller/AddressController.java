package com.mavidevtest.project.controller;

import com.mavidevtest.project.model.Address;
import com.mavidevtest.project.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
public class AddressController {
    @Autowired
    final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @RequestMapping("/")
    public String viewHomePage(Model model)
    {
        return "index";
    }
    @RequestMapping("/locations")
    public String showAddressPage(Model model,String keyword) {
        if(keyword != null)
        {
            model.addAttribute("listLocations",addressService.findByKeyword(keyword));
        }
        else
        {
            model.addAttribute("listLocations", addressService.listAll());
        }
        return "locations";
    }


    @RequestMapping("/locations/edit/{id}")
    public ModelAndView EditAddressPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("editAddress");
        Address location = addressService.get(id);
        mav.addObject("location", location);

        return mav;
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveAdress(@ModelAttribute("address") Address address, Model model) {
        addressService.save(address);
        return "redirect:/locations";

    }

    @RequestMapping("/locations/add")
    public String showNewLocationPage(Model model) {
        Address address = new Address();
        model.addAttribute("address", address);

        return "addAddress";
    }
    @RequestMapping("/locations/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        addressService.delete(id);

        return "redirect:/locations";
    }
}
