public class Main {
    static int[] chocolate;

    public static void main(String[] args) {
        int n = 6;
        int k = 3;

        chocolate = new int[n];
        chocolate[0] = 3;
        chocolate[1] = 2;
        chocolate[2] = 5;
        chocolate[3] = 1;
        chocolate[4] = 6;
        chocolate[5] = 3;

        Section section = f(0, n, k);

        System.out.println(section);
        System.out.println(valOfSection(section));
    }

    public static Section f(int l, int r, int k) {
        if ((r - l) == 0 || k == 0) return null;
        if ((r - l) == 1 && k > 1) return null;
        if (k == 1) return new Section(l, r);

        Section maxMinSection = null;

        for (int i = l + k - 1; i < r; i++) {
            Section rightSection = new Section(i, r);
            Section leftSection = f(l, i, k-1);

            if (valOfSection(leftSection) < valOfSection(rightSection)) {
                if (valOfSection(maxMinSection) < valOfSection(leftSection)) {
                    maxMinSection = leftSection;
                }
            } else {
                if (valOfSection(maxMinSection) < valOfSection(rightSection)) {
                    maxMinSection = rightSection;
                }
            }
        }

        return maxMinSection;
    }

    public static int valOfSection(Section section) {
        if (section == null) return 0;

        int val = 0;

        for (int i = section.left(); i < section.right(); i++) {
            val += chocolate[i];
        }

        return val;
    }
}