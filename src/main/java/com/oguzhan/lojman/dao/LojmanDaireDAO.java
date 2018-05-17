package com.oguzhan.lojman.dao;

import com.oguzhan.lojman.model.LojmanDairesi;
import com.oguzhan.lojman.model.LojmanDairesi;
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
public class LojmanDaireDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    //Daire ekle ya da güncelle

    public boolean saveOrUpdateObject(Object object) {
        getCurrentSession().saveOrUpdate(object);
        return true;
    }

    //Daireyi sil
    public boolean removeObject(LojmanDairesi lojmanDairesi) {
        getCurrentSession().remove(lojmanDairesi);
        return true;
    }

    //Bütün daireleri listele
    public List<LojmanDairesi> loadDaireler() {
        Session currentSession = getCurrentSession();
        CriteriaBuilder criteriaBuilder = currentSession.getCriteriaBuilder();
        CriteriaQuery<LojmanDairesi> criteriaQuery = criteriaBuilder.createQuery(LojmanDairesi.class);
        Root<LojmanDairesi> root = criteriaQuery.from(LojmanDairesi.class);
        criteriaQuery.select(root);

        Query<LojmanDairesi> query = currentSession.createQuery(criteriaQuery);

        List<LojmanDairesi> daireList = query.getResultList();
        return daireList;
    }

    //ID değerine göre daireleri listele
    public LojmanDairesi loadDaireById(Long id) {
        Session currentSession = getCurrentSession();
        CriteriaBuilder criteriaBuilder = currentSession.getCriteriaBuilder();
        CriteriaQuery<LojmanDairesi> criteriaQuery = criteriaBuilder.createQuery(LojmanDairesi.class);
        Root<LojmanDairesi> root = criteriaQuery.from(LojmanDairesi.class);

        Predicate predicateURL = criteriaBuilder.equal(root.get("id"), id);
        criteriaQuery.select(root).where(predicateURL);
        criteriaQuery.distinct(true);

        Query<LojmanDairesi> query = currentSession.createQuery(criteriaQuery);
        LojmanDairesi daire = query.getSingleResult();
        return daire;
    }
    
}
