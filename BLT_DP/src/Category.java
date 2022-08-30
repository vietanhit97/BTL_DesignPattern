
import java.util.Objects;
import java.util.Scanner;

public class Category {
	int id;
	private String name;
	private boolean status;

	public Category() {
	}

	public Category(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return id == other.id;
	}

	public Category(int id, String name, boolean status) {
		this.id = id;
		this.name = name;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public boolean setId(int id) {
		try {
			for (Category item : CategoryDAOImp.getInstance().get()) {
				if (item.getId() == id) {
					System.err.println("ma san pham da ton tai !!! (nhap lai): ");
					return false;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (id > 0) {
			this.id = id;
			return true;
		} else {
			System.err.println("ma sản phẩm không được để trống ! ");
			return false;
		}
	}

	public String getName() {
		return name;
	}

	public boolean setName(String name) {
		if (name.length() >= 6 && name.length() <= 30) {
			this.name = name;
			return true;
		} else {
			System.err.println("do dai 6 -> 30 ky tu (nhap lai) : ");
			return false;
		}

	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void inputData() {
		Scanner sc = new Scanner(System.in);
		System.out.println("nhap ma danh muc  : ");
		while (true) {
			try {
				int reCatalogID = Integer.parseInt(sc.nextLine());
				boolean check = setId(reCatalogID);
				if (check) {
					break;
				}
			} catch (Exception e) {
				System.err.println("nhap khong dung dinh dang!!!");
			}
		}

		System.out.println("nhap ten danh muc : ");
		while (true) {
			String reCatalogName = sc.nextLine();
			boolean check = setName(reCatalogName);
			if (check) {
				break;
			}
		}
		System.out.println("nhap trang thai danh muc : ");
		String reStatus = sc.nextLine();
		this.status = Boolean.parseBoolean(reStatus);
		while (!(reStatus.equalsIgnoreCase("true") || reStatus.equalsIgnoreCase("false"))) {
			System.err.println("nhap true hoac false (nhap lai) : ");
			reStatus = sc.nextLine();
			this.status = Boolean.parseBoolean(reStatus);
		}

	}

	String S = "";

	public String Status(boolean prdStatus) {
		if (prdStatus) {
			S = "Hiện";
		} else {
			S = "Ẩn";
		}
		return S;
	}

	public void displayData() {
		System.out.format("%20d|%20s|%20s", id, name, Status(status));
		System.out.println("");
	}

}