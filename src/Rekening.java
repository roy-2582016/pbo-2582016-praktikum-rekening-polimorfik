import java.util.Locale;

public abstract class Rekening {
    private String nomor;
    private String pemilik;
    protected int saldo;

    public Rekening(String nomor, String pemilik, int saldo) {
        this.nomor = nomor;
        this.pemilik = pemilik;
        this.saldo = saldo;
    }

    public String getNomor() {
        return nomor;
    }

    public String getPemilik() {
        return pemilik;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setor(int jumlah) {
        saldo += jumlah;
    }

    public boolean tarik(int jumlah) {
        if (jumlah <= saldo) {
            saldo -= jumlah;
            return true;
        }
        return false;
    }

    // Tiap jenis rekening menentukan biaya admin-nya sendiri
    public abstract int biayaAdminBulanan();

    // Memotong saldo sebesar biaya admin, lalu mengembalikan besar biayanya
    public int potongBiayaAdmin() {
        int biaya = biayaAdminBulanan();
        saldo -= biaya;
        return biaya;
    }

    public void tampilkanInfo() {
        System.out.println(String.format("%s | %-5s | %12s", nomor, pemilik, rupiah(saldo)));
    }

    // Format angka jadi Rp1.000.000
    protected static String rupiah(int nominal) {
        return "Rp" + String.format(Locale.US, "%,d", nominal).replace(',', '.');
    }
}