public class GetArrayMode {

    /*
    Para testes usei o array que @amanda_gdias colocou no Instagram.
    Mas o programa vai funcionar para arrays de qualquer tamanho e valores.
    O programa identifica se o array tem ou não uma moda e se tem moda ele identifica se é única ou múltipla.
    */

    public static int[] testArray = {1, 8, 85, 100, 2, 1, 3, 1};

    public static void getArrayMode(int[] array) {

        if (array.length == 0) {
            System.out.print("The array has no elements.");
            return;
        } else if (array.length == 1) {
            System.out.print("The array {" + array[0] + "} has only one element (" + array[0] + ") which is its mode.");
            return;
        }

        int[] placeHolderArray = array;
        int[] counts = getCounts(array);

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] == placeHolderArray[j]) {
                    counts[i]++;
                }
            }
        }

        int highestValue = getHighestValue(counts);

        if (highestValue == 1) {
            System.out.print("The array {");

            for (int k = 0; k < array.length; k++) {
                if (k != array.length - 1) {
                    System.out.print(array[k] + ", ");
                } else {
                    System.out.print(array[k] + "} ");
                }
            }
            System.out.print("has " + array.length + " modes. All values repeats " + highestValue + " time each.");

        } else {
            getAllValuesRepeatedMostTimes(highestValue, counts, array);
        }

    }

    private static int[] getCounts(int[] array) {
        int[] counts = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            counts[i] = 0;
        }

        return counts;
    }

    private static int getHighestValue(int[] array) {
        int highestValue = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > highestValue) {
                highestValue = array[i];
            }
        }
        return highestValue;
    }

    private static void getAllValuesRepeatedMostTimes(int highestRepeatedValue, int[] counts, int[] array) {

        int[] repeatedValues;
        int count = 0;

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == highestRepeatedValue) {
                count++;
            }
        }

        repeatedValues = new int[count];
        int index = 0;

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == highestRepeatedValue) {
                repeatedValues[index] = array[i];
                index++;
            }
        }

        checkModes(repeatedValues, array, highestRepeatedValue);
        //return repeatedValues;
    }

    private static void checkModes(int[] repeatedValues, int[] array, int highestRepeatedValue) {
        int count = 0;
        int[] placeHolderArray = repeatedValues;
        int[] finalPlaceholderArray = repeatedValues;

        if (arrayHasDifferentValues(repeatedValues) == false) {
            System.out.print("The mode of: {");
            for (int k = 0; k < array.length; k++) {
                if (k != array.length - 1) {
                    System.out.print(array[k] + ", ");
                } else {
                    System.out.print(array[k] + "} ");
                }
            }
            System.out.print("is " + repeatedValues[0] + ". This value repeats " + highestRepeatedValue + " times.");
        } else {
            while (arrayHasDifferentValues(repeatedValues)) {
                for (int i = 0; i < repeatedValues.length; i++) {
                    innerLoop:
                    for (int j = 0; j < placeHolderArray.length; j++) {
                        if (repeatedValues[i] != placeHolderArray[j]) {
                            count++;
                            int value = repeatedValues[i];
                            placeHolderArray = takeValueFromArray(repeatedValues, value);
                            repeatedValues = placeHolderArray;
                            break innerLoop;
                        }
                    }
                }
            }

            int[] finalValues = new int[count + 1];
            int index = 0;

            repeatedValues = finalPlaceholderArray;
            placeHolderArray = repeatedValues;

            do {
                outerLoop:
                for (int i = 0; i < repeatedValues.length; i++) {
                    innerLoop:
                    for (int j = 0; j < placeHolderArray.length; j++) {
                        if (repeatedValues[i] != placeHolderArray[j]) {

                            int value = repeatedValues[i];
                            finalValues[index] = value;
                            index++;
                            placeHolderArray = takeValueFromArray(repeatedValues, value);
                            repeatedValues = placeHolderArray;
                            break innerLoop;
                        }
                    }
                }
            } while (arrayHasDifferentValues(repeatedValues));

            finalValues[finalValues.length - 1] = repeatedValues[0];

            System.out.print("The array {");

            for (int k = 0; k < array.length; k++) {
                if (k != array.length - 1) {
                    System.out.print(array[k] + ", ");
                } else {
                    System.out.print(array[k] + "} ");
                }
            }

            System.out.print("has multiple modes. The values ");

            for (int i = 0; i < finalValues.length; i++) {

                if (i + 2 == finalValues.length) // penultimo
                {
                    System.out.print(finalValues[i] + " ");
                } else if (i + 1 == finalValues.length) //last
                {
                    System.out.print("and " + finalValues[i] + " repeated " + highestRepeatedValue + " times each.");
                } else {
                    System.out.print(finalValues[i] + ", ");
                }
            }
        }
    }

    private static boolean arrayHasDifferentValues(int[] array) {
        int[] placeholder = array;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < placeholder.length; j++) {
                if (array[i] != placeholder[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int[] takeValueFromArray(int[] array, int value) {
        int[] newArray;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                count++;
            }
        }

        newArray = new int[array.length - count];
        int index = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != value) {
                newArray[index] = array[i];
                index++;
            }
        }

        return newArray;
    }
}
