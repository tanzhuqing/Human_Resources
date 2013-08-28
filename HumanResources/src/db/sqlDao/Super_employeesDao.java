package db.sqlDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBManager;
import db.bean.Employees_InformationBean;
import db.bean.Super_employeesBean;

/**
 * 查询超级管理员
 * 
 * @author Administrator
 * 
 */
public class Super_employeesDao {
	public Super_employeesBean getEmployeeByemployeeName(String user) {
		Super_employeesBean super_employeesBean = null;
		// 定义数据库连接对象
		Connection conn = null;
		// 定义SQL语句的装载器对象（可以带有参数）
		PreparedStatement stm = null;
		// 定义结果集对象
		ResultSet rs = null;
		String sql = "select * from super_employees where user=?";
		try {
			// （1）获取数据库的连接对象
			conn = DBManager.getConnection();
			// （2）将SQL语句放到装载器中
			stm = conn.prepareStatement(sql);
			stm.setString(1,user);// 姓名
			// （3）执行SQL语句
			rs = stm.executeQuery();
			// （4）从结果集中将数据取出来放到javaBean中
			while (rs.next()) {
				super_employeesBean = new Super_employeesBean();
				super_employeesBean.setId(rs.getInt("id"));
				super_employeesBean.setUser(rs.getString("user"));
				super_employeesBean.setPass(rs.getString("pass"));
				super_employeesBean.setStatus(rs.getString("status"));
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
		return super_employeesBean;
	}

	/**
	 * 修改密码
	 * 
	 * @param employeeName
	 *            操作员登陆名
	 * @param employeePassword
	 *            操作员密码
	 * @return
	 */

	public boolean updatePasswordById(String user, String pass) {
		Connection conn = null;// 数据库连接对象
		// sql语句的装载器（可以带有参数）
		PreparedStatement stm = null;
		String sql = "update super_employees set pass=? where user=?";
		try {
			// （1）获取数据库的连接
			conn = DBManager.getConnection();
			// （2）将sql语句放到装载器中
			stm = conn.prepareStatement(sql);
			// （3）使用数据库的事务：不自动提交
			conn.setAutoCommit(false);
			// （4）给参数进行赋值
			stm.setString(1, pass);// 密码
			stm.setString(2, user);// 姓名

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

	/**
	 * 添加操作员
	 * 
	 * @param employeeBean
	 *            操作员bean
	 * @return
	 */
	public boolean addEmployee(Super_employeesBean super_employeesBean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO super_employees (user,pass,status)"
				+ " VALUES (?,?,?)";
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			con.setAutoCommit(false);
			// pstmt.setInt(1, super_employeesBean.getId());
			pstmt.setString(1, super_employeesBean.getUser());// 操作员姓名
			pstmt.setString(2, super_employeesBean.getPass());// 操作员密码
			pstmt.setString(3, super_employeesBean.getStatus());// 操作员状态
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
	 * 根据状态判断查询
	 * 
	 * @param status
	 * @return
	 */
	public ArrayList<Super_employeesBean> getOperByWhereSql(String status) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Super_employeesBean> al = new ArrayList<Super_employeesBean>();
		Super_employeesBean super_employeesBean = null;
		String sql = "select * from super_employees where status=?";
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, status);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				super_employeesBean = new Super_employeesBean();
				super_employeesBean.setId(rs.getInt("id"));
				super_employeesBean.setUser(rs.getString("user"));

				super_employeesBean.setPass(rs.getString("pass"));
				super_employeesBean.setStatus(rs.getString("status"));

				al.add(super_employeesBean);
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
 * 删除
 * @param id
 * @return
 */
	public boolean deleteUser(int id) { 
		Connection conn = null;// 数据库连接对象��ݿ�l�Ӷ���
		// 执行sql语句的装载器（可以带有参数）�����Դ��в���
		PreparedStatement stm = null;
		String sql = "delete from super_employees where id=?";
		try {
			// 1获取java与mysql数据库接连对象��ȡjava��mysql��ݿ��l����
			conn = DBManager.getConnection();
			// 2开始装载sql语句��sql���
			stm = conn.prepareStatement(sql);
			// 3设置数据库的事务：不自动提交
			conn.setAutoCommit(false);
			// 4对sql语句中的参数进行设置��sql����еĲ����������
			stm.setInt(1, id);
			// 5执行sql语句
			stm.execute();
			// 6提交事务����
			conn.commit();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			// 事务进行回滚
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			// 关闭操作��
			try {
				stm.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;

	}

	/**
	 * 根据操作员序列号查询信息
	 * 
	 * @param employeeOID
	 * @return
	 */
	public Super_employeesBean getUserBeanById(int id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Super_employeesBean kBean = null;
		String sql = "select * from super_employees where id=? ";
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				kBean = new Super_employeesBean();
				kBean.setId(rs.getInt("id"));
				kBean.setPass(rs.getString("pass"));
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
