public class Trips implements Tripsuliides {
    private char[][] kohad = new char[3][3];
    private char[] symbolid = {'X', '0'};
    private char kord = 'X';

    public void alusta(char symbol) {
        if (new String(symbolid).indexOf(symbol) == -1) { // https://stackoverflow.com/a/18581539
            throw new IllegalArgumentException("See sümbol ei sobi!");
        }
        kord = symbol;
    }

    public char kelleKord() {
        return kord;
    }

    public void paiguta(char symbol, int rida, int veerg) throws Exception {
        if (kelleKord() == symbol){
            kohad[rida][veerg] = symbol;
        }
        else {
            throw new IllegalArgumentException("Pole selle sümboli kord!");
        }

        // Vaheta korda
        if (kelleKord() == symbolid[0]){
            kord = symbolid[1];
        }
        else if (kelleKord() == symbolid[1]) {
            kord = symbolid[0];
        }
    }

    public char kysi(int rida, int veerg) {
        return kohad[rida][veerg];
    }

    public boolean kontrolliVoitu() throws Exception {
        boolean isDone = false;

        for (char c : symbolid) {
            if ((kysi(0, 0) == c && kysi(1, 0) == c && kysi(2, 0) == c) || // ülevalt alla 1 tulp
                    (kysi(0, 1) == c && kysi(1, 1) == c && kysi(2, 1) == c) || // ülevalt alla 2 tulp
                    (kysi(0, 2) == c && kysi(1, 2) == c && kysi(2, 2) == c) || // ülevalt alla 3 tulp
                    (kysi(0, 0) == c && kysi(1, 1) == c && kysi(2, 2) == c) || // ülevalt vasakult alla paremale
                    (kysi(0, 2) == c && kysi(1, 1) == c && kysi(2, 0) == c) || // ülevalt paremalt alla vasakule
                    (kysi(0, 0) == c && kysi(0, 1) == c && kysi(0, 2) == c) || // 1. rida
                    (kysi(1, 0) == c && kysi(1, 1) == c && kysi(1, 2) == c) || // 2. rida
                    (kysi(2, 0) == c && kysi(2, 1) == c && kysi(2, 2) == c)) { // 2. rida
                isDone = true;
                System.out.println("Võitis [" + c + "]");
                break;
            }
        }

        return isDone;
    }
}
