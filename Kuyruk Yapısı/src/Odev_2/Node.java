

/**
* @file Node
* @description Node sınıfında gerekli değişkenler tanımlanmıştır.
* @assignment 2.
* @date 19.12.2019 / 22.12.2019
* @author Omer Faruk Dursun / omerfaruk.dursun@stu.fsm.edu.tr
*/



package Odev_2;

public class Node <T>{
 String AdSoyad;
 String FaturaTipi;
 Double FaturaMiktari;
 int oncelik;
 int zaman;
 Node next;

    public Node(String AdSoyad, String FaturaTipi, Double FaturaMiktari, int oncelik, int zaman) {
        this.AdSoyad = AdSoyad;
        this.FaturaTipi = FaturaTipi;
        this.FaturaMiktari = FaturaMiktari;
        this.oncelik = oncelik;
        this.zaman = zaman;
    }
    

    @Override
    public String toString() {
        return  this.AdSoyad+" - "+this.FaturaTipi+" - "+this.FaturaMiktari+" - "+this.oncelik+" - "+this.zaman;
    }
}
