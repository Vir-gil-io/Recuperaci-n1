package mx.utng.ultima.model.dao;

import java.util.List;

import mx.utng.ultima.model.entity.RegistroTareasHogar;

public interface IRegistroTareasHogarDao {
    List<RegistroTareasHogar> list();
    void save(RegistroTareasHogar registroTareasHogar);
    RegistroTareasHogar getById(Long id);
    void delete(Long id);
}
