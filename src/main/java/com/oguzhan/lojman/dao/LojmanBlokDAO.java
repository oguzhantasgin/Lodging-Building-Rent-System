package com.oguzhan.lojman.dao;

import com.oguzhan.lojman.model.LojmanBlok;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class LojmanBlokDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    //Daireyi güncelle ya da kaydet
    public boolean saveOrUpdateObject(Object object) {
        getCurrentSession().saveOrUpdate(object);
        return true;
    }

    //Daireyi sil
    public boolean removeObject(LojmanBlok lojmanBlok) {
        getCurrentSession().remove(lojmanBlok);
        return true;
    }


    //Bütün blokları listele
    public List<LojmanBlok> loadBloklar() {
        Session currentSession = getCurrentSession();
        CriteriaBuilder criteriaBuilder = currentSession.getCriteriaBuilder();
        CriteriaQuery<LojmanBlok> criteriaQuery = criteriaBuilder.createQuery(LojmanBlok.class);
        Root<LojmanBlok> root = criteriaQuery.from(LojmanBlok.class);
        criteriaQuery.select(root);

        Query<LojmanBlok> query = currentSession.createQuery(criteriaQuery);

        List<LojmanBlok> blokList = query.getResultList();
        return blokList;
    }


    //ID değerine göre blok getir
    public LojmanBlok loadBlokById(Long id) {
        Session currentSession = getCurrentSession();
        CriteriaBuilder criteriaBuilder = currentSession.getCriteriaBuilder();
        CriteriaQuery<LojmanBlok> criteriaQuery = criteriaBuilder.createQuery(LojmanBlok.class);
        Root<LojmanBlok> root = criteriaQuery.from(LojmanBlok.class);

        Predicate predicateURL = criteriaBuilder.equal(root.get("id"), id);
        criteriaQuery.select(root).where(predicateURL);
        criteriaQuery.distinct(true);

        Query<LojmanBlok> query = currentSession.createQuery(criteriaQuery);
        LojmanBlok blok = query.getSingleResult();
        return blok;
    }
    
}
