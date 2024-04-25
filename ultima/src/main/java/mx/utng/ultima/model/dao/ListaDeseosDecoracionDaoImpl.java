package mx.utng.ultima.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mx.utng.ultima.model.entity.ListaDeseosDecoracion;

 @Repository
 public class ListaDeseosDecoracionDaoImpl implements IListaDeseosDecoracionDao {
 
     @PersistenceContext
     private EntityManager entityManager;
 

     @SuppressWarnings("unchecked")
    @Override
     public List<ListaDeseosDecoracion> list() {
         return entityManager.createQuery("From ListaDeseosDecoracion").
         getResultList();
     }
 
     @Override
     public void save(ListaDeseosDecoracion listaDeseosDecoracion) {
         System.out.println("listaDeseosDecoracion id=" + listaDeseosDecoracion.getId());
         if (listaDeseosDecoracion.getId() != null && listaDeseosDecoracion.getId() > 0) {
             // Actualizo la entidad existente
             entityManager.merge(listaDeseosDecoracion);
         } else {
             // Creo una nueva entidad en la base de datos
             entityManager.persist(listaDeseosDecoracion);
         }
     }
 
     @Override
     public ListaDeseosDecoracion getById(Long id) {
         return entityManager.find(ListaDeseosDecoracion.class, id);
     }
 
     @Override
     public void delete(Long id) {
        ListaDeseosDecoracion listaDeseosDecoracion = getById(id);
         entityManager.remove(listaDeseosDecoracion);
     }
 }