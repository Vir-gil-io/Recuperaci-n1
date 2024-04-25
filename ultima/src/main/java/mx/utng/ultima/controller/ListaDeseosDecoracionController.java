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
import mx.utng.ultima.model.entity.ListaDeseosDecoracion;
import mx.utng.ultima.model.service.IListaDeseosDecoracionService;


@Controller
@SessionAttributes("listaDeseosDecoracion")
public class ListaDeseosDecoracionController {
    
    @Autowired
    private IListaDeseosDecoracionService service;

    @GetMapping({"/listaDeseosDecoracion", "/listaDeseosDecoracion/", "/listaDeseosDecoracion/list"})
    public String list(Model model){
        model.addAttribute("title", "Lista de Deseos de Decoración");
        model.addAttribute("listasDeseosDecoracion", service.list());
        return "listaDeseosDecoracion-list";
    }

    @GetMapping("/listaDeseosDecoracion/form")
    public String create(Model model){
        model.addAttribute("title", "Lista de Deseos de Decoración");
        model.addAttribute("listaDeseosDecoracion", new ListaDeseosDecoracion());
        return "listaDeseosDecoracion-form";
    }

    @PostMapping("/listaDeseosDecoracion/form")
    public String save(@Valid ListaDeseosDecoracion listaDeseosDecoracion, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Lista de Deseos de Decoracion");
            return "listaDeseosDecoracion-form";
        }
        service.save(listaDeseosDecoracion);
        return "redirect:/listaDeseosDecoracion/list";
    }

    @GetMapping("/listaDeseosDecoracion/form/{id}")
    public String update(@PathVariable Long id, Model model){
        ListaDeseosDecoracion listaDeseosDecoracion = null;
        if(id>0){
            listaDeseosDecoracion = service.getById(id);
        }else{
            return "redirect:/listaDeseosDecoracion/list";
        }
        model.addAttribute("title", "Editar Lista de Deseos de Decoracion");
        model.addAttribute("listaDeseosDecoracion", listaDeseosDecoracion);
        return "listaDeseosDecoracion-form";
    }

    @GetMapping("/listaDeseosDecoracion/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if(id > 0){
            service.delete(id);
        }
        return "redirect:/listaDeseosDecoracion/list";
    }



}