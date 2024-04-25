package mx.utng.ultima.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
/*
 * Clase repositorio o dao, utilizare la 
 * anotacion @Repository
 */
import mx.utng.ultima.model.entity.RegistroTareasHogar;

 @Repository
 public class RegistroTareasHogarDaoImpl implements IRegistroTareasHogarDao {
 
     @PersistenceContext
     private EntityManager entityManager;
 

     @SuppressWarnings("unchecked")
    @Override
     public List<RegistroTareasHogar> list() {
         return entityManager.createQuery("From RegistroTareasHogar").
         getResultList();
     }
 
     @Override
     public void save(RegistroTareasHogar registroTareasHogar) {
         System.out.println("registroTareasHogar id=" + registroTareasHogar.getId());
         if (registroTareasHogar.getId() != null && registroTareasHogar.getId() > 0) {
             // Actualizo la entidad existente
             entityManager.merge(registroTareasHogar);
         } else {
             // Creo una nueva entidad en la base de datos
             entityManager.persist(registroTareasHogar);
         }
     }
 
     @Override
     public RegistroTareasHogar getById(Long id) {
         return entityManager.find(RegistroTareasHogar.class, id);
     }
 
     @Override
     public void delete(Long id) {
        RegistroTareasHogar registroTareasHogar = getById(id);
         entityManager.remove(registroTareasHogar);
     }
 }