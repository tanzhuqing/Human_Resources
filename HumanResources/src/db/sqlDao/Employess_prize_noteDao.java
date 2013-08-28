package db.sqlDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBManager;
import db.bean.Employess_prize_noteBean;

public class Employess_prize_noteDao {
	/**
	 * 添加奖惩
	 * 
	 * @param employess_prize_noteBean
	 * @return
	 */
	public boolean addJiangCheng(
			Employess_prize_noteBean employess_prize_noteBean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO employess_prize_note (employess_id,matter,time,jiangjin,fakuan,userid)"
				+ " values (?,?,?,?,?,?)";
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			con.setAutoCommit(false);
			// pstmt.setInt(1, employess_wage_noteBean.getId());
			pstmt.setString(1, employess_prize_noteBean.getEmployess_id());
			pstmt.setString(2, employess_prize_noteBean.getMatter());
			pstmt.setDate(3, new java.sql.Date(employess_prize_noteBean
					.getTime().getTime()));
			pstmt.setString(4, employess_prize_noteBean.getJiangjin());
			pstmt.setString(5, employess_prize_noteBean.getFakuan());
			pstmt.setInt(6, employess_prize_noteBean.getUserid());

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

	/**
	 * 奖惩查询
	 * 
	 * @param employess_id
	 * @return
	 */
	public ArrayList<Employess_prize_noteBean> getPrizeByemployee_id(
			String whereSQL) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Employess_prize_noteBean> al = new ArrayList<Employess_prize_noteBean>();
		Employess_prize_noteBean pBean = null;
		String sql = "select * from jiangcheng " + whereSQL;
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				pBean = new Employess_prize_noteBean();
				pBean.setId(rs.getInt("id"));
				pBean.setEmployess_id(rs.getString("employess_id"));
				pBean.setMatter(rs.getString("matter"));
				pBean.setTime(rs.getDate("time"));
				pBean.setJiangjin(rs.getString("jiangjin"));
				pBean.setFakuan(rs.getString("fakuan"));
				pBean.setUserid(rs.getInt("userid"));
				pBean.setUser(rs.getString("user"));
				pBean.setEmployees_name(rs.getString("employees_name"));
				al.add(pBean);
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

	/**
	 * xiugaijiangcheng
	 * 
	 * @param employess_id
	 * @return
	 */
	public Employess_prize_noteBean getInformationByemployee_id(int id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Employess_prize_noteBean pBean = null;
		String sql = "select * from employess_prize_note where id=?";
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				pBean = new Employess_prize_noteBean();
				pBean.setId(rs.getInt("id"));
				pBean.setEmployess_id(rs.getString("employess_id"));
				pBean.setMatter(rs.getString("matter"));
				pBean.setJiangjin(rs.getString("jiangjin"));
				pBean.setFakuan(rs.getString("fakuan"));

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
		return pBean;
	}

	// 修改奖惩
	public boolean updateJiangCheng(Employess_prize_noteBean bean) {
		Connection conn = null;// 数据库连接对象
		// sql语句的装载器（可以带有参数）
		PreparedStatement stm = null;
		String sql = "update employess_prize_note set matter=? ,jiangjin=?, fakuan=?, employess_id=? WHERE id=?";
		try {
			// （1）获取数据库的连接
			conn = DBManager.getConnection();
			// （2）将sql语句放到装载器中
			stm = conn.prepareStatement(sql);
			// （3）使用数据库的事务：不自动提交
			conn.setAutoCommit(false);
			// （4）给参数进行赋值
			stm.setInt(5, bean.getId());
			stm.setString(1, bean.getMatter());
			stm.setString(2, bean.getJiangjin());
			stm.setString(3, bean.getFakuan());
			stm.setString(4, bean.getEmployess_id());
			// （5）执行SQL语句
			// 开始向数据库中更新数据
			stm.executeUpdate();
			// （6）提交事务
			conn.commit();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			// 事务回滚
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return false;
		} finally {// 最后必须关闭操作
			try {
				stm.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean deleteJC(int id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM employess_prize_note WHERE id=?";
		try {
			con = DBManager.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);//
			pstmt.execute();// 执行删除操作
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
