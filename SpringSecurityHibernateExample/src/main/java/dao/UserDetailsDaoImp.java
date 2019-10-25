package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.User;

@Repository
public class UserDetailsDaoImp implements UserDetailsDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User findUserByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		User user = null;
		user = sessionFactory.getCurrentSession().get(User.class, username);
		tx.commit();
		
		return user;
	}
}