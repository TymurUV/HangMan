public class Storage {
    private String[] words = {"Tymur", "Vlad", "School", "Chemistry", "Anime"};

    public String getRandomWord() {
        int randomIndex = (int) (Math.random() * words.length);
        return words[randomIndex];
    }
}
