package menu.crud.model;

public class Menu {

		private int id;
		private String foodname;
		private String releasedate;
		private String category;
		private String description;
	
		public Menu(String foodname, String releasedate, String category, String description) {
			super();
			this.foodname = foodname;
			this.releasedate = releasedate;
			this.category = category;
			this.description = description;
		}
		
		public Menu(int id, String foodname, String releasedate, String category, String description) {
			super();
			this.id = id;
			this.foodname = foodname;
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
		public String getFoodname() {
			return foodname;
		}
		public void setFoodname(String foodname) {
			this.foodname = foodname;
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