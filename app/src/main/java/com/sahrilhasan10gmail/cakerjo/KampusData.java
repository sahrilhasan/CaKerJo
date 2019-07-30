package com.sahrilhasan10gmail.cakerjo;

import java.util.ArrayList;

public class KampusData {
    public static String[][] data = new String[][]{
            {"1","1. Universitas Gadjah Mada (UGM)", "Universitas Gadjah Mada adalah salah satu universitas tertua di Indonesia yang ada sejak tahun 1949. UGM menjadi salah satu universitas terbaik di Yogyakarta dan juga di Indonesia.", "https://kampusaja.com/wp-content/uploads/2018/08/1.-UGM-Universitas-Gadjah-Mada-Universitas-Terbaik-di-Yogyakarta--810x355.jpg","-7.7713847","110.3753111"},
            {"2","2. Universitas Negeri Yogyakarta (UNY)", "Universitas Negeri Yogyakarta adalah universitas yang didirikan pada 21 Mei 1964, dimana sebelumnya universitas ini bernama IKIP Yogyakarta. Sehingga tak heran universitas ini lebih dikenal sebagai sekolah untuk para calon guru, walaupun ada yang non pendidikan.", "https://kampusaja.com/wp-content/uploads/2018/08/2.-UNY-Universitas-Negeri-Yogyakarta-Universitas-Terbaik-di-Yogyakarta.jpg","-7.7747532","110.3840556"},
            {"3","3. Universitas Islam Negeri Sunan Kalijaga (UIN SUKA)", "UIN Sunan Kalijaga adalah salah satu universitas terbaik di Yogyakarta, dimana universitas ini berdiri pada 26 September 1951. Kampus UIN berada di perbatasan antara Kota Yogyakarta dan kabupaten Sleman yakni di Jalan Marsda Adisucipto No. 1.", "https://kampusaja.com/wp-content/uploads/2018/08/3.-UIN-SUKA-UIN-Sunan-Kalijaga-Universitas-Terbaik-di-Yogyakarta.jpg","-7.7842319","110.3924107"},
            {"4","4. Universitas Muhammadiyah Yogyakarta (UMY)","UMY adalah universitas swasta dan menjadi salah satu universitas terbaik di Yogyakarta. UMY didirikan pada 1 Maret 1981 yang berlokasi di Jalan Lingkar Selatan, Kasihan, Bantul, DIY.","https://kampusaja.com/wp-content/uploads/2018/08/4.-UMY-Universitas-Muhammadiyah-Yogyakarta-Universitas-Terbaik-di-Yogyakarta.jpg","-7.8077616","110.3265314"},
            {"5","5. Universitas Sanata Dharma (USD)","Universitas Sanata Dharma atau sering dikenal dengan USD adalah salah satu universitas swasta terbaik di Yogyakarta. Kampus USD sendiri tersebar di beberapa wilayah di Yogyakarta dan terdiri dari 5 Kampus.","https://kampusaja.com/wp-content/uploads/2018/08/5.-USD-Universitas-Sanata-Dharma-Universitas-Terbaik-di-Yogyakarta.jpg","-7.7753299","110.3906635"},
            {"6","6. Universitas Islam Indonesia (UII)","Universitas Islam Indonesia atau yang lebih dikenal dengan UII adalah salah satu perguruan tinggi swasta tertua di Indonesia dan berada di Yogyakarta. UII berdiri pada tanggal 8 Juli 1945 dengan nama Sekolah Tinggi Islam (STI) yang berada di Jakarta.","https://kampusaja.com/wp-content/uploads/2018/08/6.-UII-Universitas-Islam-Indonesia-Universitas-Terbaik-di-Yogyakarta.jpg","-7.7386839","110.3573957"},
            {"7","7. Universitas Kristen Duta Wacana (UKDW)","UKDW adalah salah satu perguruan tinggi swasta yang didirikan pada tahun 1962 dan berada di Yogyakarta. Saat ini sendiri UKDW telah memperoleh akreditasi A dari BAN PT.","https://kampusaja.com/wp-content/uploads/2018/08/7.UKDW-Universitas-Kristen-Duta-Wacana-Universitas-Terbaik-di-Yogyakarta-810x482.jpg","-7.7881965","110.3665627"},
            {"8","8. Universitas Ahmad Dahlan (UAD)","UAD adalah salah satu perguruan tinggi swasta yang berada di Jalan Kapas No.9, Semaki, Umbulharjo, Kota Yogyakarta, DIY. UAD didirikan pada tanggal 19 Desember 1993.","https://kampusaja.com/wp-content/uploads/2018/08/8.-UAD-Universitas-Ahmad-Dahlan-Universitas-Terbaik-di-Yogyakarta.jpg","-7.798761","110.3809038"},
            {"9","9. Universitas Atma Jaya (UAJY)","Universitas Atma Jaya Yogyakarta atau sering dikenal dengan UAJY adalah salah satu perguruan tinggi swasta di Yogyakarta. UAJY sekarang telah mendapatkan akreditasi A dari BAN PT secara institusi.","https://kampusaja.com/wp-content/uploads/2018/08/9.-UAJY-Universitas-Atma-Jaya-Universitas-Terbaik-di-Yogyakarta.jpg","-7.7888805","110.3660513"},
            {"10","10. Universitas Pembangunan Nasional “Veteran” Yogyakarta (UPN)","UPN Yogyakarta adalah salah satu universitas terbaik di Yogyakarta. UPN sebelumnya adalah kampus swasta, akan tetapi setelah tahun 2014 berubah menjadi berstatus kampus negeri.","https://kampusaja.com/wp-content/uploads/2018/08/10.-UPN-Veteran-Yogyakarta-Universitas-Terbaik-di-Yogyakarta-810x540.jpg","-7.7611031","110.4070599"},
 };
    public static ArrayList<Kampus> getListData(){
        ArrayList<Kampus> list = new ArrayList<>();
        for (String[] aData : data) {
            Kampus kampus = new Kampus();
            kampus.setId(aData[0]);
            kampus.setName(aData[1]);
            kampus.setFrom(aData[2]);
            kampus.setPhoto(aData[3]);
            kampus.setLat(aData[4]);
            kampus.setLing(aData[5]);
            list.add(kampus);
        }
        return list;
    }
}
