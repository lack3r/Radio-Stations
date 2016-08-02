import java.util.Arrays;

/**
 * @author Andreas Loizou
 *
 */
public class RadioStation {

	protected String stationRawInfo;/*The information for a radio station exactly as written in the input file*/
	protected String title;			/*The title of the radio station*/
	protected String description;	/*The description of the radio station*/
	protected String genre;			/*The genre of the radio station*/
	protected String country;		/*The country of the radio station*/
	protected String language;		/*The language of the radio station*/
	protected String[] URLs;		/*The links of the Radio station that can be used to listen online. The input file contains up to 6*/
	protected String ParsedStringForm; /*The title of the radio station*/
	protected static final int EXPECTED_FIELDS = 11; 	/*The title of the radio station*/
	protected static final int MAX_URLS = 6; 			/*How many URLs the input file might contain for each Radio Station*/
	protected static final String SPLIT_REGEX = "\t"; 	/*How the fields of the input line are splitted.*/
	protected static final String JOIN_REGEX = "\t"; 	/*How the fields of the output line are joined.*/

	
	/**
	 * @author An Enum that defines the position of each field in the input file
	 *
	 */
	static enum FieldPosition {TITLE(0),DESCRIPTION(1),GENRE(2),COUNTRY(3),LANGUAGE(4),URLS(5);
		private int value;  
		private FieldPosition(int value){  
			this.value=value;  
	}  	
	
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
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

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
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

	/**
	 * @return The raw info for the radio station as read from the input file
	 */
	public String getStationRawInfo() {
		return stationRawInfo;
	}

	/**
	 * @return The title of the Radio Station
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return The description of the Radio Station
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return The genre of the Radio Station
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * @return the Country of the Radio Station
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @return The string of the radio station after the string is parsed. It should match the stationRawInfo.
	 */
	public String getParsedStringForm() {
		return ParsedStringForm;
	}

	/**
	 * @return The language of the Radio Station
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param stationRawInfo. We get one line with all the information of the radio station in a raw form. The constructor tries to create the RadioStation object based on the raw information
	 */
	public RadioStation(String stationRawInfo) {

		if (stationRawInfo == null) {
			throw new NullPointerException("stationRawInfo is null");
		}
		this.stationRawInfo = stationRawInfo;
		String[] infoParsed = stationRawInfo.split(SPLIT_REGEX);
		if (infoParsed.length != EXPECTED_FIELDS) {
			throw new IllegalArgumentException("ERROR: " + stationRawInfo
					+ " cannot be parsed into " + EXPECTED_FIELDS + " fields.");
		}
		URLs = new String[MAX_URLS];
		title = infoParsed[FieldPosition.TITLE.value];
		description = infoParsed[FieldPosition.DESCRIPTION.value];
		genre = infoParsed[FieldPosition.GENRE.value];
		country = infoParsed[FieldPosition.COUNTRY.value];
		language = infoParsed[FieldPosition.LANGUAGE.value];
		int urlOffset = FieldPosition.URLS.value;
		for (int urlNo=urlOffset;urlNo<urlOffset+MAX_URLS;urlNo++){
			if (!infoParsed[urlNo].toString().equals("-")) {
				URLs[urlNo-urlOffset] = infoParsed[urlNo];
			}
		}
		createParsedStringForm();
	}

	/**
	 * 
	 */
	private void createParsedStringForm() {
		StringBuffer sb = new StringBuffer();
		sb.append(title);
		sb.append(JOIN_REGEX);
		sb.append(description);
		sb.append(JOIN_REGEX);
		sb.append(genre);
		sb.append(JOIN_REGEX);
		sb.append(country);
		sb.append(JOIN_REGEX);
		sb.append(language);
		sb.append(JOIN_REGEX);
		
		for (int urlNo=0;urlNo<MAX_URLS;urlNo++){
			if (!(URLs[urlNo] == null)) {
				sb.append(URLs[urlNo]);
			} else {
				sb.append("-");
			}
			
			if(urlNo<MAX_URLS-1){
				sb.append(JOIN_REGEX);
			}
		}
		ParsedStringForm = sb.toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ParsedStringForm;
	}

	/**
	 * Print the Radio Station in a pretty form
	 */
	public void prettyPrint() {
		System.out.println(ParsedStringForm);
	}

	/**
	 * @param args Is not used
	 */
	public static void main(String[] args) {
		RadioStation first = new RadioStation(
				"WMBR 88.1 FM Cambridge, MA	From MIT, First on your FM Dial. (\"College Station\")	College/University	USA	English	http://headphones.mit.edu:8000/	http://wmbr.mit.edu/WMBR_live_128.m3u	http://www.wmbr.org/WMBR_live_128.m3u	http://18.7.25.128/WMBR_live_128.m3u	http://headphones.mit.edu:8000	http://wmbr.org/WMBR_live_128.m3u");
		first.prettyPrint();
	}

}
