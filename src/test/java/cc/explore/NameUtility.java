package cc.explore;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 
 * Junior automation engineer was asked to implement a utility method that:
 * 1. accepts a string that includes from 0 to N words of a name
 * 2. returns a string that represents the first letter from each word in the name followed by
 *    "."
 * For example: "Bruno Mars" → "B.M."
 * "Dave M Jones" → "D.M.J."
 * "MichaelSmith" → "M."
 *
 */
public class NameUtility {

	public static void main(String[] args) {
		/**
		 * Exception in thread "main" Bruno.. Mars.
         * Dave. M. Jones.
         * java.lang.StringIndexOutOfBoundsException: String index out of range: -1
	     *         at java.lang.String.substring(String.java:1967)
	     *         at cc.explore.NameUtility.convertNameToInitials(NameUtility.java:25)
	     *         at cc.explore.NameUtility.main(NameUtility.java:19)
		 */
		//System.out.println(convertNameToInitials("Bruno Mars"));
		//System.out.println(convertNameToInitials("Dave M Jones"));
		//System.out.println(convertNameToInitials("MichaelSmith"));
		
		System.out.println(newConvertNameToInitials("Bruno Mars"));
		System.out.println(newConvertNameToInitials("Dave M Jones"));
		System.out.println(newConvertNameToInitials("MichaelSmith"));
	}
	
	public static String convertNameToInitials(String name) {
		int firstSpace = name.indexOf(" ");
		int lastSpace = name.lastIndexOf(" ");
		String firstName = name.substring(0, firstSpace);
		String middleName = name.substring(firstSpace, lastSpace);
		String lastName = name.substring(lastSpace);
		String initials = firstName + "." + middleName + "." + lastName + ".";
		return initials;
	}
	
	public static String newConvertNameToInitials(String name) {
		return Arrays.stream(name.split("\\s+")).map(e -> e.substring(0, 1)).collect(Collectors.joining(".")) + ".";
	}
}
