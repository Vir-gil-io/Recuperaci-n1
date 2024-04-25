package mx.utng.ultima.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mx.utng.ultima.model.entity.RegistroGastosRestaurantes;

 @Repository
 public class RegistroGastosRestaurantesDaoImpl implements IRegistroGastosRestaurantesDao {
 
     @PersistenceContext
     private EntityManager entityManager;
 

     @SuppressWarnings("unchecked")
    @Override
     public List<RegistroGastosRestaurantes> list() {
         return entityManager.createQuery("From RegistroGastosRestaurantes").
         getResultList();
     }
 
     @Override
     public void save(RegistroGastosRestaurantes registroGastosRestaurantes) {
         System.out.println("registroGastosRestaurantes id=" + registroGastosRestaurantes.getId());
         if (registroGastosRestaurantes.getId() != null && registroGastosRestaurantes.getId() > 0) {
             // Actualizo la entidad existente
             entityManager.merge(registroGastosRestaurantes);
         } else {
             // Creo una nueva entidad en la base de datos
             entityManager.persist(registroGastosRestaurantes);
         }
     }
 
     @Override
     public RegistroGastosRestaurantes getById(Long id) {
         return entityManager.find(RegistroGastosRestaurantes.class, id);
     }
 
     @Override
     public void delete(Long id) {
        RegistroGastosRestaurantes registroGastosRestaurantes = getById(id);
         entityManager.remove(registroGastosRestaurantes);
     }
 }