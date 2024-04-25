package mx.utng.ultima.model.service;

import mx.utng.ultima.model.entity.ListaDeseosDecoracion;
import java.util.List;

public interface IListaDeseosDecoracionService {
    List<ListaDeseosDecoracion> list();
    void save(ListaDeseosDecoracion listaDeseosDecoracion);
    ListaDeseosDecoracion getById(Long id);
    void delete(Long id);
}