import java.util.ArrayList;
import java.util.List;

public class CategoryDAOImp implements GeneralDAO<Category> {
	private List<Category> data = new ArrayList<Category>();
	private static final CategoryDAOImp instance = new CategoryDAOImp();

	private CategoryDAOImp() {
	}

	public static CategoryDAOImp getInstance() {
		return instance;
	}
	@Override
	public List<Category> get() {
		// TODO Auto-generated method stub
		return data;
	}

	@Override
	public List<Category> getByName(String name) {
		// TODO Auto-generated method stub
		List<Category> getByName = new ArrayList<>();
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).getName().equalsIgnoreCase(name)) {
				getByName.add(data.get(i));
			}
		}
		return getByName;
	}

	@Override
	public Category findId(Category id) {
		// TODO Auto-generated method stub
		for (Category category : data) {
			if (category.equals(id)) {
				return category;
			}
		}
		return null;
	}

	@Override
	public boolean add(Category entity) {
		if (data.add(entity)) {
			System.out.println("Them moi thanh cong");
			return true;
		} else {
			System.out.println("Them moi khong thanh cong");
			return false;
		}
	}

	@Override
	public boolean edit(Category entity,int i) {
		data.set(i, entity);
		return true;
	}

	@Override
	public boolean remove(Category entity) {
		if (data.remove(entity)) {
			System.out.println("Xoa thanh cong");
			return true;
		} else {
			System.out.println("Xoa khong thanh cong");
			return false;
		}
	}

}
