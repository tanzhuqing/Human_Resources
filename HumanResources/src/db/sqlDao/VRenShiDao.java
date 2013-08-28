package db.sqlDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBManager;
import db.bean.Employees_InformationBean;
import db.bean.VRenShiBean;

public class VRenShiDao {
	
		public ArrayList<Employees_InformationBean> getAllClass() {
			Employees_InformationBean kBean = null;
			ArrayList<Employees_InformationBean> al = new ArrayList<Employees_InformationBean>();
			Connection conn = null;// 数据库连接对象
			// sql语句的装载器（可以带有参数）
			PreparedStatement stm = null;
			// 定义 结果集 对象
			ResultSet rs = null;
			String sql = "select * from employees_information order by employess_id";// order
																						// by
			// 是排序
			try {
				// (1) 获取java与mysql数据库连接对象
				conn = DBManager.getConnection();
				// (2)将sql语句放入装载器中
				stm = conn.prepareStatement(sql);
				// (3)执行sql语句 的查询结果
				rs = stm.executeQuery();
				// 4.从结果集中取出数据放到Javabean 中
				// .next() 数据库打开是第一条记录 下一条
				while (rs.next()) {
					kBean = new Employees_InformationBean();
					kBean.setEmployess_id(rs.getString("employess_id"));
					al.add(kBean);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				// 最后必须进行关闭操作
				try {
					rs.close();
					stm.close();// 关闭装载器
					conn.close();// 关闭连接
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return al;
		}

		public ArrayList<VRenShiBean> getname() {
			VRenShiBean bean = null;
			Connection conn = null;// 数据库连接对象
			// sql语句的装载器（可以带有参数）
			PreparedStatement stm = null;
			// 定义结果集对象
			ResultSet rs = null;
			ArrayList<VRenShiBean> al = new ArrayList<VRenShiBean>();
			String sql = "select * from vrenshi";
			try {
				// （1）获取java与mysql数据库连接对象
				conn = DBManager.getConnection();
				// （2）将sql语句放入装载器中
				stm = conn.prepareStatement(sql);
				rs = stm.executeQuery();
				// （5）从结果集中取出数据，放到javaBean中
				while (rs.next()) {
					bean = new VRenShiBean();
					bean.setEmployess_id(rs.getString("employess_id"));
					bean.setTime(rs.getDate("time"));
					bean.setEmployess_job(rs.getString("employess_job"));
					bean.setEmployees_name(rs.getString("employees_name"));
					bean.setEmployees_status(rs.getString("employees_status"));
					
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
		public VRenShiBean getUserBeanById(String employess_id) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			VRenShiBean kBean = null;
			String sql = "select * from vrenshi where employess_id=? ";
			try {
				con = DBManager.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, employess_id);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					kBean = new VRenShiBean();
					kBean.setEmployess_id(rs.getString("employess_id"));
					kBean.setTime(rs.getDate("time"));
					kBean.setEmployess_job(rs.getString("employess_job"));

					kBean.setEmployees_name(rs.getString("employees_name"));
					kBean.setEmployees_status(rs.getString("employees_status"));
				kBean.setEmployees_professional(rs.getString("employees_professional"));
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
		public ArrayList<VRenShiBean> getOperByWhereSql(String whereSQL) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ArrayList<VRenShiBean> al = new ArrayList<VRenShiBean>();
			VRenShiBean kBean = null;
			String sql = "select * from vrenshi " + whereSQL;
			try {
				con = DBManager.getConnection();
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					kBean = new VRenShiBean();
					kBean.setId(rs.getInt("id"));
					kBean.setEmployess_id(rs.getString("employess_id"));
					kBean.setTime(rs.getDate("time"));
					kBean.setEmployess_job(rs.getString("employess_job"));
					kBean.setEmployees_name(rs.getString("employees_name"));
					kBean.setEmployees_status(rs.getString("employees_status"));
					kBean.setEmployees_professional(rs.getString("employees_professional"));
					
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
		 * 韩晶
		 * 
		 * @param employess_id
		 * @return
		 */
		public ArrayList<VRenShiBean> getMobileCardByWhereSql(String employess_id) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			ArrayList<VRenShiBean> al = new ArrayList<VRenShiBean>();
			VRenShiBean kBean = null;

			String sql = "select * from vrenshi  where employess_id =?";
			try {
				con = DBManager.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, employess_id);

				rs = pstmt.executeQuery();
				while (rs.next()) {
					kBean = new VRenShiBean();
					kBean.setId(rs.getInt("id"));
					kBean.setEmployess_id(rs.getString("employess_id"));
					kBean.setEmployees_name(rs.getString("employees_name"));
					kBean.setEmployees_sex(rs.getString("employees_sex"));
				
					kBean.setEmployees_study(rs.getString("employees_study"));
					kBean.setEmployees_politically(rs
							.getString("employees_politically"));
				
					kBean.setEmployees_professional(rs
							.getString("employees_professional"));
					kBean.setEmployess_jointime(rs.getDate("employess_jointime"));
					kBean.setElmployess_engtime(rs.getDate("elmployess_engtime"));
					
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
		 * 查询语句
		 * 
		 * @param strSQL
		 * @return
		 */

		public ArrayList<VRenShiBean> getEmployees(String strSQL) {
			VRenShiBean kBean = null;
			ArrayList<VRenShiBean> al = new ArrayList<VRenShiBean>();
			Connection conn = null;
			PreparedStatement stm = null;
			ResultSet rs = null;
			String sql = "select * from vrenshi " + strSQL;
			try {
				conn = DBManager.getConnection();
				stm = conn.prepareStatement(sql);
				rs = stm.executeQuery();
				while (rs.next()) {
					kBean = new VRenShiBean();
					kBean.setId(rs.getInt("id"));
					kBean.setEmployess_id(rs.getString("employess_id"));
					kBean.setEmployees_name(rs.getString("employees_name"));
					kBean.setEmployees_sex(rs.getString("employees_sex"));
					kBean.setEmployees_study(rs.getString("employees_study"));
					kBean.setEmployees_politically(rs
							.getString("employees_politically"));
					kBean.setEmployees_professional(rs
							.getString("employees_professional"));
					kBean.setEmployess_jointime(rs.getDate("employess_jointime"));
					kBean.setElmployess_engtime(rs.getDate("elmployess_engtime"));
					kBean.setEmployees_status(rs.getString("employees_status"));
					kBean.setEmployess_job(rs.getString("employess_job"));
					al.add(kBean);

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

		public ArrayList<VRenShiBean> getAllClassal() {
			VRenShiBean kBean = null;
			ArrayList<VRenShiBean> al = new ArrayList<VRenShiBean>();
			Connection conn = null;// 数据库连接对象
			// sql语句的装载器（可以带有参数）
			PreparedStatement stm = null;
			// 定义 结果集 对象
			ResultSet rs = null;
			String sql = "select * from vrenshi order by employess_id";// order by
																		// 是排序
			try {
				// (1) 获取java与mysql数据库连接对象
				conn = DBManager.getConnection();
				// (2)将sql语句放入装载器中
				stm = conn.prepareStatement(sql);
				// (3)执行sql语句 的查询结果
				rs = stm.executeQuery();
				// 4.从结果集中取出数据放到Javabean 中
				// .next() 数据库打开是第一条记录 下一条
				while (rs.next()) {
					kBean = new VRenShiBean();
					kBean.setEmployess_id(rs.getString("employess_id"));
					kBean.setTime(rs.getDate("time"));
					kBean.setEmployess_job(rs.getString("employess_job"));
					kBean.setEmployees_professional(rs
							.getString("employees_professional"));
					kBean.setEmployees_name(rs.getString("employees_name"));
					kBean.setEmployees_status(rs.getString("employees_status"));
					al.add(kBean);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				// 最后必须进行关闭操作
				try {
					rs.close();
					stm.close();// 关闭装载器
					conn.close();// 关闭连接
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return al;
		}
	}
