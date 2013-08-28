package db.sqlDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBManager;
import db.bean.Employees_InformationBean;
import db.bean.Employess_Wage_NoteBean;
import db.bean.Employess_Zhiwu_NoteBean;
import db.bean.Employess_prize_noteBean;

public class Employess_Wage_NoteDao {
	/**
	 * 基本工资
	 * 
	 * @param ewnBean
	 * @return
	 */
	public boolean addWage(Employess_Wage_NoteBean ewnBean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO employess_wage_note (employess_id,time,money,userid) "
				+ " VALUES (?,?,?,?)";
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			con.setAutoCommit(false);
			pstmt.setString(1, ewnBean.getEmployess_id());
			pstmt.setTimestamp(2, new java.sql.Timestamp(ewnBean.getTime()
					.getTime()));
			pstmt.setString(3, ewnBean.getMoney());
			pstmt.setInt(4, ewnBean.getUserid());
			pstmt.execute();
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
	 * 根据自动递增id修改前的查询
	 * 
	 * @param id
	 * @return
	 */
	public Employess_Wage_NoteBean getInformationByemployee_id(int id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Employess_Wage_NoteBean pBean = null;
		String sql = "select * from employess_wage_note where id=?";
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				pBean = new Employess_Wage_NoteBean();
				pBean.setId(rs.getInt("id"));
				pBean.setEmployess_id(rs.getString("employess_id"));
				pBean.setMoney(rs.getString("money"));
				pBean.setTime(rs.getDate("time"));
				pBean.setUserid(rs.getInt("userid"));
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
	
	public ArrayList<Employess_Wage_NoteBean> getEmployees() {
		Employess_Wage_NoteBean pBean = null;
		ArrayList<Employess_Wage_NoteBean> al = new ArrayList<Employess_Wage_NoteBean>();
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		String sql = "select * from employess_wage_note ";
		try {
			conn = DBManager.getConnection();
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while (rs.next()) {
				pBean = new Employess_Wage_NoteBean();
				pBean.setId(rs.getInt("id"));
				pBean.setEmployess_id(rs.getString("employess_id"));
				pBean.setMoney(rs.getString("money"));
				pBean.setTime(rs.getDate("time"));
				pBean.setUserid(rs.getInt("userid"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stm.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return al;
	}

	
	
	
	
	
	
	
	
	
	
	/**
	 * 修改工资
	 * @param bean
	 * @return
	 */
	public boolean updateJiangCheng(Employess_Wage_NoteBean bean) {
		Connection conn = null;// 数据库连接对象
		// sql语句的装载器（可以带有参数）
		PreparedStatement stm = null;
		String sql = "update employess_wage_note set money=? ,time=?, userid=?, employess_id=? WHERE id=?";
		try {
			// （1）获取数据库的连接
			conn = DBManager.getConnection();
			// （2）将sql语句放到装载器中
			stm = conn.prepareStatement(sql);
			// （3）使用数据库的事务：不自动提交
			conn.setAutoCommit(false);
			// （4）给参数进行赋值
			stm.setInt(5, bean.getId());
			stm.setString(1, bean.getMoney());
		
			stm.setTimestamp(2, new java.sql.Timestamp(bean
					.getTime().getTime()));
			stm.setInt(3, bean.getUserid());
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
	public boolean deleteGZ(int id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM employess_wage_note WHERE id=?";
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
	/**
	 * 添加前查询
	 * @param bean
	 * @return
	 */
	public Employess_Wage_NoteBean getGz(String employess_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Employess_Wage_NoteBean pBean = null;
		String sql = "select * from employess_wage_note where employess_id=?";
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, employess_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				pBean = new Employess_Wage_NoteBean();
				pBean.setId(rs.getInt("id"));
				pBean.setEmployess_id(rs.getString("employess_id"));
				pBean.setMoney(rs.getString("money"));
				pBean.setTime(rs.getDate("time"));
				pBean.setUserid(rs.getInt("userid"));
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
	/**
	 * 根据id最大值查询工资
	 * @param employess_id
	 * @return
	 */
	public Employess_Wage_NoteBean getEmployessById(String employess_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Employess_Wage_NoteBean kBean = null;
		
		String sql = "select money from employess_wage_note where id = (select max(id) from employess_wage_note where employess_id=? )";
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, employess_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				kBean = new Employess_Wage_NoteBean();

				kBean.setMoney(rs.getString("money"));

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
		return kBean;
	}
}
