package peaksoft.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.Entity.Company;
import peaksoft.servise.serviseImpl.ServiseCompanyImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequestMapping
public class MyController {

    private final ServiseCompanyImpl serviseCompany;

    @Autowired
    public MyController(ServiseCompanyImpl serviseCompany) {
        this.serviseCompany = serviseCompany;
    }

    @ModelAttribute("CompanyList")
    public List<Company> getAllCompany() {
        return serviseCompany.getAllCompany();
    }

    //main page
    @GetMapping("/")
    public String showMain() {
        return "main_page";
    }

    @GetMapping("/saveCompany")
    public String showSaveCompanyForm(Model theModel) {
        theModel.addAttribute("t", "A");
        theModel.addAttribute("company", new Company());
        return "save_company";
    }

    //save user to db
    @PostMapping("/saveCompany")
    public String saveToDB(@ModelAttribute("company") Company company) {
        serviseCompany.save(company);
        return "redirect:/";
    }

    //delete
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, Model theModel) {

        //get from database
        serviseCompany.deleteById(id);

        return "redirect:/";
    }

    //update]
    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable("id") long id ) {
        model.addAttribute("company",serviseCompany.getById(id));
        return "updateCompany";
}
    @RequestMapping("/saveUpdateCompany")
    public String saveUpdateCompany(@ModelAttribute("company") Company company){
        serviseCompany.Update(company);
        return "redirect:/";
    }

}
