package ee.bcs.vali.it;

public class Auto {
    private String mudel;
    private int aasta;
    private boolean kindlustus;

    public String getMudel() {
        return mudel;
    }

    public void setMudel(String mudel) {
        this.mudel = mudel;
    }

    public int getAasta() {
        return aasta;
    }

    public void setAasta(int aasta) {
        this.aasta = aasta;
    }

    public boolean isKindlustus() {
        return kindlustus;
    }

    public void setKindlustus(boolean kindlustus) {
        this.kindlustus = kindlustus;
    }
}