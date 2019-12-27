package sakila.inventory.model;

public class Film {
	private int filmId;
	private String title;
	private String description;
	private String releaseYear;
	private Language language;
	private int rentalDuration;
	private String rentalRate;
	private int length;
	private String replacementcost;
	private String rating;
	private String spacialFeatures;
	private String lastUpdate;
	public int getFilmId() {
		return filmId;
	}
	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}
	public Language getLanguage() {
		return language;
	}
	public void setLanguage(Language language) {
		this.language = language;
	}
	public int getRentalDuration() {
		return rentalDuration;
	}
	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}
	public String getRentalRate() {
		return rentalRate;
	}
	public void setRentalRate(String rentalRate) {
		this.rentalRate = rentalRate;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getReplacementcost() {
		return replacementcost;
	}
	public void setReplacementcost(String replacementcost) {
		this.replacementcost = replacementcost;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getSpacialFeatures() {
		return spacialFeatures;
	}
	public void setSpacialFeatures(String spacialFeatures) {
		this.spacialFeatures = spacialFeatures;
	}
	public String getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	@Override
	public String toString() {
		return "Film [filmId=" + filmId + ", title=" + title + ", description=" + description + ", releaseYear="
				+ releaseYear + ", language=" + language + ", rentalDuration=" + rentalDuration + ", rentalRate="
				+ rentalRate + ", length=" + length + ", replacementcost=" + replacementcost + ", rating=" + rating
				+ ", spacialFeatures=" + spacialFeatures + ", lastUpdate=" + lastUpdate + "]";
	}
	
}
