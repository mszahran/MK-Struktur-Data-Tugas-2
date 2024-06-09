import java.util.Arrays;

public class No01 {

    public static void main(String[] args) {
        // Inisialisasi nilai data
        int nilai1 = 5;
        int nilai2 = 2;
        int nilai3 = 4;
        int nilai4 = 1;
        int nilai5 = 3;
        int nilai6 = 6;

        int[] data = {nilai1, nilai2, nilai3, nilai4, nilai5, nilai6};

        // Mengurutkan data menggunakan Merge Sort
        data = mergeSort(data);

        // Menampilkan data yang telah diurutkan
        System.out.print("Data yang diurutkan: ");
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }

    private static int[] mergeSort(int[] data) {
        if (data.length <= 1) {
            return data;
        }

        int middle = data.length / 2;
        // 5, 2, 4
        int[] left = Arrays.copyOfRange(data, 0, middle);
        // 1, 3, 6
        int[] right = Arrays.copyOfRange(data, middle, data.length);

        left = mergeSort(left); // recursive menjadikan array sebelumnya [5, 2, 4] menjadi [2, 4, 5]
        right = mergeSort(right); // recursive menjadikan array sebelumnya [1, 3, 6] menjadi [1, 3, 6]

        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        // i / left [2, 4, 5]
        // j / right [1, 3, 6]
        // result [1, 2, 3, 4, 5]
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        while (i < left.length) {
            result[k++] = left[i++];
        }

        // result [1, 2, 3, 4, 5, 6]
        while (j < right.length) {
            result[k++] = right[j++];
        }

        return result;
    }
}
