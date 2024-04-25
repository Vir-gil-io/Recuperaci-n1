package mx.utng.ultima.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.ultima.model.dao.IRegistroTareasHogarDao;
import mx.utng.ultima.model.entity.RegistroTareasHogar;

/*
 * Una clase service, esta basada en el patrón de diseño fachada
 * Es un único punto de acceso hacia los DAOs. Dentro de la clase
 * service , podemos operar con distintas clases DAO
 */
@Service
public class RegistroTareasHogarServiceImpl implements IRegistroTareasHogarService{

    //Inyectamos la interfaz para utilizar los métodos de CRUD
    //C-Create, R-Read Retrieve, U-Update, D-Delete
    @Autowired
    private IRegistroTareasHogarDao dao;


    @Transactional(readOnly = true)
    @Override
    public List<RegistroTareasHogar> list() {
        return dao.list();
    }

    @Transactional
    @Override
    public void save(RegistroTareasHogar registroTareasHogar) {
        dao.save(registroTareasHogar);
    }

    @Transactional(readOnly = true)
    @Override
    public RegistroTareasHogar getById(Long id) {
        return dao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }
   
}