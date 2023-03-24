package bean;

public class Comment {
	private int id;
	private String name;
	private String cmt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCmt() {
		return cmt;
	}

	public void setCmt(String cmt) {
		this.cmt = cmt;
	}

	public Comment(int id, String name, String cmt) {
		super();
		this.id = id;
		this.name = name;
		this.cmt = cmt;
	}

	public Comment() {
		super();
	}

}
