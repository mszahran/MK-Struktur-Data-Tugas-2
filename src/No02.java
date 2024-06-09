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

        // Hitung posisi setiap elemen
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Tempatkan elemen dalam urutan yang benar
        for (int i = array.length - 1; i >= 0; i--) {
            output[count[array[i] - min] - 1] = array[i];
            count[array[i] - min]--;
        }

        // Salin elemen yang diurutkan ke array asli
        System.arraycopy(output, 0, array, 0, array.length);
    }
}
