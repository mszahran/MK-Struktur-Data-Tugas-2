import java.util.Arrays;

public class No02 {
    public static void main(String[] args) {
        // Tentukan nilai untuk variabel nilai1 hingga nilai6
        int nilai1 = 23;
        int nilai2 = 15;
        int nilai3 = 42;
        int nilai4 = 8;
        int nilai5 = 16;
        int nilai6 = 4;

        // Masukkan nilai-nilai tersebut ke dalam array
        int[] data = {nilai1, nilai2, nilai3, nilai4, nilai5, nilai6};

        // Cetak data sebelum diurutkan
        System.out.println("Data sebelum diurutkan: " + Arrays.toString(data));

        // Urutkan data menggunakan Counting Sort
        countingSort(data);

        // Cetak data setelah diurutkan
        System.out.println("Data setelah diurutkan: " + Arrays.toString(data));
    }

    public static void countingSort(int[] array) {
        // array = [23, 15, 42, 8, 16, 4]
        int max = Arrays.stream(array).max().getAsInt();
        int min = Arrays.stream(array).min().getAsInt();
        int range = max - min + 1;

        // max = 42
        // min = 4
        // range = 39 (42 - 4 + 1)

        int[] count = new int[range];
        int[] output = new int[array.length];

        // Hitung frekuensi setiap elemen
        // Bagian kode ini bertujuan untuk menghitung frekuensi (jumlah kemunculan) setiap elemen dalam array input dan menyimpannya dalam array count.
        // array.length = 6
        for (int i = 0; i < array.length; i++) {
            count[array[i] - min]++;
        }
        // Setelah semua iterasi, array count akan memiliki nilai berikut pada posisi yang relevan:
        // count = [1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1]
        // Di sini, indeks dalam array count mewakili nilai asli elemen setelah ditambah min (4).
        // count[0] (untuk nilai 4) memiliki 1
        // count[4] (untuk nilai 8) memiliki 1
        // count[11] (untuk nilai 15) memiliki 1
        // count[12] (untuk nilai 16) memiliki 1
        // count[19] (untuk nilai 23) memiliki 1
        // count[38] (untuk nilai 42) memiliki 1

        // Hitung posisi setiap elemen
        // Misalkan kita memiliki array count setelah menghitung frekuensi
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        // Iterasi melalui array count:
        // Iterasi pertama (i = 1):
        // count[1] += count[0]
        // count[1] = 0 + 1 = 1

        // Ilustrasi
        // Berikut adalah gambaran bagaimana nilai dalam count berubah:
        // Setelah iterasi pertama
        // [1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1]
        // Setelah iterasi kesembilan belas
        // [1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6]

        // Makna dari Nilai Akhir
        // count[i] sekarang menunjukkan posisi terakhir elemen dengan nilai i + min dalam array yang diurutkan.
        // Contoh: count[0] = 1 berarti elemen dengan nilai 4 (karena min = 4) berada di indeks 0 dalam array yang diurutkan.
        // Contoh: count[19] = 5 berarti elemen dengan nilai 23 berada di indeks 4 dalam array yang diurutkan.
        // array = {23, 15, 42, 8, 16, 4}

        // Tempatkan elemen dalam urutan yang benar
        for (int i = array.length - 1; i >= 0; i--) {
            output[count[array[i] - min] - 1] = array[i];
            count[array[i] - min]--;
        }
        // array[i]: Nilai elemen saat ini dalam iterasi.
        // array[i] - min: Ini memberikan posisi akhir elemen dalam array yang diurutkan. Misalnya, jika array[i] adalah 8 dan min adalah 4, maka nilai ini adalah 4, yang menunjukkan elemen 8 berada pada posisi keempat dalam array yang diurutkan.
        // count[array[i] - min]: Mengakses jumlah elemen yang kurang dari atau sama dengan nilai saat ini dalam array yang diurutkan. Ini mengembalikan posisi terakhir elemen dalam array yang diurutkan.
        // count[array[i] - min] - 1: Karena indeks array dimulai dari 0, kita mengurangi 1 untuk mendapatkan posisi yang tepat dalam array yang diurutkan.
        // output[count[array[i] - min] - 1]: Ini adalah posisi di mana elemen saat ini harus ditempatkan dalam array yang diurutkan.

        // Proses iterasi dari belakang ke depan akan menghasilkan:
        // Iterasi pertama (i = 5):
        // array[5] = 4
        // output[count[4 - 4] - 1] = array[5] → output[0] = 4
        // count[4 - 4]-- → count[0]--
        // Iterasi kedua (i = 4):
        // array[4] = 16
        // output[count[16 - 4] - 1] = array[4] → output[3] = 16
        // count[16 - 4]-- → count[12]--
        // Proses ini terus berlanjut hingga iterasi pertama hingga indeks pertama, sehingga semua elemen ditempatkan pada posisi yang benar dalam array yang diurutkan.

        // Salin elemen yang diurutkan ke array asli
        System.arraycopy(output, 0, array, 0, array.length);
    }
}
