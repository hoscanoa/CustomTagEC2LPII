package DAOFactory;

public abstract class Factory {

	// Constantes
	public static final int TIPO_MYSQL = 1;
	public static final int TIPO_SQL_SERVER = 2;

	// Interface DAO Generica para Combo
	public abstract DAOCombo getDAOCombo();
	public abstract DAOProducto getDAOProducto();
	
	public static Factory getTipo(int tipo){
		switch (tipo) {
		case TIPO_MYSQL:
			return new MySqlFactory();
		default:
			return null;
		}
	}
}
