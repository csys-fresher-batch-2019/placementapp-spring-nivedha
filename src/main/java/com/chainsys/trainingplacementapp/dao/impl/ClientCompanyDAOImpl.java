package com.chainsys.trainingplacementapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.trainingplacementapp.dao.ClientCompanyDAO;
import com.chainsys.trainingplacementapp.domain.ClientCompany;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.exception.ErrorConstant;
import com.chainsys.trainingplacementapp.util.DbConnection;

public class ClientCompanyDAOImpl implements ClientCompanyDAO {
	private static final Logger logger = LoggerFactory.getLogger(ClientCompanyDAOImpl.class);

	public void save(ClientCompany client) throws DbException {

		String sql = "insert into clientcmpy(client_id,company_name,company_type,company_address,ph_no,contact_person,email_id)values"
				+ "(client_id_seq.nextval,?,?,?,?,?,?)";
		logger.info("***Add Company Details***");
		logger.info(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, client.getCompanyName());
			pst.setString(2, client.getCompanyType());
			pst.setString(3, client.getCompanyAddress());
			pst.setLong(4, client.getPhoneNo());
			pst.setString(5, client.getContactPerson());
			pst.setString(6, client.getEmailId());
			int row = pst.executeUpdate();
			logger.info("" + row);
		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_ADD);

		}
	}

	public List<ClientCompany> findAll() throws DbException {

		List<ClientCompany> list1 = new ArrayList<ClientCompany>();
		String sql = "select * from clientcmpy";
		logger.info("***Display All Company Details***");
		logger.info(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					ClientCompany cc = new ClientCompany();
					cc.setClientId(rs.getInt("client_id"));
					cc.setCompanyName(rs.getString("company_name"));
					cc.setCompanyType(rs.getString("company_type"));
					cc.setCompanyAddress(rs.getString("company_address"));
					cc.setPhoneNo(rs.getLong("ph_no"));
					cc.setContactPerson(rs.getString("contact_person"));
					cc.setEmailId(rs.getString("email_id"));
					list1.add(cc);
				}
			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_SELECT);

		}
		return list1;
	}

	public List<ClientCompany> findByCompanyName(String companyName) throws DbException {

		List<ClientCompany> list1 = new ArrayList<ClientCompany>();
		String sql = "select client_id,company_name,company_type,company_address,ph_no,contact_person,email_id from clientcmpy where company_name like ?";
		logger.info("***Display " + companyName + " Company Details***");
		logger.info(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, "%" + companyName + "%");
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					ClientCompany cc = new ClientCompany();
					cc.setClientId(rs.getInt("client_id"));
					cc.setCompanyName(rs.getString("company_name"));
					cc.setCompanyType(rs.getString("company_type"));
					cc.setCompanyAddress(rs.getString("company_address"));
					cc.setPhoneNo(rs.getLong("ph_no"));
					cc.setContactPerson(rs.getString("contact_person"));
					cc.setEmailId(rs.getString("email_id"));
					list1.add(cc);
				}
			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_SELECT);

		}
		return list1;
	}

	public void delete(int clientId) throws DbException {

		String sql = "delete from clientcmpy where client_id=?";
		logger.info("***Delete Company Details***");
		logger.info(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, clientId);
			int row = pst.executeUpdate();
			logger.info("" + row);
		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_DELETE);

		}
	}

	public List<ClientCompany> findCompanyNames() throws DbException {

		List<ClientCompany> list1 = new ArrayList<ClientCompany>();
		String sql = "select company_name from clientcmpy";
		logger.info("***Display Company Names***");
		logger.info(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					ClientCompany cc = new ClientCompany();
					cc.setCompanyName(rs.getString("company_name"));
					list1.add(cc);
				}
			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_SELECT);

		}
		return list1;
	}

	public int count() throws DbException {

		String sql = "select count(company_name) from clientcmpy";
		logger.info(sql);
		int a = 0;
		try (Connection con = DbConnection.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					a = rs.getInt("count(company_name)");
				}
			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_SELECT);

		}
		return a;
	}

	public void update(String companyName, String contactPerson) throws DbException {

		String sql = "update clientcmpy set contact_person=? where company_name=?";
		logger.info(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, contactPerson);
			pst.setString(2, companyName);
			int row = pst.executeUpdate();
		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_UPDATE);

		}
	}
}