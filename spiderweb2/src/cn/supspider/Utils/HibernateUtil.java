package cn.supspider.Utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
		private static final Configuration config;
		private static final SessionFactory sessionFactory;
		
		static {
			config=new Configuration().configure();
			sessionFactory=config.buildSessionFactory();
		}
		
		public static SessionFactory getSessionFactory() {
			return sessionFactory;
		}
}
