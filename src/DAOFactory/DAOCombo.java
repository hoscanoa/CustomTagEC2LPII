package DAOFactory;

import java.sql.SQLException;
import java.util.ArrayList;

import bean.ComboBean;

public interface DAOCombo {
	public ArrayList<ComboBean> listar(String sql) 
			throws SQLException;
}
