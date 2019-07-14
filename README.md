Путь для запуска http://localhost:8080/my-parts-list/store/main/1?choice=allParts<br>
Задание:<br>
Файлы проекта .idea и скомпилированные классы в output или target выкладывать не надо.<br>
 Требуемые технологии:<br>  
• Maven (для сборки проекта).<br>
• Tomcat 8 или 9 (для тестирования своего приложения); <br>
• Spring (версия не ниже 4.3.12); <br>
• Hibernate (версия не ниже 5.3); <br>
• MySQL (база данных (БД)). Для упрощения тестирования называйте все свою базу test, с логином и паролем root (нам не нужно будет для     тестирования создавать кучу лишних и ненужных баз); <br>
• Frontend: Spring MVC или Angular. <br><p>
Версии можно смело брать самые последние. Конфликтов быть не должно.<br>
Приложение должно быть в виде проекта, который собирается с помощью Maven. Обязательно должен присутствовать скрипт для создания и наполнения тестовыми данными вашей базы данных. Предупреждение: скрипт на SQL – это скрипт, а не дамп базы данных из WorkBench, PhpMyAdmin, и прочих программ. Не ленитесь и напишите скрипт сами. В тестовые данные вставьте от 21 до 40 записей (компьютерных комплектующих).<br>
Реализовать простенькое приложение Parts-list, для отображения списка деталей для сборки компьютеров на складе. Записи хранить в базе данных. Схему таблички для хранения нужно придумать самому (достаточно одной таблицы). <br>
Нужно показывать список уже имеющихся деталей (с пейджингом по 10 штук на странице). <br>
В списке должно быть наименование детали (String), обязательна ли она для сборки (boolean) и их количество на складе (int). На склад можно добавлять новые детали, редактировать существующие детали (любое из полей), удалять.<br><p>
  • Должна быть сортировка по принципу: все детали, детали, которые необходимы для сборки, опциональные детали. <br> 
  • Должен быть поиск по наименованию детали. <br><p>
Бизнес-требование: ниже списка деталей всегда выводить поле, в котором выводится, сколько компьютеров можно собрать из деталей в наличии. Для сборки одного компьютера должны быть в наличии все детали, которые отмечены как необходимые.<br>
