package com.chainsys.trainingplacementapp.factory;

import com.chainsys.trainingplacementapp.dao.AdminLoginDAO;
import com.chainsys.trainingplacementapp.dao.ClientCompanyDAO;
import com.chainsys.trainingplacementapp.dao.CommentsDAO;
import com.chainsys.trainingplacementapp.dao.CourseDAO;
import com.chainsys.trainingplacementapp.dao.GradeDAO;
import com.chainsys.trainingplacementapp.dao.InterviewPerformanceDAO;
import com.chainsys.trainingplacementapp.dao.InterviewScheduleDAO;
import com.chainsys.trainingplacementapp.dao.JoinDAO;
import com.chainsys.trainingplacementapp.dao.LoginDAO;
import com.chainsys.trainingplacementapp.dao.RegistrationDAO;
import com.chainsys.trainingplacementapp.dao.TrainerDAO;
import com.chainsys.trainingplacementapp.dao.UserCourseDAO;
import com.chainsys.trainingplacementapp.dao.impl.AdminLoginDAOImpl;
import com.chainsys.trainingplacementapp.dao.impl.ClientCompanyDAOImpl;
import com.chainsys.trainingplacementapp.dao.impl.CommentsDAOImpl;
import com.chainsys.trainingplacementapp.dao.impl.CourseDAOImpl;
import com.chainsys.trainingplacementapp.dao.impl.GradeDAOImpl;
import com.chainsys.trainingplacementapp.dao.impl.InterviewPerformanceDAOImpl;
import com.chainsys.trainingplacementapp.dao.impl.InterviewScheduleDAOImpl;
import com.chainsys.trainingplacementapp.dao.impl.JoinDAOImpl;
import com.chainsys.trainingplacementapp.dao.impl.LoginDAOImpl;
import com.chainsys.trainingplacementapp.dao.impl.RegistrationDAOImpl;
import com.chainsys.trainingplacementapp.dao.impl.TrainerDAOImpl;
import com.chainsys.trainingplacementapp.dao.impl.UserCourseDAOImpl;

public class DAOFactory {

	public static ClientCompanyDAO getClientCompanyDAO() {
		return new ClientCompanyDAOImpl();
	}

	public static CourseDAO getCourseDAO() {
		return new CourseDAOImpl();
	}

	public static CommentsDAO getCommentsDAO() {
		return new CommentsDAOImpl();
	}

	public static RegistrationDAO getRegistrationDAO() {
		return new RegistrationDAOImpl();
	}

	public static GradeDAO getGradeDAO() {
		return new GradeDAOImpl();
	}

	public static InterviewPerformanceDAO getInterviewPerformanceDAO() {
		return new InterviewPerformanceDAOImpl();
	}

	public static InterviewScheduleDAO getInterviewScheduleDAO() {
		return new InterviewScheduleDAOImpl();
	}

	public static LoginDAO getLoginDAO() {
		return new LoginDAOImpl();
	}

	public static TrainerDAO getTrainerDAO() {
		return new TrainerDAOImpl();
	}

	public static UserCourseDAO getUserCourseDAO() {
		return new UserCourseDAOImpl();
	}

	public static AdminLoginDAO getAdminLoginDAO() {
		return new AdminLoginDAOImpl();
	}

	public static JoinDAO getJoinDAO() {
		return new JoinDAOImpl();
	}

}
