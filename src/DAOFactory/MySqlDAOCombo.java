package DAOFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.ConexionDB;

import bean.ComboBean;

public class MySqlDAOCombo implements DAOCombo {

	@Override
	public ArrayList<ComboBean> listar(String sql) throws SQLException {
		ArrayList<ComboBean> lista = new ArrayList<ComboBean>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = new ConexionDB().getConexion();
			pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			ComboBean obj = null;
			while (rs.next()) {
				obj = new ComboBean();
				obj.setValue(rs.getString(1));
				obj.setText(rs.getString(2));
				lista.add(obj);
			}
			pstm.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			conn.close();
		}
				
		
		return lista;
	}

}
