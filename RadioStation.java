import java.util.Arrays;

public class RadioStation {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((ParsedStringForm == null) ? 0 : ParsedStringForm.hashCode());
		result = prime * result + Arrays.hashCode(URLs);
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result
				+ ((language == null) ? 0 : language.hashCode());
		result = prime * result
				+ ((stationRawInfo == null) ? 0 : stationRawInfo.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RadioStation other = (RadioStation) obj;
		if (ParsedStringForm == null) {
			if (other.ParsedStringForm != null)
				return false;
		} else if (!ParsedStringForm.equals(other.ParsedStringForm))
			return false;
		if (!Arrays.equals(URLs, other.URLs))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (stationRawInfo == null) {
			if (other.stationRawInfo != null)
				return false;
		} else if (!stationRawInfo.equals(other.stationRawInfo))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	public String getStationRawInfo() {
		return stationRawInfo;
	}

	public void setStationRawInfo(String stationRawInfo) {
		this.stationRawInfo = stationRawInfo;
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

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getParsedStringForm() {
		return ParsedStringForm;
	}

	public void setParsedStringForm(String parsedStringForm) {
		ParsedStringForm = parsedStringForm;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	String stationRawInfo;
	String title;
	String description;
	String genre;
	String country;
	String language;
	String[] URLs;
	String ParsedStringForm;
	static final int expectedFields = 11;

	public RadioStation(String stationRawInfo) {

		if (stationRawInfo == null) {
			throw new NullPointerException("stationRawInfo is null");
		}
		this.stationRawInfo = stationRawInfo;
		String[] infoParsed = stationRawInfo.split("\t");
		if (infoParsed.length != expectedFields) {
			throw new IllegalArgumentException("ERROR: " + stationRawInfo
					+ " cannot be parsed into " + expectedFields + " fields.");
		}
		URLs = new String[6];
		title = infoParsed[0];
		description = infoParsed[1];
		genre = infoParsed[2];
		country = infoParsed[3];
		language = infoParsed[4];
		if (!infoParsed[5].toString().equals("-")) {
			URLs[0] = infoParsed[5];
		}
		if (!infoParsed[6].toString().equals("-")) {
			URLs[1] = infoParsed[6];
		}
		if (!infoParsed[7].toString().equals("-")) {
			URLs[2] = infoParsed[7];
		}
		if (!infoParsed[8].toString().equals("-")) {
			URLs[3] = infoParsed[8];
		}
		if (!infoParsed[9].toString().equals("-")) {
			URLs[4] = infoParsed[9];
		}
		if (!infoParsed[10].toString().equals("-")) {
			URLs[5] = infoParsed[10];
		}
		createParsedStringForm();
	}

	private void createParsedStringForm() {
		StringBuffer sb = new StringBuffer();
		sb.append(title);
		sb.append("\t");
		sb.append(description);
		sb.append("\t");
		sb.append(genre);
		sb.append("\t");
		sb.append(country);
		sb.append("\t");
		sb.append(language);
		sb.append("\t");
		if (!(URLs[0] == null)) {
			sb.append(URLs[0]);
		} else {
			sb.append("-");
		}
		sb.append("\t");
		if (!(URLs[1] == null)) {
			sb.append(URLs[1]);
		} else {
			sb.append("-");
		}
		sb.append("\t");
		if (!(URLs[2] == null)) {
			sb.append(URLs[2]);
		} else {
			sb.append("-");
		}
		sb.append("\t");
		if (!(URLs[3] == null)) {
			sb.append(URLs[3]);
		} else {
			sb.append("-");
		}
		sb.append("\t");
		if (!(URLs[4] == null)) {
			sb.append(URLs[4]);
		} else {
			sb.append("-");
		}
		sb.append("\t");
		if (!(URLs[5] == null)) {
			sb.append(URLs[5]);
		} else {
			sb.append("-");
		}
		ParsedStringForm = sb.toString();
	}

	@Override
	public String toString() {
		return ParsedStringForm;
	}

	public void prettyPrint() {
		System.out.println(ParsedStringForm);
	}

	public static void main(String[] args) {
		RadioStation first = new RadioStation(
				"WMBR 88.1 FM Cambridge, MA	From MIT, First on your FM Dial. (\"College Station\")	College/University	USA	English	http://headphones.mit.edu:8000/	http://wmbr.mit.edu/WMBR_live_128.m3u	http://www.wmbr.org/WMBR_live_128.m3u	http://18.7.25.128/WMBR_live_128.m3u	http://headphones.mit.edu:8000	http://wmbr.org/WMBR_live_128.m3u");
		first.prettyPrint();
	}

}
