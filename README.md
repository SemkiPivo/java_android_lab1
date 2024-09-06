<h1>Практическая работа №1</h1>

<p>Первая работа по большей части заключается в повторении кода из методички.
    Здесь более подробно разобраны методы и компоненты итогового приложения</p>

<h2>Файл activity_main.xml</h2>
<p>
    В данном XML-файле описан макет активности, который включает в себя несколько компонентов пользовательского интерфейса.
    Каждый из описанных компонентов имеет собственный идентификатор (id), по которому к ним можно обращаться при написании логики приложения.
    Сама логика описана ниже, в разделе "Файл MainActivity.java".

    Путь к файлу activity_main.xml: app\src\main\res\layout\activity_main.xml
</p>
<h3>Методы и копоненты:</h3>
<p>Здесь не расписаны атрибуты для каждого компонента, так как в основе своей атрибуты во всех компонетах повторяются.</p>
<pre>
1. ConstraintLayout
    Тип: Контейнер макета.

2. TextView
    Тип: Отображает текст.
    Атрибуты:
    android:id="@+id/mainTextView": Уникальный идентификатор макета.
    android:layout_width="match_parent": Ширина макета равна ширине родительского контейнера.
    android:layout_height="match_parent": Высота макета равна высоте родительского контейнера.
    android:background="#FFFFFF": Цвет фона макета — белый.
    android:backgroundTintMode="multiply": Режим наложения оттенка фона.
    tools:context=".MainActivity": Указывает, что этот макет связан с активностью MainActivity.
3. LinearLayout (main_inputlayout)
    Тип: Контейнер макета с горизонтальной ориентацией.
    Атрибуты:
    android:id="@+id/main_textview": Уникальный идентификатор.
    android:layout_width="wrap_content": Ширина компонента подстраивается под содержимое.
    android:layout_height="wrap_content": Высота компонента подстраивается под содержимое.
    android:text="Hello World!": Текст, который отображается.
    android:textAlignment="center": Текст выравнивается по центру.
    android:textColor="#000000": Цвет текста — черный.
    android:textSize="20sp": Размер текста — 20sp.
    app:layout_constraintBottom_toBottomOf="parent": Нижняя граница компонента привязана к нижней границе родительского контейнера.
    app:layout_constraintEnd_toEndOf="parent": Правая граница компонента привязана к правой границе родительского контейнера.
    app:layout_constraintStart_toStartOf="parent": Левая граница компонента привязана к левой границе родительского контейнера.
    app:layout_constraintTop_toTopOf="parent": Верхняя граница компонента привязана к верхней границе родительского контейнера.
    app:layout_constraintVertical_bias="0.107": Вертикальное смещение компонента относительно родительского контейнера.
4. Button (main_button)
    Тип: Кнопка.
   Описание: Кнопка ввода.
6. EditText
    Тип: Поле ввода текста.
7. ListView
    Тип: Список элементов.
8. LinearLayout (add_btnslayout)
    Тип: Контейнер макета с горизонтальной ориентацией.
9. Button (ok_btn)
    Тип: Кнопка.
   Описание: Кнопка ОК.
10. Button (cnc_btn)
    Тип: Кнопка.
   Описание: Кнопка Cancel.
</pre>

<h2>Файл MainActivity.java</h2>

<p>
    MainActivity.java содержит код основной активности андроид-приложения.

    Путь к файлу MainActivity.java:  app\src\main\java\com\example\lab1\MainActivity.java
</p>
<h3>Методы и компоненты:</h3>
<pre>
1. onCreate(Bundle savedInstanceState)

Этот метод вызывается при создании активности.
В нем происходит инициализация и настройка всех необходимых компонентов:

    EdgeToEdge.enable(this);: Включает режим "от края до края" для активности, что позволяет использовать всю доступную область экрана,
    включая области, занятые системными панелями (например, панелью навигации).

    setContentView(R.layout.activity_main);: Устанавливает макет activity_main.xml для этой активности.

    ViewCompat.setOnApplyWindowInsetsListener: Устанавливает слушатель для применения отступов от системных панелей к mainTextView.

  Инициализация компонентов:

      mainTextView, mainButton, okButton, cncButton, mainEditText, mainListView — это все компоненты,
      которые были определены в макете activity_main.xml и теперь инициализируются в коде.

      mainArrayAdapter — это адаптер, который связывает mainArrayList с mainListView.

  Установка текста для mainTextView: mainTextView.setText("Set in Java!");

  Установка слушателей событий:

      mainButton.setOnClickListener(this); — устанавливает текущий объект (this) как слушатель нажатий на mainButton.

      mainListView.setOnItemClickListener(this); — устанавливает текущий объект (this) как слушатель нажатий на элементы mainListView.

      okButton.setOnClickListener(oclBtn); и cncButton.setOnClickListener(oclBtn); — устанавливают один и тот же слушатель (oclBtn) для двух кнопок.

2. onClick(View view)

Этот метод вызывается при нажатии на кнопку mainButton. В нем происходит следующее:

    Изменение текста mainTextView: Текст mainTextView устанавливается на значение, введенное в mainEditText,
    с добавлением строки "\nis learning Android development!".

    Добавление элемента в список: Текст из mainEditText добавляется в mainArrayList.

    Обновление адаптера: mainArrayAdapter.notifyDataSetChanged(); уведомляет адаптер о том,
    что данные изменились, и список должен быть обновлен.

3. onItemClick(AdapterView<?> adapterView, View view, int position, long id)

Этот метод вызывается при нажатии на элемент в mainListView. В нем происходит следующее:

    Логирование: В лог записывается информация о нажатом элементе.

    Изменение текста mainTextView: Текст mainTextView устанавливается на значение выбранного элемента списка
    с добавлением строки "\nis learning Android development!".

4. oclBtn (View.OnClickListener)

Это анонимный класс, который реализует интерфейс View.OnClickListener.
Он обрабатывает нажатия на кнопки okButton и cncButton:

    Для okButton:

        Устанавливает текст mainTextView на "Нажата кнопка OK".

        Показывает тост с текстом "Нажата кнопка OK".

    Для cncButton:

        Устанавливает текст mainTextView на "Нажата кнопка Cancel".

        Показывает тост с текстом "Нажата кнопка Cancel".

Данный код содержит базовую функциональность Android-приложения, 
включая обработку нажатий на кнопки, обновление списка, изменение текста и отображение уведомлений (тостов).
  </pre>
