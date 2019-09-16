import java.time.LocalDate;
import java.util.Comparator;

/**
 * Represents a Release object.
 * @author Jordan Chrisostomidis
 */
public class Release {
	public static final Comparator<Release> RELEASE_DATE_ORDER = new ReleaseDateComparator();
	public static final Comparator<Release> OPEN_DATE_ORDER = new OpenDateComparator();
	public static final Comparator<Release> DEPENDENCY_DATE_ORDER = new DependencyDateComparator();
	@SuppressWarnings("unused")
	private String id, name, type, status, manager, author, appId;
	private LocalDate openDate, dependencyDate, contentDate, rtmDate;
	
	/**
	 * Creates a Release object with the provided data as expected.
	 * @param data The data as expected.
	 * @throws IllegalArgumentException Thrown if data is not of size 11.
	 */
	public Release(String[] data) throws IllegalArgumentException{
		if(data.length != 11)
			throw new IllegalArgumentException();
		
		id = data[0];
		name = data[1];
		type = data[2];
		status = data[3];
		if(data[4].length() > 0)
			openDate = LocalDate.parse(data[4]);
		if(data[5].length() > 0)
			dependencyDate = LocalDate.parse(data[5]);
		if(data[6].length() > 0)
			contentDate = LocalDate.parse(data[6]);
		if(data[7].length() > 0)
			rtmDate = LocalDate.parse(data[7]);
		manager = data[8];
		author = data[9];
		appId = data[10];
	}
	
	/**
	 * Gets the name.
	 * @return The name.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the rtm_date.
	 * @return The rtm_date.
	 */
	public LocalDate getRtmDate() {
		return rtmDate;
	}
	
	/**
	 * Gets the open_date.
	 * @return The open_date.
	 */
	public LocalDate getOpenDate() {
		return openDate;
	}
	
	/**
	 * Gets the dependency_date.
	 * @return The dependency_date.
	 */
	public LocalDate getDependencyDate() {
		return dependencyDate;
	}
	
	@Override
	public String toString() {
		return String.format("id = %10s, name = %20s, type = %6s, status = %9s, "
					+ "open_date = %10s, dependency_date = %10s, content_date = %10s, "
					+ "rtm_date = %10s, manager = %20s, author = %20s",
					id, name, type.trim(), status, openDate, dependencyDate, 
					contentDate, rtmDate, manager, author);
	}
	
	/**
	 * Compares Releases by rtm_date.
	 * @author Jordan Chrisostomidis
	 */
	private static class ReleaseDateComparator implements Comparator<Release>{

		@Override
		public int compare(Release release1, Release release2) {
			if(release1.getRtmDate() == null)
				return 1;
			if(release2.getRtmDate() == null)
				return -1;
			
			if(release1.getRtmDate().compareTo(release2.getRtmDate()) < 0)
				return -1;
			if(release1.getRtmDate().compareTo(release2.getRtmDate()) > 0)
				return 1;
			return 0;
		}
		
	}
	
	/**
	 * Compares Releases by rtm_date.
	 * @author Jordan Chrisostomidis
	 */
	private static class OpenDateComparator implements Comparator<Release>{

		@Override
		public int compare(Release release1, Release release2) {
			if(release1.getOpenDate() == null)
				return 1;
			if(release2.getOpenDate() == null)
				return -1;
			
			if(release1.getOpenDate().compareTo(release2.getOpenDate()) < 0)
				return -1;
			if(release1.getOpenDate().compareTo(release2.getOpenDate()) > 0)
				return 1;
			return 0;
		}
		
	}
	
	/**
	 * Compares Releases by dependency_date.
	 * @author Jordan Chrisostomidis
	 */
	private static class DependencyDateComparator implements Comparator<Release>{

		@Override
		public int compare(Release release1, Release release2) {
			if(release1.getDependencyDate() == null)
				return 1;
			if(release2.getDependencyDate() == null)
				return -1;
			
			if(release1.getDependencyDate().compareTo(release2.getDependencyDate()) < 0)
				return -1;
			if(release1.getDependencyDate().compareTo(release2.getDependencyDate()) > 0)
				return 1;
			return 0;
		}
		
	}
	
}
