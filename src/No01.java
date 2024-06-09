import java.util.Arrays;

public class Main {
    // Merge dua subarray terurut menjadi satu array terurut
    private static void merge(int arr[], int l, int m, int r) {
        System.out.println(Arrays.toString(arr) + l + "" + m + "" + r);
        // Ukuran dua subarray
        int n1 = m - l + 1;
        int n2 = r - m;

        // Buat array sementara
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Salin data ke array sementara
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Gabungkan array sementara menjadi array utama
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Salin elemen yang tersisa dari L[] jika ada
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Salin elemen yang tersisa dari R[] jika ada
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function yang melakukan MergeSort pada array
    private static void sort(int arr[], int l, int r) {
        // 1. 0 < 5 = TRUE
        // 2. 0 < 2 = TRUE
        // 3. 0 < 1 = TRUE
        // 4. 0 < 0 = FALSE
        // 5. 1 < 1 = FALSE
        if (l < r) {
            // Temukan titik tengah
            int m = (l + r) / 2;
            // 1. nilai m = 2
            // 2. nilai m = 1

            // Urutkan setengah pertama dan kedua
            sort(arr, l, m);
            sort(arr, (m + 1), r);

            // Gabungkan dua setengah yang sudah diurutkan
            merge(arr, l, m, r);
        }
    }

    // Method untuk memanggil Merge Sort dari luar
    public static void mergeSort(int arr[]) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    // Method untuk menampilkan array
    public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Contoh penggunaan
    public static void main(String args[]) {
        int nilai1 = 10;
        int nilai2 = 7;
        int nilai3 = 5;
        int nilai4 = 9;
        int nilai5 = 3;
        int nilai6 = 2;

        int arr[] = {nilai1, nilai2, nilai3, nilai4, nilai5, nilai6};

        System.out.println("Array sebelum diurutkan:");
        printArray(arr);

        mergeSort(arr);

        System.out.println("Array setelah diurutkan:");
        printArray(arr);
    }
}
