package com.chainsys.trainingplacementapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.chainsys.trainingplacementapp.dao.ClientCompanyDAO;
import com.chainsys.trainingplacementapp.domain.ClientCompany;
import com.chainsys.trainingplacementapp.exception.DbException;
import com.chainsys.trainingplacementapp.util.DbConnection;

@Repository
public class ClientCompanyDAOImpl implements ClientCompanyDAO {
	private static final Logger logger = LoggerFactory.getLogger(ClientCompanyDAOImpl.class);

	/**
	 * Used to insert the new client company in the client company details
	 */
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
		} catch (SQLException e) {
			throw new DbException("Unable to Add Company Details", e);
		}
	}

	/**
	 * Used to display all the client companies
	 */
	public List<ClientCompany> findAll() throws DbException {

		List<ClientCompany> list1 = new ArrayList<ClientCompany>();
		String sql = "select client_id,company_name,company_type,company_address,ph_no,contact_person,email_id from clientcmpy";
		logger.info("***Display All Company Details***");
		logger.info(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					ClientCompany clientCompany = new ClientCompany();
					clientCompany.setClientId(rs.getInt("client_id"));
					clientCompany.setCompanyName(rs.getString("company_name"));
					clientCompany.setCompanyType(rs.getString("company_type"));
					clientCompany.setCompanyAddress(rs.getString("company_address"));
					clientCompany.setPhoneNo(rs.getLong("ph_no"));
					clientCompany.setContactPerson(rs.getString("contact_person"));
					clientCompany.setEmailId(rs.getString("email_id"));
					list1.add(clientCompany);
				}
			}
		} catch (SQLException e) {
			throw new DbException("Unable to Find Company Details", e);
		}
		return list1;
	}

	/**
	 * Used to display all the client companies with company name
	 */
	public List<ClientCompany> findByCompanyName(String companyName) throws DbException {

		List<ClientCompany> list1 = new ArrayList<ClientCompany>();
		String sql = "select client_id,company_name,company_type,company_address,ph_no,contact_person,email_id from clientcmpy where company_name like ?";
		logger.info("***Display " + companyName + " Company Details***");
		logger.info(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, "%" + companyName + "%");
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					ClientCompany clientCompany = new ClientCompany();
					clientCompany.setClientId(rs.getInt("client_id"));
					clientCompany.setCompanyName(rs.getString("company_name"));
					clientCompany.setCompanyType(rs.getString("company_type"));
					clientCompany.setCompanyAddress(rs.getString("company_address"));
					clientCompany.setPhoneNo(rs.getLong("ph_no"));
					clientCompany.setContactPerson(rs.getString("contact_person"));
					clientCompany.setEmailId(rs.getString("email_id"));
					list1.add(clientCompany);
				}
			}
		} catch (SQLException e) {
			throw new DbException("Unable to Find Company Names", e);
		}
		return list1;
	}
	/**
	 * Used to delete the client companies with clientId
	 */
	public void delete(int clientId) throws DbException {

		String sql = "delete from clientcmpy where client_id=?";
		logger.info("***Delete Company Details***");
		logger.info(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, clientId);
			int row = pst.executeUpdate();
			logger.info("" + row);
		} catch (SQLException e) {
			throw new DbException("Unable to Delete Company Details", e);
		}
	}

	public List<ClientCompany> findCompanyNames() throws DbException {

		List<ClientCompany> list1 = new ArrayList<ClientCompany>();
		String sql = "select company_name from clientcmpy";
		logger.info("***Display Company Names***");
		logger.info(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					ClientCompany clientCompany = new ClientCompany();
					clientCompany.setCompanyName(rs.getString("company_name"));
					list1.add(clientCompany);
				}
			}
		} catch (SQLException e) {
			throw new DbException("Unable to Find Company Names", e);
		}
		return list1;
	}

	public int count() throws DbException {

		String sql = "select count(company_name) from clientcmpy";
		logger.info(sql);
		int count = 0;
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					count = rs.getInt("count(company_name)");
				}
			}
		} catch (SQLException e) {
			throw new DbException("Unable to Count Company Details", e);
		}
		return count;
	}

	public void update(String companyName, String contactPerson) throws DbException {

		String sql = "update clientcmpy set contact_person=? where company_name=?";
		logger.info(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, contactPerson);
			pst.setString(2, companyName);
			int row = pst.executeUpdate();
			logger.info("" + row);
		} catch (SQLException e) {
			throw new DbException("Unable to Update Contact Person", e);
		}
	}
}