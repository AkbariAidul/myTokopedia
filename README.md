# TokopediaKW

Aplikasi Android clone sederhana dari Tokopedia. Dibuat menggunakan **Java** dan **XML** dengan target **minSdk 23**.

## Fitur

- **Splash Screen** - Layar pembuka dengan logo Tokopedia hijau (#00AA5B) dan versi aplikasi
- **Login Screen** - Halaman masuk menggunakan Nomor HP atau Email
- **Home Dashboard** - Halaman utama dengan search bar dan navigasi bawah

## Teknologi

| Komponen | Detail |
|---|---|
| Bahasa | Java |
| Build System | Gradle (AGP 8.2.0) |
| Min SDK | 23 (Android 6.0) |
| Target SDK | 36 |
| Package | `arifaidulhaikal.tokopedia` |
| UI | XML Layout, AppCompat, Material Design |

## Cara Menjalankan

1. Buka folder project di **Android Studio**
2. Tunggu hingga Gradle sync selesai
3. Pilih perangkat/emulator (min API 23)
4. Klik **Run** ▶

## Struktur Project

```
app/src/main/
├── java/arifaidulhaikal/tokopedia/
│   ├── SplashActivity.java
│   ├── LoginActivity.java
│   └── MainActivity.java
└── res/
    ├── drawable/        # logo, icon, border, background
    ├── layout/          # activity_splash, activity_login, activity_main
    └── values/          # strings, colors, themes
```

## Catatan

Warna utama menggunakan hijau khas Tokopedia `#00AA5B`. Detail desain lainnya bisa dilihat di file [`DESIGN.md`](./DESIGN.md) (tersedia di folder sumber TokopediaKW).
