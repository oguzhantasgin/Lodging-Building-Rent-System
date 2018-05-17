package com.oguzhan.lojman.service;

import com.oguzhan.lojman.dao.LojmanBlokDAO;
import com.oguzhan.lojman.model.LojmanBlok;
import com.oguzhan.lojman.model.LojmanDairesi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("blokService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class BlokService {

    @Autowired
    private LojmanBlokDAO dao;

    public List<LojmanBlok> loadBloklar() {
        return dao.loadBloklar();
    }

    public LojmanBlok loadBlokById(Long id) {
        return dao.loadBlokById(id);
    }

    public void saveOrUpdateBlok(LojmanBlok blok) {

        dao.saveOrUpdateObject(blok);
    }

    public boolean removeBlok(LojmanBlok blok) {
        return dao.removeObject(blok);
    }

}
