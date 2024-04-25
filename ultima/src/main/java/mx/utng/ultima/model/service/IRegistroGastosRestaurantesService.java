package mx.utng.ultima.model.service;

import mx.utng.ultima.model.entity.RegistroGastosRestaurantes;
import java.util.List;

public interface IRegistroGastosRestaurantesService {
    List<RegistroGastosRestaurantes> list();
    void save(RegistroGastosRestaurantes registroGastosRestaurantes);
    RegistroGastosRestaurantes getById(Long id);
    void delete(Long id);
}