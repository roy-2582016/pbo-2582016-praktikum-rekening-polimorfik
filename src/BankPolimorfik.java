public class BankPolimorfik {
    public static void main(String[] args) {
        // Buat ketiga object di variabel masing-masing dulu
        Tabungan ani = new Tabungan("101", "Ani", 1000000, 2.5);
        Tabungan citra = new Tabungan("102", "Citra", 300000, 2.0);
        Giro budi = new Giro("201", "Budi", 200000, 500000);

        // Semua rekening, dan hanya yang berbunga
        Rekening[] semua = { ani, citra, budi };
        BerBunga[] berbunga = { ani, citra };

        System.out.println("========== REKENING AWAL ==========");
        for (Rekening r : semua) {
            r.tampilkanInfo();
        }

        System.out.println();
        System.out.println("========== AKHIR BULAN ============");
        // Biaya admin semua rekening dulu...
        for (Rekening r : semua) {
            int biaya = r.potongBiayaAdmin();
            System.out.println(r.getNomor() + " biaya admin  : " + Rekening.rupiah(biaya));
        }
        // ...baru bunga untuk yang berbunga
        for (BerBunga b : berbunga) {
            int bunga = b.tambahBunga();
            System.out.println(b.getNomor() + " bunga        : " + Rekening.rupiah(bunga));
        }

        System.out.println();
        System.out.println("========== REKENING AKHIR =========");
        int total = 0;
        for (Rekening r : semua) {
            r.tampilkanInfo();
            total += r.getSaldo();
        }
        System.out.println("-----------------------------------");
        System.out.println("Total dana bank : " + Rekening.rupiah(total));

        // Percobaan: Rekening r = new Rekening("999", "Eko", 0);
        // Pesan error: java: Rekening is abstract; cannot be instantiated
    }
}