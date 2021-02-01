package Odev_2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @file Queue
 * @description Kuyruk ile ilgili enqueue,dequeue gibi işlemler bu sınıfta yapılıyor.
 * yapılmıştır.
 * @assignment 2.
 * @date 19.12.2019 / 22.12.2019
 * @author Omer Faruk Dursun / omerfaruk.dursun@stu.fsm.edu.tr
 */
public class Queue<T> {

    Node<T> front, rear; // Nodeun kuyruğunu ve başını tanımlıyoruz.

    void enqueue(String AdSoyad, String FaturaTipi, Double FaturaMiktari, int oncelik, int zaman) { // İstenilen parametreleri alan kuyruğa ekleme fonksiyonu
        Node newNode = new Node(AdSoyad, FaturaTipi, FaturaMiktari, oncelik, zaman); // Bu parametlerle bir node oluşturuyoruz.
        if (front == null) { // Kuyruğun başı boşsa başı ve sonu newNode yapıyoruz.
            front = rear = newNode;

        } else {
            Node temp = front; // Kuyruğun başını geçici bir değişkene atıyoruz.
            if (front.oncelik > newNode.oncelik) { // başdaki elemanın önceliği yeni gelen node dan büyükse 
                front = newNode; // Yeni node baş yapıyoruz.
                front.next = temp; // Önceki başı şimdiki başın arkasına ekliyoruz.
            } else {
                boolean eklendiMi = false;
                while (temp.next != null) { // Kuyrukta gezinti yapıyor.
                    if (temp.next.oncelik > newNode.oncelik) { // Araya ekleme işlemini burada yapıyoruz.
                        newNode.next = temp.next;
                        temp.next = newNode;
                        eklendiMi = true;
                        break;
                    }
                    temp = temp.next;
                }
                if (!eklendiMi) { // Eklenmediyse demekki gelen değer arada değil sondadır diyip sona ekliyoruz (Ondan daha küçük bir değer yoktur yani.)
                    rear.next = newNode;
                    rear = rear.next;
                }
            }

        }
    }

    void enqueue(Node node) {
        enqueue(node.AdSoyad, node.FaturaTipi, node.FaturaMiktari, node.oncelik, node.zaman);
    }

    String dequeue() {
        if (front == null) { // Front boşsa null döndürüyor.
            System.out.println("Liste bos!!");
            return null;
        } else {
            String temp = front.AdSoyad + " - " + front.FaturaTipi + " - " + front.FaturaMiktari + " - " + front.oncelik + " - " + front.zaman;
            if (front.next == null) { // Kuyruktan eleman çıkartıyoruz.
                front = rear = null;
            } else {
                front = front.next;
            }
            return temp;
        }
    }

    Node nDequeue() {
        if (front == null) { // Front boşsa null döndürüyor.
            System.out.println("Liste bos!!");
            return null;
        } else {
            Node temp = front;
            if (front.next == null) { // Kuyruktan eleman çıkartıyoruz.
                front = rear = null;
            } else {
                front = front.next;
            }
            return temp;
        }
    }

    int size() {
        int count = 0;
        if (front != null) {
            Node<T> temp = front;
            while (temp != null) {
                count++;
                temp = temp.next;
            }
        }
        return count;
    }

    void print() {
        Node<T> temp = front;
        while (temp != null) {
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }

    void dosyaOku(String path) throws FileNotFoundException, IOException { // Dosya okuma işlemleri yapılıyor.
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
        String satir = br.readLine();
        while (satir != null) {
            String[] elemanlar = satir.split("#");
            enqueue(elemanlar[0], elemanlar[1], Double.valueOf(elemanlar[2]), Integer.valueOf(elemanlar[3]), Integer.valueOf(elemanlar[4]));
            satir = br.readLine();
        }

    }

    int toplamSure() { // Toplam Süre Hesabını hesaplıyor
        Node temp = front;
        int toplam = 0;
        while (temp != null) {
            toplam += temp.zaman;
            temp = temp.next;
        }
        return toplam;
    }

    double toplamFatura() { // Toplam Faturayı Hesaplıyor.
        Node temp = front;
        double toplam = 0.0;
        while (temp != null) {
            toplam += temp.FaturaMiktari;
            temp = temp.next;
        }
        return toplam;
    }
}
