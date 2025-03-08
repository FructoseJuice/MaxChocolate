public record Section(int left, int right) {
    @Override
    public String toString() {
        return left + " " + right;
    }
}
