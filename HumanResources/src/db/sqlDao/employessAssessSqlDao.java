package db.sqlDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBManager;
import db.bean.employessAssessBean;

public class employessAssessSqlDao {
	/**
	 * 添加职务
	 * 
	 * @param eznBean
	 * @return
	 */

	public boolean addZhiwu(employessAssessBean eznBean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO employess_assess (employess_id,time,matter,status) "
				+ " VALUES (?,?,?,?)";
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			con.setAutoCommit(false);
			pstmt.setString(1, eznBean.getEmployess_id());
			pstmt.setTimestamp(2, new java.sql.Timestamp(eznBean.getTime()
					.getTime()));
			pstmt.setString(3, eznBean.getMatter());
			pstmt.setString(4, eznBean.getStatus());

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

	public ArrayList<employessAssessBean> getname() {
		employessAssessBean bean = null;
		Connection conn = null;// 数据库连接对象
		// sql语句的装载器（可以带有参数）
		PreparedStatement stm = null;
		// 定义结果集对象
		ResultSet rs = null;
		ArrayList<employessAssessBean> al = new ArrayList<employessAssessBean>();
		String sql = "select * from employess_assess";
		try {
			// （1）获取java与mysql数据库连接对象
			conn = DBManager.getConnection();
			// （2）将sql语句放入装载器中
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			// （5）从结果集中取出数据，放到javaBean中
			while (rs.next()) {
				bean = new employessAssessBean();
				bean.setEmployess_id(rs.getString("employess_id"));
				bean.setTime(rs.getDate("time"));
				bean.setMatter(rs.getString("matter"));
				bean.setStatus(rs.getString("status"));
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
	 * 根据指定的条件，业务员查询记录
	 * 
	 * @param whereSQL
	 * @return
	 */
	public ArrayList<employessAssessBean> getOperByWhereSql(String whereSQL) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<employessAssessBean> al = new ArrayList<employessAssessBean>();
		employessAssessBean kBean = null;
		String sql = "select * from shitu1 " + whereSQL;
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				kBean = new employessAssessBean();
				kBean.setId(rs.getInt("id"));
				kBean.setEmployess_id(rs.getString("employess_id"));
				kBean.setEmployees_name(rs.getString("employees_name"));
				kBean.setEmployees_sex(rs.getString("employees_sex"));
				kBean.setTime(rs.getDate("time"));
				kBean.setMatter(rs.getString("matter"));
				kBean.setStatus(rs.getString("status"));
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
	public employessAssessBean getEmployessById(String employess_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		employessAssessBean kBean = null;

		String sql = "select metter from employess_assess where id = (select max(id) from employess_assess where employess_id=? )";
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, employess_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				kBean = new employessAssessBean();
				// kBean.setId(rs.getInt("id"));
				// kBean.setEmployess_id(rs.getString("employess_id"));
				// kBean.setTime(rs.getDate("time"));
				kBean.setMatter(rs.getString("metter"));

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

	public boolean deleteUser(String employess_id) {
		Connection conn = null;
		
		PreparedStatement stm = null;
		String sql = "delete from employess_assess where id=?";
		try {
	
			conn = DBManager.getConnection();
		
			stm = conn.prepareStatement(sql);
			
			conn.setAutoCommit(false);
		
			stm.setString(1, employess_id);
	
			stm.execute();
		
			conn.commit();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
	
			try {
				stm.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;

	}

	public employessAssessBean getEmployeeByEmployeeOID(int id) {
		employessAssessBean employeeBean = null;
		// 定义数据库连接对象
		Connection conn = null;
		// 定义SQL语句的装载器对象（可以带有参数）
		PreparedStatement stm = null;
		// 定义结果集对象
		ResultSet rs = null;
		String sql = "select * from employess_assess where id=?";
		try {
			// （1）获取数据库的连接对象
			conn = DBManager.getConnection();
			// （2）将SQL语句放到装载器中
			stm = conn.prepareStatement(sql);
			stm.setInt(1, id);// 姓名
			// （3）执行SQL语句
			rs = stm.executeQuery();
			// （4）从结果集中将数据取出来放到javaBean中
			while (rs.next()) {
				employeeBean = new employessAssessBean();
				employeeBean.setId(rs.getInt("id"));
				employeeBean.setEmployess_id(rs.getString("employess_id"));
				employeeBean.setMatter(rs.getString("matter"));
				employeeBean.setTime(rs.getDate("time"));
				employeeBean.setStatus(rs.getString("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {// 最后必须执行关闭操作
			try {
				rs.close();
				stm.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return employeeBean;
	}

	public boolean updateKaoQinbyID(employessAssessBean bean) {
		Connection conn = null;// 数据库连接对象
		// sql语句的装载器（可以带有参数）
		PreparedStatement stm = null;
		String sql = "update employess_assess set status=?,matter=? where id=?";
		try {
			// （1）获取数据库的连接
			conn = DBManager.getConnection();
			// （2）将sql语句放到装载器中
			stm = conn.prepareStatement(sql);
			// （3）使用数据库的事务：不自动提交
			conn.setAutoCommit(false);
			// （4）给参数进行赋值
			stm.setInt(3, bean.getId());//
			stm.setString(1, bean.getStatus());// 姓名
			stm.setString(2, bean.getMatter());// 登陆名

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
}
