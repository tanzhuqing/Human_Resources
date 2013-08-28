package db.sqlDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBManager;
import db.bean.Employess_Zhiwu_NoteBean;

public class Employess_Zhiwu_NoteDao {
	/**
	 * 添加职务
	 * 
	 * @param eznBean
	 * @return
	 */

	public boolean addZhiwu(Employess_Zhiwu_NoteBean eznBean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO employess_zhiwu_note (employess_id,time,employess_job) "
				+ " VALUES (?,?,?)";
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			con.setAutoCommit(false);
			pstmt.setString(1, eznBean.getEmployess_id());// 文章标题
			pstmt.setTimestamp(2, new java.sql.Timestamp(eznBean.getTime()
					.getTime()));// 文章内容
			pstmt.setString(3, eznBean.getEmployess_job());// 文章类型ID

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

	public ArrayList<Employess_Zhiwu_NoteBean> getname() {
		Employess_Zhiwu_NoteBean bean = null;
		Connection conn = null;// 数据库连接对象
		// sql语句的装载器（可以带有参数）
		PreparedStatement stm = null;
		// 定义结果集对象
		ResultSet rs = null;
		ArrayList<Employess_Zhiwu_NoteBean> al = new ArrayList<Employess_Zhiwu_NoteBean>();
		String sql = "select * from employess_zhiwu_note";
		try {
			// （1）获取java与mysql数据库连接对象
			conn = DBManager.getConnection();
			// （2）将sql语句放入装载器中
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			// （5）从结果集中取出数据，放到javaBean中
			while (rs.next()) {
				bean = new Employess_Zhiwu_NoteBean();
				bean.setEmployess_id(rs.getString("employess_id"));
				bean.setTime(rs.getDate("time"));
				bean.setEmployess_job(rs.getString("employess_job"));
				al.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 最后必须进行关闭操作
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
	 * 根据操作员序列号查询信息
	 * 
	 * @param employeeOID
	 * @return
	 */
	public Employess_Zhiwu_NoteBean getUserBeanById(String employess_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Employess_Zhiwu_NoteBean kBean = null;
		String sql = "select * from employess_zhiwu_note where employess_id=? ";
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, employess_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				kBean = new Employess_Zhiwu_NoteBean();
				kBean.setEmployess_id(rs.getString("employess_id"));
				kBean.setTime(rs.getDate("time"));
				kBean.setEmployess_job(rs.getString("employess_job"));

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

	/**
	 * 根据指定的条件，业务员查询记录
	 * 
	 * @param whereSQL
	 * @return
	 */
	public ArrayList<Employess_Zhiwu_NoteBean> getOperByWhereSql(String whereSQL) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Employess_Zhiwu_NoteBean> al = new ArrayList<Employess_Zhiwu_NoteBean>();
		Employess_Zhiwu_NoteBean kBean = null;
		String sql = "select * from employess_zhiwu_note " + whereSQL;
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				kBean = new Employess_Zhiwu_NoteBean();
				kBean.setId(rs.getInt("id"));
				kBean.setEmployess_id(rs.getString("employess_id"));
				kBean.setTime(rs.getDate("time"));
				kBean.setEmployess_job(rs.getString("employess_job"));

				al.add(kBean);
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
	 * 根据操作员序列号查询信息
	 * 
	 * @param employeeOID
	 * @return
	 */
	public Employess_Zhiwu_NoteBean getEmployessById(String employess_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Employess_Zhiwu_NoteBean kBean = null;
		
		String sql = "select employess_job from employess_zhiwu_note where id = (select max(id) from employess_zhiwu_note where employess_id=? )";
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, employess_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				kBean = new Employess_Zhiwu_NoteBean();
//				kBean.setId(rs.getInt("id"));
//				kBean.setEmployess_id(rs.getString("employess_id"));
//				kBean.setTime(rs.getDate("time"));
				kBean.setEmployess_job(rs.getString("employess_job"));

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
	public boolean deleteRenShi(int id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM employess_zhiwu_note WHERE id=?";
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
