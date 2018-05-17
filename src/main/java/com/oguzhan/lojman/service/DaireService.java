package com.oguzhan.lojman.service;

import com.oguzhan.lojman.dao.LojmanDaireDAO;
import com.oguzhan.lojman.model.LojmanDairesi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("daireService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class DaireService {

    @Autowired
    private LojmanDaireDAO dao;

    public void saveOrUpdateDaire(LojmanDairesi daire) {
        dao.saveOrUpdateObject(daire);
    }

    public boolean removeDaire(LojmanDairesi daire) {
        return dao.removeObject(daire);
    }

    public List<LojmanDairesi> loadDaireler() {
        return dao.loadDaireler();
    }

    public LojmanDairesi loadDaireById(Long id) {
        return dao.loadDaireById(id);
    }

}