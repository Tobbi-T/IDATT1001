class AnalyzeText {
    public static void main(String[] args) {
        TextAnalyzer ta = new TextAnalyzer();
        System.out.println(ta.letterCount(ta.analyzeText("aaaabccccdee!!"), 'a'));
    }
}

class TextAnalyzer  {
    public int[] analyzeText(String text) {
        int[] amount = new int[30];
        char[] chars = text.toLowerCase().toCharArray();

        for(char c : chars) {
            int n;
            try {
                n = getNumberGivenLetter(c);
                amount[n]++;
            }
            catch(IllegalArgumentException e) {
                amount[29]++;
            }
        }

        return amount;
    }

    public int uniqueLetters(int[] analyzedText) {
        int count = 0;

        for(int i : analyzedText) {
            if(i > 0)
                count++;
        }

        return count;
    }

    public int totalChars(int[] analyzedText) {
        int count = 0;

        for(int i : analyzedText) {
            count += i;
        }

        return count;
    }

    public float percentSymbols(int[] analyzedText) {
        return ( (float) analyzedText[29] / (float) totalChars(analyzedText) );
    }

    public int letterCount(int[] analyzedText, char letter) throws IllegalArgumentException {
        return analyzedText[getNumberGivenLetter(letter)];
    }

    public String mostUsedLetters(int[] analyzedText) {
        final char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
                                'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'Æ', 'Ø', 'Å'};
        StringBuilder chars = new StringBuilder();
        int highest = 0;

        for(int i = 0; i < 29; i++) {
            if(analyzedText[i] > highest) {
                chars = new StringBuilder(String.valueOf(letters[i]));
                highest = analyzedText[i];
            }
            else if(analyzedText[i] == highest) {
                chars.append(", ").append(letters[i]);
            }
        }

        return chars.toString();
    }

    private int getNumberGivenLetter(char letter) throws IllegalArgumentException {
        if((int) letter >= 97 && (int) letter <= 122) //a-z
            return (int) letter - 97;
        else if((int) letter == 230) //æ
            return 26;
        else if((int) letter == 248) //ø
            return 27;
        else if((int) letter == 229) //å
            return 28;
        else
            throw new IllegalArgumentException("Expected a letter from a-å, got '" + letter + "'.");
    }
}