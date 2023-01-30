package ua.jemm.webMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.jemm.webMVC.dao.PersonDAO;
import ua.jemm.webMVC.model.Person;

@Controller
@RequestMapping("/people")
public class PeopleController {
    private PersonDAO personDAO;

    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("people", personDAO.getAll());
        return "people/all";
    }

    @GetMapping("/{id}")
    public String getById(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", personDAO.getBiId(id));
        return "people/id";
    }

    @GetMapping("/new")
//    public String newPerson(@ModelAttribute Person person) {
    public String newPerson(Model model) {
        model.addAttribute("people", new Person());
        return "/people/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") Person person) {
        personDAO.save(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", personDAO.getBiId(id));
        return "/people/edit";
    }

    @PatchMapping("/{id}")
    public String patch(@ModelAttribute("person") Person person, @PathVariable("id") int id) {
        System.out.println("patch");
        personDAO.update(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        personDAO.delete(id);
        return "redirect:/people";
    }

}
