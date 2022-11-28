package codegym.vn.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import codegym.vn.bean.Declaration;

public class DeclarationImpl implements DeclarationService {
    private static Map<Integer, Declaration> toKhaiYTeMap;

    static {
        toKhaiYTeMap = new HashMap<>();
        toKhaiYTeMap.put(1, new Declaration(1, "Toàn", "nam", "vn", "123", "xe", "123", "123", "123", "123", "123", "123", "123", "123", "123", "123", "123", true, true, true, true, true, true, true, true, true, true));
    }


    @Override
    public List<Declaration> findAll() {
        return new ArrayList<>(toKhaiYTeMap.values());
    }

    @Override
    public void save(Declaration toKhaiYTe) {
        toKhaiYTeMap.put(toKhaiYTe.getId(), toKhaiYTe);

    }

    @Override
    public Declaration findById(int id) {
        return toKhaiYTeMap.get(id);
    }


    @Override
    public void update(int id, Declaration toKhaiYTe) {
        toKhaiYTeMap.put(toKhaiYTe.getId(), toKhaiYTe);
    }

    @Override
    public void deleteById(int id) {
        toKhaiYTeMap.remove(id);
    }
}
