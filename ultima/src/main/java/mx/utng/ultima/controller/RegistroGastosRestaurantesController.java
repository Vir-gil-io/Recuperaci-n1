package mx.utng.ultima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import jakarta.validation.Valid;
import mx.utng.ultima.model.entity.RegistroGastosRestaurantes;
import mx.utng.ultima.model.service.IRegistroGastosRestaurantesService;


@Controller
@SessionAttributes("registroGastosRestaurantes")
public class RegistroGastosRestaurantesController {
    
    @Autowired
    private IRegistroGastosRestaurantesService service;

    @GetMapping({"/registroGastosRestaurantes", "/registroGastosRestaurantes/", "/registroGastosRestaurantes/list"})
    public String list(Model model){
        model.addAttribute("title", "Registro de Gastos de Restaurantes");
        model.addAttribute("registrosGastosRestaurantes", service.list());
        return "registroGastosRestaurantes-list";
    }

    @GetMapping("/registroGastosRestaurantes/form")
    public String create(Model model){
        model.addAttribute("title", "Registro de Gastos de Restaurantes");
        model.addAttribute("registroGastosRestaurantes", new RegistroGastosRestaurantes());
        return "registroGastosRestaurantes-form";
    }

    @PostMapping("/registroGastosRestaurantes/form")
    public String save(@Valid RegistroGastosRestaurantes registroGastosRestaurantes, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Registro de Gastos de Restaurantes");
            return "registroGastosRestaurantes-form";
        }
        service.save(registroGastosRestaurantes);
        return "redirect:/registroGastosRestaurantes/list";
    }

    @GetMapping("/registroGastosRestaurantes/form/{id}")
    public String update(@PathVariable Long id, Model model){
        RegistroGastosRestaurantes registroGastosRestaurantes = null;
        if(id>0){
            registroGastosRestaurantes = service.getById(id);
        }else{
            return "redirect:/registroGastosRestaurantes/list";
        }
        model.addAttribute("title", "Editar Registro de Gastos de Restaurantes");
        model.addAttribute("registroGastosRestaurantes", registroGastosRestaurantes);
        return "registroGastosRestaurantes-form";
    }

    @GetMapping("/registroGastosRestaurantes/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if(id > 0){
            service.delete(id);
        }
        return "redirect:/registroGastosRestaurantes/list";
    }



}