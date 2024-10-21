//package com.example.lovecalculator.ui.fragment
//import android.annotation.SuppressLint
//import android.os.Bundle
//import android.view.View
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.appcompat.app.AppCompatActivity
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.example.lovecalculator.MyAdapter
//import com.example.lovecalculator.R
//import com.google.android.material.bottomnavigation.BottomNavigationView
//
//class MainActivity : AppCompatActivity() {
//
//    private lateinit var recyclerView: RecyclerView
//    private lateinit var adapter: MyAdapter // Замените на ваш адаптер
//    private lateinit var bottomNavigationView: BottomNavigationView
//
//    @SuppressLint("MissingInflatedId")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main) // Убедитесь, что имя вашего XML-файла правильное
//
//        // Инициализация компонентов
//        val headerImage: ImageView = findViewById(R.id.img) // Сохраняем ссылку на ImageView
//        val titleTextView: TextView = findViewById(R.id.tv_title)
//        recyclerView = findViewById(R.id.recyclerView)
//        bottomNavigationView = findViewById(R.id.bottomNavigation)
//
//// Если нужно, можно установить изображение для ImageView
//        headerImage.setImageResource(R.drawable.img) // Замените your_image на ваше изображение
//
//        // Установка LayoutManager для RecyclerView
//        recyclerView.layoutManager = LinearLayoutManager(this)
//
//        // Инициализация адаптера и привязка его к RecyclerView
//        adapter = MyAdapter() // Создайте экземпляр вашего адаптера
//        recyclerView.adapter = adapter
//
//        // Пример заполнения адаптера данными (замените на ваши данные)
//        val items = listOf("Item 1", "Item 2", "Item 3")
//        adapter.submitList(items)
//
//        // Настройка навигационной панели
//        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
//            when (menuItem.itemId) {
//                R.id.nav_home -> {
//                    // Обработка нажатия на элемент "Home"
//                    true
//                }
//                R.id.nav_history -> {
//                    // Обработка нажатия на элемент "History"
//                    true
//                }
//                else -> false
//            }
//        }
//    }
//
//    fun goToOnboarding(view: View) {}
//}
