package bean;

public class Hoa {
	int id;
	String tenHoa;
	int soLuong;
	float giaBan;
	public Hoa(int id, String tenHoa, int soLuong, float giaBan) {
		super();
		this.id = id;
		this.tenHoa = tenHoa;
		this.soLuong = soLuong;
		this.giaBan = giaBan;
	}
	public int getId() {
		return id;
	}
	public String getTenHoa() {
		return tenHoa;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public float getGiaBan() {
		return giaBan;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
}
