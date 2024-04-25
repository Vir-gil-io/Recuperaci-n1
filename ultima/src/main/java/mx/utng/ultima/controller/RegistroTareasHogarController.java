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
import mx.utng.ultima.model.entity.RegistroTareasHogar;
import mx.utng.ultima.model.service.IRegistroTareasHogarService;


@Controller
@SessionAttributes("registroTareasHogar")
public class RegistroTareasHogarController {
    
    @Autowired
    private IRegistroTareasHogarService service;

    @GetMapping({"/registroTareasHogar", "/registroTareasHogar/", "/registroTareasHogar/list"})
    public String list(Model model){
        model.addAttribute("title", "Registro de Tareas del Hogar");
        model.addAttribute("registrosTareasHogar", service.list());
        return "registroTareasHogar-list";
    }

    @GetMapping("/registroTareasHogar/form")
    public String create(Model model){
        model.addAttribute("title", "Registro de Tareas del Hogar");
        model.addAttribute("registroTareasHogar", new RegistroTareasHogar());
        return "registroTareasHogar-form";
    }

    @PostMapping("/registroTareasHogar/form")
    public String save(@Valid RegistroTareasHogar registroTareasHogar, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Registro de Tareas del Hogar");
            return "registroTareasHogar-form";
        }
        service.save(registroTareasHogar);
        return "redirect:/registroTareasHogar/list";
    }

    @GetMapping("/registroTareasHogar/form/{id}")
    public String update(@PathVariable Long id, Model model){
        RegistroTareasHogar registroTareasHogar = null;
        if(id>0){
            registroTareasHogar = service.getById(id);
        }else{
            return "redirect:/registroTareasHogar/list";
        }
        model.addAttribute("title", "Editar Registro de Tareas del Hogar");
        model.addAttribute("registroTareasHogar", registroTareasHogar);
        return "registroTareasHogar-form";
    }

    @GetMapping("/registroTareasHogar/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if(id > 0){
            service.delete(id);
        }
        return "redirect:/registroTareasHogar/list";
    }



}