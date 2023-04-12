# MİKROSERVİS İŞLEMLERİ VE NOTLARIM

## 1- Kurulum adımları

    ### 1.1. Boş bir gradle projesi açtık.
    ### 1.2. Dependencies.gradle dosyası kurduk.
        #### 1.2.1. ext{} bloğu içerisindeki kütüphaneleri projemize dahil ettik.
        #### 1.2.2. versions {} bloğu içerisindeki kütüphanelerin versiyonlarını belirledik.
        #### 1.2.3. libs{} bloğu içerisinde kullanacağımız kütüphaneleri belirledik.
    ### 1.3. build.gradle dosyasını kodladık, bu dosya içinde tüm alt projelerimizde 
    ortak olarak kullanacağımız kütüphaneleri ekledik.
    ### 1.4. Uygulamamızın mimarisi gereği ihtiyaç duyduğumuz mikroserviceleri belirleyerek
    onları modül olarak ekledik.
    ### 1.5. Her bir modül için eklememiz gerekn aşağıdaki kod bloğunu build.gradle 
    dosyalarına ekledik.
```
buildscript {
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:${versions.springBoot}")
    }
}
```
    ### 1.6. tüm modüllerimize monolitik mimaride kullandığımız default kodlamaları ekledik.
    ### 1.7. Eğer bir modül içinde kullanmak istediğimiz özel bağımlılıklar var ise bunları
    build.gradle dosyalarına ekledik.
    ### 1.8. AuthService için application.yml dosyasına veritabanı bağlantı bilgilerini girdik.
    ### 1.9. AuthService içinde auth entity class oluşturduk ve gerekli propertyleri tanımladık
    ### 1.10. IAuthRepository interface kurduk ve içini ihtiyacımız olan metotlar ile doldurduk.

## 2. MongoDB Kurulum ve Kullanımı

### 2.1. MongoDB Docker üzerinde çalıştırmak

    Docker kurulu olan bir sistem üzerinde command satırına girerek aşağıda yer alan
    komutları yazarak docker üzerinden çalıştırabiliriz.

    > docker run --name dockermongo -p 27017:27017 -e MONGO_INITDB_ROOT_USERNAME=BilgeAdmin -e MONGO_INITDB_ROOT_PASSWORD=root -d mongo

### 2.2 MongoDB Bağlanmak
    MongoDB kullanırken admin ve şifresini veritabanlarına erişmek için kullanmayınız.
    Yeni bir veritabanı oluşturmak için admin kullanıcısı ile işlem yapılır.
    Bu veritabanına atanmak üzerie yeni bir kullanıcı oluşturur. Böylece admin kullanıcısına
    ihtiyac kalmadan DB üzerinde işlemler gerççekleştirir.
    
    1- Öncelikle bir veritabanı oluşuruyoruz
    2- Mongsh kullanarak konsolda "user db_adi" yazıyorsunuz ve ilgili DB ye geçiş yapıyorsunuz 
    3- Yine aynı ekranda yeni bir kullanııcı oluşturmamız gereklidir. bu kullanıcı yetkili olcaktır.
    db.createUser({user: "Java7User",pwd: "root",roles: ["readWrite", "dbAdmin"]})



