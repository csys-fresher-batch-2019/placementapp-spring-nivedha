package com.chainsys.trainingproject.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.trainingproject.dao.ClientCompanyDAO;
import com.chainsys.trainingproject.logger.Logger;
import com.chainsys.trainingproject.model.ClientCompany;
import com.chainsys.util.DbConnection;
import com.chainsys.util.DbException;

public class ClientCompanyDAOImpl implements ClientCompanyDAO {
	private static final Logger log = Logger.getInstance();

	public void addCompanyDetails(ClientCompany client) throws DbException {

		String sql = "insert into clientcmpy(client_id,company_name,company_type,company_address,ph_no,contact_person,email_id)values"
				+ "(client_id_seq.nextval,?,?,?,?,?,?)";
		log.getInput("***Add Company Details***");
		log.getInput(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, client.getCompanyName());
			pst.setString(2, client.getCompanyType());
			pst.setString(3, client.getCompanyAddress());
			pst.setLong(4, client.getPhoneNo());
			pst.setString(5, client.getContactPerson());
			pst.setString(6, client.getEmailId());
			int row = pst.executeUpdate();
			log.getInput(row);
		} catch (Exception e) {
			log.error(e);
		}
	}

	public List<ClientCompany> listCompanyDetails() throws DbException {

		List<ClientCompany> list1 = new ArrayList<ClientCompany>();
		String sql = "select * from clientcmpy";
		log.getInput("***Display All Company Details***");
		log.getInput(sql);
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
			log.error(e);
		}
		return list1;
	}

	public List<ClientCompany> searchByCompany(String companyName) throws DbException {

		List<ClientCompany> list1 = new ArrayList<ClientCompany>();
		String sql = "select client_id,company_name,company_type,company_address,ph_no,contact_person,email_id from clientcmpy where company_name like ?";
		log.getInput("***Display " + companyName + " Company Details***");
		log.getInput(sql);
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
			log.error(e);
		}
		return list1;
	}

	public void deleteCompanyDetails(int clientId) throws DbException {

		String sql = "delete from clientcmpy where client_id=?";
		log.getInput("***Delete Company Details***");
		log.getInput(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, clientId);
			int row = pst.executeUpdate();
			log.getInput(row);
		} catch (Exception e) {
			log.error(e);
		}
	}

	public List<ClientCompany> getCompanyNames() throws DbException {

		List<ClientCompany> list1 = new ArrayList<ClientCompany>();
		String sql = "select company_name from clientcmpy";
		log.getInput("***Display Company Names***");
		log.getInput(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					ClientCompany cc = new ClientCompany();
					cc.setCompanyName(rs.getString("company_name"));
					list1.add(cc);
				}
			}
		} catch (Exception e) {
			log.error(e);
		}
		return list1;
	}

	public int getNoOfCompanies() throws DbException {

		String sql = "select count(company_name) from clientcmpy";
		log.getInput(sql);
		int a = 0;
		try (Connection con = DbConnection.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					a = rs.getInt("count(company_name)");
				}
			}
		} catch (Exception e) {
			log.error(e);
		}
		return a;
	}

	public void updateCompanyDetails(String companyName, String contactPerson) throws DbException {

		String sql = "update clientcmpy set contact_person=? where company_name=?";
		log.getInput(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, contactPerson);
			pst.setString(2, companyName);
			int row = pst.executeUpdate();
		} catch (Exception e) {
			log.error(e);
		}
	}
}