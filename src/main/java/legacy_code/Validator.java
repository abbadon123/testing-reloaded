package legacy_code;

public class Validator {

	/**
	 * Returns
	 * <code>true</code> if the string is
	 * <code>null</code>, meaning it is a
	 * <code>null</code> reference, nothing but spaces, or the string
     * "
	 * <code>null</code>".
	 *
	 * @param s the string to check
	 * @return <code>true</code> if the string is <code>null</code>;
	 * <code>false</code> otherwise
	 */
	public static boolean isNull(String s) {
		if (s == null) {
			return true;
		}

		String strippedString = s.replaceAll(" ", "");
		return strippedString.isEmpty() || strippedString.equals("null");
	}
}
