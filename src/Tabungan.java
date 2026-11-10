public class Tabungan extends Rekening implements BerBunga {
    private double bungaPersen;

    public Tabungan(String nomor, String pemilik, int saldo, double bungaPersen) {
        super(nomor, pemilik, saldo);
        this.bungaPersen = bungaPersen;
    }

    // Gratis kalau saldo minimal 1.000.000, selain itu Rp5.000
    @Override
    public int biayaAdminBulanan() {
        if (getSaldo() >= 1000000) {
            return 0;
        }
        return 5000;
    }

    @Override
    public int tambahBunga() {
        int bunga = (int) Math.round(getSaldo() * bungaPersen / 100);
        saldo += bunga;
        return bunga;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("     Tabungan, bunga " + bungaPersen + "% per bulan");
    }
}