package db.sqlDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBManager;

import db.bean.employessTrainBean;

public class employessTrainSqlDao {
	/**
	 * 添加员工信息
	 * 
	 * @param userBean
	 * @return
	 */
	public boolean addPeiXun(employessTrainBean eznBean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO employess_train(employess_id,month,status,matter) "
				+ " VALUES (?,?,?,?)";
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			con.setAutoCommit(false);
			pstmt.setString(1, eznBean.getEmployess_id());
System.out.println("asdashdasd="+eznBean.getMonth());
			pstmt.setDate(2, new java.sql.Date(eznBean.getMonth().getTime()));// 文章内容

			pstmt.setString(3, eznBean.getStatus());
			pstmt.setString(4, eznBean.getMatter());
			pstmt.execute();// 开始向数据库中插入数据
			con.commit();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<employessTrainBean> getMobileCardByWhereSql(String whereSQL) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<employessTrainBean> al = new ArrayList<employessTrainBean>();
		employessTrainBean tempBean = null;
		String sql = "select * from shitu2 " + whereSQL;
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				tempBean = new employessTrainBean();
				tempBean = new employessTrainBean();
				tempBean = new employessTrainBean();
				tempBean.setId(rs.getInt("id"));
				tempBean.setEmployess_id(rs.getString("employess_id"));
				tempBean.setEmployees_name(rs.getString("employees_name"));
				tempBean.setEmployees_sex(rs.getString("employees_sex"));
				tempBean.setMonth(rs.getDate("month"));
				tempBean.setStatus(rs.getString("status"));
				tempBean.setMatter(rs.getString("matter"));
				al.add(tempBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return al;
	}

}
