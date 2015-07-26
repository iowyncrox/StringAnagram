public class StringAnagram {

	public static boolean isAnagram(String stringOne, String stringTwo) {

		if (stringOne == null || stringTwo == null)
			return false;

		if (stringOne.length() != stringTwo.length())
			return false;

		Character[] charArrayOne = toCharacterArray(stringOne);
		Character[] charArrayTwo = toCharacterArray(stringTwo);

		return anagramHelper(charArrayOne, charArrayTwo);
	}

	private static boolean anagramHelper(Comparable[] arrayOne,
			Comparable[] arrayTwo) {

		quickSort(arrayOne);
		quickSort(arrayTwo);

		for (int i = 0; i < arrayTwo.length; i++) {
			if (arrayOne[i] != arrayTwo[i])
				return false;
		}
		return true;
	}

	private static void quickSort(Comparable[] array) {
		sort(array, 0, array.length - 1);
	}

	private static void sort(Comparable[] array, int start, int end) {
		if (start < end) {
			int j = partition(array, start, end);
			sort(array, start, j - 1);
			sort(array, j + 1, end);
		}
	}

	private static int partition(Comparable[] array, int low, int high) {
		Comparable pivot = array[low];
		int i = low;
		int j = high + 1;

		while (true) {

			while (compare(array[++i], pivot)) {
				if (i == high)
					break;
			}

			while (compare(pivot, array[--j])) {
				if (j == low)
					break;
			}

			if (i >= j)
				break;

			swap(array, i, j);
		}

		swap(array, low, j);
		return j;
	}

	private static boolean compare(Comparable i, Comparable j) {
		return (i.compareTo(j) < 0);
	}

	private static void swap(Comparable[] array, int i, int j) {
		Comparable temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	private static Character[] toCharacterArray(String str) {
		char[] charArray = new char[str.length()];
		charArray = str.toCharArray();
		Character[] characterArray = new Character[charArray.length];
		for (int i = 0; i < charArray.length; i++) {
			characterArray[i] = charArray[i];
		}
		return characterArray;
	}

	public static void main(String[] args) {
		String str1 = "the sky is blue";
		String str2 = "eth is lbue ksy";

		System.out.println(isAnagram(str1, str2));
	}
}
