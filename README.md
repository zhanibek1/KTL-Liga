# КТЛ ЛИГА: Android-приложение (APK)

Приложение открывает вашу опубликованную страницу КТЛ ЛИГА в полноэкранном окне.
Ссылка задаётся в app/src/main/java/com/ktl/liga/MainActivity.kt (переменная url).

## Как собрать APK (бесплатно, через GitHub)
1. На github.com нажмите New repository, назовите KTL-Liga, создайте.
2. Add file, Upload files: перетащите всё ВНУТРИ папки KTL-Liga (не саму папку).
3. Если папка .github не загрузилась: Actions, set up a workflow yourself, и вставьте
   файл сборки (тот же текст, что лежит в .github/workflows/main.yml в этом архиве).
4. Commit changes. Во вкладке Actions пройдёт сборка (3-8 минут).
5. Откройте запуск с зелёной галочкой, внизу Artifacts, скачайте KTL-Liga-apk,
   распакуйте zip, внутри app-debug.apk.
6. Установите на настоящий телефон с Android 7 или новее.
