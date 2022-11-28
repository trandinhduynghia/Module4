package codegym.vn.service;

import codegym.vn.bean.Declaration;

import java.util.List;

public interface DeclarationService {
    List<Declaration> findAll();

    void save(Declaration toKhaiYTe);

    Declaration findById(int id);


    void update(int id, Declaration toKhaiYTe);

    void deleteById(int id);
}
