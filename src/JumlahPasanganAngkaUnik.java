import java.util.Arrays;
import java.util.Scanner;

public class JumlahPasanganAngkaUnik {
    public static void hitungJumlahPasanganAngkaUnik() {

        Scanner scanner = new Scanner(System.in);

        // Inisialisasi variabel untuk validasi panjang array
        boolean validasiPanjangArray = true;
        while (validasiPanjangArray) {
            System.out.print("Masukkan panjang array : ");
            // Cek apakah input panjang array adalah integer
            boolean cekValid = scanner.hasNextInt();
            if (cekValid) {
                int panjangArray = scanner.nextInt();
                scanner.nextLine(); // Membersihkan baris kosong dari scanner sebelum membaca elemen

                while (true) {
                    System.out.print("Masukkan elemen array (" + panjangArray + " angka dipisahkan spasi) : ");
                    String inputElemen = scanner.nextLine();

                    // Memisahkan elemen-elemen array dari string inputElemen
                    String[] elemenArrayString = inputElemen.trim().replaceAll("\\s+", " ").split(" ");

                    // Validasi agar jumlah elemen sesuai dengan panjang array
                    if (elemenArrayString.length != panjangArray) {
                        System.out.println("Maaf! Jumlah elemen yang dimasukkan harus sama dengan panjang array yang ditentukan yaitu " + panjangArray + ".");
                    } else {
                        boolean valid = true;

                        // Cek apakah setiap elemenArrayString adalah angka
                        for (String elemen : elemenArrayString) {
                            if (!elemen.matches("^[0-9]+$")) {
                                System.out.println("Maaf! Elemen harus berupa angka.");
                                valid = false;
                                break;
                            }
                        }

                        if (valid) {
                            // Konversi elemenArrayString menjadi array int
                            int[] elemenArray = new int[panjangArray];
                            for (int indeksElemenArray = 0; indeksElemenArray < panjangArray; indeksElemenArray++) {
                                elemenArray[indeksElemenArray] = Integer.parseInt(elemenArrayString[indeksElemenArray]);
                            }

                            // Sorting array elemenArray
                            Arrays.sort(elemenArray);

                            int jumlahPasanganUnik = 0;
                            // Cek apakah data yang sudah diurutkan sama atau tidak secara berurutan
                            for (int indeksPasanganUnik = 0; indeksPasanganUnik < elemenArray.length - 1; indeksPasanganUnik++) {
                                if (elemenArray[indeksPasanganUnik] != elemenArray[indeksPasanganUnik + 1]) {
                                    jumlahPasanganUnik++;
                                }
                            }

                            // Menampilkan hasil jumlah pasangan angka unik
                            System.out.println("Output :");
                            if (jumlahPasanganUnik > 0) {
                                System.out.println("Jumlah pasangan angka unik yang ditemukan : " + jumlahPasanganUnik);
                            } else {
                                System.out.println("Pasangan angka unik tidak ditemukan! karena angka nya sama semua.");
                            }

                            // Menghentikan validasi dan loop input
                            validasiPanjangArray = false;
                            break;
                        }
                    }
                }
            } else {
                System.out.println("Maaf, inputan harus berupa angka!");
                scanner.next();
            }
        }

        // Menutup objek Scanner setelah selesai digunakan
        scanner.close();
    }
}
