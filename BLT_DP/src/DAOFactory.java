
public class DAOFactory {
	public <T> GeneralDAO getDAO(Class<T> _class) {
		if (_class == Category.class) {
			return CategoryDAOImp.getInstance();
		} else if (_class == Product.class) {
			return ProductDAPImp.getInstance();
		} else {
			return null;
		}
	}
}
