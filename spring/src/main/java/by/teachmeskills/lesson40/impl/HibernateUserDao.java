package by.teachmeskills.lesson40.impl;

import by.teachmeskills.lesson40.dao.UserDao;
import by.teachmeskills.lesson40.entity.User;
import com.mysql.cj.Session;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class HibernateUserDao implements UserDao {
    private final SessionFactory sessionFactory;

    @Override
    public List<User> getAll() {
        Session currentSession = (Session) sessionFactory.getCurrentSession();
        return currentSession.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public Optional<User> getByName(Long name) {
        Session currentSession = (Session) sessionFactory.getCurrentSession();
        return Optional.ofNullable(currentSession.get(User.class, name));
    }
    @Override
    public User save(User user) {
        Session currentSession = (Session) sessionFactory.getCurrentSession();
        Long name = (Long) currentSession.save(user);
        user.setName(String.valueOf(name));
        return user;
    }
    @Override
    public User remove(User user) {
        Session currentSession = (Session) sessionFactory.getCurrentSession();
        currentSession.remove(user);
        return user;
    }
    @Override
    public void delete(Long id) {
        Session currentSession = (Session) sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = currentSession.getCriteriaBuilder();
        CriteriaDelete<User> criteriaDelete = criteriaBuilder.createCriteriaDelete(User.class);
        Root<User> root = criteriaDelete.from(User.class);
        criteriaDelete.where(criteriaBuilder.equal(root.get("name"), name));
        currentSession.createQuery(criteriaDelete).executeUpdate();
    }
}
