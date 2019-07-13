package com.zfwhub.tutorial.jdbc.dao;

import com.zfwhub.tutorial.jdbc.domain.User;

public class UserDaoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UserDao userDao = DaoFactory.getInstance().getUserDao();
		// System.out.println(userDao);
		//		
		// User user = new User();
		// user.setBirthday(new Date());
		// user.setName("dao name1");
		// user.setMoney(1000.0f);

		// userDao.addUser(user);

		// User u = userDao.findUser(user.getName(), null);
		// System.out.println(u.getId());

		User u = userDao.getUser(7);
		u.setMoney(20000.1f);
		userDao.update(u);

		// User u1 = userDao.getUser(8);
		// userDao.delete(u1);

	}

}
