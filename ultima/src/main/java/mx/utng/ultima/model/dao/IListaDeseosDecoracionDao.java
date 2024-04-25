package mx.utng.ultima.model.dao;

import java.util.List;

import mx.utng.ultima.model.entity.ListaDeseosDecoracion;

public interface IListaDeseosDecoracionDao {
    List<ListaDeseosDecoracion> list();
    void save(ListaDeseosDecoracion listaDeseosDecoracion);
    ListaDeseosDecoracion getById(Long id);
    void delete(Long id);
}
