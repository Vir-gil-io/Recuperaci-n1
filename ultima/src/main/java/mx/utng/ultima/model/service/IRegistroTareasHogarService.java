package mx.utng.ultima.model.service;

import mx.utng.ultima.model.entity.RegistroTareasHogar;

import java.util.List;

public interface IRegistroTareasHogarService {
    List<RegistroTareasHogar> list();
    void save(RegistroTareasHogar registroTareasHogar);
    RegistroTareasHogar getById(Long id);
    void delete(Long id);
}