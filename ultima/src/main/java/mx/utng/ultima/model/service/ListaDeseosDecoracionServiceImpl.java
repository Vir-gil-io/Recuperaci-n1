package mx.utng.ultima.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.ultima.model.dao.IListaDeseosDecoracionDao;
import mx.utng.ultima.model.entity.ListaDeseosDecoracion;

/*
 * Una clase service, esta basada en el patrón de diseño fachada
 * Es un único punto de acceso hacia los DAOs. Dentro de la clase
 * service , podemos operar con distintas clases DAO
 */
@Service
public class ListaDeseosDecoracionServiceImpl implements IListaDeseosDecoracionService{

    //Inyectamos la interfaz para utilizar los métodos de CRUD
    //C-Create, R-Read Retrieve, U-Update, D-Delete
    @Autowired
    private IListaDeseosDecoracionDao dao;


    @Transactional(readOnly = true)
    @Override
    public List<ListaDeseosDecoracion> list() {
        return dao.list();
    }

    @Transactional
    @Override
    public void save(ListaDeseosDecoracion listaDeseosDecoracion) {
        dao.save(listaDeseosDecoracion);
    }

    @Transactional(readOnly = true)
    @Override
    public ListaDeseosDecoracion getById(Long id) {
        return dao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }
   
}