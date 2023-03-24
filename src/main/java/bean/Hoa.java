package bean;

public class Hoa {
	int id;
	String tenHoa;
	int soLuong;
	float giaBan;
	String hinhAnh;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenHoa() {
		return tenHoa;
	}

	public void setTenHoa(String tenHoa) {
		this.tenHoa = tenHoa;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public float getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(float giaBan) {
		this.giaBan = giaBan;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public Hoa(int id, String tenHoa, int soLuong, float giaBan, String hinhAnh) {
		super();
		this.id = id;
		this.tenHoa = tenHoa;
		this.soLuong = soLuong;
		this.giaBan = giaBan;
		this.hinhAnh = hinhAnh;
	}

	public Hoa() {
		super();
	}

}
