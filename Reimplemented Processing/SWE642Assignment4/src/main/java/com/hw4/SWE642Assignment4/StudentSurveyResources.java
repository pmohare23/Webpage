// Pratik Mohare

package com.hw4.SWE642Assignment4;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.dao.Students;
import com.bean.DataBean;
import com.dao.DataProcessor;

@Path("studentSurvey")
public class StudentSurveyResources {

	@GET
	@Path("records")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Students> getStudentSurveyRecords() {

		Session session = null;
		@SuppressWarnings("unchecked")
		List<Students> listOfRecords = null;
		try {
			session = getSession();
			Transaction tx = session.beginTransaction();

			Query q = session.createQuery("from Students order by recent_date desc");
			listOfRecords = q.list();

			//tx.commit();
		} catch (HibernateException e) {
			System.out.println("Failed");
			session.disconnect();
			session.close();
		}

		if (session != null) {
			session.disconnect();
			session.close();
		}
		System.out.println(listOfRecords);
		return listOfRecords;
	}

	@POST
	@Path("surveyEntry")
	public Students createStudentSurveyEntry(Students s1) {
		Session session = null;
		try {
			if (s1!=null) {
				System.out.print(s1.getStudentID());
			}
			DataProcessor dataProce = new DataProcessor();
			DataBean dataBean = dataProce.processNums(s1.getData());			
			s1.setMean(Double.toString(dataBean.getMean()));
			s1.setStd(Double.toString(dataBean.getStd()));
			session = getSession();
			Transaction tx = session.beginTransaction();
			session.save(s1);
			tx.commit();
		} catch (Exception e) {
			System.out.println(e + "error");
			session.disconnect();
			session.close();
			return null;
		}

		if (session != null) {
			session.disconnect();
			session.close();
		}

		return s1;
	}

	/**
	 * 
	 * Creates session for database transaction
	 * 
	 * @return session
	 */
	private Session getSession() {
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Students.class);

		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();

		SessionFactory sf = cfg.buildSessionFactory(reg);

		Session session = sf.openSession();

		return session;
	}

}
