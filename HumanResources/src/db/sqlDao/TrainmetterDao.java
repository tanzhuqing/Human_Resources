package db.sqlDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DBManager;
import db.bean.TrainmetterBean;

public class TrainmetterDao {

	public boolean addKaoP(TrainmetterBean aBean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO employess_zhiwu_note (employess_id,month,status,matter) "
				+ " VALUES (?,?,?,?)";
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			con.setAutoCommit(false);
			pstmt.setString(1, aBean.getEmployess_id());

			pstmt.setDate(2, new java.sql.Date(aBean.getMonth().getMonth()));// 文章内容
			pstmt.setString(3, aBean.getMatter());
			pstmt.setString(4, aBean.getStatus());

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
}
