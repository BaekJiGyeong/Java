
public class StringSplit {

	public static void main(String[] args) {
		String hashtags = " 오이 소박이 맛이쪙";
		hashtags = hashtags.trim();
		String hashtagArray[] = hashtags.split(" ");
	
		for (String tag : hashtagArray) {
			System.out.println(tag);
		}
		
		String a[] = {"a", "b", "c", "d"};
		String end ="";
		for (String t : a) {
			end = end + " #" + t;
		}
		System.out.println(end);
	}
}
