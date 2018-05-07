import java.util.*;

public class Thesaurus {
	public static HashMap<String, ArrayList<String>> thesaurus = new HashMap<String, ArrayList<String>>();
	
	public static void addWord(String word, ArrayList<String> synonyms) {
		word = word.toLowerCase();
		if (thesaurus.get(word) != null) {
			thesaurus.get(word).addAll(synonyms);
		} else {
			thesaurus.put(word, synonyms);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = "";
		String synonyms = "";
		ArrayList<String> synonymsList = new ArrayList<String>();
		
		while (true) {
			System.out.print("Enter a word or enter '1' to end: ");

			word = sc.nextLine();
			
			if (word.equals("1")) {
				break;
			}
			
			System.out.printf("Enter synonyms for %s (separated by commas) or just enter '0' to skip: ", word);			
			synonyms = sc.nextLine().replaceAll("\\s+", "");
			String[] tmp = synonyms.split(",");
			synonymsList = new ArrayList<String>(Arrays.asList(tmp));	
			
			if (synonyms.equals("1")) {
				addWord(word, null);
				break;
			}

			if (synonyms.equals("0")) {
				addWord(word, null);
			} else {
				addWord(word, synonymsList);
				synonyms = "";		
			}
		}
		
		sc.close();
		
		// Print content
		Set<Map.Entry<String, ArrayList<String>>> set = thesaurus.entrySet();
		Iterator<Map.Entry<String, ArrayList<String>>> iterator = set.iterator();
		while(iterator.hasNext()) {
			Map.Entry<String, ArrayList<String>> pair = (Map.Entry<String, ArrayList<String>>)iterator.next();		
			if (pair.getValue() == null) {
				System.out.printf("Word is '%s'. There are no synonyms.\n", pair.getKey());
			} else {
				System.out.printf("Word is '%s'. Synonyms are: \n", pair.getKey());
				System.out.println(pair.getValue());
			}
			
		}
	}
}
