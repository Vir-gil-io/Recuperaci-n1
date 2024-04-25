package mx.utng.ultima.model.dao;

import java.util.List;

import mx.utng.ultima.model.entity.RegistroGastosRestaurantes;

public interface IRegistroGastosRestaurantesDao {
    List<RegistroGastosRestaurantes> list();
    void save(RegistroGastosRestaurantes registroGastosRestaurantes);
    RegistroGastosRestaurantes getById(Long id);
    void delete(Long id);
}
