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