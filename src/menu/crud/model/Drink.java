package menu.crud.model;

public class Drink {
	
	private int id;
	private String drinkname;
	private String releasedate;
	private String category;
	private String description;
	
	
	public Drink(String drinkname, String releasedate, String category, String description) {
		super();
		this.drinkname = drinkname;
		this.releasedate = releasedate;
		this.category = category;
		this.description = description;
	}
	
	public Drink(int id, String drinkname, String releasedate, String category, String description) {
		super();
		this.id = id;
		this.drinkname = drinkname;
		this.releasedate = releasedate;
		this.category = category;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDrinkname() {
		return drinkname;
	}
	public void setDrinkname(String drinkname) {
		this.drinkname = drinkname;
	}
	public String getReleasedate() {
		return releasedate;
	}
	public void setReleasedate(String releasedate) {
		this.releasedate = releasedate;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
